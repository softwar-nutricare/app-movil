package com.example.nutricare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_add_date.*

class UpdateHour : AppCompatActivity() {

    lateinit var date: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_hour)

        val actionBar = supportActionBar
        actionBar!!.title = "Actualizar hora"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val btNDate_Save = findViewById<Button>(R.id.btNDate_Save)
        val btNDate_Delete = findViewById<Button>(R.id.btNDate_Delete)
        loadDate()

        btNDate_Save.setOnClickListener {
            saveDate()
        }

        btNDate_Delete.setOnClickListener {
            deleteDate()
        }
    }

    private fun loadDate() {
        val gson = Gson()
        val stringObj = intent.getStringExtra("date")

        date = gson.fromJson(stringObj, Date::class.java) ?: Date(null, "", "","","","","","","","","")

        if (date.id != null){
            etNameSpetialist.setText(date.nutritionist)
            etDay.setText(date.day)
            etStar1.setText(date.timeStar1)
            etEnd1.setText(date.timeEnd1)
            etStar2.setText(date.timeStar2)
            etEnd2.setText(date.timeEnd2)
            etStar3.setText(date.timeStar3)
            etEnd3.setText(date.timeEnd3)
            etStatus.setText(date.status)
            etSpeciality.setText(date.speciality)
        }
    }

    private fun deleteDate() {
        AppDatabaseDate.getInstance(this).getDao().deleteDate(date)
        finish()
    }

    fun saveDate(){
        //modifico el metodo grabar
        date.timeStar1 = etStar1.text.toString()
        date.timeEnd1 = etEnd1.text.toString()

        //es un contacto nuevo o ya existe?
        if (date.id != null){
            AppDatabaseDate.getInstance(this).getDao().updateDate(date)
        }
        else{
            AppDatabaseDate.getInstance(this).getDao().insertDate(date)
        }
        finish()
    }
}