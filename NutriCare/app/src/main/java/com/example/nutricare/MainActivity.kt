package com.example.nutricare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCliente= findViewById<Button>(R.id.btCliente)
        val btNutricionista = findViewById<Button>(R.id.btNutricionista)

        btCliente.setOnClickListener {
            val intent = Intent(this, MainUser::class.java)
            startActivity(intent)
        }

        btNutricionista.setOnClickListener {
            val intent = Intent(this, MainUser::class.java)
            startActivity(intent)
        }
    }
}