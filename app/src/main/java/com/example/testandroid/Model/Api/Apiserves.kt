package com.example.testandroid.Model.Api

import com.example.testandroid.Model.Models.Students
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface Apiserves {
    @POST("Student")
    fun InsertarUsuario(@Body student: Students): Call<Students>


    @GET("Student")
    fun GetAllStudents(@Header("authorization") tokent: String): Call<List<Students>>


    @GET("Student/{id}")
    fun GetStudentsId(
        @Header("authorization") tokent: String,
        @Path("id") id: String
    ): Call<Students>

    @PUT("Student/{id}")
    fun UpdateStudent(
        @Header("authorization") tokent: String, @Path("id") id: String, @Body Student: Students
    ): Call<Students>

    @DELETE("Student/{id}")
    fun DeleteStudent(
        @Header("authorization") tokent: String,
        @Path("id") id: String
    ): Call<Students>

}