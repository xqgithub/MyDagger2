package com.example.mydagger2.di.module;

import android.content.Context;

import com.example.mydagger2.application.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by beijixiong on 2019/3/23.
 */

@Module
public class MyAppModule {

    private MyApp myApp;

    public MyAppModule(MyApp myApp) {
        this.myApp = myApp;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return myApp;
    }

}
