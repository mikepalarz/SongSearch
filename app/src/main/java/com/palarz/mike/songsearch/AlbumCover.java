package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mike on 5/19/18.
 */

class AlbumCover {

    // The image height in pixels. If unknown: null or not returned.
    @SerializedName("height")
    int mHeight;

    // The image width in pixels. If unknown: null or not returned.
    @SerializedName("width")
    int mWidth;

    // The source URL of the image.
    @SerializedName("url")
    String mURL;

    public AlbumCover() {
        this.mHeight = 0;
        this.mWidth = 0;
        this.mURL = "";
    }

    public AlbumCover(int height, int width, String url) {
        this.mHeight = height;
        this.mWidth = width;
        this.mURL = url;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getWidth() {
        return mWidth;
    }

    public String getURL() {
        return mURL;
    }

}
