fun ejercicioCalculadoraElemental() {
  var opcion: Int
  do {
    println("\n ------ CALCULADORA ELEMENTAL ------")
    println("1. Suma (+)")
    println("2. Resta (-)")
    println("3. Multiplicación (×)")
    println("4. División (÷)")
    println("5. Volver al menú principal")
    println("\n Seleccione una operación (1-5): ")

    opcion = readln().toInt()

  } while (opcion != 5)
}
