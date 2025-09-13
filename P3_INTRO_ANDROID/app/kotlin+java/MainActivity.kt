/*
Descripción: Aplicación que muestra un Toast personalizado al hacer clic en una imagen
Autor: Nicolle Lozano
Fecha creación: 09/09/25
Fecha última modificación: 12/09/25
*/

package com.nicolle.p3_intro_android

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencia a la ImageView
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Programar el clic en la imagen
        imageView.setOnClickListener {
            Toast.makeText(
                this,
                "¡Has tocado el botón! 🎉",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
