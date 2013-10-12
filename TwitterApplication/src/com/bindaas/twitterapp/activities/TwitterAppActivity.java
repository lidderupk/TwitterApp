
package com.bindaas.twitterapp.activities;

import com.bindaas.twitterapp.R;
import com.bindaas.twitterapp.models.Tweet;
import com.bindaas.twitterapp.restclient.RestClientApp;
import com.loopj.android.http.AsyncHttpResponseHandler;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TwitterAppActivity extends RoboActivity {

    private final static String tag = "com.bindaas.twitterapp.activities.TwitterAppActivity";

    @InjectView(R.id.lvTweets)
    ListView lvTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_app);

        setupViews();
    }

    private void setupViews() {
        RestClientApp.getRestClient().getHomeTimeline(0, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, String arg1) {
                super.onSuccess(arg0, arg1);
                Log.d(tag, "successful");
            }

            @Override
            public void onFailure(Throwable exception, String arg1) {
                super.onFailure(exception, arg1);
                Log.d(tag, exception.getMessage());
            }
        });
        List<Tweet> tweets = new ArrayList<Tweet>();
        lvTweets.setAdapter(new ArrayAdapter<Tweet>(getBaseContext(), R.layout.item_tweet, tweets));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.twitter_app, menu);
        return true;
    }

}
