/*
 * Descripción: Fragment inicial que presenta la opción de crear un nuevo pedido
 * Autor: Nicolle Lozano
 * Fecha creación: 01/10/2025
 * Fecha última modificación: 04/10/2025
 */

package com.nicolle.configuradorpedido

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botonNuevoPedido = view.findViewById<Button>(R.id.botonNuevoPedido)
        botonNuevoPedido.setOnClickListener {
            navegarASeleccionComida()
        }
    }

    private fun navegarASeleccionComida() {
        findNavController().navigate(R.id.action_inicioFragment_to_seleccionComidaFragment)
    }
}
