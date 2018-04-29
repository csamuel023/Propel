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
import static org.junit.Assert.*;

public class Day1ActivityTest {

    @Rule
    public ActivityTestRule<Day1Activity> mActivityTestRule = new ActivityTestRule<Day1Activity>(Day1Activity.class);

    private Day1Activity mActivity = null;

    Instrumentation.ActivityMonitor monitor1 = getInstrumentation().addMonitor(ExerciseActivities.class.getName(), null, false);
    Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(ThirdActivity.class.getName(), null, false);
    Instrumentation.ActivityMonitor monitor3 = getInstrumentation().addMonitor(Day2Activity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void launchExercise(){

        assertNotNull(mActivity.findViewById(R.id.addexercise));
        onView(withId(R.id.addexercise)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor1, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();

    }

    @Test
    public void launchHome(){

        assertNotNull(mActivity.findViewById(R.id.done));
        onView(withId(R.id.done)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor2, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();

    }
    @Test
    public void launchNextDay(){

        assertNotNull(mActivity.findViewById(R.id.next_day));
        onView(withId(R.id.next_day)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor3, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();

    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}