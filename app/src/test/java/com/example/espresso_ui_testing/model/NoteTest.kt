//package com.example.espresso_ui_testing.model
//
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.Assertions.*
//
//internal open class NoteTest {
//
//
//    /*
//    Compare two equal Notes
//     */
//    @Test
//    @Throws(Exception::class)
//    open fun isNotesEqual_identicalProperties_returnTrue() {
//
//        val TIMESTAMP_1 = "05-2019"
//        val TIMESTAMP_2 = "05-2019"
//
//
//        // Arrange
//        val note1 = Note("Note #1", "This is note #1", TIMESTAMP_1)
//        note1.id = 1
//        val note2 = Note("Note #1", "This is note #1", TIMESTAMP_1)
//        note2.id = 1
//
//        // Act
//
//
//        // Assert
//        assertEquals(note1, note2)
//        println("The notes are equal!")
//    }
///*
//    Compare notes with 2 different ids
//     */
//
//    /*
//    Compare two notes with different timestamps
//     */
//
//    /*
//    Compare two notes with different titles
//     */
//
//    /*
//    Compare two notes with different content
//     */
//}