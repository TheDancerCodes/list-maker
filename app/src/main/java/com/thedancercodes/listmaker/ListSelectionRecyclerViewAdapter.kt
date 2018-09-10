package com.thedancercodes.listmaker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by TheDancerCodes on 10/09/2018.
 */
class ListSelectionRecyclerViewAdapter : RecyclerView.Adapter<ListSelectionViewHolder>() {

    // Instance variable to contain our list
    val listTitles = arrayOf("Shopping List", "Chores", "Android Tuts")

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ListSelectionViewHolder {

        // Reference the ViewHolder view
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_selection_view_holder, parent, false)

        // Create an instance of ViewHolder and pass in the view.
        return ListSelectionViewHolder(view)
    }

    // Returns number of items in the list
    override fun getItemCount(): Int {
        return listTitles.size
    }

    override fun onBindViewHolder(p0: ListSelectionViewHolder, p1: Int) {

    }
}