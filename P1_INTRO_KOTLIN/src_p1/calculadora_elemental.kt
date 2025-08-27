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

    if (opcion in 1<= ..<= 4) {
            realizarOperacion(operacion = opcion)
        } else if (opcion != 5) {
            println("Opción no válida. Intente nuevamente.")
        }

  } while (opcion != 5)
}

fun realizarOperacion(operacion: Int) {
  // Pedir números
  print("Ingrese el primer número: ")
  val num1 = readln().toDouble()
  print("Ingrese el segundo número: ")
  val num2 = readln().toDouble()

  // Variables para resultados
  val resultado: Double
  val simbolo: String

  // Operaciones 
  when (operacion) {
      1 -> {
          resultado = num1 + num2
          simbolo = "+"
      }
      2 -> {
          resultado = num1 - num2
          simbolo = "-"
      }
      3 -> {
          resultado = num1 * num2
          simbolo = "×"
      }
      4 -> {
          if (num2 == 0.0) {
              println("Error matemático: La división entre cero no está definida.")
              println("   Por favor, ingrese un divisor diferente de cero.")
              return
          }
          resultado = num1 / num2
          simbolo = "÷"
      }
      else -> return
  }
  // Mostrar resultado con formato
  println("\n ------ RESULTADO ------")
  println("$num1 $simbolo $num2 = $resultado")
}
