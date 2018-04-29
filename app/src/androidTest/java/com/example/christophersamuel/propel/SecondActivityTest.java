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

public class SecondActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> secondActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity secondActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LoginSinup.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {

        secondActivity = secondActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch() {

        View v1 = secondActivity.findViewById(R.id.uname);
        assertNotNull(v1);

        View v2 = secondActivity.findViewById(R.id.email);
        assertNotNull(v2);

        View v3 = secondActivity.findViewById(R.id.pass1);
        assertNotNull(v3);

        View v4 = secondActivity.findViewById(R.id.pass2);
        assertNotNull(v4);

        View v5 = secondActivity.findViewById(R.id.bRegister);
        assertNotNull(v5);

    }

    public void testLaunchOfSecondActivityOnButtonClick() {

        assertNotNull(secondActivity.findViewById(R.id.bRegister));
        onView(withId(R.id.bRegister)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
        
    }

    @After
    public void tearDown() throws Exception {

        secondActivity = null;

    }
}