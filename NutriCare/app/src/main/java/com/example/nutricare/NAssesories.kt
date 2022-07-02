package com.example.nutricare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_nassesories.*
import kotlinx.android.synthetic.main.activity_ninform.*

class NAssesories : AppCompatActivity(), OnItemClickListenerDate {

    override fun OnItemClicked(date: Date) {
        //CON ESTE CODIGO paso los valores al adddietrecipesActivity
        val intent = Intent(this, Add_Date::class.java)
        val gson = Gson()
        intent.putExtra("date", gson.toJson(date))
        startActivity(intent)
    }
    //lateinit var displayedList : List<Info>
    lateinit var dates: List<Date>

    //utilizo el adaptador del RV
    lateinit var dateAdapter: DateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nassesories)

        val actionBar = supportActionBar
        actionBar!!.title = "Asesorias"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val fab: View = findViewById(R.id.fabAdd_Date)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()

            val intent = Intent(this, Add_Date::class.java)
            startActivity(intent)
        }
    }

    //este metodo se carga en c/cambio
    override fun onResume() {
        super.onResume()
        loadDates()

        dateAdapter = DateAdapter(dates, this)
        rvN_Date.adapter = dateAdapter
        rvN_Date.layoutManager = LinearLayoutManager(this)
    }

    private fun loadDates() {
        dates = AppDatabaseDate.getInstance(this).getDao().getAll()
    }
}