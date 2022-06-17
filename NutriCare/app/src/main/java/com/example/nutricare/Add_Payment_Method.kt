package com.example.nutricare

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity

class Add_Payment_Method : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_payment_method)

        val actionBar = supportActionBar
        actionBar!!.title = "Agregar Metodo de Pago"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_add_diet_recipe, menu)
        return true
    }

}