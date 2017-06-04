package com.hacker.olevel.smartarchive.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hacker.olevel.smartarchive.Model.ImageGridItem;
import com.hacker.olevel.smartarchive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * File: ImageGridAdapter.java
 * Desc: This adapter populates grid views with images and text
 *
 * Created by olevel on 6/3/17.
 */

public class ImageGridAdapter extends BaseAdapter {
    private final List<ImageGridItem> imageGridItems = new ArrayList<>();
    private final LayoutInflater layoutInflater;

    public ImageGridAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);

        imageGridItems.add(new ImageGridItem("Computer", R.mipmap.material_wallpaper));
        imageGridItems.add(new ImageGridItem("Env & safety", R.mipmap.material_wallpaper));
        imageGridItems.add(new ImageGridItem("Electrical", R.mipmap.material_wallpaper));
        imageGridItems.add(new ImageGridItem("Mechanical", R.mipmap.material_wallpaper));
        imageGridItems.add(new ImageGridItem("Mining", R.mipmap.material_wallpaper));
        imageGridItems.add(new ImageGridItem("Minerals", R.mipmap.material_wallpaper));
        imageGridItems.add(new ImageGridItem("Petroleum", R.mipmap.material_wallpaper));
        imageGridItems.add(new ImageGridItem("Geomatics", R.mipmap.material_wallpaper));
        imageGridItems.add(new ImageGridItem("Geology", R.mipmap.material_wallpaper));

    }

    @Override
    public int getCount() {
        return imageGridItems.size();
    }

    @Override
    public ImageGridItem getItem(int position) {
        return imageGridItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return imageGridItems.get(position).drawableId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ImageView gridImage;
        TextView caption;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.grid_item_with_image, parent, false);
            view.setTag(R.id.grid_image, view.findViewById(R.id.grid_image));
            view.setTag(R.id.grid_caption, view.findViewById(R.id.grid_caption));
        }

        gridImage = (ImageView) view.getTag(R.id.grid_image);
        caption = (TextView) view.getTag(R.id.grid_caption);

        ImageGridItem imageGridItem = getItem(position);

        gridImage.setImageResource(imageGridItem.drawableId);
        caption.setText(imageGridItem.caption);

        return view;
    }
}
