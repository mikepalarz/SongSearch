package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * A class which represents a Track object from the Spotify Web API:
 *
 * https://beta.developer.spotify.com/documentation/web-api/reference/object-model/#track-object-full
 *
 * This class is used in order to parse the data returned by the JSON response in order to obtain
 * the following for a given track:
 *
 * 1. Track title
 * 2. Artist
 * 3. Album cover art (if available)
 *
 */

public class Track {

    // The name of the track.
    @SerializedName("name")
    String mTitle;

    // The album on which the track appears. The album object includes a link in href to full
    // information about the album.
    @SerializedName("album")
    Album mAlbum;

    // The artists who performed the track. Each artist object includes a link in href to more
    // detailed information about the artist.
    @SerializedName("artists")
    List<Artist> mArtists;

    public Track() {
        this.mTitle = "";
        this.mAlbum = new Album();
        this.mArtists = new ArrayList<>();
    }

    public Track(String title, Album album, ArrayList<Artist> artists) {
        this.mTitle = title;
        this.mAlbum = album;
        this.mArtists = artists;
    }

    public String getTitle() {
        return mTitle;
    }

    public Album getAlbum() {
        return mAlbum;
    }

    public List<Artist> getArtists() {
        return mArtists;
    }

    /**
     * Generates a comma-separated String of the artists associated to the track
     *
     * @return A comma-separated String of the artists associated to the track
     */
    public String getArtistNames() {
        if (mArtists == null || mArtists.size() == 0) {
            return "";
        }

        String artistNames = mArtists.get(0).getName();

        if (mArtists.size() > 1) {
            for (int i = 1; i < mArtists.size(); i++) {
                artistNames += ", " + mArtists.get(i).getName();
            }
        }

        return artistNames;
    }

}
