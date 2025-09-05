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
