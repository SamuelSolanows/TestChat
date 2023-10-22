package com.example.testandroid.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testandroid.Model.Adapter.StudentAdapter
import com.example.testandroid.Model.Api.Api
import com.example.testandroid.Model.Models.Students
import com.example.testandroid.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnIniciarSession.setOnClickListener {
                ValidarCampos()
            }
            btnCrearCuenta.setOnClickListener {
                startActivity(Intent(this@MainActivity, CrearCuenta::class.java))
            }

        }
    }

    private fun ValidarCampos() {
        binding.apply {
            var txts = mutableListOf<EditText>(etxtContrasena, etxtUsuario)
            txts.forEach {
                if (it.text.isEmpty()) {
                    it.setError("Llenar Campo")
                } else {
                    startActivity(Intent(this@MainActivity, ViewChats::class.java))
                }
            }
        }
    }
}