package com.example.nutricare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DateAdapter(var dates: ArrayList<Date>):RecyclerView.Adapter<DatePrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatePrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_dates, parent, false)

        return DatePrototype(view)
    }

    override fun onBindViewHolder(holder: DatePrototype, position: Int) {
        holder.bind(dates.get(position))
    }

    override fun getItemCount(): Int {
        return dates.size
    }
}

class DatePrototype(itemView: View): RecyclerView.ViewHolder(itemView) {

    val tvNutricionistDate = itemView.findViewById<TextView>(R.id.tvNutricionistDate)
    val tvDayDate = itemView.findViewById<TextView>(R.id.tvDayDate)
    val tvStarDate = itemView.findViewById<TextView>(R.id.tvStarDate)
    val tvEndDate = itemView.findViewById<TextView>(R.id.tvEndDate)
    val tvStatus = itemView.findViewById<TextView>(R.id.tvStatus)

    fun bind(date: Date){
        tvNutricionistDate.text = date.nutritionist
        tvDayDate.text = date.day
        tvStarDate.text = date.timeStar
        tvEndDate.text = date.timeEnd
        tvStatus.text = date.status
    }

}
