package com.example.espresso_ui_testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun test_isActivityInView() {

        onView(withId(R.id.secondActivity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_backbutton() {

        onView(withId(R.id.titletext))
            .check(matches(isDisplayed()))

        onView(withId(R.id.backButton))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTitleTextDisplayed() {
        onView(withId(R.id.titletext))
            .check(matches(withText(R.string.your_trip_includes_free_coffee_would_you_like_to_experience_this_again)))
    }
}