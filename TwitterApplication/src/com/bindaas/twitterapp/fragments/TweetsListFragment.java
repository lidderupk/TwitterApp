
package com.bindaas.twitterapp.fragments;

import com.bindaas.twitterapp.R;
import com.bindaas.twitterapp.TweetsActivityAdapter;
import com.bindaas.twitterapp.models.Tweet;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TweetsListFragment extends RoboFragment {
    private final static String tag = "com.bindaas.twitterapp.fragments.TweetsListFragment";

    @InjectView(R.id.lvTweets)
    ListView lvTweets;

    List<Tweet> tweets = new ArrayList<Tweet>();

    TweetsActivityAdapter tweetsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_tweets_list, container, false);
        return view;
    }

    /*
     * (non-Javadoc)
     * @see roboguice.fragment.RoboFragment#onViewCreated(android.view.View,
     * android.os.Bundle) the views are injected after super.onViewCreated.
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tweetsAdapter = new TweetsActivityAdapter(getActivity().getBaseContext(), tweets);
        lvTweets.setAdapter(tweetsAdapter);
    }

    public TweetsActivityAdapter getAdapter() {
        return tweetsAdapter;
    }

}
