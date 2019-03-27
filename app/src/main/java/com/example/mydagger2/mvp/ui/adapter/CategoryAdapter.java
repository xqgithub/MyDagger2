package com.example.mydagger2.mvp.ui.adapter;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydagger2.R;
import com.example.mydagger2.mvp.entity.Category;

import java.util.Collections;
import java.util.List;

/**
 * Created by beijixiong on 2019/3/27.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categories;
    private ItemClickListener itemClickListener;


    public CategoryAdapter() {
        categories = Collections.emptyList();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_category_icon);
            textView = itemView.findViewById(R.id.label_category_name);
        }
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int position) {
        final Category category = categories.get(position);
        bind(holder, category);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(category, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    private void bind(CategoryViewHolder holder, Category category) {
        holder.textView.setText(category.getName());
        holder.textView.setBackgroundColor(
                getColor(holder.textView.getContext(), category.getPrimaryColor()));
        holder.imageView.setImageResource(category.getIcon());
        holder.imageView.setBackgroundColor(
                getColor(holder.imageView.getContext(), category.getBackgroundColor()));
    }

    private int getColor(Context context, @ColorRes int colorRes) {
        return ContextCompat.getColor(context, colorRes);
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(Category category, int position);
    }

}
