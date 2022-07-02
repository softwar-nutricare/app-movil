package com.example.nutricare

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_payment_method.*

class PaymentMethod : AppCompatActivity(), OnItemClickListenerPayment{

    override fun OnItemClicked(payment: Payment) {
        val intent = Intent(this, Add_Payment_Method::class.java)
        val gson = Gson()
        intent.putExtra("payment", gson.toJson(payment))
        startActivity(intent)
    }

    lateinit var payments: List<Payment>

    lateinit var paymentAdapter: PaymentAdapter

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_method)
        val actionBar = supportActionBar
        actionBar!!.title = "Metodo de Pago"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val fab: View = findViewById(R.id.fabAdd_Method_Payment)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()

            val intent = Intent(this, Add_Payment_Method::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadPayments()

        paymentAdapter = PaymentAdapter(payments, this)
        rvPaymentMethod.adapter = paymentAdapter
        rvPaymentMethod.layoutManager = LinearLayoutManager(this)

    }

    private fun loadPayments() {
        payments = AppDatabasePayment.getInstance(this).getDao().getAll()
    }
}