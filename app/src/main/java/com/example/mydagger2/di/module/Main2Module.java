package com.example.mydagger2.di.module;

import com.example.mydagger2.di.qualifier.ForBoy;
import com.example.mydagger2.di.qualifier.ForGirl;
import com.example.mydagger2.di.scope.PerActivity;
import com.example.mydagger2.mvp.entity.Test;

import dagger.Module;
import dagger.Provides;

/**
 * Created by beijixiong on 2019/3/23.
 */
@Module
public class Main2Module {
    @PerActivity
    @Provides
    @ForBoy
    Test ProvideBoy() {
        return new Test(1);
    }

    @PerActivity
    @Provides
    @ForGirl
    Test ProvideGirl() {
        return new Test(2);
    }

}
