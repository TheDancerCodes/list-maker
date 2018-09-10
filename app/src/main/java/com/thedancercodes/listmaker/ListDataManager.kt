package com.thedancercodes.listmaker

import android.content.Context
import android.preference.PreferenceManager

/**
 * Created by TheDancerCodes on 10/09/2018.
 */

// A centralised DataManager object to manage the operations of SharedPreferences.
class ListDataManager(val context: Context) {

    // Method to save the list
    fun saveList(list: TaskList) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()

        // Save the task list as a Set: a list without duplicates
        sharedPreferences.putStringSet(list.name, list.tasks.toHashSet()) // Convert List to Set
        sharedPreferences.apply()
    }

    // Method to read the list
    fun readLists(): ArrayList<TaskList> {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val sharedPreferenceContents = sharedPreferences.all

        // Variable to store task lists
        val taskLists = ArrayList<TaskList>()

        // Loop over items returned from the preferences.
        for (preferenceItem in sharedPreferenceContents) {
            val itemHashSet = preferenceItem.value as HashSet<String>
            val list = TaskList(preferenceItem.key, ArrayList(itemHashSet)) // Convert Set to List
            taskLists.add(list)
        }

        return taskLists
    }
}