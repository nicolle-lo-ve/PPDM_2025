/*
 * Descripción: Fragment para seleccionar los extras del pedido (bebida, papas, postre)
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
import android.widget.CheckBox
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SeleccionExtrasFragment : Fragment() {

    private lateinit var checkBoxBebida: CheckBox
    private lateinit var checkBoxPapas: CheckBox
    private lateinit var checkBoxPostre: CheckBox
    private lateinit var botonSiguiente: Button

    private var comidaSeleccionada: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_seleccion_extras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inicializarVistas(view)
        recuperarDatosComida()
        configurarBotonSiguiente()
    }

    private fun inicializarVistas(view: View) {
        checkBoxBebida = view.findViewById(R.id.checkBoxBebida)
        checkBoxPapas = view.findViewById(R.id.checkBoxPapas)
        checkBoxPostre = view.findViewById(R.id.checkBoxPostre)
        botonSiguiente = view.findViewById(R.id.botonSiguiente)
    }

    private fun recuperarDatosComida() {
        arguments?.let { bundle ->
            comidaSeleccionada = bundle.getString("comida", "")
        }
    }

    private fun configurarBotonSiguiente() {
        botonSiguiente.setOnClickListener {
            val extras = obtenerExtrasSeleccionados()
            navegarAResumen(comidaSeleccionada, extras)
        }
    }

    private fun obtenerExtrasSeleccionados(): List<String> {
        val listaExtras = mutableListOf<String>()

        if (checkBoxBebida.isChecked) {
            listaExtras.add(checkBoxBebida.text.toString())
        }
        if (checkBoxPapas.isChecked) {
            listaExtras.add(checkBoxPapas.text.toString())
        }
        if (checkBoxPostre.isChecked) {
            listaExtras.add(checkBoxPostre.text.toString())
        }

        return listaExtras
    }

    private fun navegarAResumen(comida: String, extras: List<String>) {
        val bundle = bundleOf(
            "comida" to comida,
            "extras" to extras.toTypedArray()
        )
        findNavController().navigate(
            R.id.action_seleccionExtrasFragment_to_resumenPedidoFragment,
            bundle
        )
    }
}
