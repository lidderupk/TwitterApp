
package com.bindaas.twitterapp.test;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;

public class ResourcesUnitTest extends AndroidTestCase {
    /*
     * see http://googletesting.blogspot.com/2010/12/test-sizes.html for
     * explanation of mediumtest
     */
    @MediumTest
    public void testApplicationName() {
        int appName = com.bindaas.twitterapp.R.string.app_name;
        assertEquals("Twitter Application", getContext().getString(appName));
    }

}
