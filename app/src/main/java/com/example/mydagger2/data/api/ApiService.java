package com.example.mydagger2.data.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by beijixiong on 2019/3/23.
 */

public interface ApiService {
    @GET
    Call<ResponseBody> downloadFileWithDynamicUrlSync(@Url String fileUrl);


    /**
     * 判断客户端是否是在国内
     */
    @GET
    Call<ResponseBody> location(@Url String fileUrl);
}
