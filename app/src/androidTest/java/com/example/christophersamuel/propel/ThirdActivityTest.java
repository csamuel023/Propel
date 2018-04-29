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

public class ThirdActivityTest {

    @Rule
    public ActivityTestRule<ThirdActivity> thirdActivityTestRule =
            new ActivityTestRule<ThirdActivity>(ThirdActivity.class);

    private ThirdActivity thirdActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LoginSinup.class.getName(), null, false);


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLaunch() {

        View v1 = thirdActivity.findViewById(R.id.bUpdateProfile);
        assertNotNull(v1);

        View v2 = thirdActivity.findViewById(R.id.bCreateSchedule);
        assertNotNull(v2);

        View v3 = thirdActivity.findViewById(R.id.bSeeSchedule);
        assertNotNull(v3);

        View v4 = thirdActivity.findViewById(R.id.bGoals);
        assertNotNull(v4);

        View v5 = thirdActivity.findViewById(R.id.bSummary);
        assertNotNull(v5);

    }

    public void testLaunchOfBodyInfoOnButtonClick() {

        assertNotNull(thirdActivity.findViewById(R.id.bUpdateProfile));
        onView(withId(R.id.bUpdateProfile)).perform(click());
        Activity thirdActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(thirdActivity);
        thirdActivity.finish();

    }

    public void testLaunchOfDay1OnButtonClick() {

        assertNotNull(thirdActivity.findViewById(R.id.bCreateSchedule));
        onView(withId(R.id.bCreateSchedule)).perform(click());
        Activity thirdActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(thirdActivity);
        thirdActivity.finish();

    }

    public void testLaunchOfWeeklyCalendarOnButtonClick() {

        assertNotNull(thirdActivity.findViewById(R.id.bSeeSchedule));
        onView(withId(R.id.bSeeSchedule)).perform(click());
        Activity thirdActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(thirdActivity);
        thirdActivity.finish();

    }

    public void testLaunchOfGoalsOnButtonClick() {

        assertNotNull(thirdActivity.findViewById(R.id.bGoals));
        onView(withId(R.id.bGoals)).perform(click());
        Activity thirdActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(thirdActivity);
        thirdActivity.finish();

    }

    public void testLaunchOfSummaryOnButtonClick() {

        assertNotNull(thirdActivity.findViewById(R.id.bSummary));
        onView(withId(R.id.bSummary)).perform(click());
        Activity thirdActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(thirdActivity);
        thirdActivity.finish();

    }

    @After
    public void tearDown() throws Exception {

        thirdActivity = null;

    }
}