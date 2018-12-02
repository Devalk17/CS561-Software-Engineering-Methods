package com.example.chethangarapati.parkinglot;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class logRegScreenTest {

    @Rule
    public ActivityTestRule<logRegScreen> logRegScreenActivityTestRule = new ActivityTestRule<logRegScreen>(logRegScreen.class);
    private logRegScreen logregScreeActivity = null;
    Instrumentation.ActivityMonitor monitorlogin = getInstrumentation().addMonitor(loginScreen.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitorRegister = getInstrumentation().addMonitor(regScreen.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        logregScreeActivity = logRegScreenActivityTestRule.getActivity();
    }

    @Test
    public void TestRegisterButton(){

        assertNotNull(logregScreeActivity.findViewById(R.id.regButton));

        onView(withId(R.id.regButton)).perform(click());
        Activity loginRegister = getInstrumentation().waitForMonitorWithTimeout(monitorRegister,10000);
        assertNotNull(loginRegister);
        loginRegister.finish();

    }

    @Test
    public void TestLoginButton(){

        assertNotNull(logregScreeActivity.findViewById(R.id.login));

        onView(withId(R.id.login)).perform(click());
        Activity loginClick = getInstrumentation().waitForMonitorWithTimeout(monitorlogin,50000);
        assertNotNull(loginClick);
        loginClick.finish();

    }


    @After
    public void tearDown() throws Exception {
        logregScreeActivity = null;
    }
}