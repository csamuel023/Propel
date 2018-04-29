package com.example.christophersamuel.propel;

import android.app.*;
import android.app.*;
import android.content.*;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.*;

public class ExerciseActivitiesTest {

    @Rule
    public ActivityTestRule<ExerciseActivities> mActivityRule =
            new ActivityTestRule<ExerciseActivities>(ExerciseActivities.class) {
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation()
                            .getTargetContext();
                    Intent result = new Intent(targetContext, ExerciseActivities.class);
                    result.putExtra("i", 0);
                    return result;
                }
            };

    private ExerciseActivities mActivity = null;

    Instrumentation.ActivityMonitor monitor3 = getInstrumentation().addMonitor(Day1Activity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityRule.getActivity();

    }

    @Test
    public void test(){
        assertNotNull(mActivity.findViewById(R.id.btn));
        RadioGroup r1;
        r1 = mActivity.findViewById(R.id.legRadio);
        r1.check(R.id.leg_extention);
        r1 = mActivity.findViewById(R.id.chestRadio);
        r1.check(R.id.benchPress);
        r1 = mActivity.findViewById(R.id.bicepRadio);
        r1.check(R.id.DumCurl);
        r1 = mActivity.findViewById(R.id.backRadio);
        r1.check(R.id.deadLift);
        r1 = mActivity.findViewById(R.id.shoulderRadio);
        r1.check(R.id.dumUpright);
        r1 = mActivity.findViewById(R.id.coreRadio);
        r1.check(R.id.mntClimbers);
        r1 = mActivity.findViewById(R.id.cardioRadio);
        r1.check(R.id.running);
        onView(withId(R.id.btn)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor3, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();

    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}