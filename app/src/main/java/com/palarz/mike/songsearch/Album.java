package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 5/19/18.
 */

public class Album {

    // The name of the album. In case of an album takedown, the value may be an empty string.
    @SerializedName("name")
    String mAlbumTitle;

    // The cover art for the album in various sizes, widest first.
    @SerializedName("images")
    List<AlbumCover> mAlbumCovers;

    public Album() {
        this.mAlbumTitle = "";
        this.mAlbumCovers = new ArrayList<>();
    }

    public Album(String albumTitle, ArrayList<AlbumCover> albumCovers) {
        this.mAlbumTitle = albumTitle;
        this.mAlbumCovers = albumCovers;
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public List<AlbumCover> getAlbumCovers() {
        return mAlbumCovers;
    }

    public String getLargeAlbumCover() {
        return mAlbumCovers.get(0).getURL();
    }

}
