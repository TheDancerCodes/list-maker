package com.thedancercodes.listmaker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ListDetailActivity : AppCompatActivity() {

    lateinit var list: TaskList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)

        // Retrieve the list that was pass in Extra
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)

        // Update title based off the list name
        title = list.name
    }
}
