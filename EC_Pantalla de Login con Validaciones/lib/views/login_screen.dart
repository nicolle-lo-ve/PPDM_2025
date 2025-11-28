import 'package:flutter/material.dart';
import 'user_list_screen.dart';

// Pantalla de Login con validaciones avanzadas
// Se implementa como StatefulWidget porque maneja estado interno del formulario
class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  // Clave global para el formulario, permite validar todos los campos
  final _formKey = GlobalKey<FormState>();

  // Variables para almacenar los valores del formulario
  // Se llenan cuando se ejecuta save()
  String _email = '';
  String _password = '';

  // Variable para controlar la visibilidad de la contraseña
  bool _obscurePassword = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Fondo con gradiente para mejor apariencia
      body: Container(
        decoration: BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topCenter,
            end: Alignment.bottomCenter,
            colors: [
              Colors.indigo.shade400,
              Colors.indigo.shade800,
            ],
          ),
        ),
        child: SafeArea(
          child: Center(
            child: SingleChildScrollView(
              padding: const EdgeInsets.all(24.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  // Logo o icono de la aplicación
                  Container(
                    padding: const EdgeInsets.all(20),
                    decoration: BoxDecoration(
                      color: Colors.white,
                      shape: BoxShape.circle,
                      boxShadow: [
                        BoxShadow(
                          color: Colors.black.withOpacity(0.1),
                          blurRadius: 20,
                          offset: const Offset(0, 10),
                        ),
                      ],
                    ),
                    child: const Icon(
                      Icons.person,
                      size: 60,
                      color: Colors.indigo,
                    ),
                  ),
                  const SizedBox(height: 30),
                  
                  // Título
                  const Text(
                    'Bienvenido',
                    style: TextStyle(
                      fontSize: 32,
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                    ),
                  ),
                  const SizedBox(height: 8),
                  Text(
                    'Inicia sesión para continuar',
                    style: TextStyle(
                      fontSize: 16,
                      color: Colors.white.withOpacity(0.9),
                    ),
                  ),
                  const SizedBox(height: 40),
                  
                  // Tarjeta con el formulario
                  Card(
                    elevation: 8,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(16),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(24.0),
                      child: Form(
                        key: _formKey,
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.stretch,
                          children: [
                            // Campo de correo electrónico
                            TextFormField(
                              decoration: const InputDecoration(
                                labelText: 'Correo electrónico',
                                hintText: 'ejemplo@correo.com',
                                prefixIcon: Icon(Icons.email),
                              ),
                              keyboardType: TextInputType.emailAddress,
                              // Validación del correo
                              validator: (value) {
                                // Verifica que no esté vacío
                                if (value == null || value.isEmpty) {
                                  return 'El correo es obligatorio';
                                }
                                // Verifica que contenga @
                                if (!value.contains('@')) {
                                  return 'Debe ser un correo válido';
                                }
                                // Validación adicional de formato de email
                                final emailRegex = RegExp(
                                  r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$',
                                );
                                if (!emailRegex.hasMatch(value)) {
                                  return 'Formato de correo inválido';
                                }
                                return null; // Validación exitosa
                              },
                              // Guarda el valor cuando se llama a save()
                              onSaved: (value) => _email = value!,
                            ),
                            const SizedBox(height: 20),
                            
                            // Campo de contraseña
                            TextFormField(
                              obscureText: _obscurePassword,
                              decoration: InputDecoration(
                                labelText: 'Contraseña',
                                hintText: 'Ingrese su contraseña',
                                prefixIcon: const Icon(Icons.lock),
                                // Botón para mostrar/ocultar contraseña
                                suffixIcon: IconButton(
                                  icon: Icon(
                                    _obscurePassword
                                        ? Icons.visibility_off
                                        : Icons.visibility,
                                  ),
                                  onPressed: () {
                                    setState(() {
                                      _obscurePassword = !_obscurePassword;
                                    });
                                  },
                                ),
                              ),
                              // Validaciones de la contraseña
                              validator: (value) {
                                // Verifica que no esté vacía
                                if (value == null || value.isEmpty) {
                                  return 'La contraseña es obligatoria';
                                }
                                // Verifica longitud mínima
                                if (value.length < 6) {
                                  return 'Debe tener al menos 6 caracteres';
                                }
                                // ACTIVIDAD EXTRA 1: Validación de mayúscula
                                if (!value.contains(RegExp(r'[A-Z]'))) {
                                  return 'Debe contener al menos una mayúscula';
                                }
                                // ACTIVIDAD EXTRA 1: Validación de número
                                if (!value.contains(RegExp(r'[0-9]'))) {
                                  return 'Debe contener al menos un número';
                                }
                                return null; // Validación exitosa
                              },
                              // Guarda el valor cuando se llama a save()
                              onSaved: (value) => _password = value!,
                            ),
                            const SizedBox(height: 12),
                            
                            // ACTIVIDAD EXTRA 2: Enlace "¿Olvidaste tu contraseña?"
                            Align(
                              alignment: Alignment.centerRight,
                              child: TextButton(
                                onPressed: () {
                                  // Aquí iría la lógica de recuperación de contraseña
                                  ScaffoldMessenger.of(context).showSnackBar(
                                    const SnackBar(
                                      content: Text(
                                        'Función de recuperación de contraseña'
                                      ),
                                      duration: Duration(seconds: 2),
                                    ),
                                  );
                                },
                                child: const Text(
                                  '¿Olvidaste tu contraseña?',
                                  style: TextStyle(
                                    color: Colors.indigo,
                                    fontWeight: FontWeight.w600,
                                  ),
                                ),
                              ),
                            ),
                            const SizedBox(height: 24),
                            
                            // Botón de Ingresar
                            ElevatedButton(
                              onPressed: _login,
                              style: ElevatedButton.styleFrom(
                                backgroundColor: Colors.indigo,
                                foregroundColor: Colors.white,
                                padding: const EdgeInsets.symmetric(vertical: 16),
                                shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(8),
                                ),
                                elevation: 2,
                              ),
                              child: const Text(
                                'Ingresar',
                                style: TextStyle(
                                  fontSize: 16,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                            ),
                            const SizedBox(height: 16),
                            
                            // ACTIVIDAD EXTRA 2: Botón "Crear cuenta"
                            OutlinedButton(
                              onPressed: () {
                                // Aquí iría la navegación a la pantalla de registro
                                ScaffoldMessenger.of(context).showSnackBar(
                                  const SnackBar(
                                    content: Text(
                                      'Función de crear cuenta'
                                    ),
                                    duration: Duration(seconds: 2),
                                  ),
                                );
                              },
                              style: OutlinedButton.styleFrom(
                                foregroundColor: Colors.indigo,
                                side: const BorderSide(color: Colors.indigo, width: 2),
                                padding: const EdgeInsets.symmetric(vertical: 16),
                                shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(8),
                                ),
                              ),
                              child: const Text(
                                'Crear cuenta',
                                style: TextStyle(
                                  fontSize: 16,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }

  // Método para manejar el login
  void _login() {
    // Valida todos los campos del formulario
    if (_formKey.currentState!.validate()) {
      // Si todas las validaciones pasan, ejecuta onSaved de cada campo
      _formKey.currentState!.save();

      // Muestra mensaje de éxito
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text('Bienvenido, $_email'),
          backgroundColor: Colors.green,
          duration: const Duration(seconds: 2),
        ),
      );

      // ACTIVIDAD EXTRA 3: Navega a la lista de usuarios pasando el email
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(
          builder: (_) => UserListScreen(email: _email),
        ),
      );
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
