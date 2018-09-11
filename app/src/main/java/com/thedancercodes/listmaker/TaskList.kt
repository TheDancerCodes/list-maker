package com.thedancercodes.listmaker

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by TheDancerCodes on 10/09/2018.
 */

// Task List object contains a name and an array list for the various tasks
// that need to be accomplished.
class TaskList(val name: String, val tasks: ArrayList<String> = ArrayList<String>()) : Parcelable {

    // Adding a 2nd Constructor so that TaskList object can be created from the passed in Parcel
    constructor(source: Parcel) : this(source.readString(), source.createStringArrayList())

    override fun describeContents(): Int = 0

    // Called when Parcel needs to be created from TaskList object
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeStringList(tasks)
    }

    // Static interface requirements:
    // We use companion objects since static objects don’t exist in Kotlin.
    companion object CREATOR : Parcelable.Creator<TaskList> {
        override fun createFromParcel(source: Parcel): TaskList = TaskList(source)
        override fun newArray(size: Int): Array<TaskList?> = arrayOfNulls(size)
    }

}


