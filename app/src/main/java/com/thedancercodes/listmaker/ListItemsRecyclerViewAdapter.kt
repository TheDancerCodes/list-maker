package com.thedancercodes.listmaker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by TheDancerCodes on 11/09/2018.
 */
class ListItemsRecyclerViewAdapter(var list: TaskList) : RecyclerView.Adapter<ListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ListItemViewHolder {

        // Inflate the View and then return it.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_view_holder, parent, false)
        return ListItemViewHolder(view)
    }

    // Return number of tasks a list contains
    override fun getItemCount(): Int {
       return list.tasks.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {

        // Check if holder exists and set TextView from the current task
        if (holder != null) {
            holder.taskTextView.text = list.tasks[position]
        }
    }

}