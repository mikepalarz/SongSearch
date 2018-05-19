package com.palarz.mike.songsearch;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class was created so that we're always using one instance of both the OkHttpClient
 * and Retrofit. More specifically, it ensures that only one networking socket is opened
 * for all of our HTTP requests. The idea was taken from here:
 *
 * https://futurestud.io/tutorials/retrofit-2-creating-a-sustainable-android-client
 *
 * All variables (as well as methods) are made static so that there is only one instance
 * of them at a time.
 */

public class ClientGenerator {

    private static String BASE_URL_ACCOUNTS = "https://accounts.spotify.com";

    private static OkHttpClient.Builder sClientBuilder = new OkHttpClient.Builder();

    private static Retrofit.Builder sRetrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL_ACCOUNTS)
            .addConverterFactory(GsonConverterFactory.create())
            .client(sClientBuilder.build());

    private static Retrofit sRetrofit = sRetrofitBuilder.build();

    public static <S> S createClient(Class<S> clientClass) {
        return sRetrofit.create(clientClass);
    }

}
