package com.thedancercodes.listmaker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by TheDancerCodes on 10/09/2018.
 */
class ListSelectionRecyclerViewAdapter(val lists: ArrayList<TaskList>, val clickListener: ListSelectionRecyclerViewClickListener) : RecyclerView.Adapter<ListSelectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ListSelectionViewHolder {

        // Reference the ViewHolder view
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_selection_view_holder, parent, false)

        // Create an instance of ViewHolder and pass in the view.
        return ListSelectionViewHolder(view)
    }

    // Returns number of items in the list
    override fun getItemCount(): Int {
        return lists.size
    }

    interface ListSelectionRecyclerViewClickListener {

        fun listItemClicked(list: TaskList)
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {

        // Check whether holder exists
        if (holder != null) {
            holder.listPosition.text = (position + 1).toString()
            holder.listTitle.text = lists.get(position).name

            // Add ClickListener
            holder.itemView.setOnClickListener {
                clickListener.listItemClicked(lists.get(position))
            }
        }
    }

    // Function that adds a list to the RecyclerView
    fun addList(list: TaskList) {
        lists.add(list) // Takes a task list and adds it to the lists variable.

        // Updates adapter when it knows about the data change & RecyclerView updates automatically
        notifyDataSetChanged()
    }
}