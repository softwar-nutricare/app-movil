package com.example.nutricare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainNutritionist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_nutritionist)

        val btNDiet = findViewById<Button>(R.id.btNDiet)
        val ivN_exit = findViewById<ImageView>(R.id.ivN_exit)
        val btNInform = findViewById<Button>(R.id.btNInform)
        val btNAsesorias = findViewById<Button>(R.id.btNAsesorias)

        btNDiet.setOnClickListener {
            val intent = Intent(this, N_Diets::class.java)
            startActivity(intent)
        }

        btNInform.setOnClickListener {
            val intent = Intent(this, N_Inform::class.java)
            startActivity(intent)
        }

        btNAsesorias.setOnClickListener {
            val intent = Intent(this, NAssesories::class.java)
            startActivity(intent)
        }



        ivN_exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}