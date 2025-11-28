// Modelo de datos para representar un usuario en la aplicación
// Contiene todos los atributos necesarios para la gestión de usuarios
class User {
  String nombre;
  String genero; // 'Masculino' o 'Femenino'
  bool activo;
  int edad; // Campo adicional para la edad del usuario
  String email; // Campo adicional para el correo electrónico

  // Constructor con parámetros requeridos
  // Se usa 'required' para garantizar que todos los campos sean inicializados
  User({
    required this.nombre,
    required this.genero,
    required this.activo,
    required this.edad,
    required this.email,
  });

  // Método para crear una copia del usuario con campos modificables
  // Útil para operaciones de edición sin mutar el objeto original
  User copyWith({
    String? nombre,
    String? genero,
    bool? activo,
    int? edad,
    String? email,
  }) {
    return User(
      nombre: nombre ?? this.nombre,
      genero: genero ?? this.genero,
      activo: activo ?? this.activo,
      edad: edad ?? this.edad,
      email: email ?? this.email,
    );
  }
}
