# Proyecto Flutter: Sistema de Login con Validaciones y Gestión de Usuarios

## Descripción del Proyecto

Aplicación Flutter completa que implementa un sistema de autenticación con login, validaciones avanzadas de formularios, y gestión de usuarios (CRUD) utilizando el patrón arquitectónico MVVM con Provider. El proyecto integra dos prácticas: Login con validaciones y gestión de usuarios.

## Características Principales

### Sistema de Login
-  Formulario de login con validaciones robustas
-  Validación de formato de correo electrónico
-  Validación de contraseña con requisitos de seguridad
-  Validación de mayúsculas y números en contraseña
-  Interfaz de usuario moderna y profesional
-  Opción de "Crear cuenta" y "¿Olvidaste tu contraseña?"

### Gestión de Usuarios
-  CRUD completo de usuarios
-  Arquitectura MVVM para separación de responsabilidades
-  Gestión de estado con Provider
-  Formularios con validación completa
-  Componentes interactivos (RadioButton, Switch)
-  Listas dinámicas con ListView.builder
-  Filtro para mostrar solo usuarios activos
-  Navegación entre pantallas con paso de parámetros

## Tecnologías Utilizadas

- Flutter SDK (3.0+)
- Dart
- Provider (^6.1.5+1)
- Material Design

## Estructura del Proyecto

```
lib/
│
├── main.dart
├── models/
│   └── user.dart
├── viewmodels/
│   └── user_view_model.dart
└── views/
    ├── login_screen.dart
    ├── user_list_screen.dart
    └── user_form_screen.dart
```

## Instalación y Configuración

### Prerrequisitos

- Flutter SDK instalado (versión 3.0 o superior)
- Dart SDK
- Android Studio o Visual Studio Code
- Emulador o dispositivo físico

## Flujo de la Aplicación

1. **Pantalla de Login**: El usuario ingresa email y contraseña con validaciones en tiempo real
2. **Validación**: Se verifica formato de email y requisitos de contraseña
3. **Navegación**: Al ingresar correctamente, se pasa a la lista de usuarios
4. **Gestión de Usuarios**: CRUD completo con todas las funcionalidades

## Conceptos Aprendidos

### Formularios en Flutter
- Uso de `Form` y `GlobalKey<FormState>`
- Diferencia entre `validator` y `onSaved`
- Cuándo usar `TextEditingController` vs `onSaved`
- Validaciones personalizadas con RegExp

### Navegación
- Navegación básica con `Navigator.push`
- Paso de parámetros entre pantallas
- Retorno de datos desde pantallas

### Validaciones Implementadas
-  Email con formato válido (contiene @)
-  Contraseña mínimo 6 caracteres
-  Al menos una letra mayúscula
-  Al menos un número
-  Campos no vacíos

## Preguntas de Reflexión - Login

### 1. ¿Cuándo usar onSaved vs TextEditingController?

**Respuesta:** 
- **onSaved**: Se usa cuando solo necesitamos capturar el valor final del campo después de validar el formulario completo. Es ideal para formularios estáticos como Login donde solo nos interesa el valor al momento de enviar.
  
- **TextEditingController**: Se usa cuando necesitamos:
  - Leer el valor del campo en cualquier momento
  - Modificar el texto programáticamente
  - Escuchar cambios en tiempo real
  - Limpiar campos dinámicamente
  - Implementar búsquedas en tiempo real

**Ejemplo de uso adecuado:**
- Login/Registro → `onSaved` (solo necesitamos valores al enviar)
- Búsqueda en tiempo real → `TextEditingController` (necesitamos cada cambio)
- Formularios con campos dependientes → `TextEditingController`

### 2. ¿Qué ventajas tiene usar Form y GlobalKey?

**Respuesta:**
- **Validación centralizada**: Con `_formKey.currentState!.validate()` se validan todos los campos a la vez
- **Captura de datos unificada**: Con `_formKey.currentState!.save()` se ejecutan todos los `onSaved`
- **Código más limpio**: No necesitamos validar campo por campo manualmente
- **Mejor UX**: Los errores se muestran automáticamente bajo cada campo
- **Mantenibilidad**: Es más fácil agregar o modificar validaciones
- **Reutilización**: El mismo patrón funciona para cualquier formulario

### 3. ¿Por qué es importante validar tanto el formato como el contenido?

**Respuesta:**
- **Seguridad**: Validaciones de contraseña fuertes previenen cuentas vulnerables
- **Integridad de datos**: Asegura que los datos cumplan el formato esperado
- **Experiencia de usuario**: Retroalimentación inmediata sobre errores
- **Prevención de errores**: Evita problemas en el backend o base de datos
- **Buenas prácticas**: Cumple con estándares de desarrollo profesional
- **Validación en capas**: Frontend valida formato, backend valida lógica de negocio

## Preguntas de Reflexión - CRUD

### 1. ¿Qué ventajas ofrece usar Provider frente a setState()?

**Respuesta:** Provider ofrece múltiples ventajas sobre setState():
- **Separación de responsabilidades**: Permite separar la lógica de negocio de la interfaz de usuario
- **Gestión centralizada del estado**: El estado se maneja en un solo lugar (ViewModel)
- **Reactividad automática**: Los widgets se reconstruyen automáticamente cuando cambia el estado
- **Mejor rendimiento**: Solo se reconstruyen los widgets que escuchan cambios específicos
- **Escalabilidad**: Facilita el mantenimiento y crecimiento de aplicaciones grandes
- **Testabilidad**: Es más fácil realizar pruebas unitarias de la lógica de negocio

### 2. ¿Por qué es importante usar ChangeNotifier en el ViewModel?

**Respuesta:** ChangeNotifier es fundamental porque:
- **Patrón Observer**: Implementa el patrón de diseño Observer
- **Notificación de cambios**: Permite notificar a todos los listeners cuando el estado cambia
- **Actualización reactiva**: Los widgets se reconstruyen automáticamente
- **Desacoplamiento**: Mantiene la vista desacoplada del modelo (principios MVVM)
- **Eficiencia**: Solo notifica cambios cuando es necesario

### 3. ¿Qué sucedería si no se llamara a notifyListeners()?

**Respuesta:** Si no se llama a `notifyListeners()`:
- **La interfaz NO se actualizaría**: Los cambios no se reflejarían visualmente
- **Estado inconsistente**: Datos actualizados en memoria pero UI desactualizada
- **Mala experiencia de usuario**: Confusión al no ver cambios realizados
- **Bugs difíciles de detectar**: Funcionalidad correcta pero sin actualización visual

## Autor

**Nicolle Andrea Lozano Vega**
- Universidad: Universidad La Salle
- Materia: Programación para Dispositivos Móviles
- Fecha: Noviembre 2024

