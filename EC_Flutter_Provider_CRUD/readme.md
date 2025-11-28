# Proyecto Flutter: Gestión de Usuarios con MVVM y Provider

## Descripción del Proyecto

Aplicación Flutter que implementa un sistema CRUD (Crear, Leer, Actualizar, Eliminar) de usuarios utilizando el patrón arquitectónico MVVM (Model-View-ViewModel) y Provider para la gestión de estado. La aplicación permite agregar, editar y eliminar usuarios con validaciones de formulario y componentes interactivos.

## Características Principales

-  Gestión completa de usuarios (CRUD)
-  Arquitectura MVVM para separación de responsabilidades
-  Gestión de estado con Provider
-  Formularios con validación
-  Componentes interactivos (RadioButton, Switch)
-  Listas dinámicas con ListView.builder
-  Interfaz responsive y moderna
-  Campo adicional de edad con validación numérica
-  Validación de correo electrónico
-  Filtro para mostrar solo usuarios activos

## Tecnologías Utilizadas

- Flutter SDK
- Dart
- Provider (^6.1.5+1)

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
    ├── user_list_screen.dart
    └── user_form_screen.dart
```

## Instalación y Configuración

### Prerrequisitos

- Flutter SDK instalado (versión 3.0 o superior)
- Dart SDK
- Android Studio o Visual Studio Code
- Emulador o dispositivo físico

### Pasos de instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/tu-usuario/gestion-usuarios-flutter.git
cd gestion-usuarios-flutter
```

2. Instalar las dependencias:
```bash
flutter pub get
```

3. Ejecutar la aplicación:
```bash
flutter run
```

## Cómo Usar la Aplicación

1. **Ver lista de usuarios**: La pantalla principal muestra todos los usuarios registrados
2. **Agregar usuario**: Presiona el botón flotante (+) para abrir el formulario
3. **Editar usuario**: Presiona el ícono de edición en cualquier usuario de la lista
4. **Eliminar usuario**: Presiona el ícono de eliminar (🗑️) en cualquier usuario
5. **Filtrar usuarios**: Usa el botón de filtro para mostrar solo usuarios activos


## Preguntas de Reflexión

### 1. ¿Qué ventajas ofrece usar Provider frente a setState()?

**Respuesta:** Provider ofrece múltiples ventajas sobre setState():
- **Separación de responsabilidades**: Permite separar la lógica de negocio de la interfaz de usuario
- **Gestión centralizada del estado**: El estado se maneja en un solo lugar (ViewModel) en lugar de estar disperso en múltiples widgets
- **Reactividad automática**: Los widgets se reconstruyen automáticamente cuando cambia el estado sin necesidad de llamadas manuales a setState()
- **Mejor rendimiento**: Solo se reconstruyen los widgets que escuchan cambios específicos, no todo el árbol de widgets
- **Escalabilidad**: Facilita el mantenimiento y crecimiento de aplicaciones grandes
- **Testabilidad**: Es más fácil realizar pruebas unitarias de la lógica de negocio

### 2. ¿Por qué es importante usar ChangeNotifier en el ViewModel?

**Respuesta:** ChangeNotifier es fundamental porque:
- **Patrón Observer**: Implementa el patrón de diseño Observer, permitiendo que múltiples widgets "observen" cambios en el estado
- **Notificación de cambios**: Permite que el ViewModel notifique a todos sus listeners cuando el estado cambia mediante `notifyListeners()`
- **Actualización reactiva**: Los widgets que usan `context.watch()` o `Consumer` se reconstruyen automáticamente cuando se notifica un cambio
- **Desacoplamiento**: Mantiene la vista desacoplada del modelo, siguiendo los principios de MVVM
- **Eficiencia**: Solo notifica cambios cuando es necesario, optimizando el rendimiento

### 3. ¿Qué sucedería si no se llamara a notifyListeners() después de editar un usuario?

**Respuesta:** Si no se llama a `notifyListeners()`:
- **La interfaz NO se actualizaría**: Los cambios en los datos no se reflejarían visualmente en la pantalla
- **Estado inconsistente**: Los datos estarían actualizados en memoria pero la UI mostraría información desactualizada
- **Mala experiencia de usuario**: El usuario no vería los cambios que acaba de realizar, causando confusión
- **Bugs difíciles de detectar**: Podría parecer que la funcionalidad no funciona cuando en realidad solo falta la actualización visual
- **Necesidad de refrescar manualmente**: El usuario tendría que salir y volver a entrar a la pantalla para ver los cambios

## Autor

**Nicolle Andrea Lozano Vega**
- Universidad: Universidad La Salle
- Materia:Programación para Dispositivos Móviles
- Fecha: Noviembre 2024


