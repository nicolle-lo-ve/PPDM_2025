/* Calcular el nivel de rendimiento y bonificación basado en la puntuacion de los empleados. */
fun ejercicioEvaluacionEmpleados(){
  print ("\n ------ EVALUACIÓN DE EMPLEADOS ------ ")

  // Pedir salario
  print("Ingrese el salario mensual del empleado: ")
  val salario = readln().toDouble()

  // Pedir Puntuación
  print("Ingrese la puntuación del empleado del 0 al 10: ")
  val puntuacion = readln().toInt()

  // Validar entradas 
  if (salario <= 0 || puntuacion < 0 || puntuacion > 10) {
    println("Error: Datos ingresados no válidos")
    println("  - Salario debe ser un numero positivo")
    println("  - Puntuación debe estar entre 0 - 10")
    return
    }

  

}
