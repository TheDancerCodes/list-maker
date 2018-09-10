package com.thedancercodes.listmaker

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by TheDancerCodes on 10/09/2018.
 */
class ListSelectionRecyclerViewAdapter : RecyclerView.Adapter<ListSelectionViewHolder>() {

    // Instance variable to contain our list
    val listTitles = arrayOf("Shopping List", "Chores", "Android Tuts")

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListSelectionViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // Returns number of items in the list
    override fun getItemCount(): Int {
        return listTitles.size
    }

    override fun onBindViewHolder(p0: ListSelectionViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}