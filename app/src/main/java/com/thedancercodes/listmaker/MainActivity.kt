package com.thedancercodes.listmaker

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var listsRecyclerView: RecyclerView

    // Instancing the List Manager class
    val listDataManager: ListDataManager = ListDataManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            showCreateListDialog()
        }

        // Get data from SharedPreferences
        val lists = listDataManager.readLists()


        // Reference the RecyclerView
        listsRecyclerView = findViewById<RecyclerView>(R.id.lists_recyclerview)
        listsRecyclerView.layoutManager = LinearLayoutManager(this)
        listsRecyclerView.adapter = ListSelectionRecyclerViewAdapter(lists)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Method to open the Dialog
    private fun showCreateListDialog() {

        // Reference to Dialog strings
        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)

        // Create instance of Dialog by calling a Builder Constructor
        val builder = AlertDialog.Builder(this)

        val listTitleEditText = EditText(this) // Edit Text UI Element
        listTitleEditText.inputType = InputType.TYPE_CLASS_TEXT // Set a text input keyboard

        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditText)

        builder.setPositiveButton(positiveButtonTitle, { dialog, i ->

            val list = TaskList(listTitleEditText.text.toString()) // Create new empty Task List
            listDataManager.saveList(list) // Save the list

            // Reference to our Recycler Adapter so that we can update the RecyclerView
            // with the new data
            val recyclerAdapter = listsRecyclerView.adapter as ListSelectionRecyclerViewAdapter
            recyclerAdapter.addList(list)

            dialog.dismiss()
        })

        builder.create().show()
    }
}
