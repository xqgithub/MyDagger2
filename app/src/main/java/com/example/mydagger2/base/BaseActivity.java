package com.example.mydagger2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mydagger2.application.MyApp;
import com.example.mydagger2.di.componets.MyAppComponet;

/**
 * Created by beijixiong on 2019/3/26.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(MyApp.getMyApp(this).getMyAppComponet());
    }

    protected abstract void setupComponent(MyAppComponet myAppcomponet);
}
