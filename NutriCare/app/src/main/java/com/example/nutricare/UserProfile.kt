package com.example.nutricare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class UserProfile : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        val actionBar = supportActionBar
        actionBar!!.title = "Perfil"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val btPaymentMethod = findViewById<Button>(R.id.btMetodoPago)

        btPaymentMethod.setOnClickListener {
            val intent = Intent(this, PaymentMethod::class.java)
            startActivity(intent)
        }
    }
}