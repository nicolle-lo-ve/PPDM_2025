/**
 * Descripción: Data class para representar los datos de un usuario
 * Autor: Nicolle Lozano
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 04/10/2025
 */

package com.nicolle.practica4

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val edad: String,
    val ciudad: String,
    val correo: String
) : Serializable {

    fun esValido(): Boolean {
        return nombre.isNotBlank() &&
                edad.isNotBlank() &&
                ciudad.isNotBlank() &&
                correo.isNotBlank()
    }

    override fun toString(): String {
        return "Nombre: $nombre\nEdad: $edad\nCiudad: $ciudad\nCorreo: $correo"
    }
}
