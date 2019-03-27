package com.example.mydagger2.mvp.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mydagger2.R;
import com.example.mydagger2.application.MyApp;
import com.example.mydagger2.di.componets.DaggerMain2ActivityComponent;
import com.example.mydagger2.di.module.Main2Module;
import com.example.mydagger2.di.qualifier.ForBoy;
import com.example.mydagger2.di.qualifier.ForGirl;
import com.example.mydagger2.mvp.entity.Test;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity {


    @Inject
    @ForBoy
    Test boy;
    @Inject
    @ForGirl
    Test girl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMain2ActivityComponent.builder()
                .myAppComponet(((MyApp) getApplication()).getMyAppComponet())
                .main2Module(new Main2Module()).build().inject(this);

        boy = boy;
        Log.i("Main2Activity", "boy----->" + boy.getA());
        girl = girl;
        Log.i("Main2Activity", "girl----->" + girl.getA());
    }
}
