package com.example.mydagger2.di.module;

import com.example.mydagger2.data.api.ApiService;
import com.example.mydagger2.di.scope.ActivityScope;
import com.example.mydagger2.mvp.contract.CategoryContract;
import com.example.mydagger2.mvp.presenter.BasePresenter;
import com.example.mydagger2.mvp.presenter.CategoryPresenter;
import com.example.mydagger2.mvp.view.CategoryView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by beijixiong on 2019/3/27.
 */

@Module
public class CategoryModule {

    private CategoryView view;

    public CategoryModule(CategoryView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public CategoryView provideView() {
        return view;
    }

    @ActivityScope
    @Provides
    public BasePresenter providePresenter(CategoryView view, CategoryContract categories, ApiService apiService) {
        return new CategoryPresenter(view, categories, apiService);
    }


}
