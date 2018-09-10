package com.thedancercodes.listmaker

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by TheDancerCodes on 10/09/2018.
 */
class ListSelectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // Initialize the ViewHolder views
    val listPosition = itemView?.findViewById<TextView>(R.id.itemNumber) as TextView
    val listTitle = itemView?.findViewById<TextView>(R.id.itemString) as TextView
}