package com.example.testandroid.Model.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private var retrofit =
        Retrofit.Builder()
            .baseUrl("http://192.168.101.9:8888/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    var token =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjEiLCJuYmYiOjE2OTc5MTM2MTIsImV4cCI6NzY5NzkxMzU1MiwiaWF0IjoxNjk3OTEzNjEyLCJpc3MiOiIzMjI4MzExMC04M2YwLTQ4OWUtYmU0MC04ZTAwZDYyOTk1OGYiLCJhdWQiOiJTb2Z0d2FyZSBGb25TRU5BLUpEIn0.5W0GSYe00vt6XgAoxovWZ33c7xb4jOccUqSDShTGaEI"

    var builder = retrofit.create(Apiserves::class.java)
}