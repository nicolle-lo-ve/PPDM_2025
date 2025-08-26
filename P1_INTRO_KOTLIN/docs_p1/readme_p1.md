# PRACTICA 1 INTRODUCCIÓN A KOTLIN
Esta carpeta contiene un programa interactivo en Kotlin que consta de 4 ejercicios prácticos con un menú de navegación unificado.

## Estructura del Proyecto
```
P1_INTRO_KOTLIN/
    ├── src_p1/
        ├── main.kt                  # Menú principal y punto de entrada
        ├── evaluacion_empleados.kt  
        ├── piedra_papel_tijera.kt   
        ├── calculadora_elemental.kt 
        └── adivina_numero.kt        
    └── docs_p1/
        └── readme_p1.md             #  Archivo descriptivo (Actual)
```

## Características

### 1. Evaluación de Empleados
- Calcula el nivel de rendimiento basado en puntuación (0-10)
- Determina bonificación económica según salario y desempeño
- Clasificación: Inaceptable (0-3), Aceptable (4-6), Meritorio (7-10)
- Validación de datos de entrada

### 2. Piedra, Papel o Tijera
- Juego clásico contra la computadora
- Elección aleatoria por la CPU
- Validación de entradas del usuario
- Determinación automática del ganador

### 3. Calculadora Elemental
- Operaciones básicas: suma, resta, multiplicación y división
- Menú interno con opciones numeradas
- Manejo de errores (división por cero)

### 4. Adivina el Número
- Número aleatorio entre 1 y 30
- 5 intentos para adivinar
- Pistas de "mayor" o "menor"

## Tecnologías Usadas
- **Kotlin** 1.9.0
- **Kotlin Random** para generación de números aleatorios
- **Readln()** para entrada de usuario
- **Control de flujo** con when, if-else, y loops

## Como usarlo
1. Ejecuta el programa desde la terminal
2. Selecciona una opción del menú principal (1-5)
3. Sigue las instrucciones específicas de cada ejercicio
4. Al finalizar cada ejercicio, volverás al menú principal
5. Selecciona la opción 5 para salir del programa

