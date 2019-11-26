package com.trydev.cbr.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trydev.cbr.R
import com.trydev.cbr.model.Indication
import com.trydev.cbr.utils.OnCheckedIndicationListener

class CheckProblemAdapter (private val context: Context, private val items: List<Indication>, val listener: OnCheckedIndicationListener) : RecyclerView.Adapter<CheckProblemAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var checkbox : CheckBox = view.findViewById<TextView>(R.id.checkbox) as CheckBox
        private val name = view.findViewById<TextView>(R.id.indication)
        fun bindItem(items: Indication, listener: OnCheckedIndicationListener) {
            this.setIsRecyclable(false)
            name.text = items.name
            checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked){
                    listener.onChecked(items)
                } else{
                    listener.notChecked(items)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_check, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem((items[position]), listener)
    }
}