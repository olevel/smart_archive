package com.hacker.olevel.smartarchive.Controller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * File: SquareDepartmentGridItem.java
 * Desc: This is a square layout that will host a TextView for department code and full department
 *          name at the center
 *
 * Created by olevel on 6/6/17.
 */

public class SquareDepartmentGridItem extends LinearLayout{
    public SquareDepartmentGridItem(Context context) {
        super(context);
    }

    public SquareDepartmentGridItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareDepartmentGridItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
