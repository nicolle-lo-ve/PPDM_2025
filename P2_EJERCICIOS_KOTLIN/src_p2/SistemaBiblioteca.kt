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
