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

  // Determinar nivel de rendimiento y calcular bonificación
  val nivel: String
  val bonificacion = salario * (puntuacion / 10.0)

  when (puntuacion) {
    in 0 <= .. <= 3 -> {
      nivel = "Inaceptable"
    }
    in 4 <= .. <= 6 -> {
      nivel = "Aceptable"
    }
    in 7 <= .. <= 10 -> {
      nivel = "Meritorio"
    }
    else -> {
      println ("Error: Puntuación fuera de rango)
      return
    }
  }
  
  // Mostrar resultados
  println(" ------ RESULTADOS DE EVALUACIÓN ------ ")
  println("Nivel de Rendimiento: $nivel")
  println("Cantidad de Dinero Recibido: $${bonificacion}")
  println("Salario Original: $${salario}")
  println("Puntuación Obtenida: $puntuacion/10")


}
