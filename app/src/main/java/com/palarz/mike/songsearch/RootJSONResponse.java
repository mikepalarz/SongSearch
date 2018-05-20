package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mike on 5/19/18.
 */

public class RootJSONResponse {

    @SerializedName("tracks")
    PagingTracks mPagingTracks;

    public RootJSONResponse() {
        this.mPagingTracks = new PagingTracks();
    }

    public RootJSONResponse(PagingTracks pagingTracks) {
        this.mPagingTracks = pagingTracks;
    }

    public PagingTracks getPagingTracks() {
        return mPagingTracks;
    }
}
