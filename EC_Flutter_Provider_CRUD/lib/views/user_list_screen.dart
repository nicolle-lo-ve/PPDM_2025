import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'viewmodels/user_view_model.dart';
import 'models/user.dart';
import 'user_form_screen.dart';

// Pantalla principal que muestra la lista de usuarios
// Se implementa como StatelessWidget ya que el estado se maneja con Provider
class UserListScreen extends StatelessWidget {
  const UserListScreen({super.key});

  @override
  Widget build(BuildContext context) {
    // context.watch escucha los cambios del ViewModel
    // Cuando se llama a notifyListeners(), este widget se reconstruye
    final viewModel = context.watch<UserViewModel>();

    return Scaffold(
      // Barra superior de la aplicación
      appBar: AppBar(
        title: const Text('Lista de Usuarios'),
        actions: [
          // Botón para activar/desactivar filtro de usuarios activos
          IconButton(
            icon: Icon(
              viewModel.mostrarSoloActivos 
                ? Icons.filter_alt 
                : Icons.filter_alt_outlined,
            ),
            tooltip: viewModel.mostrarSoloActivos 
              ? 'Mostrar todos' 
              : 'Solo activos',
            onPressed: () {
              viewModel.toggleFiltroActivos();
            },
          ),
          // Indicador del número total de usuarios
          Padding(
            padding: const EdgeInsets.only(right: 16.0),
            child: Center(
              child: Text(
                '${viewModel.usuarios.length}/${viewModel.totalUsuarios}',
                style: const TextStyle(fontSize: 16),
              ),
            ),
          ),
        ],
      ),
      
      // Cuerpo principal con la lista de usuarios
      body: viewModel.usuarios.isEmpty
          ? _buildEmptyState() // Muestra estado vacío si no hay usuarios
          : _buildUserList(context, viewModel), // Muestra la lista de usuarios
      
      // Botón flotante para agregar nuevos usuarios
      floatingActionButton: FloatingActionButton(
        onPressed: () => _navigateToAddUser(context, viewModel),
        tooltip: 'Agregar Usuario',
        child: const Icon(Icons.add),
      ),
    );
  }

  // Widget para mostrar cuando no hay usuarios en la lista
  Widget _buildEmptyState() {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(
            Icons.people_outline,
            size: 100,
            color: Colors.grey[400],
          ),
          const SizedBox(height: 16),
          Text(
            'No hay usuarios registrados',
            style: TextStyle(
              fontSize: 18,
              color: Colors.grey[600],
              fontWeight: FontWeight.w500,
            ),
          ),
          const SizedBox(height: 8),
          Text(
            'Presiona el botón + para agregar uno',
            style: TextStyle(
              fontSize: 14,
              color: Colors.grey[500],
            ),
          ),
        ],
      ),
    );
  }

  // Construye la lista de usuarios usando ListView.builder
  // Este widget es eficiente porque solo construye los elementos visibles
  Widget _buildUserList(BuildContext context, UserViewModel viewModel) {
    return ListView.builder(
      padding: const EdgeInsets.all(8),
      itemCount: viewModel.usuarios.length,
      itemBuilder: (context, index) {
        final user = viewModel.usuarios[index];
        
        return Card(
          margin: const EdgeInsets.symmetric(vertical: 4, horizontal: 8),
          child: ListTile(
            // Avatar con inicial del nombre
            leading: CircleAvatar(
              backgroundColor: user.activo ? Colors.green : Colors.grey,
              child: Text(
                user.nombre.isNotEmpty ? user.nombre[0].toUpperCase() : '?',
                style: const TextStyle(
                  color: Colors.white,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
            
            // Título con el nombre del usuario
            title: Text(
              user.nombre,
              style: const TextStyle(fontWeight: FontWeight.bold),
            ),
            
            // Subtítulo con información adicional
            subtitle: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const SizedBox(height: 4),
                Text('${user.genero} • ${user.edad} años'),
                Text(
                  user.email,
                  style: TextStyle(
                    fontSize: 12,
                    color: Colors.grey[600],
                  ),
                ),
              ],
            ),
            
            // Indicador de estado (activo/inactivo)
            trailing: Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                // Chip de estado
                Container(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 8,
                    vertical: 4,
                  ),
                  decoration: BoxDecoration(
                    color: user.activo ? Colors.green[100] : Colors.grey[300],
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Text(
                    user.activo ? 'Activo' : 'Inactivo',
                    style: TextStyle(
                      fontSize: 12,
                      color: user.activo ? Colors.green[900] : Colors.grey[700],
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ),
                const SizedBox(width: 8),
                
                // Botón de editar
                IconButton(
                  icon: const Icon(Icons.edit, color: Colors.blue),
                  tooltip: 'Editar usuario',
                  onPressed: () => _navigateToEditUser(context, viewModel, user, index),
                ),
                
                // Botón de eliminar
                IconButton(
                  icon: const Icon(Icons.delete, color: Colors.red),
                  tooltip: 'Eliminar usuario',
                  onPressed: () => _confirmDelete(context, viewModel, index, user.nombre),
                ),
              ],
            ),
            isThreeLine: true,
          ),
        );
      },
    );
  }

  // Navega a la pantalla de agregar usuario
  Future<void> _navigateToAddUser(BuildContext context, UserViewModel viewModel) async {
    final nuevoUsuario = await Navigator.push<User>(
      context,
      MaterialPageRoute(
        builder: (_) => const UserFormScreen(),
      ),
    );
    
    // Si se retorna un usuario, lo agrega a la lista
    if (nuevoUsuario != null) {
      viewModel.agregarUsuario(nuevoUsuario);
      
      // Muestra un mensaje de confirmación
      if (context.mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('Usuario agregado exitosamente'),
            backgroundColor: Colors.green,
            duration: Duration(seconds: 2),
          ),
        );
      }
    }
  }

  // Navega a la pantalla de editar usuario
  Future<void> _navigateToEditUser(
    BuildContext context,
    UserViewModel viewModel,
    User user,
    int index,
  ) async {
    final usuarioActualizado = await Navigator.push<User>(
      context,
      MaterialPageRoute(
        builder: (_) => UserFormScreen(
          usuario: user,
          indice: index,
        ),
      ),
    );
    
    // Si se retorna un usuario actualizado, lo guarda
    if (usuarioActualizado != null) {
      viewModel.editarUsuario(index, usuarioActualizado);
      
      // Muestra un mensaje de confirmación
      if (context.mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('Usuario actualizado exitosamente'),
            backgroundColor: Colors.blue,
            duration: Duration(seconds: 2),
          ),
        );
      }
    }
  }

  // Muestra un diálogo de confirmación antes de eliminar
  Future<void> _confirmDelete(
    BuildContext context,
    UserViewModel viewModel,
    int index,
    String nombre,
  ) async {
    final confirmar = await showDialog<bool>(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Confirmar eliminación'),
        content: Text('¿Estás seguro de eliminar a $nombre?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context, false),
            child: const Text('Cancelar'),
          ),
          TextButton(
            onPressed: () => Navigator.pop(context, true),
            style: TextButton.styleFrom(foregroundColor: Colors.red),
            child: const Text('Eliminar'),
          ),
        ],
      ),
    );

    // Si el usuario confirma, elimina el usuario
    if (confirmar == true) {
      viewModel.eliminarUsuario(index);
      
      if (context.mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text('Usuario $nombre eliminado'),
            backgroundColor: Colors.red,
            duration: const Duration(seconds: 2),
          ),
        );
      }
    }
  }
}
