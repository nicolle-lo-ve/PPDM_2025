/* Calcular el nivel de rendimiento y bonificación basado en la puntuacion de los empleados. */
fun ejercicioEvaluacionEmpleados(){
  print ("\n ------ EVALUACIÓN DE EMPLEADOS ------ ")

  // Pedir salario
  
  print("Ingrese el salario mensual del empleado: ")
  val salario = readln()

  if (salario == null || salario <= 0) {
    println("Error: Salario ingresado no válido.")
    return
    }

  println("Salario válido: $$salario")

}
