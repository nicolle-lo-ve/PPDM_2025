/*
 * Descripción: Fragment para seleccionar el tipo de comida principal del pedido
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
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class SeleccionComidaFragment : Fragment() {

    private lateinit var radioGroupComida: RadioGroup
    private lateinit var botonSiguiente: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_seleccion_comida, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inicializarVistas(view)
        configurarListenerResultado()
        configurarBotonSiguiente()
    }

    private fun inicializarVistas(view: View) {
        radioGroupComida = view.findViewById(R.id.radioGroupComida)
        botonSiguiente = view.findViewById(R.id.botonSiguiente)
    }

    private fun configurarListenerResultado() {
        setFragmentResultListener("pedido_editado") { _, bundle ->
            val comidaGuardada = bundle.getString("comida")
            seleccionarComidaPorNombre(comidaGuardada)
        }
    }

    private fun seleccionarComidaPorNombre(nombreComida: String?) {
        if (nombreComida == null) return

        for (i in 0 until radioGroupComida.childCount) {
            val radioButton = radioGroupComida.getChildAt(i) as? RadioButton
            if (radioButton?.text.toString() == nombreComida) {
                radioButton?.isChecked = true
                break
            }
        }
    }

    private fun configurarBotonSiguiente() {
        botonSiguiente.setOnClickListener {
            val comidaSeleccionada = obtenerComidaSeleccionada()
            if (comidaSeleccionada.isNotEmpty()) {
                navegarASeleccionExtras(comidaSeleccionada)
            }
        }
    }

    private fun obtenerComidaSeleccionada(): String {
        val radioButtonSeleccionado = radioGroupComida.checkedRadioButtonId
        if (radioButtonSeleccionado != -1) {
            val radioButton = view?.findViewById<RadioButton>(radioButtonSeleccionado)
            return radioButton?.text.toString()
        }
        return ""
    }

    private fun navegarASeleccionExtras(comida: String) {
        val bundle = bundleOf("comida" to comida)
        findNavController().navigate(
            R.id.action_seleccionComidaFragment_to_seleccionExtrasFragment,
            bundle
        )
    }
}
