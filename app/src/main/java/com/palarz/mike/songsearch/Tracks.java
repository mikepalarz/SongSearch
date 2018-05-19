package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 5/19/18.
 */

public class Tracks {

    @SerializedName("items")
    private List<Track> mTracks;

    public Tracks() {
        this.mTracks = new ArrayList<>();
    }

    public Tracks(ArrayList<Track> tracks) {
        this.mTracks = tracks;
    }

    public List<Track> getTracks() {
        return mTracks;
    }

}
