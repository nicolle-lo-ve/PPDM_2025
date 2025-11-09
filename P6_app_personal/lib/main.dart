import 'package:flutter/material.dart';

import 'package:app_personal/screens/pantalla_inicio.dart';
import 'package:app_personal/screens/pantalla_perfil.dart';
import 'package:app_personal/screens/pantalla_hobbies.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: "/welcome",
      routes: {
        "/welcome": (_) => const PantallaInicio(),
        "/perfil": (_) => const PantallaPerfil(),
        "/hobbies": (_) => const PantallaHobbies(),
      },
      title: "Mi App Personal",
      // home: PantallaInicio(), //Cambiar por PantallaInicio(), PantallaPerfil() o PantallaHobbies() para probar
    );
  }
}
