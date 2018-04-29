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

public class LoginSinupTest {

    @Rule
    public ActivityTestRule<LoginSinup> loginSinupTestRule =
            new ActivityTestRule<LoginSinup>(LoginSinup.class);

    private LoginSinup loginSinupActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LoginSinup.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {

        loginSinupActivity = loginSinupTestRule.getActivity();

    }

    @Test
    public void testLaunch() {

        View v1 = loginSinupActivity.findViewById(R.id.bSignIn);
        assertNotNull(v1);

        View v2 = loginSinupActivity.findViewById(R.id.email_uname);
        assertNotNull(v2);

        View v3 = loginSinupActivity.findViewById(R.id.password);
        assertNotNull(v3);

    }
    public void testLaunchOfSecondActivityOnButtonClick() {

        assertNotNull(loginSinupActivity.findViewById(R.id.bSignIn));
        onView(withId(R.id.bSignIn)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @After
    public void tearDown() throws Exception {

        loginSinupActivity = null;

    }
}