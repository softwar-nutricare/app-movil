package com.example.nutricare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

class Dates : AppCompatActivity() {

    var dates = ArrayList<Date>()

    var dateAdapter = DateAdapter(dates)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dates)

        val actionBar = supportActionBar

        actionBar!!.title = "Citas"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val btCancel =findViewById<Button>(R.id.btCancel)
        val rvDate = findViewById<RecyclerView>(R.id.rvDate)

        loadDates()
        initView()

        /*btCancel.setOnClickListener(View.OnClickListener { // instance of alert dialog to build alert dialog
            val builder = AlertDialog.Builder(this@Dates)
            builder.setTitle("This is Alert Dialog")
            builder.setMessage("Bottom Alert dialog")

            // set the positive button to do some actions
            builder.setPositiveButton(
                "OKAY"
            ) { dialog, which ->
                Toast.makeText(this@Dates, "OKAY", Toast.LENGTH_SHORT).show()
            }

            // set the negative button to do some actions
            builder.setNegativeButton(
                "CANCEL"
            ) { dialog, which ->
                Toast.makeText(this@Dates, "CANCEL", Toast.LENGTH_SHORT).show()
            }

            // show the alert dialog
            val alertDialog = builder.create()
            alertDialog.show()

            // get the top most window of the android
            // screen using getWindow() method
            // and set the the gravity of the window to
            // top that is alert dialog will be now at
            // the topmost position
            alertDialog.window!!.setGravity(Gravity.CENTER)
        })*/
    }

    private fun showAlertDialog() {

        val builder = AlertDialog.Builder(this@Dates)
        builder.setTitle("This is Alert Dialog")
        builder.setMessage("Bottom Alert dialog")
    }

    private fun initView() {
        val rvDate = findViewById<RecyclerView>(R.id.rvDate)
        rvDate.adapter = dateAdapter
        rvDate.layoutManager = LinearLayoutManager(this)
    }

    private fun loadDates() {
        dates.add(Date("Michael Kyle", "Lunes", "11:00", "11:30", "Atrasado"))
        dates.add(Date("Michael Kyle", "Martes", "15:00", "15:30", "Pendiente"))
        dates.add(Date("Michael Kyle", "Lunes", "11:00", "11:30", "Pendiente"))
        dates.add(Date("Michael Kyle", "Viernes", "11:00", "11:30", "Cancelado"))
        dates.add(Date("Michael Kyle", "Lunes", "10:00", "11:30", "Pendiente"))
        dates.add(Date("Michael Kyle", "Miercoles", "15:30", "16:00", "Pendiente"))
        dates.add(Date("Michael Kyle", "Sabado", "11:00", "11:30", "Cancelado"))
    }


}