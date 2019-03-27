package com.example.mydagger2.mvp.presenter;

import com.example.mydagger2.mvp.entity.Category;

/**
 * Created by beijixiong on 2019/3/26.
 */

public interface BasePresenter {

    void onResume();

    void onItemSelected(Category category, int position);
}
