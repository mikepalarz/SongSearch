package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 5/14/18.
 */

public class Paging {

    // A link to the Web API endpoint returning the full result of the request.
    @SerializedName("href")
    private String mHref;

    // The maximum number of items in the response (as set in the query or by default).
    @SerializedName("limit")
    private int mLimit;

    // URL to the next page of items. ( null if none)
    @SerializedName("next")
    private String mNext;

    // The offset of the items returned (as set in the query or by default).
    @SerializedName("offset")
    private int mOffset;

    // URL to the previous page of items. ( null if none)
    @SerializedName("previous")
    private String mPrevious;

    // The total number of items available to return.
    @SerializedName("total")
    private int mTotal;

    public Paging() {
        this.mHref = "";
        this.mLimit = 0;
        this.mNext = "";
        this.mOffset = 0;
        this.mPrevious = "";
        this.mTotal = 0;
    }

    public Paging(String href, int limit, String next, int offset, String previous, int total) {
        this.mHref = href;
        this.mLimit = limit;
        this.mNext = next;
        this.mOffset = offset;
        this.mPrevious = previous;
        this.mTotal = total;
    }

    public String getHref() {
        return mHref;
    }

    public int getLimit() {
        return mLimit;
    }

    public String getNext() {
        return mNext;
    }

    public int getOffset() {
        return mOffset;
    }

    public String getPrevious() {
        return mPrevious;
    }

    public int getTotal() {
        return mTotal;
    }


}