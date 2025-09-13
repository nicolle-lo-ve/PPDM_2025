/*
Descripción: Reproductor de música básico con funciones de reproducir, pausar y detener
Autor: Nicolle Lozano
Fecha creación: 09/09/25
Fecha última modificación: 12/09/25
*/

package com.nicolle.p3_reproductor_musica

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencias a los botones
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnStop = findViewById<Button>(R.id.btnStop)

        // Botón REPRODUCIR
        btnPlay.setOnClickListener {
            if (mediaPlayer == null) {
                // Crear MediaPlayer con el archivo de audio
                mediaPlayer = MediaPlayer.create(this, R.raw.sabrina_carpenter_manchild)
                mediaPlayer?.start()
                Toast.makeText(this, "Reproduciendo música", Toast.LENGTH_SHORT).show()
            } else if (!mediaPlayer!!.isPlaying) {
                mediaPlayer?.start()
                Toast.makeText(this, "Reproduciendo música", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ya se está reproduciendo", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón PAUSAR
        btnPause.setOnClickListener {
            if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                mediaPlayer?.pause()
                Toast.makeText(this, "Música pausada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No hay música reproduciéndose", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón DETENER
        btnStop.setOnClickListener {
            if (mediaPlayer != null) {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
                Toast.makeText(this, "Música detenida", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No hay música para detener", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Liberar recursos del MediaPlayer
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
