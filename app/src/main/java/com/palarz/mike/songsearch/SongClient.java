package com.palarz.mike.songsearch;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by mike on 5/8/18.
 */

public interface SongClient {

    String BASE_URL_ACCOUNTS = "https://accounts.spotify.com/";
    String BASE_URL_SEARCH = "https://api.spotify.com/";

    @FormUrlEncoded
    @POST("api/token")
    Call<TokenResponse> getAccessToken(@Header("Authorization") String encodedIDAndSecret, @Field("grant_type") String grantType);

    @GET("v1/search?type=track&market=US")
    Call<RootJSONResponse> searchForTrack(@Header("Authorization") String accessToken, @Query("q") String query);


}
