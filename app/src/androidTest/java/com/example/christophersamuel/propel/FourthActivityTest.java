package com.example.christophersamuel.propel;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class FourthActivityTest {

    @Rule
    public ActivityTestRule<FourthActivity> fourthActivityTestRule =
            new ActivityTestRule<FourthActivity>(FourthActivity.class);

    private FourthActivity fourthActivity = null;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLaunch() {

        View v1 = fourthActivity.findViewById(R.id.button9);
        assertNotNull(v1);
    }

    @After
    public void tearDown() throws Exception {

        fourthActivity = null;

    }
}