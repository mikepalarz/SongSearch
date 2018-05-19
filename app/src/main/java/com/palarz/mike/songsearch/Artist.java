package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mike on 5/19/18.
 */

public class Artist {

    @SerializedName("name")
    String mName;

    public Artist() {
        this.mName = "";
    }

    public Artist(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }
}
