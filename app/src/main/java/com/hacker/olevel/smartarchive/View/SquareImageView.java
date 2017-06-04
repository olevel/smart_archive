package com.hacker.olevel.smartarchive.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


/**
 * File: SquareImageView
 * Desc: Ensures a square dimension of images to be used for grids
 * Created by olevel on 6/3/17.
 */

public class SquareImageView extends android.support.v7.widget.AppCompatImageView {
    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = (int) (getMeasuredWidth() * 0.6);
        setMeasuredDimension(getMeasuredWidth(), height);
    }
}
