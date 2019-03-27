package com.example.mydagger2.di.componets;

import com.example.mydagger2.di.module.CategoryModule;
import com.example.mydagger2.di.scope.ActivityScope;
import com.example.mydagger2.mvp.presenter.BasePresenter;
import com.example.mydagger2.mvp.ui.activities.CategoryActivity;

import dagger.Component;

/**
 * Created by beijixiong on 2019/3/27.
 */
@ActivityScope
@Component(dependencies = MyAppComponet.class, modules = CategoryModule.class)
public interface CategoryComponent {
    void inject(CategoryActivity categoryActivity);

    BasePresenter getMainPresenter();
}
