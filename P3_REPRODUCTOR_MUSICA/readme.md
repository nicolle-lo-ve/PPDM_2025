# PRACTICA 3 - Reproductor de Música Básico

> **Tarea 2 - Práctica 3: Aplicaciones Básicas Android**

## 📝 Descripción del Problema

Desarrollo de un reproductor de música básico para Android que implemente las funcionalidades esenciales de reproducción de audio.

**Objetivo**: Crear una interfaz de usuario con botones para reproducir, pausar y detener la reproducción de música, implementando la lógica para reproducir archivos de audio almacenados localmente usando MediaPlayer.

## Información del Proyecto

- **Autor**: Nicolle Lozano
- **Fecha de creación**: 09/09/25
- **Fecha última modificación**: 13/09/25
- **Lenguaje**: Kotlin
- **Plataforma**: Android Studio

## Funcionalidades Implementadas

### Controles de reproducción:
- **REPRODUCIR**: Inicia la reproducción del archivo de audio
- **PAUSAR**: Pausa la reproducción manteniando la posición
- **DETENER**: Detiene completamente y libera recursos

### Características técnicas:
- **MediaPlayer Integration**: Uso correcto de la clase MediaPlayer
- **Resource Management**: Carpeta res/raw para archivos de audio
- **Memory Management**: Liberación correcta de recursos
- **User Feedback**: Toast informativos para cada acción

## Interfaz de Usuario

<img width="367" height="770" alt="image" src="https://github.com/user-attachments/assets/7f2c57ec-96f5-49aa-8a16-fffc0c4833aa" />


## 🛠️ Estructura del Proyecto

```
MusicPlayer/
├── app/
│   ├── src/main/
│   │   ├── kotlin+java
│   │   │   └── MainActivity.kt                            # Lógica del reproductor
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml                      # Interfaz de usuario
│   │   │   ├── raw/                                       # Archivos de audio
|               └── sabrina_carpenter_manchild.mp3         # Audio de ejemplo
└── README.md                                              # Este archivo
```

## Conceptos Técnicos Implementados

### Android Media Framework:
- **MediaPlayer Class**: Reproducción de archivos multimedia
- **Resource Management**: Uso de carpeta res/raw
- **Lifecycle Management**: onCreate() y onDestroy()
- **Memory Management**: release() para liberar recursos

### Estados de Control:
```
[IDLE] → create() → [Inicialización] → start() → [REPRODUCIR]
   ↑                                              ↓
   ← release() ← [DETENER] ← stop() ← pause() → [PAUSAR]
```

### Manejo de Eventos:
- **Button OnClickListener**: Manejo de eventos de botón
- **Exception Handling**: try/catch para errores
- **State Checking**: isPlaying() para verificar estado


## Aspectos de Aprendizaje

### Conocimientos adquiridos:
1. **Multimedia en Android**: Fundamentos de reproducción de audio
2. **Gestión de recursos**: Carpetas especiales y archivos raw
3. **Estados de aplicación**: Lifecycle y gestión de memoria
4. **UI/UX básico**: Feedback al usuario y controles intuitivos

