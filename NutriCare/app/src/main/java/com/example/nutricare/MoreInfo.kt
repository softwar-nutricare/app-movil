package com.example.nutricare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoreInfo : AppCompatActivity(){





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        val actionBar = supportActionBar

        actionBar!!.title = "Más Información"

        actionBar.setDisplayHomeAsUpEnabled(true)


        initView()
    }

    private fun initView() {

    }



}