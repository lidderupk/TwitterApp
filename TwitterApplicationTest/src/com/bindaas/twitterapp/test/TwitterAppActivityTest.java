
package com.bindaas.twitterapp.test;

import com.bindaas.twitterapp.R;
import com.bindaas.twitterapp.activities.TwitterAppActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.ListView;

public class TwitterAppActivityTest extends ActivityInstrumentationTestCase2<TwitterAppActivity> {

    private TwitterAppActivity mActivity;

    ListView lvTweets;

    public TwitterAppActivityTest() {
        super(TwitterAppActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        mActivity = getActivity();
        lvTweets = (ListView)mActivity.findViewById(R.id.lvTweets);
    }

    public void testPreConditions() {
        Log.d("debug", "test debug");
        assertTrue(lvTweets != null);
    }

}
