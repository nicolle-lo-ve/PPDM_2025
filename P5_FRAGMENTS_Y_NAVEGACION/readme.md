# PRÁCTICA 5 - Fragments y Navegación

## Descripción del Problema
Desarrollo de una aplicación Android que implementa un sistema de configuración de pedidos de comida utilizando múltiples fragments y el componente de navegación de Android. La aplicación permite al usuario armar un pedido paso a paso, visualizarlo y editarlo si es necesario.

**Objetivo:** Implementar la navegación entre fragments utilizando Navigation Component, el paso de datos mediante Bundle, la comunicación bidireccional entre fragments con Fragment Result API, y el uso de popBackStack para retroceder en el flujo de navegación.

---

## Información del Proyecto
- **Autor:** Nicolle Lozano
- **Fecha de creación:** 01/10/2025
- **Fecha última modificación:** 04/10/2025
- **Lenguaje:** Kotlin
- **Plataforma:** Android Studio

---

## Aplicación Implementada

### **Configurador de Pedido de Comida**
Aplicación que guía al usuario a través de un proceso de tres pasos para configurar un pedido de comida, permitiendo seleccionar la comida principal, agregar extras y visualizar un resumen antes de confirmar.

#### **Funcionalidades:**
- Navegación paso a paso para configurar pedido
- Selección de comida principal (Pizza, Hamburguesa, Ensalada)
- Selección múltiple de extras (Bebida, Papas fritas, Postre)
- Visualización de resumen detallado del pedido
- Confirmación del pedido con mensaje informativo
- Opción de editar el pedido y volver al inicio del flujo
- Comunicación bidireccional entre fragments
- Gestión del backstack de navegación

---

## Capturas de Pantalla

### Pantalla 1 - Inicio
<img width="270" height="585" alt="image" src="https://github.com/user-attachments/assets/af7cd78d-e8ba-45d0-82b9-d02fe800d2eb" />
 
**InicioFragment:** Pantalla de bienvenida

### Pantalla 2 - Selección de Comida
<img width="270" height="585" alt="image" src="https://github.com/user-attachments/assets/4f18ce8f-faef-4328-a5cf-a2be1c42608b" />

**SeleccionComidaFragment:** Selección de comida principal mediante RadioButtons

### Pantalla 3 - Selección de Extras
<img width="270" height="585" alt="image" src="https://github.com/user-attachments/assets/e8ff6bb8-d87b-4a93-af3c-34a63407b608" />

**SeleccionExtrasFragment:** Selección de extras adicionales mediante CheckBoxes

### Pantalla 4 - Resumen del Pedido
<img width="270" height="585" alt="image" src="https://github.com/user-attachments/assets/5ff226ea-b8bc-474f-8d2f-8ec1a7bb0ecc" />

**ResumenPedidoFragment:** Visualización del pedido completo

### Toast de Confirmación
<img width="270" height="585" alt="image" src="https://github.com/user-attachments/assets/1878e550-74c1-49d2-b36c-073ee988c084" />

Mensaje al confirmar el pedido exitosamente

---

## Estructura del Proyecto

```
Practica5/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/configuradorpedido/
│   │   │   ├── MainActivity.kt                 # Activity principal con NavHost
│   │   │   ├── InicioFragment.kt               # Fragment de pantalla inicial
│   │   │   ├── SeleccionComidaFragment.kt      # Fragment selección de comida
│   │   │   ├── SeleccionExtrasFragment.kt      # Fragment selección de extras
│   │   │   └── ResumenPedidoFragment.kt        # Fragment de resumen
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml           # Layout principal con NavHostFragment
│   │   │   │   ├── fragment_inicio.xml         # Layout pantalla inicial
│   │   │   │   ├── fragment_seleccion_comida.xml    # Layout selección comida
│   │   │   │   ├── fragment_seleccion_extras.xml    # Layout selección extras
│   │   │   │   └── fragment_resumen_pedido.xml      # Layout resumen
│   │   │   └── navigation/
│   │   │       └── nav_graph.xml               # Grafo de navegación
│   │   └── AndroidManifest.xml                 # Declaración de actividad
└── README.md                                    # Este archivo
```

---

## Conceptos Técnicos Implementados

### **1. Navigation Component**

#### Configuración del NavHostFragment
```kotlin
// En activity_main.xml
<androidx.fragment.app.FragmentContainerView
    android:id="@+id/nav_host_fragment"
    android:name="androidx.navigation.fragment.NavHostFragment"
    app:navGraph="@navigation/nav_graph"
    app:defaultNavHost="true" />
```

#### Navegación entre Fragments
```kotlin
// Navegación simple
findNavController().navigate(R.id.action_fragmentA_to_fragmentB)

// Navegación con datos
val bundle = bundleOf("clave" to valor)
findNavController().navigate(R.id.action_fragmentA_to_fragmentB, bundle)
```

### **2. Paso de Datos con Bundle**

#### Envío de datos hacia adelante
```kotlin
// En SeleccionComidaFragment
private fun navegarASeleccionExtras(comida: String) {
    val bundle = bundleOf("comida" to comida)
    findNavController().navigate(
        R.id.action_seleccionComidaFragment_to_seleccionExtrasFragment,
        bundle
    )
}
```

#### Recepción de datos
```kotlin
// En SeleccionExtrasFragment
private fun recuperarDatosComida() {
    arguments?.let { bundle ->
        comidaSeleccionada = bundle.getString("comida", "")
    }
}
```

#### Paso de arrays
```kotlin
// Envío
val bundle = bundleOf(
    "comida" to comida,
    "extras" to extras.toTypedArray()
)

// Recepción
extrasPedido = bundle.getStringArray("extras") ?: arrayOf()
```

### **3. Fragment Result API**

#### Envío de resultados hacia atrás
```kotlin
// En ResumenPedidoFragment - botón "Editar"
private fun enviarDatosParaEdicion() {
    val bundle = bundleOf(
        "comida" to comidaPedido,
        "extras" to extrasPedido
    )
    setFragmentResult("pedido_editado", bundle)
}
```

#### Escuchar resultados
```kotlin
// En SeleccionComidaFragment
private fun configurarListenerResultado() {
    setFragmentResultListener("pedido_editado") { _, bundle ->
        val comidaGuardada = bundle.getString("comida")
        seleccionarComidaPorNombre(comidaGuardada)
    }
}
```

---

## Flujo de Navegación

```
[InicioFragment]
    ↓ (Botón: Nuevo Pedido)
[SeleccionComidaFragment] ← Recibe datos si se edita (setFragmentResultListener)
    ↓ (Siguiente + comida seleccionada en Bundle)
[SeleccionExtrasFragment] ← Recibe comida del Bundle anterior
    ↓ (Siguiente + comida y extras en Bundle)
[ResumenPedidoFragment] ← Recibe todo el pedido del Bundle
    ↓ Confirmar → navigate() → Toast + Limpiar backstack
    ↓ Editar → setFragmentResult() + popBackStack()
[SeleccionComidaFragment] ← Restaura datos del pedido
```

---

## Conceptos de Aprendizaje

Este proyecto permite practicar:
-  **Navigation Component** para gestión de fragments
-  **Bundle** para paso de datos entre fragments
-  **Fragment Result API** para comunicación bidireccional
-  **popBackStack()** para navegación hacia atrás
-  **Ciclo de vida de Fragments**
-  **RadioButtons y CheckBoxes** para selección
-  **Manejo de eventos** con listeners
-  **Arquitectura limpia** con separación de responsabilidades



