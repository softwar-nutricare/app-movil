package com.example.nutricare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class UserProfile : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        val actionBar = supportActionBar
        actionBar!!.title = "Perfil del usuario"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}