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
