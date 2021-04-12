package com.example.espresso_ui_testing.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import com.example.espresso_ui_testing.util.DateUtilJava.months

import com.example.espresso_ui_testing.util.DateUtilJava.monthNumbers

import org.junit.jupiter.api.TestReporter

import org.junit.jupiter.api.TestInfo

internal class DateUtilTest {

    private val today = "04-2021"

    @Test
    fun testGetCurrentTimestamp_returnedTimestamp() {
        assertDoesNotThrow {
            assertEquals(today, DateUtilJava.getCurrentTimeStamp())
            println("Timestamp is generated correctly")
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    fun getMonthFromNumber_returnSuccess(
        monthNumber: Int,
        testInfo: TestInfo?,
        testReporter: TestReporter?
    ) {
        assertEquals(months[monthNumber], DateUtilJava.getMonthFromNumber(monthNumbers[monthNumber]))
        println(monthNumbers[monthNumber].toString() + " : " + months[monthNumber])
    }
}