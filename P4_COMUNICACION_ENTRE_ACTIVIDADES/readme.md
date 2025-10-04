# PRÁCTICA 4 - Comunicación entre Actividades


## Descripción del Problema

Desarrollo de dos aplicaciones Android que demuestran la comunicación efectiva entre actividades mediante el uso de Intent, gestión de resultados y persistencia de datos durante cambios de configuración.

**Objetivo**: Implementar la comunicación bidireccional entre actividades utilizando Intent para el envío de datos, registerForActivityResult para recibir resultados, y onSaveInstanceState para mantener el estado durante rotaciones de pantalla.

---

## Información del Proyecto

* **Autor**: Nicolle Lozano
* **Fecha de creación**: 01/10/2025
* **Fecha última modificación**: 04/10/2025
* **Lenguaje**: Kotlin
* **Plataforma**: Android Studio

---

## Ejercicios Implementados

### **Ejercicio 1: Editor de Perfil con Confirmación**

Aplicación que permite capturar información de un usuario, mostrar un resumen y confirmar o editar los datos.

**Funcionalidades:**
*  Captura de datos de perfil (Nombre, Edad, Ciudad, Correo)
*  Validación de campos obligatorios
*  Visualización de resumen de datos
*  Confirmación con Toast informativo
*  Opción de regresar a editar
*  Persistencia de datos en rotación de pantalla

### **Ejercicio 2: Editor de Nota Rápida**

Aplicación para escribir notas rápidas con opciones de compartir o continuar editando.

**Funcionalidades:**
*  Editor de texto multilínea
*  Visualización de la nota escrita
*  Simulación de compartir por correo
*  Opción de regresar a editar
*  Persistencia del texto en rotación de pantalla

---

## Capturas de Pantalla

### Ejercicio 1: Editor de Perfil

#### Pantalla 1 - Formulario de Captura
<img width="180" height="398" alt="image" src="https://github.com/user-attachments/assets/8ff98d45-e4e6-490c-85ae-d627071a0f71" />

*FormularioActivity: Captura de datos del usuario*

#### Pantalla 2 - Resumen del Perfil
<img width="180" height="398" alt="image" src="https://github.com/user-attachments/assets/d39f8d20-c458-4784-b3c3-97b9b257202f" />

*ResumenActivity: Visualización y confirmación de datos*

#### Toast de Confirmación
<img width="180" height="398" alt="image" src="https://github.com/user-attachments/assets/c2f0f632-4b0a-4ad3-a42a-c5db6b07c19a" />

*Mensaje de confirmación al guardar el perfil*


---

### Ejercicio 2: Editor de Nota Rápida

#### Pantalla 1 - Editor de Nota
<img width="180" height="398" alt="image" src="https://github.com/user-attachments/assets/24a755f7-9012-4165-a452-2d14c6d015b5" />

*EditorActivity: Campo de texto para escribir la nota*

#### Pantalla 2 - Opciones de la Nota
<img width="180" height="398" alt="image" src="https://github.com/user-attachments/assets/a6361879-b2a6-431b-9404-1c3950e61e20" />

*OpcionesActivity: Visualización y opciones de acción*

#### Toast de Compartir y Persistencia en Rotación
<img width="180" height="398" alt="image" src="https://github.com/user-attachments/assets/bc97cdbc-5582-4472-8b8c-51d1f9052f92" />

*Mensaje al compartir por correo*
*El texto de la nota se conserva al rotar*

---

## Estructura del Proyecto

```
Practica4/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/practica4/
│   │   │   ├── Usuario.kt                      # Data class para perfil
│   │   │   ├── FormularioActivity.kt           # Captura de datos del perfil
│   │   │   ├── ResumenActivity.kt              # Resumen y confirmación
│   │   │   ├── EditorActivity.kt               # Editor de notas
│   │   │   └── OpcionesActivity.kt             # Opciones de la nota
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   ├── activity_formulario.xml         # Layout del formulario
│   │   │   ├── activity_resumen.xml            # Layout del resumen
│   │   │   ├── activity_editor.xml             # Layout del editor
│   │   │   └── activity_opciones.xml           # Layout de opciones
│   │   └── AndroidManifest.xml                 # Declaración de actividades
└── README.md                                   # Este archivo
```

---

## Conceptos Técnicos Implementados

### **1. Comunicación entre Actividades**

#### **Intent con Extras**
```kotlin
// Envío de datos simples
intent.putExtra("CLAVE", valor)

// Envío de objetos serializables
intent.putExtra("USUARIO", usuario)
```

#### **Data Class con Serializable**
```kotlin
data class Usuario(
    val nombre: String,
    val edad: String,
    val ciudad: String,
    val correo: String
) : Serializable
```

### **2. Gestión de Resultados (Activity Result API)**

```kotlin
// Registro del launcher
private val launcher = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
) { result ->
    if (result.resultCode == RESULT_OK) {
        // Procesar resultado
    }
}

// Lanzar actividad
launcher.launch(intent)

// Enviar resultado
setResult(RESULT_OK, intent)
finish()
```

### **3. Persistencia de Estado**

```kotlin
// Guardar estado
override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putString("CLAVE", valor)
}

// Restaurar estado
private fun restaurarDatos(savedInstanceState: Bundle?) {
    savedInstanceState?.let {
        val valor = it.getString("CLAVE", "")
    }
}
```

---

## Flujos de Navegación

### **Ejercicio 1: Editor de Perfil**

```
[FormularioActivity]
    ↓ (Continuar + Datos)
[ResumenActivity]
    ↓ Confirmar → RESULT_OK → Toast + Limpiar campos
    ↓ Volver a editar → RESULT_CANCELED → Mantener datos
[FormularioActivity]
```

### **Ejercicio 2: Editor de Nota**

```
[EditorActivity]
    ↓ (Compartir + Nota)
[OpcionesActivity]
    ↓ Compartir por correo → Toast + finish()
    ↓ Editar de nuevo → RESULT_OK + Nota → Restaurar texto
[EditorActivity]
```

---

## Características Técnicas

### **Manejo de Eventos:**
* OnClickListener para botones
* Validación antes de navegación
* Toast informativos para feedback

### **Arquitectura:**
* Separación de responsabilidades
* Funciones privadas auxiliares
* Inicialización ordenada en onCreate

---

## Checklist de Funcionalidades

### **Ejercicio 1:**
- [x] Captura de 4 campos (Nombre, Edad, Ciudad, Correo)
- [x] Validación de campos obligatorios
- [x] Navegación con Intent y objeto Serializable
- [x] Visualización de resumen en segunda actividad
- [x] Botón "Confirmar" con Toast y limpieza de campos
- [x] Botón "Volver a editar" mantiene los datos
- [x] Persistencia con onSaveInstanceState
- [x] Uso de registerForActivityResult

### **Ejercicio 2:**
- [x] Campo de texto multilínea para nota
- [x] Navegación con Intent y String extra
- [x] Visualización de nota en segunda actividad
- [x] Botón "Compartir por correo" con Toast
- [x] Botón "Editar de nuevo" regresa con texto
- [x] Persistencia con onSaveInstanceState
- [x] Uso de registerForActivityResult




---

**Nota**: Este proyecto fue desarrollado con fines educativos para aprender los fundamentos de comunicación entre actividades en Android.
