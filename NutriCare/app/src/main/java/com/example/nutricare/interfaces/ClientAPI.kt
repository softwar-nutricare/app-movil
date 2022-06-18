package com.example.nutricare.interfaces

import com.example.nutricare.models.Client
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url
import java.util.*

interface ClientAPI {
   @GET
    fun getClient(@Url url:String):Response<Client>
}