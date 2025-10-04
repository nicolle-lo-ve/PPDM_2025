/**
 * Descripción: Actividad para mostrar opciones de compartir o editar la nota
 * Autor: Nicolle Lozano
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 04/10/2025
 */

package com.nicolle.practica4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OpcionesActivity : AppCompatActivity() {

    private lateinit var tvNotaMostrada: TextView
    private lateinit var btnCompartirCorreo: Button
    private lateinit var btnEditarDeNuevo: Button
    private var notaRecibida: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        inicializarVistas()
        obtenerNotaRecibida()
        mostrarNota()
        configurarBotones()
    }

    private fun inicializarVistas() {
        tvNotaMostrada = findViewById(R.id.tvNotaMostrada)
        btnCompartirCorreo = findViewById(R.id.btnCompartirCorreo)
        btnEditarDeNuevo = findViewById(R.id.btnEditarDeNuevo)
    }

    private fun obtenerNotaRecibida() {
        notaRecibida = intent.getStringExtra("NOTA") ?: ""
    }

    private fun mostrarNota() {
        tvNotaMostrada.text = notaRecibida
    }

    private fun configurarBotones() {
        btnCompartirCorreo.setOnClickListener {
            compartirPorCorreo()
        }

        btnEditarDeNuevo.setOnClickListener {
            volverAEditar()
        }
    }

    private fun compartirPorCorreo() {
        Toast.makeText(
            this,
            "Compartido por correo",
            Toast.LENGTH_SHORT
        ).show()
        finish()
    }

    private fun volverAEditar() {
        val intentResultado = Intent().apply {
            putExtra("NOTA_EDITADA", notaRecibida)
        }
        setResult(RESULT_OK, intentResultado)
        finish()
    }
}
