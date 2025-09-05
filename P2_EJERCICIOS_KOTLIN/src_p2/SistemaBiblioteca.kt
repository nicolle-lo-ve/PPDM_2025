// Clase abstracta que representa material bibliográfico
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles() // Método abstracto para mostrar detalles específicos
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("""
            Libro: $titulo
            Autor: $autor
            Año: $anioPublicacion
            Género: $genero
            Páginas: $numeroPaginas
        """.trimIndent())
    }
}

class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("""
            Revista: $titulo
            ISSN: $issn
            Volumen: $volumen
            Número: $numero
            Editorial: $editorial
        """.trimIndent())
    }
}

data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
)

// Interfaz que define las operaciones básicas de una biblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(material: Material, usuario: Usuario)
    fun devolucion(material: Material, usuario: Usuario)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservados(usuario: Usuario)
    fun obtenerUsuario(nombre: String, apellido: String): Usuario?
    fun obtenerMaterialDisponible(titulo: String): Material?
    fun obtenerMaterialPrestado(usuario: Usuario, titulo: String): Material?
}

// Implementación concreta del sistema de biblioteca
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosRegistrados = mutableListOf<Usuario>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
        prestamos[usuario] = mutableListOf() // Inicializa lista vacía para sus préstamos
    }

    override fun prestamo(material: Material, usuario: Usuario) {
         // Verifica que el material esté disponible y el usuario esté registrado
        if (material in materialesDisponibles && usuario in usuariosRegistrados) {
            materialesDisponibles.remove(material)
            prestamos[usuario]?.add(material)
            println("Préstamo exitoso de '${material.titulo}' a ${usuario.nombre}")
        } else {
            println("Error en el préstamo")
        }
    }

    override fun devolucion(material: Material, usuario: Usuario) {
         // Intenta remover el material de los préstamos del usuario
        if (prestamos[usuario]?.remove(material) == true) {
            materialesDisponibles.add(material)
            println("Devolución exitosa de '${material.titulo}'")
        } else {
            println("Error en la devolución")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("\nMateriales disponibles:")
        materialesDisponibles.forEach { println("- ${it.titulo}") }
    }

    override fun mostrarMaterialesReservados(usuario: Usuario) {
        println("\nMateriales reservados por ${usuario.nombre}:")
        prestamos[usuario]?.forEach { println("- ${it.titulo}") }
    }

    override fun obtenerUsuario(nombre: String, apellido: String): Usuario? {
        return usuariosRegistrados.firstOrNull { it.nombre == nombre && it.apellido == apellido }
    }

    override fun obtenerMaterialDisponible(titulo: String): Material? {
        return materialesDisponibles.firstOrNull { it.titulo == titulo }
    }

    override fun obtenerMaterialPrestado(usuario: Usuario, titulo: String): Material? {
        return prestamos[usuario]?.firstOrNull { it.titulo == titulo }
    }
}

fun obtenerDatosUsuario(): Usuario {
    print("Ingrese nombre: ")
    val nombre = readln()
    print("Ingrese apellido: ")
    val apellido = readln()
    print("Ingrese edad: ")
    val edad = readln().toIntOrNull() ?: 0

    return Usuario(nombre, apellido, edad)
}

fun obtenerMaterialPrestado(biblioteca: IBiblioteca, usuario: Usuario): Material? {
    biblioteca.mostrarMaterialesReservados(usuario)
    print("Ingrese el título del material: ")
    val titulo = readln()
    return biblioteca.obtenerMaterialPrestado(usuario, titulo)
}

fun obtenerMaterialDisponible(biblioteca: IBiblioteca): Material? {
    biblioteca.mostrarMaterialesDisponibles()
    print("Ingrese el título del material: ")
    val titulo = readln()
    return biblioteca.obtenerMaterialDisponible(titulo)
}

fun obtenerUsuario(biblioteca: IBiblioteca): Usuario? {
    print("Ingrese el nombre del usuario: ")
    val nombre = readln()
    print("Ingrese el apellido del usuario: ")
    val apellido = readln()
    return biblioteca.obtenerUsuario(nombre, apellido)
}


fun ejecutarBiblioteca() {
    println("\n=== SISTEMA DE BIBLIOTECA ===")
    val biblioteca = Biblioteca()

    // Registrar algunos materiales de ejemplo
    val libro1 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico", 417)
    val revista1 = Revista("National Geographic", "Varios autores", 2023, "ISSN-1234", 45, 6, "National Geographic Society")

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)

    var opcion: Int
    do {
        println("\n--- Menú Biblioteca ---")
        println("1. Registrar usuario")
        println("2. Mostrar materiales disponibles")
        println("3. Realizar préstamo")
        println("4. Realizar devolución")
        println("5. Mostrar materiales prestados")
        println("6. Volver al menú principal")
        print("Seleccione una opción: ")

        opcion = readln().toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                val usuario = obtenerDatosUsuario()
                biblioteca.registrarUsuario(usuario)
                println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
            }
            2 -> biblioteca.mostrarMaterialesDisponibles()
            3 -> {
                val usuario = obtenerUsuario(biblioteca)
                if (usuario != null) {
                    val material = obtenerMaterialDisponible(biblioteca)
                    if (material != null) {
                        biblioteca.prestamo(material, usuario)
                    } else {
                        println("Material no encontrado")
                    }
                } else {
                    println("Usuario no encontrado")
                }
            }
            4 -> {
                val usuario = obtenerUsuario(biblioteca)
                if (usuario != null) {
                    val material = obtenerMaterialPrestado(biblioteca, usuario)
                    if (material != null) {
                        biblioteca.devolucion(material, usuario)
                    } else {
                        println("Material no encontrado")
                    }
                } else {
                    println("Usuario no encontrado")
                }
            }
            5 -> {
                val usuario = obtenerUsuario(biblioteca)
                if (usuario != null) {
                    biblioteca.mostrarMaterialesReservados(usuario)
                } else {
                    println("Usuario no encontrado")
                }
            }
            6 -> println("Volviendo al menú principal...")
            else -> println("Opción no válida")
        }
    } while (opcion != 6) // Repite hasta que se seleccione salir
}
