package com.example.mydagger2.di.componets;

import android.content.Context;

import com.example.mydagger2.application.MyApp;
import com.example.mydagger2.data.api.ApiService;
import com.example.mydagger2.di.module.ApiServiceModule;
import com.example.mydagger2.di.module.InteractorsModule;
import com.example.mydagger2.di.module.MyAppModule;
import com.example.mydagger2.mvp.contract.CategoryContract;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by beijixiong on 2019/3/23.
 */
@Singleton
@Component(modules = {MyAppModule.class, InteractorsModule.class, ApiServiceModule.class})
public interface MyAppComponet {
    Context getContext();

    CategoryContract getFindItemsInteractor();

    void inject(MyApp myapp);

    ApiService getService();
}
