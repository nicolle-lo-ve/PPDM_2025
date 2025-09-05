fun main() {
    var opcion: Int

    do {
        println("\n=== MENÚ PRINCIPAL ===")
        println("1. Cuenta Bancaria")
        println("2. Producto")
        println("3. Figuras Geométricas")
        println("4. Sistema de Biblioteca")
        println("5. Salir")
        print("Seleccione una opción: ")

        opcion = readln().toInt()

        when (opcion) {
            1 -> 
            2 -> 
            3 -> 
            4 -> 
            5 -> println("Saliendo del programa...")
            else -> println("Opción no válida. Intente nuevamente.")
        }
    } while (opcion != 5)
}
