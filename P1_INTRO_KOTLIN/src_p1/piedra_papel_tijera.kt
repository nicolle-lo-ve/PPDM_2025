import kotlin.random.Random

fun ejercicioPiedraPapelTijera(){
  println ("\n ------ PIEDRA, PAPEL, TIJERA ------ ")

  // Opciones Disponibles
  val opciones = listOf("piedra", "papel", "tijera")

  // Elección aleatoria de la computadora
  val eleccionComputadora = opciones[Random.nextInt(from = 0, until = 3)]
}
