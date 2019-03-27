package com.example.mydagger2.mvp.presenter;

import com.example.mydagger2.data.api.ApiService;
import com.example.mydagger2.mvp.contract.CategoryContract;
import com.example.mydagger2.mvp.entity.Category;
import com.example.mydagger2.mvp.listener.CategoryCallback;
import com.example.mydagger2.mvp.view.CategoryView;

import java.util.List;

/**
 * Created by beijixiong on 2019/3/26.
 */

public class CategoryPresenter implements BasePresenter, CategoryCallback {

    private CategoryView view;
    private CategoryContract categories;
    private ApiService apiService;

    public CategoryPresenter(CategoryView view, CategoryContract categories, ApiService apiService) {
        this.view = view;
        this.categories = categories;
        this.apiService = apiService;
    }

    @Override
    public void onResume() {
        view.showProgress();
        categories.getCategories(apiService, this);
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
