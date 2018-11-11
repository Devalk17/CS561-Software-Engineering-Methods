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

public class MainScreenTest {

    @Rule
    public ActivityTestRule<MainScreen> mainScreenActivityTestRule = new ActivityTestRule<MainScreen>(MainScreen.class);
    private MainScreen mainScreenActivity = null;
    Instrumentation.ActivityMonitor monitorRent = getInstrumentation().addMonitor(renterScreen.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitorGrant = getInstrumentation().addMonitor(granterScreen.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        mainScreenActivity = mainScreenActivityTestRule.getActivity();

    }

    @Test
    public void TestLaunchOfRenterButton(){

        assertNotNull(mainScreenActivity.findViewById(R.id.renterButton));

        onView(withId(R.id.renterButton)).perform(click());
        Activity nextActivity = getInstrumentation().waitForMonitorWithTimeout(monitorRent,10000);
        assertNotNull(nextActivity);
        nextActivity.finish();

    }

    @Test
    public void TestLaunchOfGranterButton(){

        assertNotNull(mainScreenActivity.findViewById(R.id.granterButton));

        onView(withId(R.id.granterButton)).perform(click());
        Activity activitynext = getInstrumentation().waitForMonitorWithTimeout(monitorGrant,10000);
        assertNotNull(activitynext);
        activitynext.finish();

    }

    @After
    public void tearDown() throws Exception {
    mainScreenActivity = null;
    }
}