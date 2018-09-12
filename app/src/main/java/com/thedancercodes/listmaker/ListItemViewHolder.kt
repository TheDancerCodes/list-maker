package com.thedancercodes.listmaker

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by TheDancerCodes on 11/09/2018.
 */
// Set up the ListItemViewHolder constructor to pass in a View so that we can use a reference to
// the ViewHolders widgets.
class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // Reference to our TextView
    val taskTextView = itemView.findViewById<TextView>(R.id.textview_task) as TextView
}