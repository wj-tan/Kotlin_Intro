package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.TextItemViewHolder
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter : RecyclerView.Adapter<TextItemViewHolder>() {
    // A list to hold the data
    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // Returns the size of the list in the data
    // RecyclerView need to know how many items the adapter has for it to display, which is done by calling getItemCount()
    override fun getItemCount () = data.size

    // Method called by RecyclerView to display the data for one list item at the specified position
    // The holder for this case is the TextItemViewHolder
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.sleepQuality.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        // Pass in the XML for the view, and the parent view group for the view
        // Boolean argument is for attachToRoot, needs to be false as RecyclerView adds this item to the view hierarchy for you when it's time
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView

        return TextItemViewHolder(view)
    }
}