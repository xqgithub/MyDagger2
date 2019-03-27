package com.example.mydagger2.application;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.mydagger2.di.componets.DaggerMyAppComponet;
import com.example.mydagger2.di.componets.MyAppComponet;
import com.example.mydagger2.di.module.MyAppModule;

/**
 * Created by beijixiong on 2019/3/23.
 */

public class MyApp extends MultiDexApplication {

    private MyAppComponet myAppComponet;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    public static MyApp getMyApp(Context context) {
        return (MyApp) context.getApplicationContext();
    }

    public MyAppComponet getMyAppComponet() {
        return myAppComponet;
    }


    private void setupGraph() {
        myAppComponet = DaggerMyAppComponet.builder().myAppModule(new MyAppModule(this)).build();
        myAppComponet.inject(this);
    }

}
