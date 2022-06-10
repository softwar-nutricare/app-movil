package com.example.nutricare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainNutritionist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_nutritionist)

        val btNDiet = findViewById<Button>(R.id.btNDiet)

        btNDiet.setOnClickListener {
            val intent = Intent(this, N_Diets::class.java)
            startActivity(intent)
        }
    }
}