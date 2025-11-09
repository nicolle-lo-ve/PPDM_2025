// Descripción: Practica de BottomNavigationBar
// Autor: Nicolle Lozano
// Fecha creación: 07/11/2025
// Última modificación: 08/11/2025

import 'package:flutter/material.dart';
import 'editar_perfil_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'App con BottomNavigationBar',
      theme: ThemeData(primarySwatch: Colors.indigo),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;
  String _nombreUsuario = 'Invitado';

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  // Lista de pantallas
  late final List<Widget> _pages = [
    const Center(
      child: Text('Bienvenido al Inicio', style: TextStyle(fontSize: 22)),
    ),
    const Center(
      child: Text('Lista de Usuarios', style: TextStyle(fontSize: 22)),
    ),
    const Center(
      child: Text('Configuración de la App', style: TextStyle(fontSize: 22)),
    ),
    _perfilTab(),
  ];

  Widget _perfilTab() {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            _nombreUsuario,
            style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 20),
          ElevatedButton(
            onPressed: () async {
              // Navegamos a la pantalla "Editar Perfil"
              final nombre = await Navigator.push(
                context,
                MaterialPageRoute(
                    builder: (context) => const EditarPerfilScreen()),
              );
              // Si el usuario guardó un nombre, actualizamos el estado
              if (nombre != null && nombre.toString().trim().isNotEmpty) {
                setState(() {
                  _nombreUsuario = nombre;
                });
              }
            },
            child: const Text('Editar perfil'),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('App con BottomNavigationBar'),
      ),
      body: _pages[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
        type: BottomNavigationBarType.fixed,
        selectedItemColor: Colors.indigo,
        unselectedItemColor: Colors.grey,
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Inicio'),
          BottomNavigationBarItem(icon: Icon(Icons.people), label: 'Usuarios'),
          BottomNavigationBarItem(icon: Icon(Icons.settings), label: 'Config'),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: 'Perfil'),
        ],
      ),
    );
  }
}
