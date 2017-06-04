package com.hacker.olevel.smartarchive.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * File: RectangularGridItem.java
 * Desc: A simple RelativeLayout of predefined rectangular shape
 * Created by olevel on 6/4/17.
 */

public class RectangularGridItem extends RelativeLayout {
    public RectangularGridItem(@NonNull Context context) {
        super(context);
    }

    public RectangularGridItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RectangularGridItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = (int) (getMeasuredWidth() * 0.6);
        setMeasuredDimension(getMeasuredWidth(), height);
    }
}
