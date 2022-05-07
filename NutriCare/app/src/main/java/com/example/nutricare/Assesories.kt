package com.example.nutricare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Assesories : AppCompatActivity() {

    var assesories = ArrayList<Assesory>()

    var assesoryAdapter = AssesoryAdapter(assesories)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assesory)

        val actionBar = supportActionBar

        actionBar!!.title = "Asesorias"

        actionBar.setDisplayHomeAsUpEnabled(true)

        loadAssesories()
        initView()
    }

    private fun initView() {
        val rvAssesory = findViewById<RecyclerView>(R.id.rvAssesory)
        rvAssesory.adapter = assesoryAdapter
        rvAssesory.layoutManager = LinearLayoutManager(this)
    }

    private fun loadAssesories() {
        assesories.add(Assesory("Antonio Valencia", "20 años", "antonio@gmail.com"))
        assesories.add(Assesory("Edison Flores", "26 años", "edison@gmail.com"))
        assesories.add(Assesory("Federico Valverde", "22 años", "federico@gmail.com"))
    }
}