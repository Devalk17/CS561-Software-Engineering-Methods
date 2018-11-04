package com.example.chethangarapati.parkinglot;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import static org.junit.Assert.*;


public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SiteBehaviorTest {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
        nStringToBetyped = "Espresso2";
    }

    @Test
    public void goToMainScreen() {
        // types value into email and password and checks if sign in button goes to correct layout.
        onView(withId(R.id.Emailsn))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.passwordsn))
                .perform(typeText(nStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.Sign-in)).perform(click());
        onView(withId(R.id.mainlayout)).check(matches(isDisplayed()));

    }

    @Test
    public void goToSignUp() {
        // types value into email and password and checks if sign in button goes to correct layout.
        onView(withId(R.id.Sign-in)).perform(click());
        onView(withId(R.id.mainlayout)).check(matches(isDisplayed()));

    }

    @Test
    public void goToGranter() {
        // types value into email and password and checks if sign in button goes to correct layout.
        onView(withId(R.id.granterButton)).perform(click());
        onView(withId(R.id.granterlayout)).check(matches(isDisplayed()));

    }

    @Test
    public void goToRenter() {
        // types value into email and password and checks if sign in button goes to correct layout.
        onView(withId(R.id.renterButton)).perform(click());
        onView(withId(R.id.renterlayout)).check(matches(isDisplayed()));

    }
}