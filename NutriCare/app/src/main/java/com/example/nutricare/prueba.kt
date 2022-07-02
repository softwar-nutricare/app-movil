package com.example.nutricare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class prueba : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_cliente)

        val btLoginCliente= findViewById<Button>(R.id.idLoguearCliente)
        btLoginCliente.setOnClickListener {
            val intent = Intent(this, MainUser::class.java)
            startActivity(intent)
        }
    }
}