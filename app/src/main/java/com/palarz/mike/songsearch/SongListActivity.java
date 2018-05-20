package com.palarz.mike.songsearch;

import android.provider.DocumentsContract;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v7.widget.SearchView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongListActivity extends AppCompatActivity {

    private static final String TAG = SongListActivity.class.getSimpleName();

    // TODO: I really, really need to figure out a better way to hide these...
    private static final String CLIENT_ID = "e31c0e021bb24dbcb39717172c68dd98";
    private static final String CLIENT_SECRET = "788b8ae21bb644c9a660c613cc912000";

    private ListView mSeachResults;
    private SongAdapter mAdapter;
    private SongClient mClient;
    private ProgressBar mProgressBar;
    private String mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        mSeachResults = (ListView) findViewById(R.id.book_list_list_view);
        ArrayList<Track> tracks = new ArrayList<>();
        mAdapter = new SongAdapter(this, tracks);
        mSeachResults.setAdapter(mAdapter);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        retrieveAccessToken();
    }

    private void retrieveAccessToken() {

        mClient = ClientGenerator.createClient(SongClient.class);

        String encodedString = encodeClientIDAndSecret();

        Call<TokenResponse> tokenResponseCall = mClient.getAccessToken(encodedString, "client_credentials");
        tokenResponseCall.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                Log.d(TAG, "on Response: response toString(): " + response.toString());
                TokenResponse tokenResponse = null;
                if (response.isSuccessful()) {
                    tokenResponse = response.body();
                    Log.d(TAG, "Access token value: " + tokenResponse.getAccessToken());
                    mAccessToken = tokenResponse.getAccessToken();
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: request toString():" + call.request().toString());
                mAccessToken = "";
            }
        });
    }

    private String encodeClientIDAndSecret(){
        String basic = "Basic ";
        String clientIDAndSecret = CLIENT_ID + ":" + CLIENT_SECRET;
        /*
        I use the NO_WRAP flag so that the encoded String is contained within a single line.
        Otherwise, there will be new line characters in the encoded String and we don't want to
        include those.
         */
        byte [] encodedValue = Base64.encode(clientIDAndSecret.getBytes(), Base64.NO_WRAP);
        String encodedString = new String(encodedValue);

        // The final output needs to have both the encoded String as well as 'Basic ' prepended to it
        return basic + encodedString;
    }

    private void fetchSongs(String query) {
        mProgressBar.setVisibility(ProgressBar.VISIBLE);
        ClientGenerator.changeBaseURL(SongClient.BASE_URL_SEARCH);

        mClient = ClientGenerator.createClient(SongClient.class);
        if (TextUtils.isEmpty(mAccessToken)) {
            return;
        }

        Call<RootJSONResponse> call = mClient.searchForTrack("Bearer " + mAccessToken, query);

        call.enqueue(new Callback<RootJSONResponse>() {
            @Override
            public void onResponse(Call<RootJSONResponse> call, Response<RootJSONResponse> response) {
                RootJSONResponse rootJSONResponse = null;
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: The full URL: " + call.request().url());
                    mAdapter.clear();
                    rootJSONResponse = response.body();
                    PagingTracks pagingTracks = rootJSONResponse.getPagingTracks();
                    List<Track> tracks = pagingTracks.getTracks();
                    for (Track track : tracks) {
                        mAdapter.add(track);
                    }
                    mAdapter.notifyDataSetChanged();
                    mProgressBar.setVisibility(ProgressBar.GONE);
                }
            }

            @Override
            public void onFailure(Call<RootJSONResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: The full URL: " + call.request().url());
                mProgressBar.setVisibility(ProgressBar.GONE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Fetch the remote data
                fetchSongs(query);
                // Reset the SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();
                // We'll also set the title of the activity to the current search query
                SongListActivity.this.setTitle(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }
}
