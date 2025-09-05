abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${"%.2f".format(calcularArea())}")
        println("Perímetro: ${"%.2f".format(calcularPerimetro())}")
    }
}
