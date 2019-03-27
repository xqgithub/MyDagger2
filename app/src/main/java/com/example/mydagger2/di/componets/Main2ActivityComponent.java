package com.example.mydagger2.di.componets;

import com.example.mydagger2.di.module.Main2Module;
import com.example.mydagger2.di.scope.PerActivity;
import com.example.mydagger2.mvp.ui.activities.Main2Activity;

import dagger.Component;

/**
 * Created by beijixiong on 2019/3/23.
 */

@PerActivity
@Component(dependencies = {MyAppComponet.class}, modules = {Main2Module.class})
public interface Main2ActivityComponent {
    void inject(Main2Activity main2activity);
}
