/**
 * Descripción: Actividad principal para editar y escribir notas rápidas
 * Autor: Nicolle Lozano
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 04/10/2025
 *
 */

package com.nicolle.practica4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class EditorActivity : AppCompatActivity() {

    private lateinit var etNota: EditText
    private lateinit var btnCompartir: Button

    private val opcionesLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val notaEditada = result.data?.getStringExtra("NOTA_EDITADA")
            notaEditada?.let {
                etNota.setText(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        inicializarVistas()
        configurarBoton()
        restaurarNota(savedInstanceState)
    }

    private fun inicializarVistas() {
        etNota = findViewById(R.id.etNota)
        btnCompartir = findViewById(R.id.btnCompartir)
    }

    private fun configurarBoton() {
        btnCompartir.setOnClickListener {
            val textoNota = etNota.text.toString()

            if (textoNota.isNotBlank()) {
                enviarNotaAOpciones(textoNota)
            } else {
                mostrarMensajeVacio()
            }
        }
    }

    private fun enviarNotaAOpciones(nota: String) {
        val intent = Intent(this, OpcionesActivity::class.java).apply {
            putExtra("NOTA", nota)
        }
        opcionesLauncher.launch(intent)
    }

    private fun mostrarMensajeVacio() {
        Toast.makeText(
            this,
            "Por favor, escribe una nota primero",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("NOTA_GUARDADA", etNota.text.toString())
    }

    private fun restaurarNota(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            val notaGuardada = it.getString("NOTA_GUARDADA", "")
            etNota.setText(notaGuardada)
        }
    }
}
