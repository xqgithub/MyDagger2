package com.example.mydagger2.mvp.entity;

import android.os.Handler;

import com.example.mydagger2.R;
import com.example.mydagger2.mvp.listener.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beijixiong on 2019/3/26.
 */

public class Categories {

    public void getCategories(final Callback callback) {
        final int DELEAY_MILLIS = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onLoadCategories(createArrayList());
            }
        }, DELEAY_MILLIS);
    }

    private List<Category> createArrayList() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Food & Drink", R.drawable.image_category_food_raster, R.color.theme_green_background,
                R.color.theme_green_primary));
        categories.add(new Category("General Knowledge", R.drawable.image_category_knowledge_raster,
                R.color.theme_yellow_background, R.color.theme_yellow_primary));
        categories.add(new Category("History", R.drawable.image_category_history_raster, R.color.theme_blue_background,
                R.color.theme_blue_primary));
        categories.add(new Category("Geography", R.drawable.image_category_geography_raster, R.color.theme_red_background,
                R.color.theme_red_primary));
        categories.add(new Category("Science and Nature", R.drawable.image_category_science_raster,
                R.color.theme_green_background, R.color.theme_green_primary));
        categories.add(new Category("TV & Movies", R.drawable.image_category_tvmovies_raster,
                R.color.theme_purple_background, R.color.theme_purple_primary));
        categories.add(new Category("Music", R.drawable.image_category_science_raster, R.color.theme_blue_background,
                R.color.theme_blue_primary));
        categories.add(new Category("Entertainment", R.drawable.image_category_entertainment_raster, R.color.theme_red_background, R.color.theme_red_primary));
        categories.add(new Category("Sports", R.drawable.image_category_sports_raster, R.color.theme_purple_background,
                R.color.theme_purple_primary));
        return categories;
    }


}
