package com.example.nutricare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AssesoryAdapter(var assesories: ArrayList<Assesory>): RecyclerView.Adapter<AssesoryPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssesoryPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_assesories, parent, false)

        return AssesoryPrototype(view)
    }

    override fun onBindViewHolder(holder: AssesoryPrototype, position: Int) {
        holder.bind(assesories.get(position))
    }

    override fun getItemCount(): Int {
        return assesories.size
    }

}

class AssesoryPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {

    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvAge = itemView.findViewById<TextView>(R.id.tvAge)
    val tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)

    fun bind(assesory: Assesory){
        tvName.text = assesory.name
        tvAge.text = assesory.age
        tvEmail.text = assesory.email
    }
}
