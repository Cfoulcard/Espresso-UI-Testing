package com.example.espresso_ui_testing.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

// Create the table in Room
@Entity(tableName = "notes")
class Note : Parcelable {

    // Automatically add IDs
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    // We do not want the title to be null. If it is null an exception will be thrown
    @NonNull
    @ColumnInfo(name = "title")
    private var title: String? = null

    @ColumnInfo(name = "content")
    private var content: String? = null

    @ColumnInfo(name = "timestamp")
    private var timestamp: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        title = parcel.readString()
        content = parcel.readString()
        timestamp = parcel.readString()
    }

    // Main Constructor for creating new notes
    constructor(@NonNull title: String, content: String, timestamp: String) {
        this.title = title
        this.content = content
        this.timestamp = timestamp
    }

    @Ignore
    constructor(id: Int, @NonNull title: String, content: String, timestamp: String) {
        this.id = id
        this.title = title
        this.content = content
        this.timestamp = timestamp
    }

    @Ignore
    constructor() {
    }

    @Ignore
    constructor(note: Note) {
        id = note.id
        title = note.title
        content = note.content
        timestamp = note.timestamp
    }

    fun getId(): Int {
        return id!!
    }

    fun setId(id: Int) {
        this.id = id
    }

    @NonNull
    fun getTitle(): String? {
        return title
    }

    fun setTitle(@NonNull title: String?) {
        this.title = title
    }

    fun getContent(): String? {
        return content
    }

    fun setContent(content: String?) {
        this.content = content
    }

    fun getTimestamp(): String? {
        return timestamp
    }

    fun setTimestamp(timestamp: String?) {
        this.timestamp = timestamp
    }

    override fun toString(): String {
        return "Note(id=$id, title=$title, content=$content, timestamp=$timestamp)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(timestamp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note? {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }

    override fun equals(@Nullable obj: Any?): Boolean {
        if (obj == null) {
            return false
        }
        if (javaClass != obj.javaClass) {
            return false
        }
        val note: Note = obj as Note
        return note.getId() === getId() && note.getTitle().equals(getTitle()) && note.getContent()
            .equals(getContent())
    }
}