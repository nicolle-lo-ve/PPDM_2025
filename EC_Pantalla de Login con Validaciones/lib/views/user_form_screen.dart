import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'models/user.dart';

// Pantalla de formulario para agregar o editar usuarios
// Se implementa como StatefulWidget porque maneja estado interno del formulario
class UserFormScreen extends StatefulWidget {
  final User? usuario; // Usuario a editar (null si es uno nuevo)
  final int? indice; // Índice del usuario en la lista (null si es nuevo)

  const UserFormScreen({super.key, this.usuario, this.indice});

  @override
  State<UserFormScreen> createState() => _UserFormScreenState();
}

class _UserFormScreenState extends State<UserFormScreen> {
  // Clave global para el formulario, permite validar todos los campos
  final _formKey = GlobalKey<FormState>();
  
  // Controladores para los campos de texto
  // Permiten obtener y establecer el valor de los TextFormField
  final _nombreController = TextEditingController();
  final _edadController = TextEditingController();
  final _emailController = TextEditingController();
  
  // Variables de estado para los otros campos
  String _genero = 'Masculino'; // Valor por defecto del género
  bool _activo = true; // Valor por defecto del estado activo

  @override
  void initState() {
    super.initState();
    // Si se recibe un usuario, se inicializan los campos con sus valores
    if (widget.usuario != null) {
      _nombreController.text = widget.usuario!.nombre;
      _edadController.text = widget.usuario!.edad.toString();
      _emailController.text = widget.usuario!.email;
      _genero = widget.usuario!.genero;
      _activo = widget.usuario!.activo;
    }
  }

