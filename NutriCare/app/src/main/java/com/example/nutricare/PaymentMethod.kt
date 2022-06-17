package com.example.nutricare

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_payment_method, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemAdd ->{
                val intent = Intent(this, Add_Payment_Method::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}