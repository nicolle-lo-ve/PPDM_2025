/**
 * Descripción: Actividad principal para capturar datos del perfil de usuario
 * Autor: Estudiante de Ingeniería de Software
 * Fecha creación: 04/10/2025
 * Fecha última modificación: 04/10/2025
 */

package com.nicolle.practica4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnContinuar: Button

    private val resumenLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(
                this,
                "Perfil guardado correctamente",
                Toast.LENGTH_SHORT
            ).show()
            limpiarCampos()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        inicializarVistas()
        configurarBoton()
        restaurarDatos(savedInstanceState)
    }

    private fun inicializarVistas() {
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)
    }

    private fun configurarBoton() {
        btnContinuar.setOnClickListener {
            if (validarCampos()) {
                enviarDatosAResumen()
            } else {
                mostrarError()
            }
        }
    }

    private fun validarCampos(): Boolean {
        return etNombre.text.toString().isNotBlank() &&
                etEdad.text.toString().isNotBlank() &&
                etCiudad.text.toString().isNotBlank() &&
                etCorreo.text.toString().isNotBlank()
    }

    private fun mostrarError() {
        Toast.makeText(
            this,
            "Por favor, completa todos los campos",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun enviarDatosAResumen() {
        val usuario = Usuario(
            nombre = etNombre.text.toString(),
            edad = etEdad.text.toString(),
            ciudad = etCiudad.text.toString(),
            correo = etCorreo.text.toString()
        )

        val intent = Intent(this, ResumenActivity::class.java).apply {
            putExtra("USUARIO", usuario)
        }
        resumenLauncher.launch(intent)
    }

    private fun limpiarCampos() {
        etNombre.text.clear()
        etEdad.text.clear()
        etCiudad.text.clear()
        etCorreo.text.clear()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("NOMBRE", etNombre.text.toString())
        outState.putString("EDAD", etEdad.text.toString())
        outState.putString("CIUDAD", etCiudad.text.toString())
        outState.putString("CORREO", etCorreo.text.toString())
    }

    private fun restaurarDatos(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            etNombre.setText(it.getString("NOMBRE", ""))
            etEdad.setText(it.getString("EDAD", ""))
            etCiudad.setText(it.getString("CIUDAD", ""))
            etCorreo.setText(it.getString("CORREO", ""))
        }
    }
}
