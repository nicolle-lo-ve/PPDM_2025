import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'viewmodels/user_view_model.dart';
import 'views/login_screen.dart';

// Punto de entrada de la aplicación
void main() {
  runApp(
    // ChangeNotifierProvider envuelve toda la aplicación
    // Esto permite que cualquier widget descendiente acceda al UserViewModel
    ChangeNotifierProvider(
      create: (_) => UserViewModel(), // Crea la instancia del ViewModel
      child: const MyApp(),
    ),
  );
}

// Widget raíz de la aplicación
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // Configuración general de la aplicación
      title: 'Login y Gestión de Usuarios',
      debugShowCheckedModeBanner: false, // Oculta el banner de debug
      
      // Tema personalizado de la aplicación
      theme: ThemeData(
        // Color primario de la aplicación
        primarySwatch: Colors.indigo,
        
        // Configuración del AppBar
        appBarTheme: const AppBarTheme(
          elevation: 2,
          centerTitle: true,
          backgroundColor: Colors.indigo,
          foregroundColor: Colors.white,
        ),
        
        // Configuración de los botones flotantes
        floatingActionButtonTheme: const FloatingActionButtonThemeData(
          backgroundColor: Colors.indigo,
          foregroundColor: Colors.white,
        ),
        
        // Configuración de las tarjetas
        cardTheme: CardTheme(
          elevation: 2,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(12),
          ),
        ),
        
        // Configuración de los campos de texto
        inputDecorationTheme: InputDecorationTheme(
          border: OutlineInputBorder(
            borderRadius: BorderRadius.circular(8),
          ),
          filled: true,
          fillColor: Colors.grey[50],
        ),
        
        // Configuración de los botones elevados
        elevatedButtonTheme: ElevatedButtonThemeData(
          style: ElevatedButton.styleFrom(
            padding: const EdgeInsets.symmetric(vertical: 16),
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(8),
            ),
          ),
        ),
      ),
      
      // Pantalla inicial de la aplicación (Login)
      home: const LoginScreen(),
    );
  }
}
