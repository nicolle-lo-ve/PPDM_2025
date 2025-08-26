import kotlin.random.Random

fun ejercicioPiedraPapelTijera(){
  println ("\n ------ PIEDRA, PAPEL, TIJERA ------ ")

  // Opciones Disponibles
  val opciones = listOf("piedra", "papel", "tijera")

  // Elección aleatoria de la computadora
  val eleccionComputadora = opciones[Random.nextInt(from = 0, until = 3)]

  // Pedir elección al usuario
  println("Opciones Disponibles:")
  println(" - piedra ")
  println(" - papel ")
  println(" - tijera ")
  println("Por favor, elige una opción: ")
  val eleccionUsuario = readln().lowercase().trim()

  // Validar elección del usuario
  if (eleccionUsuario !in opciones) {
      println("Error: Elección no válida.")
      println("   Debe ser: piedra, papel o tijera")
      return
  }
}
