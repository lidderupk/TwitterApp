
package com.bindaas.twitterapp.restclient;

import com.google.inject.util.Modules;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import roboguice.RoboGuice;

import android.content.Context;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 * 
 *     RestClient client = RestClientApp.getRestClient();
 *     // use client to send requests to API
 * 
 */
public class RestClientApp extends com.activeandroid.app.Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        RestClientApp.context = this;

        // Create global configuration and initialize ImageLoader with this
        // configuration
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory()
                .cacheOnDisc().build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config);

        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE,
                Modules.override(RoboGuice.newDefaultRoboModule(this)).with(new MyCustomModule()));
    }

    public static RestClient getRestClient() {
        return (RestClient)RestClient.getInstance(RestClient.class, RestClientApp.context);
    }
}
