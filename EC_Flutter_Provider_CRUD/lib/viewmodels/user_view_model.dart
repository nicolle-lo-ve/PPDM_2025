import 'package:flutter/material.dart';
import 'models/user.dart';

// ViewModel que gestiona el estado y la lógica de negocio de los usuarios
// Extiende ChangeNotifier para notificar cambios a los widgets que lo escuchan
class UserViewModel extends ChangeNotifier {
  // Lista privada de usuarios para encapsular los datos
  final List<User> _usuarios = [];
  
  // Variable para controlar el filtro de usuarios activos
  bool _mostrarSoloActivos = false;

  // Getter público para acceder a los usuarios
  // Si el filtro está activo, retorna solo usuarios activos
  List<User> get usuarios {
    if (_mostrarSoloActivos) {
      return _usuarios.where((user) => user.activo).toList();
    }
    return _usuarios;
  }

  // Getter para el estado del filtro
  bool get mostrarSoloActivos => _mostrarSoloActivos;

  // Método para agregar un nuevo usuario a la lista
  // Notifica a los listeners después de la operación
  void agregarUsuario(User usuario) {
    _usuarios.add(usuario);
    notifyListeners(); // Dispara la actualización de la UI
  }

  // Método para editar un usuario existente en un índice específico
  // Reemplaza el usuario completo en la posición indicada
  void editarUsuario(int index, User usuario) {
    // Se valida que el índice esté dentro del rango válido
    if (index >= 0 && index < _usuarios.length) {
      _usuarios[index] = usuario;
      notifyListeners(); // Dispara la actualización de la UI
    }
  }

  // Método para eliminar un usuario por su índice
  // Utiliza removeAt para eliminar eficientemente
  void eliminarUsuario(int index) {
    if (index >= 0 && index < _usuarios.length) {
      _usuarios.removeAt(index);
      notifyListeners(); // Dispara la actualización de la UI
    }
  }

  // Método para alternar el filtro de usuarios activos
  // Permite mostrar todos los usuarios o solo los activos
  void toggleFiltroActivos() {
    _mostrarSoloActivos = !_mostrarSoloActivos;
    notifyListeners(); // Dispara la actualización de la UI
  }

  // Método para obtener el conteo total de usuarios sin filtrar
  int get totalUsuarios => _usuarios.length;

  // Método para obtener el conteo de usuarios activos
  int get totalUsuariosActivos => _usuarios.where((user) => user.activo).length;
}
