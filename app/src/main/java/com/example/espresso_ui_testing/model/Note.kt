package com.example.espresso_ui_testing.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import android.os.Parcel
import androidx.room.Entity
import androidx.room.Ignore

@Entity(tableName = "notes")
class Note : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "title")
    var title: String

    @ColumnInfo(name = "content")
    var content: String?

    @ColumnInfo(name = "timestamp")
    var timestamp: String?

    constructor(title: String, content: String?, timestamp: String?) {
        this.title = title
        this.content = content
        this.timestamp = timestamp
    }

    @Ignore
    constructor(id: Int, title: String, content: String?, timestamp: String?) {
        this.id = id
        this.title = title
        this.content = content
        this.timestamp = timestamp
    }

    @Ignore
    constructor(note: Note) {
        id = note.id
        title = note.title
        content = note.content
        timestamp = note.timestamp
    }

    protected constructor(`in`: Parcel) {
        id = `in`.readInt()
        title = `in`.readString()!!
        content = `in`.readString()
        timestamp = `in`.readString()
    }

    override fun toString(): String {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}'
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(title)
        dest.writeString(content)
        dest.writeString(timestamp)
    }

    override fun equals(obj: Any?): Boolean {
        if (obj == null) {
            return false
        }
        if (javaClass != obj.javaClass) {
            return false
        }
        val note = obj as Note
        return note.id == id && note.title == title && note.content == content
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }


}