  @override
  void dispose() {
    // Es importante liberar los recursos de los controladores
    _nombreController.dispose();
    _edadController.dispose();
    _emailController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    // Determina si estamos editando o agregando un usuario
    final isEditing = widget.usuario != null;

    return Scaffold(
      appBar: AppBar(
        title: Text(isEditing ? 'Editar Usuario' : 'Agregar Usuario'),
        // Botón de cerrar en la barra de aplicación
        leading: IconButton(
          icon: const Icon(Icons.close),
          onPressed: () => Navigator.pop(context),
        ),
      ),
      
      body: SingleChildScrollView(
        // Permite hacer scroll si el teclado cubre el formulario
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              // Sección de información personal
              _buildSectionTitle('Información Personal'),
              const SizedBox(height: 16),
              
              // Campo de nombre
              TextFormField(
                controller: _nombreController,
                decoration: const InputDecoration(
                  labelText: 'Nombre completo',
                  hintText: 'Ingrese el nombre',
                  prefixIcon: Icon(Icons.person),
                ),
                textCapitalization: TextCapitalization.words,
                validator: (value) {
                  // Validación: el nombre no puede estar vacío
                  if (value == null || value.trim().isEmpty) {
                    return 'Por favor ingrese un nombre';
                  }
                  // Validación: el nombre debe tener al menos 3 caracteres
                  if (value.trim().length < 3) {
                    return 'El nombre debe tener al menos 3 caracteres';
                  }
                  return null; // Validación exitosa
                },
              ),
              const SizedBox(height: 16),
              
              // Campo de edad
              TextFormField(
                controller: _edadController,
                decoration: const InputDecoration(
                  labelText: 'Edad',
                  hintText: 'Ingrese la edad',
                  prefixIcon: Icon(Icons.cake),
                  suffixText: 'años',
                ),
                keyboardType: TextInputType.number,
                // Solo permite ingresar números
                inputFormatters: [
                  FilteringTextInputFormatter.digitsOnly,
                ],
                validator: (value) {
                  // Validación: la edad no puede estar vacía
                  if (value == null || value.isEmpty) {
                    return 'Por favor ingrese la edad';
                  }
                  final edad = int.tryParse(value);
                  // Validación: debe ser un número válido
                  if (edad == null) {
                    return 'Ingrese una edad válida';
                  }
                  // Validación: la edad debe estar en un rango realista
                  if (edad <= 0 || edad > 120) {
                    return 'La edad debe estar entre 1 y 120 años';
                  }
                  return null; // Validación exitosa
                },
              ),
              const SizedBox(height: 16),
              
              // Campo de correo electrónico
              TextFormField(
                controller: _emailController,
                decoration: const InputDecoration(
                  labelText: 'Correo electrónico',
                  hintText: 'ejemplo@correo.com',
                  prefixIcon: Icon(Icons.email),
                ),
                keyboardType: TextInputType.emailAddress,
                validator: (value) {
                  // Validación: el correo no puede estar vacío
                  if (value == null || value.trim().isEmpty) {
                    return 'Por favor ingrese un correo electrónico';
                  }
                  // Validación: formato de correo electrónico
                  // Expresión regular para validar el formato
                  final emailRegex = RegExp(
                    r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$',
                  );
                  if (!emailRegex.hasMatch(value.trim())) {
                    return 'Ingrese un correo electrónico válido';
                  }
                  return null; // Validación exitosa
                },
              ),
              const SizedBox(height: 24),
              
              // Sección de género
              _buildSectionTitle('Género'),
              const SizedBox(height: 8),
              
              // Botones de radio para seleccionar el género
              Row(
                children: [
                  Expanded(
                    child: RadioListTile<String>(
                      title: const Text('Masculino'),
                      value: 'Masculino',
                      groupValue: _genero,
                      onChanged: (value) {
                        setState(() {
                          _genero = value!;
                        });
                      },
                      contentPadding: EdgeInsets.zero,
                      dense: true,
                    ),
                  ),
                  Expanded(
                    child: RadioListTile<String>(
                      title: const Text('Femenino'),
                      value: 'Femenino',
                      groupValue: _genero,
                      onChanged: (value) {
                        setState(() {
                          _genero = value!;
                        });
                      },
                      contentPadding: EdgeInsets.zero,
                      dense: true,
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 16),
              
              // Switch para activar/desactivar el usuario
              SwitchListTile(
                title: const Text('Usuario activo'),
                subtitle: Text(
                  _activo 
                    ? 'El usuario puede acceder al sistema' 
                    : 'El usuario no puede acceder al sistema',
                ),
                value: _activo,
                onChanged: (value) {
                  setState(() {
                    _activo = value;
                  });
                },
                // Icono que cambia según el estado
                secondary: Icon(
                  _activo ? Icons.check_circle : Icons.cancel,
                  color: _activo ? Colors.green : Colors.grey,
                ),
              ),
              const SizedBox(height: 32),
              
              // Botones de acción
              Row(
                children: [
                  // Botón de cancelar
                  Expanded(
                    child: OutlinedButton(
                      onPressed: () => Navigator.pop(context),
                      style: OutlinedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 16),
                      ),
                      child: const Text('Cancelar'),
                    ),
                  ),
                  const SizedBox(width: 16),
                  // Botón de guardar
                  Expanded(
                    child: ElevatedButton(
                      onPressed: _guardarUsuario,
                      style: ElevatedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 16),
                      ),
                      child: Text(
                        isEditing ? 'Actualizar' : 'Guardar',
                        style: const TextStyle(fontSize: 16),
                      ),
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  // Widget helper para crear títulos de sección
  Widget _buildSectionTitle(String title) {
    return Text(
      title,
      style: const TextStyle(
        fontSize: 18,
        fontWeight: FontWeight.bold,
        color: Colors.indigo,
      ),
    );
  }

  // Método para guardar o actualizar el usuario
  void _guardarUsuario() {
    // Valida todos los campos del formulario
    if (_formKey.currentState!.validate()) {
      // Si todas las validaciones pasan, crea el objeto User
      final user = User(
        nombre: _nombreController.text.trim(),
        genero: _genero,
        activo: _activo,
        edad: int.parse(_edadController.text),
        email: _emailController.text.trim(),
      );
      
      // Retorna el usuario a la pantalla anterior
      Navigator.pop(context, user);
    } else {
      // Si hay errores de validación, muestra un mensaje
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('Por favor corrija los errores en el formulario'),
          backgroundColor: Colors.red,
          duration: Duration(seconds: 2),
        ),
      );
    }
  }
}



