package com.trydev.cbr.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trydev.cbr.model.History
import com.trydev.cbr.R

class HistoryAdapter (val context: Context, private val items: List<History>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder (view : View) : RecyclerView.ViewHolder(view){
        private val code : TextView = view.findViewById(R.id.text_code)
        private val textSolution : TextView = view.findViewById(R.id.text_diagnosis)
        var rvIndication : RecyclerView = view.findViewById(R.id.rv_indication)
        fun bindItem(items: History, context: Context){
            code.text = "C" + items.code.toString()
            textSolution.text = items.solution
            rvIndication.layoutManager = LinearLayoutManager(context)
            rvIndication.adapter = StringIndicationAdapter(context, items.listIndication)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_history, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], context)
    }

}