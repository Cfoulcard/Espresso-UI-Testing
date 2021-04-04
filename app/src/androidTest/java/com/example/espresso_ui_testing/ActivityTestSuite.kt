package com.example.espresso_ui_testing

import org.junit.runner.RunWith
import org.junit.runners.Suite

// Suites allow you to run more than one test at the same time
@RunWith(Suite::class)
@Suite.SuiteClasses(MainActivityTest::class, SecondActivityTest::class)
class ActivityTestSuite {
}