package com.example.christophersamuel.propel;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LoginSinup.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch() {

        View v1 = mActivity.findViewById(R.id.button7);
        assertNotNull(v1);

        View v2 = mActivity.findViewById(R.id.button8);
        assertNotNull(v2);

        View v3 = mActivity.findViewById(R.id.imageView);
        assertNotNull(v3);

    }
    public void testLaunchOfLoginSinupActivityOnButtonClick() {

        assertNotNull(mActivity.findViewById(R.id.button7));
        onView(withId(R.id.button7)).perform(click());
        Activity loginSinup = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(loginSinup);
        loginSinup.finish();

    }

    public void testLaunchOfSecondActivityOnButtonClick() {

        assertNotNull(mActivity.findViewById(R.id.button8));
        onView(withId(R.id.button8)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();

    }

    @After
    public void tearDown() throws Exception {

        mActivity = null;

    }
}