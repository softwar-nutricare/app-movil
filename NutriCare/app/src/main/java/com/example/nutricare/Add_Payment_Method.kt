package com.example.nutricare

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_add_payment_method.*

class Add_Payment_Method : AppCompatActivity(){

    lateinit var payment: Payment

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_payment_method)
        val actionBar = supportActionBar
        actionBar!!.title = "Agregar Metodo de Pago"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val btCPayment_Save = findViewById<Button>(R.id.btCPayment_Save)
        val btCPayment_Delete = findViewById<Button>(R.id.btCPayment_Delete)

        loadPayment()

        btCPayment_Save.setOnClickListener {
            savePayment()
        }

        btCPayment_Delete.setOnClickListener {
            deleteMethod_Payment()
        }
    }

    private fun loadPayment(){
        val gson = Gson()
        val stringObj = intent.getStringExtra("payment")

        payment = gson.fromJson(stringObj, Payment::class.java)?: Payment(null,"","","","","")

        if(payment.id != null){
            etPayment_Add_Nombre.setText(payment.name)
            etPayment_Add_Tipo.setText(payment.name_card)
            etPayment_Add_NumeroTarjeta.setText(payment.card_number)
            etPayment_Add_FechaExp.setText(payment.expiration_date)
            etPayment_Add_CCV.setText(payment.ccv)
        }
    }

    private fun deleteMethod_Payment() {
        AppDatabasePayment.getInstance(this).getDao().deletePaymentMethod(payment)
        finish()
    }

    fun savePayment(){
        payment.name = etPayment_Add_Nombre.text.toString()
        payment.name_card = etPayment_Add_Tipo.text.toString()
        payment.card_number = etPayment_Add_NumeroTarjeta.text.toString()
        payment.expiration_date = etPayment_Add_FechaExp.text.toString()
        payment.ccv = etPayment_Add_CCV.text.toString()

        //es un contacto nuevo o ya existe?
        if (payment.id != null){
            AppDatabasePayment.getInstance(this).getDao().updatePaymentMethod(payment)
        }
        else{
            AppDatabasePayment.getInstance(this).getDao().insertPaymentMethod(payment)
        }
        finish()
    }
}