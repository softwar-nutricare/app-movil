package com.example.nutricare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_dates.view.*

class DateAdapter(var dates: List<Date>, val itemClickListener: OnItemClickListenerDate):
    RecyclerView.Adapter<DatePrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatePrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_dates, parent, false)

        return DatePrototype(view)
    }

    override fun onBindViewHolder(datePrototype: DatePrototype, position: Int) {
        datePrototype.bind(dates[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return dates.size
    }
}

class DatePrototype(itemView: View): RecyclerView.ViewHolder(itemView) {

    val tvNutricionistDate = itemView.tvNutricionistDate
    val tvDayDate = itemView.tvDayDate
    val tvStarDate = itemView.tvStarDate
    val tvEndDate = itemView.tvEndDate
    val tvSpecialidad = itemView.tvSpecialidad
    val tvStatus = itemView.tvStatus
    val cvDates = itemView.cvDates

    fun bind(date: Date, itemClickListener: OnItemClickListenerDate){
        tvNutricionistDate.text = date.nutritionist
        tvDayDate.text = date.day
        tvStarDate.text = date.timeStar1
        tvEndDate.text = date.timeEnd1
        tvStatus.text = date.status
        tvSpecialidad.text = date.speciality

        cvDates.setOnClickListener {
            itemClickListener.OnItemClicked(date)
        }
    }
}

interface OnItemClickListenerDate {
    fun OnItemClicked(date: Date)

}
