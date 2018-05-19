package com.palarz.mike.songsearch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mike on 5/18/18.
 */

class TokenResponse {

    @SerializedName("access_token")
    String mAccessToken;

    @SerializedName("token_type")
    String mTokenType;

    @SerializedName("expires_in")
    int mExpiration;

    public TokenResponse() {
        this.mAccessToken = "";
        this.mTokenType = "";
        this.mExpiration = 0;
    }

    public TokenResponse(String accessToken, String tokenType, int expiration) {
        this.mAccessToken = accessToken;
        this.mTokenType = tokenType;
        this.mExpiration = expiration;
    }


    public String getAccessToken() {
        return mAccessToken;
    }

    public String getTokenType() {
        return mTokenType;
    }

    public int getExpiration() {
        return mExpiration;
    }

}
