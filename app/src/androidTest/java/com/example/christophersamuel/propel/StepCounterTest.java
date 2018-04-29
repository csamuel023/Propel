package com.example.christophersamuel.propel;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class StepCounterTest {

    @Rule
    public ActivityTestRule<StepCounter> stepCounterTestRule =
            new ActivityTestRule<StepCounter>(StepCounter.class);

    private StepCounter stepCounter = null;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLaunch() {

        View v1 = stepCounter.findViewById(R.id.numStepsTaken);
        assertNotNull(v1);

        View v2 = stepCounter.findViewById(R.id.ProgressBar01);
        assertNotNull(v2);

        View v3 = stepCounter.findViewById(R.id.stepsGoal);
        assertNotNull(v3);
    }

    @After
    public void tearDown() throws Exception {

        stepCounter = null;

    }
}