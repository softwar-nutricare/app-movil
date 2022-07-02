package com.example.nutricare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HistoryInfo : AppCompatActivity() {
    var s:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_info)


        val tvInfo = findViewById<TextView>(R.id.tvInfoHistory)

        val bundle = intent.extras

        s = bundle!!.getString("value")

        if (s == "1"){
            tvInfo.text =  this.getString(R.string.info_michael)
        }
        if (s == "2"){
            tvInfo.text =  this.getString(R.string.info_Lucy)
        }

    }
}