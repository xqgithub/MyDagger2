package com.example.mydagger2.mvp.view;

import com.example.mydagger2.mvp.entity.Category;

import java.util.List;

/**
 * Created by beijixiong on 2019/3/26.
 */

public interface CategoryView {
    void showProgress();

    void hideProgress();

    void showCategories(List<Category> categories);

    void showMessage(String message);
}
