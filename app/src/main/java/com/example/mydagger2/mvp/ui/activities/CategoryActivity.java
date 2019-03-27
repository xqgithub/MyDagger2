package com.example.mydagger2.mvp.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mydagger2.R;
import com.example.mydagger2.base.BaseActivity;
import com.example.mydagger2.di.componets.DaggerCategoryComponent;
import com.example.mydagger2.di.componets.MyAppComponet;
import com.example.mydagger2.di.module.CategoryModule;
import com.example.mydagger2.mvp.entity.Category;
import com.example.mydagger2.mvp.presenter.BasePresenter;
import com.example.mydagger2.mvp.ui.adapter.CategoryAdapter;
import com.example.mydagger2.mvp.view.CategoryView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by beijixiong on 2019/3/27.
 */

public class CategoryActivity extends BaseActivity implements CategoryView, CategoryAdapter.ItemClickListener {


    @Inject
    BasePresenter presenter;

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void setupComponent(MyAppComponet myAppcomponet) {
        DaggerCategoryComponent.builder()
                .myAppComponet(myAppcomponet)
                .categoryModule(new CategoryModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initViews();
        setUpToolbar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCategories(List<Category> items) {
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setCategories(items);
        categoryAdapter.setItemClickListener(this);
        recyclerView.setAdapter(categoryAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_categorys);
        progressBar = findViewById(R.id.progress);
        Toolbar mToolbar = findViewById(R.id.toolbar);
    }

    private void setUpToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }

    @Override
    public void onItemClick(Category category, int position) {
        presenter.onItemSelected(category, position);
    }
}
