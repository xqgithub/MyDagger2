package com.example.mydagger2.mvp.entity;

/**
 * Created by beijixiong on 2019/3/26.
 * 实体类
 */

public class Category {

    private String mName;
    private int mIcon;
    private int mBackgroundColor;
    private int mPrimaryColor;

    public Category(String mName, int mIcon, int mBackgroundColor, int mPrimaryColor) {
        this.mName = mName;
        this.mIcon = mIcon;
        this.mBackgroundColor = mBackgroundColor;
        this.mPrimaryColor = mPrimaryColor;
    }

    public String getName() {
        return mName;
    }

    public int getIcon() {
        return mIcon;
    }

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    public int getPrimaryColor() {
        return mPrimaryColor;
    }
}
