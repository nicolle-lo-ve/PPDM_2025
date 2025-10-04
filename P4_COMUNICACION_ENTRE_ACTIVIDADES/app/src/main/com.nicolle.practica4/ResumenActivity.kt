/**
 * Descripción: Actividad para mostrar el resumen del perfil y confirmar o editar
 * Autor: Nicolle Lozano
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 04/10/2025
 */

package com.nicolle.practica4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    private lateinit var tvResumen: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnVolverEditar: Button
    private var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        inicializarVistas()
        obtenerDatosRecibidos()
        mostrarResumen()
        configurarBotones()
    }

    private fun inicializarVistas() {
        tvResumen = findViewById(R.id.tvResumen)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnVolverEditar = findViewById(R.id.btnVolverEditar)
    }

    private fun obtenerDatosRecibidos() {
        usuario = intent.getSerializableExtra("USUARIO") as? Usuario
    }

    private fun mostrarResumen() {
        usuario?.let {
            tvResumen.text = it.toString()
        }
    }

    private fun configurarBotones() {
        btnConfirmar.setOnClickListener {
            confirmarPerfil()
        }

        btnVolverEditar.setOnClickListener {
            volverAEditar()
        }
    }

    private fun confirmarPerfil() {
        setResult(RESULT_OK)
        finish()
    }

    private fun volverAEditar() {
        setResult(RESULT_CANCELED)
        finish()
    }
}
