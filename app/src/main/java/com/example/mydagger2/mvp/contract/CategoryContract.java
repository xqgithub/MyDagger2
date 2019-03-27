package com.example.mydagger2.mvp.contract;

import android.os.Handler;
import android.util.Log;

import com.example.mydagger2.R;
import com.example.mydagger2.constants.ConfigConstants;
import com.example.mydagger2.data.api.ApiService;
import com.example.mydagger2.mvp.entity.Category;
import com.example.mydagger2.mvp.listener.CategoryCallback;
import com.example.mydagger2.utils.PublicPracticalMethod;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by beijixiong on 2019/3/26.、
 * 实体类 数据实现
 */


public class CategoryContract {

    public void getCategories(ApiService apiService, final CategoryCallback callback) {
        //模拟网络数据
        final int DELEAY_MILLIS = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onLoadCategories(createArrayList());
            }
        }, DELEAY_MILLIS);

        //请求网络数据
        getApiData(apiService);
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


    public void getApiData(ApiService apiService) {
        Call<ResponseBody> call = apiService.location(ConfigConstants.BASE_URL + "api/client/v1/commons/location");
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        String jsonString = PublicPracticalMethod.getInstance().byte2String(response.body().bytes());
                        Log.i("CategoryPresenter", " =-= " + jsonString);
                    } catch (Exception e) {
                        Log.e("CategoryPresenter", e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("CategoryPresenter", " =-= " + t.getMessage());
            }
        });
    }
}
