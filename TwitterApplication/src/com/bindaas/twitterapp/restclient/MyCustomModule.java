
package com.bindaas.twitterapp.restclient;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;

import java.util.ArrayList;
import java.util.List;

public class MyCustomModule implements Module {

    @Override
    public void configure(Binder binder) {
        //        binder.bind(ITweet.class).to(Tweet.class);
        binder.bind(new TypeLiteral<List<String>>() {
        }).toInstance(new ArrayList<String>());

        //        binder.bind(new TypeLiteral<List<ITweet>>() {
        // }).toInstance(new ArrayList<ITweet>());
    }
}
