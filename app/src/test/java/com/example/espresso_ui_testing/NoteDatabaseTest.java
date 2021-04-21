package com.example.espresso_ui_testing;

import android.content.Context;

import androidx.room.Room;

import com.example.espresso_ui_testing.persistence.NoteDao;
import com.example.espresso_ui_testing.persistence.NoteDatabase;

import org.junit.After;
import org.junit.Before;

public abstract class NoteDatabaseTest {

    // System Under Test
    private NoteDatabase noteDatabase;
    private Context ApplicationProvider;

    public NoteDao getNoteDao() {
        return noteDatabase.getNoteDao();
    }

    @Before
    public void init() {
        noteDatabase = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                NoteDatabase.class
        ).build();
    }

    @After
    public void finish() {
        noteDatabase.close();
    }
}
