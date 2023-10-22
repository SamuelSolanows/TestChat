package com.example.testandroid.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.result.PickVisualMediaRequest
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.testandroid.databinding.ActivityCrearCuentaBinding

class CrearCuenta : AppCompatActivity() {
    lateinit var binding: ActivityCrearCuentaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnCancelar.setOnClickListener {
                finish()
            }
            btnCrearCuenta.setOnClickListener {
                ValidarTxts()
            }
            imgFoto.setOnClickListener {
                // PedirPermisos()
                SeleccionarImagen()
            }

            ValidarContra()
        }
    }

    private fun ValidarContra() {
        binding.apply {
            var contra = ""

            if (!etxtContrasena.isFocused) {
                contra = etxtContrasena.text.toString()
            }

            etxtConfirmarContrasena.addTextChangedListener {
                if (etxtConfirmarContrasena.text.toString() != contra) {
                    Toast.makeText(this@CrearCuenta, contra, Toast.LENGTH_SHORT).show()
                    etxtConfirmarContrasena.setError("Los campos no coinciden")
                }
            }
        }
    }

    var pikMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri == null) {
            Toast.makeText(this, "Nada Seleccionado", Toast.LENGTH_SHORT).show()
        } else {
            binding.imgFoto.setImageURI(uri)
        }
    }

    private fun SeleccionarImagen() {
        pikMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }


//    lateinit var LanzarPermisos: ActivityResultLauncher<Array<String>>
//    var Camara = false
//    var Almacenamiento = false
//    private fun PedirPermisos() {
//        LanzarPermisos =
//            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permiso ->
//                Camara = permiso[Manifest.permission.CAMERA] ?: Camara
//                Almacenamiento =
//                    permiso[Manifest.permission.READ_EXTERNAL_STORAGE] ?: Almacenamiento
//
//            }
//        Permisos()
//    }
//
//    private fun Permisos() {
//        Camara = ContextCompat.checkSelfPermission(
//            this,
//            Manifest.permission.CAMERA
//        ) == PackageManager.PERMISSION_GRANTED
//
//        Almacenamiento = ContextCompat.checkSelfPermission(
//            this,
//            Manifest.permission.READ_EXTERNAL_STORAGE
//        ) == PackageManager.PERMISSION_GRANTED
//
//
//        var preguntarpermisoos: MutableList<String> = ArrayList()
//
//        if (!Camara) {
//            preguntarpermisoos.add(Manifest.permission.CAMERA)
//        }
//        if (!Almacenamiento) {
//            preguntarpermisoos.add(Manifest.permission.READ_EXTERNAL_STORAGE)
//        }
//        if (preguntarpermisoos.isNotEmpty()) {
//            LanzarPermisos.launch(preguntarpermisoos.toTypedArray())
//        }
//    }


    private fun ValidarTxts() {
        binding.apply {
            var txts = mutableListOf<EditText>(
                etxtApellido, etxtContrasena, etxtConfirmarContrasena, etxtNombre, etxtUsuario
            )
            var c = 0
            txts.forEach {
                if (it.text.isEmpty()) {
                    it.setError("Campo vacio")
                } else {
                    c++
                }
            }
            if (c == 5) {
                Toast.makeText(this@CrearCuenta, "TAMELO", Toast.LENGTH_SHORT).show()
            }


        }
    }
}