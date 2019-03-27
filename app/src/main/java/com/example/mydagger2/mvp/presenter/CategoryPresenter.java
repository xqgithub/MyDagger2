package com.example.mydagger2.mvp.presenter;

import com.example.mydagger2.mvp.entity.Categories;
import com.example.mydagger2.mvp.entity.Category;
import com.example.mydagger2.mvp.listener.Callback;
import com.example.mydagger2.mvp.view.CategoryView;

import java.util.List;

/**
 * Created by beijixiong on 2019/3/26.
 */

public class CategoryPresenter implements BasePresenter, Callback {

    private CategoryView view;
    private Categories categories;

    public CategoryPresenter(CategoryView view, Categories categories) {
        this.view = view;
        this.categories = categories;
    }

    @Override
    public void onResume() {
        view.showProgress();
        categories.getCategories(this);
    }

    @Override
    public void onItemSelected(Category category, int position) {
        view.showMessage(String.format(category.getName() + " ->" + " Position %d clicked", position));
    }

    @Override
    public void onLoadCategories(List<Category> categories) {
        view.showCategories(categories);
        view.hideProgress();
    }
}
