
package com.bindaas.twitterapp.activities;

import com.bindaas.twitterapp.R;
import com.bindaas.twitterapp.fragments.HomeTimeLineFragment;
import com.bindaas.twitterapp.fragments.MentionsFragment;

import roboguice.activity.RoboFragmentActivity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class TwitterAppActivity extends RoboFragmentActivity implements TabListener {

    private final static String tag = "com.bindaas.twitterapp.activities.TwitterAppActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_app);
        setupNavigationTabs();
    }

    private void setupNavigationTabs() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(true);
        Tab tabHome = actionBar.newTab().setText("Home").setTag("HomeTimeLineFragment")
                .setIcon(R.drawable.ic_home).setTabListener(this);
        Tab tabMention = actionBar.newTab().setText("Mention").setTag("MentionTimeLineFragment")
                .setIcon(R.drawable.ic_mention).setTabListener(this);
        actionBar.addTab(tabHome);
        actionBar.addTab(tabMention);
        actionBar.selectTab(tabHome);

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        android.support.v4.app.FragmentTransaction fts = getSupportFragmentManager()
                .beginTransaction();

        if (tab.getTag().equals("HomeTimeLineFragment")) {
            // set the fragment to home timeline
            fts.replace(R.id.frameContainer, new HomeTimeLineFragment());
        } else {
            // set the fragment to mention timeline
            fts.replace(R.id.frameContainer, new MentionsFragment());
        }

        fts.commit();
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
}
