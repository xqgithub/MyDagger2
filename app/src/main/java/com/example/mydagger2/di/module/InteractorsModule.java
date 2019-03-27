package com.example.mydagger2.di.module;

import com.example.mydagger2.mvp.contract.CategoryContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by beijixiong on 2019/3/27.
 */
@Module
public class InteractorsModule {
    @Provides
    public CategoryContract provideFindItemsInteractor() {
        return new CategoryContract();
    }
}
