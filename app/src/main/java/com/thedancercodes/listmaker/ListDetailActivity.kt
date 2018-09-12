package com.thedancercodes.listmaker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class ListDetailActivity : AppCompatActivity() {

    lateinit var list: TaskList
    lateinit var listItemsRecyclerView: RecyclerView // Variable holding reference to RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)

        // Retrieve the list that was pass in Extra
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)

        // Update title based off the list name
        title = list.name

        // Initialize RecyclerView
        listItemsRecyclerView = findViewById<RecyclerView>(R.id.list_items_recyclerview)
        listItemsRecyclerView.layoutManager = LinearLayoutManager(this)
        listItemsRecyclerView.adapter = ListItemsRecyclerViewAdapter(list) // Instance of Adapter
    }
}
