package com.thedancercodes.listmaker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.widget.EditText

class ListDetailActivity : AppCompatActivity() {

    lateinit var list: TaskList
    lateinit var listItemsRecyclerView: RecyclerView // Variable holding reference to RecyclerView
    lateinit var addtaskButton: FloatingActionButton // Variable holding reference to FAB

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

        // Instantiate FAB
        addtaskButton = findViewById<FloatingActionButton>(R.id.add_task_button)
        addtaskButton.setOnClickListener {

            showCreateTaskDialog()
        }
    }

    private fun showCreateTaskDialog() {

        // EditText
        val taskEditText = EditText(this)
        taskEditText.inputType = InputType.TYPE_CLASS_TEXT

        // Dialog
        AlertDialog.Builder(this).setTitle(R.string.task_to_add)
                .setView(taskEditText)
                .setPositiveButton(R.string.add_task, { dialog, _ ->

            // Get text user inputs into EditText
            val task = taskEditText.text.toString()
            list.tasks.add(task)

            val recyclerAdapter = listItemsRecyclerView.adapter as ListItemsRecyclerViewAdapter
            recyclerAdapter.notifyItemInserted(list.tasks.size)
            dialog.dismiss()

        }).create().show()
    }

    // Save list when user taps back button
    override fun onBackPressed() {

        // Create Bundle and put list inside it
        val bundle = Bundle()
        bundle.putParcelable(MainActivity.INTENT_LIST_KEY, list)

        // Send result back to Activity notifying all is OK.
        val intent = Intent()
        intent.putExtras(bundle)
        setResult(Activity.RESULT_OK, intent)

        super.onBackPressed()
    }
}
