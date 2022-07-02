package com.example.nutricare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_history_info.*
import kotlinx.android.synthetic.main.activity_nutritionist_history.*

class NutritionistHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutritionist_history)

        var item = "0"

        val ibBack = findViewById<ImageButton>(R.id.ibBack)

        //Create the bundle
        val bundle = Bundle()

        ibBack.setOnClickListener {
            val intent = Intent(this, MainNutritionist::class.java)
            startActivity(intent)
        }

        constraintLayout2.setOnClickListener{
            //Toast.makeText(this, "IT WORKS !!!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HistoryInfo::class.java)
            item = "1"
            bundle.putString("value", item)
            intent.putExtras(bundle)
            startActivity(intent)

        }

        constraintLayout3.setOnClickListener{
            //Toast.makeText(this, "IT WORKS !!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HistoryInfo::class.java)
            item = "2"
            bundle.putString("value", item)
            intent.putExtras(bundle)
            startActivity(intent)
        }


    }

}