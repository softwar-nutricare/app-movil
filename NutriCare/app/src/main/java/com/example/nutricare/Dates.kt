package com.example.nutricare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_dates.*
import kotlinx.android.synthetic.main.activity_more_info.*

class Dates : AppCompatActivity(), OnItemClickListenerDate {

    override fun OnItemClicked(date: Date) {
    }

    lateinit var dates : List<Date>

    lateinit var dateAdapter : DateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dates)

        val actionBar = supportActionBar
        actionBar!!.title = "Citas"
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onResume() {
        super.onResume()
        loadDates()

        dateAdapter = DateAdapter(dates, this)
        rvDate.adapter = dateAdapter
        rvDate.layoutManager = LinearLayoutManager(this)
    }

    private fun loadDates() {
        dates = AppDatabaseDate.getInstance(this).getDao().getAll()
    }


}