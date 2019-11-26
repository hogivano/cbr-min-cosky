package com.trydev.cbr.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trydev.cbr.R
import com.trydev.cbr.model.Indication

class StringIndicationAdapter (val context: Context, private val items: List<Indication>) : RecyclerView.Adapter<StringIndicationAdapter.ViewHolder> (){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val text = view.findViewById<TextView>(R.id.name)
        fun bindItem(items: Indication){
            text.text = items.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_string_indication, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

}