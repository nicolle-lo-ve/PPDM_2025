# Práctica 6: Aplicación Personal en Flutter

## Introducción
Este proyecto contiene una aplicación Flutter que presenta información personal del desarrollador:
- Aplicación Personal: Una aplicación que muestra información sobre el desarrollador, incluyendo perfil personal, información de contacto y hobbies/intereses, con una interfaz moderna y atractiva.

## Requisitos
- Flutter SDK 3.0 o superior 
- Dart SDK 2.17 o superior 
- Android Studio o Visual Studio Code con extensiones de Flutter 
- Dispositivo Android/iOS o emulador

## Estructura del Proyecto
- [`main.dart`](app_personal/lib/main.dart): Punto de entrada principal de la aplicación Flutter
- [`pantalla_inicio.dart`](app_personal/lib/screens/pantalla_inicio.dart): Pantalla de bienvenida con mensaje introductorio
- [`pantalla_perfil.dart`](app_personal/lib/screens/pantalla_perfil.dart): Pantalla que muestra información personal y de contacto
- [`pantalla_hobbies.dart`](app_personal/lib/screens/pantalla_hobbies.dart): Pantalla que presenta hobbies e intereses con imágenes
- [`app_colors.dart`](app_personal/lib/utils/app_colors.dart): Definición de colores usados en la aplicación
- [`app_texts.dart`](app_personal/lib/utils/app_colors.dart): Definición de todos los textos utilizados en la aplicación

## Descripción
- Aplicación Flutter que presenta información personal del desarrollador de manera atractiva 
- Implementa un diseño modular con separación clara de responsabilidades 
- Utiliza widgets personalizados para mantener consistencia visual 
- Maneja imágenes de red con fallbacks en caso de error de carga 
- Implementa un sistema de colores y textos para facilitar mantenimiento

## Funcionalidades implementadas
- Pantalla de inicio con mensaje de bienvenida personalizado 
- Pantalla de perfil con foto, información personal y datos de contacto 
- Pantalla de hobbies con cards visuales que incluyen imágenes de internet 
- Sistema de colores consistente en toda la aplicación 
- Textos centralizados para fácil localización futura 
- Diseño responsive que se adapta a diferentes tamaños de pantalla 
- Manejo de errores en carga de imágenes de red

## Tecnologías y patrones utilizados
- Flutter Framework para desarrollo multiplataforma 
- Material Design para componentes de interfaz 
- Widgets Stateless para interfaces estáticas 
- SingleChildScrollView para contenido desplazable 
- NetworkImage con errorBuilder para imágenes de internet 
- Separación de utilidades (colors y texts) para mejor organización 
- Container y decoration para diseño visual personalizado 
- Column y Row para layouts flexibles

## Instrucciones de Configuración
1. Clonar o descargar el repositorio
2. Asegurarse de tener Flutter instalado correctamente (flutter doctor)
3. Abrir una terminal en la carpeta [app_personal](app_personal)
4. Ejecutar flutter `pub get` para instalar dependencias
5. Verificar que un dispositivo esté conectado o un emulador esté ejecutándose (flutter devices)

## Instrucciones de Ejecución
1. Conectar un dispositivo Android/iOS físico mediante USB o iniciar un emulador 
2. En la terminal, dentro de la carpeta del proyecto, ejecutar:
   `bashflutter run`
3. Alternativamente, desde el IDE:
   - Visual Studio Code: Presionar F5 o usar Command Palette > Flutter: Launch Emulator 
   - Android Studio: Hacer clic en el botón "Run" (triángulo verde)
4. Esperar a que la aplicación se compile e instale en el dispositivo

## Cómo Usar la Aplicación
1. Al iniciar, la aplicación mostrará una de las tres pantallas (configurable en main.dart):
   - **Pantalla de Inicio**: Mensaje de bienvenida con botón hacia el perfil 
   - **Pantalla de Perfil**: Información personal completa con foto y datos de contacto 
   - **Pantalla de Hobbies**: Lista visual de hobbies e intereses con imágenes 
2. Para probar diferentes pantallas, modificar la línea home: en main.dart:
   - `PantallaInicio()` para la pantalla de bienvenida
   - `PantallaPerfil()` para el perfil personal
   - `PantallaHobbies()` para hobbies e intereses

## Funcionalidades Adicionales
- **Diseño moderno**: Uso de cards, bordes redondeados y sombras para una apariencia profesional 
- **Manejo de errores**: Las imágenes de red tienen fallbacks en caso de fallo de carga 
- **Responsive**: La interfaz se adapta a diferentes orientaciones y tamaños de pantalla 
- **Arquitectura limpia**: Separación clara entre lógica, presentación y recursos 
- **Personalización fácil**: Colores y textos centralizados permiten cambios rápidos de tema

## Notas Técnicas
- Se utiliza `NetworkImage` para cargar imágenes desde internet con `errorBuilder` para manejo de errores 
- Los colores están definidos como constantes estáticas para consistencia y fácil mantenimiento 
- Todos los textos están centralizados en una clase separada para facilitar futuras localizaciones 
- Se implementa `SingleChildScrollView` para asegurar que el contenido sea accesible en pantallas pequeñas 
- Los widgets están organizados de manera modular con métodos privados para componentes reutilizables

## Personalización
- Para personalizar la aplicación con tu información:
  1. Modificar los textos en app_texts.dart con tu información personal 
  2. Actualizar los colores en app_colors.dart según tus preferencias 
  3. Cambiar las URLs de las imágenes en pantalla_hobbies.dart y pantalla_perfil.dart 
  4. Ajustar los hobbies y descripciones según tus intereses personales

## Solución de Problemas
- Si `flutter run` falla, ejecutar `flutter clean` seguido de `flutter pub get` 
- Si las imágenes no cargan, verificar la conexión a internet del dispositivo 
- Si hay errores de compilación, verificar la versión de Flutter con `flutter --version` 
- Para problemas de dependencias, ejecutar `flutter pub deps` para verificar el árbol de dependencias 
- Si el hot reload no funciona, reiniciar la aplicación con 'R' en la terminal
