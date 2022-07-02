package com.example.nutricare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Login_Nutricionist : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_nutricionista)

        val btLoginNutricionista= findViewById<Button>(R.id.idLoguearNutricionista)
        btLoginNutricionista.setOnClickListener {
            val intent = Intent(this, MainNutritionist::class.java)
            startActivity(intent)
        }
    }
}