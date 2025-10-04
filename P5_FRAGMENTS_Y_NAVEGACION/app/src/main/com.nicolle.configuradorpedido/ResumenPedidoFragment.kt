/*
 * Descripción: Fragment que muestra el resumen del pedido y permite confirmarlo o editarlo
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
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController

class ResumenPedidoFragment : Fragment() {

    private lateinit var textViewResumen: TextView
    private lateinit var botonConfirmar: Button
    private lateinit var botonEditar: Button

    private var comidaPedido: String = ""
    private var extrasPedido: Array<String> = arrayOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resumen_pedido, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inicializarVistas(view)
        recuperarDatosPedido()
        mostrarResumenPedido()
        configurarBotones()
    }

    private fun inicializarVistas(view: View) {
        textViewResumen = view.findViewById(R.id.textViewResumen)
        botonConfirmar = view.findViewById(R.id.botonConfirmar)
        botonEditar = view.findViewById(R.id.botonEditar)
    }

    private fun recuperarDatosPedido() {
        arguments?.let { bundle ->
            comidaPedido = bundle.getString("comida", "Sin comida")
            extrasPedido = bundle.getStringArray("extras") ?: arrayOf()
        }
    }

    private fun mostrarResumenPedido() {
        val textoResumen = generarTextoResumen()
        textViewResumen.text = textoResumen
    }

    private fun generarTextoResumen(): String {
        val builder = StringBuilder()
        builder.append("=== RESUMEN DE TU PEDIDO ===\n\n")
        builder.append("Comida principal: $comidaPedido\n\n")

        if (extrasPedido.isNotEmpty()) {
            builder.append("Extras seleccionados:\n")
            extrasPedido.forEach { extra ->
                builder.append("• $extra\n")
            }
        } else {
            builder.append("Sin extras adicionales\n")
        }

        return builder.toString()
    }

    private fun configurarBotones() {
        botonConfirmar.setOnClickListener {
            confirmarPedido()
        }

        botonEditar.setOnClickListener {
            editarPedido()
        }
    }

    private fun confirmarPedido() {
        mostrarMensajeConfirmacion()
        navegarAlInicio()
    }

    private fun mostrarMensajeConfirmacion() {
        Toast.makeText(
            requireContext(),
            "¡Pedido confirmado con éxito!",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun navegarAlInicio() {
        findNavController().navigate(R.id.action_resumenPedidoFragment_to_inicioFragment)
    }

    private fun editarPedido() {
        enviarDatosParaEdicion()
        regresarASeleccionComida()
    }

    private fun enviarDatosParaEdicion() {
        val bundle = bundleOf(
            "comida" to comidaPedido,
            "extras" to extrasPedido
        )
        setFragmentResult("pedido_editado", bundle)
    }

    private fun regresarASeleccionComida() {
        findNavController().popBackStack(R.id.seleccionComidaFragment, false)
    }
}
