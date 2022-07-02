package com.example.nutricare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_payment_method.view.*

class PaymentAdapter(var payments: List<Payment>, val itemClickListener: OnItemClickListenerPayment):
    RecyclerView.Adapter<PaymentPrototype>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_payment_method, parent, false)

        return PaymentPrototype(view)
    }

    override fun onBindViewHolder(paymentPrototype: PaymentPrototype, position: Int) {
        paymentPrototype.bind(payments[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return payments.size
    }
}

class PaymentPrototype(itemView: View):RecyclerView.ViewHolder(itemView){
    val tvCard = itemView.tvTarjeta
    val tvName = itemView.tvNombrePersona
    val tvCardNumber = itemView.tvNumTarjeta
    val tvExDay = itemView.tvExDay
    val tvCVV = itemView.tvCVV
    val cvMPayment = itemView.cvMPayment

    fun bind(payment: Payment, itemClickListener: OnItemClickListenerPayment){
        tvCard.text = payment.name_card
        tvName.text = payment.name
        tvCardNumber.text = payment.card_number
        tvExDay.text = payment.expiration_date
        tvCVV.text = payment.ccv

        cvMPayment.setOnClickListener {
            itemClickListener.OnItemClicked(payment)
        }
    }
}

interface OnItemClickListenerPayment {
    fun OnItemClicked(payment: Payment)
}

