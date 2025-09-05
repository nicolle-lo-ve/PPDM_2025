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

    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) {
            descuento = nuevoDescuento
        } else {
            println("Error: El descuento debe estar entre 0 y 100")
        }
    }

    fun getDescuento(): Double = descuento

    fun calcularPrecioFinal(): Double {
        return precio * (1 - descuento / 100)
    }
}

fun ejecutarProducto() {
    println("\n=== PRODUCTO ===")
    val producto = Producto()

    print("Ingrese el precio del producto: ")
    val precio = readln().toDouble()
    producto.setPrecio(precio)

    print("Ingrese el descuento (%): ")
    val descuento = readln().toDouble()
    producto.setDescuento(descuento)

    println("Precio original: ${producto.getPrecio()}")
    println("Descuento aplicado: ${producto.getDescuento()}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")
}
