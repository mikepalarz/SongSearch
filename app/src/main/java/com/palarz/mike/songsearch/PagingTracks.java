package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 5/19/18.
 */

public class PagingTracks extends Paging {

    @SerializedName("items")
    private List<Track> mTracks;

    public PagingTracks() {
        super();
        this.mTracks = new ArrayList<>();
    }

    public PagingTracks(ArrayList<Track> tracks) {
        super();
        this.mTracks = tracks;
    }

    public List<Track> getTracks() {
        return mTracks;
    }

}
