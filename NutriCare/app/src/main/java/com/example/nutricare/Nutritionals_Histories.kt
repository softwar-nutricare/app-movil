package com.example.nutricare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Nutritionals_Histories : AppCompatActivity() {

    var histories = ArrayList<History>()

    var historyAdapter = HistoryAdapter(histories)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutritionals_histories)

        val actionBar = supportActionBar

        actionBar!!.title = "Historial Nutricional"

        actionBar.setDisplayHomeAsUpEnabled(true)

        loadHistories()
        initView()
    }

    private fun initView() {
        //vinculo el adapter al rV
        val rvHistory = findViewById<RecyclerView>(R.id.rvHistoNutric)
        rvHistory.adapter = historyAdapter
        rvHistory.layoutManager = LinearLayoutManager(this)
    }

    private fun loadHistories() {
        histories.add(History("Historial Nutricional","Pedro Suarez",
            "999 999 999","pz@gmail.com","Importante: seguir las comidas del dia",
            "Ensalada Proteica","dia 1: Comida x","dia 2: Comida y","dia 3: Comida z","dia 4: Comida w",
            "dia 5: Comida a","dia 6: Comida t","dia 7: Comida u"))

    }
}