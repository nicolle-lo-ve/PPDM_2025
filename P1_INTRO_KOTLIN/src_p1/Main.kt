fun main() {
  var opcion: Int
  do {
    println("\n ------- MENÚ PRINCIPAL -------")
    println("1. EVALAUCIÓN DE EMPLEADOS")
    println("2. PIEDRA, PAPEL, TIJERA ")
    println("3. CALCULADORA ELEMENTAL")
    println("4. ADIVINA EL NÚMERO")
    println("5. SALIR")
    println("Seleccione una opción (1-5): ")

    opcion = readln().Int()

    when (opcion) {
      1 -> ejercicioEvaluacionEmpleados()
      2 -> ejercicioPiedraPapelTijera()
      5 -> println("¡Gracias por usar el programa!")
      else -> println("Opción en desarrollo...")
    }
  } while (opcion =! 5)
}
