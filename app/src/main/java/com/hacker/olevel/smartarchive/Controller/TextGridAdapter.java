package com.hacker.olevel.smartarchive.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hacker.olevel.smartarchive.Model.TextGridItem;
import com.hacker.olevel.smartarchive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * File: TextGridAdapter.java
 * Desc: Handles text population of grid views
 *
 * Created by olevel on 6/4/17.
 */

public class TextGridAdapter extends BaseAdapter {
    private final List<TextGridItem> textGridItems = new ArrayList<>();
    private final LayoutInflater layoutInflater;

    public TextGridAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);

        textGridItems.add(new TextGridItem("Computer"));
        textGridItems.add(new TextGridItem("Minerals"));
        textGridItems.add(new TextGridItem("Mining"));
        textGridItems.add(new TextGridItem("Geology"));
        textGridItems.add(new TextGridItem("Mechanical"));
        textGridItems.add(new TextGridItem("Geomatics"));
        textGridItems.add(new TextGridItem("Petroleum"));
        textGridItems.add(new TextGridItem("Electrical"));
        textGridItems.add(new TextGridItem("Mathematics"));
    }

    @Override
    public int getCount() {
        return textGridItems.size();
    }

    @Override
    public TextGridItem getItem(int position) {
        return textGridItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        TextView gridText;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.grid_item_with_icon, parent, false);
            view.setTag(R.id.grid_text, view.findViewById(R.id.grid_text));
        }

        gridText = (TextView) view.getTag(R.id.grid_text);

        TextGridItem textGridItem = getItem(position);

        gridText.setText(textGridItem.text);

        return view;
    }
}
