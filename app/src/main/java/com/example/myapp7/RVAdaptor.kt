package com.example.myapp7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
//adaptor for recycleview
class RVAdaptor(private val items: ArrayList<String>): RecyclerView.Adapter<RVAdaptor.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        // use textview view
        val textView: TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // creates a viewHolder every time it needed
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //bind data wtih the viewHolder
        // we need an array of string
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int {
        //return size of items
        return items.size
    }

}