package com.trydev.cbr.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trydev.cbr.model.Indication
import com.trydev.cbr.R

class IndicationAdapter(private val context: Context, private val items: List<Indication>) : RecyclerView.Adapter<IndicationAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_indication, parent, false))

    override fun getItemCount() : Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val code = view.findViewById<TextView>(R.id.text_code)
        private val name = view.findViewById<TextView>(R.id.text_name)
        private val value = view.findViewById<TextView>(R.id.text_value)
        fun bindItem(items: Indication) {
            code.text = "G" + items.code.toString()
            name.text = items.name
            value.text = items.value.toString()
        }
    }
}