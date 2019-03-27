package com.example.mydagger2.mvp.listener;

import com.example.mydagger2.mvp.entity.Category;

import java.util.List;

/**
 * Created by beijixiong on 2019/3/26.
 */

public interface Callback {
    void onLoadCategories(List<Category> categories);
}
