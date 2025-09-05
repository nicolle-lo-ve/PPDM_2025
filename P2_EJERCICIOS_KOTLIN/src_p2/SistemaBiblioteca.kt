abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
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

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosRegistrados = mutableListOf<Usuario>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
        prestamos[usuario] = mutableListOf()
    }

    override fun prestamo(material: Material, usuario: Usuario) {
        if (material in materialesDisponibles && usuario in usuariosRegistrados) {
            materialesDisponibles.remove(material)
            prestamos[usuario]?.add(material)
            println("Préstamo exitoso de '${material.titulo}' a ${usuario.nombre}")
        } else {
            println("Error en el préstamo")
        }
    }

    override fun devolucion(material: Material, usuario: Usuario) {
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


