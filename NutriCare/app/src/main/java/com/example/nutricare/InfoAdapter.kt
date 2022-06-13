package com.example.nutricare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_info.view.*


class InfoAdapter (var infos: List<Info>, val itemClickListener: OnItemClickListenerInfo):
    RecyclerView.Adapter<InfoPrototype>() {

    //lateinit var displayedList : List<Info>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_info, parent, false)

        return InfoPrototype(view)
    }

    override fun onBindViewHolder(infoPrototype: InfoPrototype, position: Int) {
        infoPrototype.bind(infos[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return infos.size
    }

    /*fun updateList(list: List<Info>) {
        displayedList = list
        notifyDataSetChanged()
    }*/
}

class InfoPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //vinculamos los controles del prototype con variables
    val tvInfo_Title = itemView.tvInfo_Title
    val tvInfo_Descrip = itemView.tvInfo_Descrip
    val cvMore_Info = itemView.cvMore_Info

    //vinculamos las variables con la clase
    fun bind(info: Info, itemClickListener: OnItemClickListenerInfo){
        tvInfo_Title.text = info.title
        tvInfo_Descrip.text = info.description

        cvMore_Info.setOnClickListener {
            itemClickListener.OnItemClicked(info)
        }
    }
}

//creo la interfaz
interface OnItemClickListenerInfo {
    fun OnItemClicked(info: Info)

}