package com.example.mydagger2.di.module;

import com.example.mydagger2.constants.ConfigConstants;
import com.example.mydagger2.data.api.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by beijixiong on 2019/3/27.
 */

@Module
public class ApiServiceModule {


    /**
     * 忽略https验证
     */
    public OkHttpClient lgnoreHttps(OkHttpClient.Builder httpClientBuilder) {
        OkHttpClient sClient = httpClientBuilder.build();
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {

                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {

                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }}, new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }

        HostnameVerifier hv1 = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        String workerClassName = "okhttp3.OkHttpClient";
        try {
            Class workerClass = Class.forName(workerClassName);
            Field hostnameVerifier = workerClass.getDeclaredField("hostnameVerifier");
            hostnameVerifier.setAccessible(true);
            hostnameVerifier.set(sClient, hv1);

            Field sslSocketFactory = workerClass.getDeclaredField("sslSocketFactory");
            sslSocketFactory.setAccessible(true);
            sslSocketFactory.set(sClient, sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sClient;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.writeTimeout(ConfigConstants.default_write_time_out, TimeUnit.SECONDS);//写操作 超时时间
        httpClientBuilder.connectTimeout(ConfigConstants.default_connect_time_out, TimeUnit.SECONDS);//连接超时时间
        httpClientBuilder.readTimeout(ConfigConstants.default_read_time_out, TimeUnit.SECONDS);//读操作超时时间
        OkHttpClient sClient = lgnoreHttps(httpClientBuilder);
        return sClient;
    }


    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
        return new Retrofit.Builder()
                .baseUrl(ConfigConstants.BASE_URL)
//                .client(httpClientBuilder.build())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Singleton
    @Provides
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
