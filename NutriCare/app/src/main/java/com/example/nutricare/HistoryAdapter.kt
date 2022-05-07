package com.example.nutricare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(var histories: ArrayList<History>): RecyclerView.Adapter<HistoryPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryPrototype {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.prototype_nutritionals_histories, parent, false)

            return HistoryPrototype(view)
    }

    override fun onBindViewHolder(holder: HistoryPrototype, position: Int) {
        holder.bind(histories.get(position))
    }

    override fun getItemCount(): Int {
        return histories.size
    }

}

class HistoryPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //vinculamos los controles del prototype con variables
    val tvTitle       = itemView.findViewById<TextView>(R.id.tvTitle)
    val tvName        = itemView.findViewById<TextView>(R.id.tvName)
    val tvN_Telephone = itemView.findViewById<TextView>(R.id.tvN_Telephone)
    val tvEmail       = itemView.findViewById<TextView>(R.id.tvEmail)
    val tvD_Description = itemView.findViewById<TextView>(R.id.tvD_Description)
    val tvSalad_Name  = itemView.findViewById<TextView>(R.id.tvSalad_Name)
    val tvDay1        = itemView.findViewById<TextView>(R.id.tvDay1)
    val tvDay2        = itemView.findViewById<TextView>(R.id.tvDay2)
    val tvDay3        = itemView.findViewById<TextView>(R.id.tvDay3)
    val tvDay4        = itemView.findViewById<TextView>(R.id.tvDay4)
    val tvDay5        = itemView.findViewById<TextView>(R.id.tvDay5)
    val tvDay6        = itemView.findViewById<TextView>(R.id.tvDay6)
    val tvDay7        = itemView.findViewById<TextView>(R.id.tvDay7)

    //vinculamos las variables con la clase
    fun bind(history: History){
        tvTitle.text = history.title
        tvName.text  =history.name
        tvN_Telephone.text=history.telephone
        tvEmail.text = history.email
        tvD_Description.text = history.diet_description
        tvSalad_Name.text = history.salad_name
        tvDay1.text = history.day1
        tvDay2.text = history.day2
        tvDay3.text = history.day3
        tvDay4.text = history.day4
        tvDay5.text = history.day5
        tvDay6.text = history.day6
        tvDay7.text = history.day7
    }
}
