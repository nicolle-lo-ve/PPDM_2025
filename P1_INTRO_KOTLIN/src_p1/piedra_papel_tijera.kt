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
  
  // Mostrar elecciones
  println("\n ------ ELECCIONES ------ ")
  println("Computadora eligió: $eleccionComputadora")
  println("Tú elegiste:  $eleccionUsuario")

  // Determinar resultado
  val resultado = when {
      eleccionUsuario == eleccionComputadora ->
          "¡Empate!  Ambos eligieron $eleccionUsuario"

      (eleccionUsuario == "piedra" && eleccionComputadora == "tijera") ->
          "¡Ganaste!  Piedra rompe Tijera "

      (eleccionUsuario == "papel" && eleccionComputadora == "piedra") ->
          "¡Ganaste! Papel cubre Piedra "

      (eleccionUsuario == "tijera" && eleccionComputadora == "papel") ->
          "¡Ganaste!  Tijera corta Papel "

      else -> "¡Perdiste!  $eleccionComputadora gana a $eleccionUsuario"
  }

  // Mostrar resultado

  println("\n ------ RESULTADO ------")
  println(resultado)
  
}
