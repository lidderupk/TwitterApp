
package com.bindaas.twitterapp.fragments;

import com.bindaas.twitterapp.models.Tweet;
import com.bindaas.twitterapp.restclient.RestClientApp;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import android.os.Bundle;

import java.util.ArrayList;

public class HomeTimeLineFragment extends TweetsListFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RestClientApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONArray tweetsAsJSON) {
                ArrayList<Tweet> tweetsFromJson = Tweet.fromJson(tweetsAsJSON);
                tweetsAdapter.addAll(tweetsFromJson);
            }

            @Override
            public void onFailure(Throwable arg0, JSONArray arg1) {
                super.onFailure(arg0, arg1);
            }
        });
    }
}
