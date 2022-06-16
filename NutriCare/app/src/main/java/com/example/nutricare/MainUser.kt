package com.example.nutricare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_user)

        val btDietRecep = findViewById<Button>(R.id.btDiet)
        val btMoreInfo= findViewById<Button>(R.id.btInform)
        //val btHistoNutric = findViewById<Button>(R.id.btHistoNutric)
        val btAssesory = findViewById<Button>(R.id.btAsesorias)
        val btDates = findViewById<Button>(R.id.btCitas)
        val ivU_exit = findViewById<ImageView>(R.id.ivU_exit)
        val btProfile = findViewById<Button>(R.id.btPerfil)

        btDietRecep.setOnClickListener {
            val intent = Intent(this, Diets_Recipes::class.java)
            startActivity(intent)
        }

        /*btHistoNutric.setOnClickListener {
            val intent = Intent(this, Nutritionals_Histories::class.java)
            startActivity(intent)
        }*/
        btAssesory.setOnClickListener {
            val intent = Intent(this, Assesories::class.java)
            startActivity(intent)
        }
        btMoreInfo.setOnClickListener {
            val intent1 = Intent(this, MoreInfo::class.java)
            startActivity(intent1)
        }
        btDates.setOnClickListener {
            val intent1 = Intent(this, Dates::class.java)
            startActivity(intent1)
        }

        ivU_exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btProfile.setOnClickListener {
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }
    }
}