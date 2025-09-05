abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${"%.2f".format(calcularArea())}")
        println("Perímetro: ${"%.2f".format(calcularPerimetro())}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea(): Double = lado * lado
    override fun calcularPerimetro(): Double = 4 * lado
}

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea(): Double = 3.14 * radio * radio
    override fun calcularPerimetro(): Double = 2 * Math.PI * radio
}

class Rectangulo(private val base: Double, private val altura: Double) : Shape() {
    override fun calcularArea(): Double = base * altura
    override fun calcularPerimetro(): Double = 2 * (base + altura)
}

fun ejecutarFiguras() {
    println("\n=== FIGURAS GEOMÉTRICAS ===")
    println("Seleccione la figura:")
    println("1. Cuadrado")
    println("2. Círculo")
    println("3. Rectángulo")
    print("Opción: ")
    fun ejecutarFiguras() {
    println("\n=== FIGURAS GEOMÉTRICAS ===")
    println("Seleccione la figura:")
    println("1. Cuadrado")
    println("2. Círculo")
    println("3. Rectángulo")
    print("Opción: ")

    val opcion = readln().toInt()

    when (opcion) {
        1 -> {
            val lado = obtenerDoubleDesdeConsola("Ingrese el lado del cuadrado: ")
            val cuadrado = Cuadrado(lado)
            println("\nResultados para el cuadrado:")
            cuadrado.imprimirResultados()
        }
        2 -> {
            val radio = obtenerDoubleDesdeConsola("Ingrese el radio del círculo: ")
            val circulo = Circulo(radio)
            println("\nResultados para el círculo:")
            circulo.imprimirResultados()
        }
        3 -> {
            val base = obtenerDoubleDesdeConsola("Ingrese la base del rectángulo: ")
            val altura = obtenerDoubleDesdeConsola("Ingrese la altura del rectángulo: ")
            val rectangulo = Rectangulo(base, altura)
            println("\nResultados para el rectángulo:")
            rectangulo.imprimirResultados()
        }
        else -> println("Opción no válida")
    }
}
