class Producto {
    private var precio: Double = 0.0
    private var descuento: Double = 0.0

    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) {
            precio = nuevoPrecio
        } else {
            println("Error: El precio no puede ser negativo")
        }
    }

    fun getPrecio(): Double = precio
}
