package com.example.espresso_ui_testing

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    // Test to navigate to second activity upon clicking button
    @Test
    fun test_nav_Second_Activity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_to_next_activity)).perform(click())
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()))
    }

    // Test to navigate to second activity, press button, and go back to first activity
    @Test
    fun backPress() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_to_next_activity)).perform(click())
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()))
        onView(withId(R.id.backButton)).perform(click())
        // pressBack() works as well, but we specifically want to press the button
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    // This is a demonstration of how to check if an activity is in view and displayed
    @Test
    fun isActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    // Testing to see if the title text matches what the view displays
    @Test
    fun test_visibility_title_of_button() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.titletext)).check(matches(isDisplayed()))
    }
}