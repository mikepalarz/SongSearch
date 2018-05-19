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

    String BASE_URL = "http://openlibrary.org/";
    String BASE_URL_ACCOUNTS = "https://accounts.spotify.com";

    @FormUrlEncoded
    @POST("api/token")
    Call<TokenResponse> getAccessToken(@Header("Authorization") String encodedIDAndSecret, @Field("grant_type") String grantType);


    @GET("search.json")
    Call<BookSearchResponse> getAllBooks(@Query("q") String query);

}
