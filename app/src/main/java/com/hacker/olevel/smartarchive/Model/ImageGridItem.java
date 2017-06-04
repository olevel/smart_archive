package com.hacker.olevel.smartarchive.Model;

/**
 * File: ImageGridItem.java
 * Desc: This class is a model of a give image grid item.
 *          It is made up of mainly the image drawable reference and a caption.
 *
 * Created by olevel on 6/3/17.
 */

public class ImageGridItem {
    public String caption;
    public int drawableId;

    public ImageGridItem(String caption, int drawableId) {
        this.caption = caption;
        this.drawableId = drawableId;
    }


}
