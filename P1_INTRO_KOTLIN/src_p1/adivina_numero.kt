import kotlin.random.Random
fun ejercicioAdivinaNumero() {
println("\n ------ ADIVINA EL NÚMERO ------")
println(" Tienes 5 intentos para adivinar un número entre 1 y 30 ")

// Generar número aleatorio
val numeroAdivinar = Random.nextInt(1, 31)
var intentos = 5
var adivinado = false

// Ciclo de intentos
while (intentos > 0 && !adivinado) {
  println("Intentos restantes: $intentos ")
  print("Ingresa tu respuesta: ")
  val respuesta = readln().toInt()

  // Validar respuesta
  if (respuesta in 1<= ..<= 30) {
      println("Por favor, ingresa un número válido entre 1 y 30.")
      continue
  }
  
  intentos--
}


// Mostrar resultado final
println("\n ------ RESULTADO FINAL ------")
}
