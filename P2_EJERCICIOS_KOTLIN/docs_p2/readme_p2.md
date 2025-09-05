# Sistema de Gestión - Práctica 2: Programación Orientada a Objetos en Kotlin

## Descripción General
Este proyecto contiene la implementación de cuatro ejercicios de programación orientada a objetos en Kotlin, desarrollados como parte de la Práctica 2 de la asignatura "Programación para Dispositivos Móviles". Cada ejercicio demuestra diferentes conceptos de POO como encapsulamiento, herencia, polimorfismo, clases abstractas e interfaces.

## Estructura del Proyecto
```
P2_EJERCICIOS_KOTLIN/
└── src_p2/
    ├── CuentaBancaria.kt
    ├── Producto.kt
    ├── Figuras.kt
    ├── SistemaBiblioteca.kt
    └── Main.kt
```

## Ejercicios Implementados

### 1. Cuenta Bancaria (`CuentaBancaria.kt`)
**Descripción:** Implementación de una clase que simula una cuenta bancaria con funcionalidades de depósito, retiro y gestión de límites.

**Características:**
- Validación de saldo no negativo
- Control de límites de retiro
- Interfaz de consola para operaciones bancarias

### 2. Gestión de Productos (`Producto.kt`)
**Descripción:** Sistema para calcular precios finales de productos aplicando descuentos.

**Características:**
- Validación de precios y porcentajes de descuento
- Cálculo automático del precio final
- Interfaz simple para entrada de datos

### 3. Figuras Geométricas (`Figuras.kt`)
**Descripción:** Sistema para calcular área y perímetro de diferentes figuras geométricas.

**Características:**
- Clase abstracta `Shape` con métodos abstractos
- Implementaciones concretas para cuadrado, círculo y rectángulo
- Formateo de resultados con dos decimales

### 4. Sistema de Biblioteca (`SistemaBiblioteca.kt`)
**Descripción:** Sistema completo de gestión de biblioteca con préstamos y devoluciones.

**Características:**
- Clase abstracta `Material` con subclases `Libro` y `Revista`
- Data class `Usuario` para gestión de usuarios
- Interfaz `IBiblioteca` con implementación completa
- Sistema de menús para todas las operaciones

### 5. Programa Principal (`Main.kt`)
**Descripción:** Menú principal que permite acceder a todos los sistemas implementados.

**Características:**
- Interfaz unificada para todos los ejercicios
- Validación de opciones de menú
- Navegación entre diferentes sistemas

## Uso del Sistema
Al ejecutar el programa, se presentará un menú principal con las siguientes opciones:
1. Cuenta Bancaria: Permite gestionar una cuenta con depósitos y retiros controlados
2. Producto: Calcula el precio final de productos aplicando descuentos
3. Figuras Geométricas: Calcula área y perímetro de figuras geométricas
4. Sistema de Biblioteca: Gestiona préstamos y devoluciones de materiales bibliográficos
5. Salir: Finaliza la ejecución del programa

## Características de Implementación
- Validación de entradas de usuario
- Manejo de errores
- Código documentado con comentarios precisos
- Implementación de principios POO
- Separación de responsabilidades entre clases

## Autor
Lozano Vega, Nicolle 

## Fechas
- Creación: 04/09/2025
- Última modificación: 04/09/2025
