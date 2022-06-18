package com.example.nutricare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nutricare.interfaces.ClientAPI
import com.example.nutricare.models.Client
import okhttp3.Dispatcher
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.ClientInfoStatus
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCliente= findViewById<Button>(R.id.btCliente)
        val btNutricionista = findViewById<Button>(R.id.btNutricionista)

        btCliente.setOnClickListener {
            val intent = Intent(this, MainUser::class.java)
            startActivity(intent)
        }

        btNutricionista.setOnClickListener {
            val intent = Intent(this, MainNutritionist::class.java)
            startActivity(intent)
        }
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://nutri-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun searchByName(query:String){
        val call:Response<Client> = getRetrofit().create(ClientAPI::class.java).getClient("api/v1/clients/{id}")


    }


}