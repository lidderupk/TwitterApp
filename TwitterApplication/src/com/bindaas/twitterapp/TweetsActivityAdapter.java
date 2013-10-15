
package com.bindaas.twitterapp;

import com.bindaas.twitterapp.models.Tweet;
import com.nostra13.universalimageloader.core.ImageLoader;

import roboguice.inject.InjectView;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TweetsActivityAdapter extends ArrayAdapter<Tweet> {

    @InjectView(R.id.ivProfilePic)
    ImageView ivProfilePic;

    @InjectView(R.id.tvUserName)
    TextView tvUserName;

    @InjectView(R.id.tvTweet)
    TextView tvTweet;

    // @Inject
    // protected Injector injector;

    private final static String tag = "Debug - com.codepath.upkar.twitterapp.TweetsActivityAdapter";

    // @Inject
    public TweetsActivityAdapter(Context context, List<Tweet> tweets) {
        super(context, 0, tweets);
        // RoboInjector injector2 = RoboGuice.getInjector(context);
        // injector2.injectMembers(this);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_tweet, null);
        }

        // injector.injectMembers(this);
        setupViews(view);
        Tweet tweet = getItem(position);

        ImageLoader.getInstance().displayImage(tweet.getUser().getProfileImageUrl(), ivProfilePic);

        String formattedName = "<b>" + tweet.getUser().getName() + "</b>"
                + " <small><font color='#777777'>@" + tweet.getUser().getScreenName()
                + "</font></small>";
        tvUserName.setText(Html.fromHtml(formattedName));

        tvTweet.setText(Html.fromHtml(tweet.getBody()));

        return view;
    }

    private void setupViews(View view) {
        ivProfilePic = (ImageView)view.findViewById(R.id.ivProfilePic);
        tvUserName = (TextView)view.findViewById(R.id.tvUserName);
        tvTweet = (TextView)view.findViewById(R.id.tvTweet);
    }
}
