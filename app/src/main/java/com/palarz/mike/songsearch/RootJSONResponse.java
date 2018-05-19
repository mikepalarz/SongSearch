package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mike on 5/19/18.
 */

public class RootJSONResponse {

    @SerializedName("tracks")
    Paging mPaging;

    public RootJSONResponse() {
        this.mPaging = null;
    }

    public RootJSONResponse(Paging paging) {
        this.mPaging = paging;
    }
}
