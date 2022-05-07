package com.example.nutricare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btDietRecep = findViewById<Button>(R.id.btDietRece)

        val btAssesory = findViewById<Button>(R.id.btAsesorias)

        btDietRecep.setOnClickListener {
            val intent = Intent(this, Diets_Recipes::class.java)
            startActivity(intent)
        }

        btAssesory.setOnClickListener {
            val intent = Intent(this, Assesories::class.java)
            startActivity(intent)
        }
    }
}