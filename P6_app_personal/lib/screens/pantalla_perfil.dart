/*
* Descripción: Pantalla de perfil personal del usuario
* Autor: Nicolle Lozano
* Fecha creación: 03/11/2025
* Fecha última modificación: 04/11/2025
*/

import 'package:flutter/material.dart';
import 'package:app_personal/utils/app_colors.dart';
import 'package:app_personal/utils/app_texts.dart';

class PantallaPerfil extends StatefulWidget {

  const PantallaPerfil({super.key});

  @override
  State<StatefulWidget> createState() => _PantallaPerfil();
}

class _PantallaPerfil extends State<PantallaPerfil> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(AppTexts.tituloPerfil),
        backgroundColor: AppColors.primaryColor,
        foregroundColor: AppColors.textLight,
        centerTitle: true,
        elevation: 2,
      ),
      backgroundColor: AppColors.backgroundColor,
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          children: [
            // Imagen de perfil
            Container(
              padding: const EdgeInsets.all(5),
              decoration: BoxDecoration(
                shape: BoxShape.circle,
                border: Border.all(
                  color: AppColors.primaryColor,
                  width: 3,
                ),
              ),
              child: CircleAvatar(
                radius: 80,
                backgroundImage: NetworkImage(
                  'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWB7f6fu5UVWmZ3NDAnnk6U-yMZ0QCHH-NHA&s',
                ),
              ),
            ),
            const SizedBox(height: 20),

            // Información personal
            Container(
              width: double.infinity,
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                color: AppColors.cardColor,
                borderRadius: BorderRadius.circular(15),
              ),
              child: Column(
                children: [
                  Text(
                    AppTexts.nombreCompleto,
                    style: TextStyle(
                      fontSize: 28,
                      fontWeight: FontWeight.bold,
                      color: AppColors.textDark,
                    ),
                  ),
                  const SizedBox(height: 10),
                  Text(
                    AppTexts.descripcionPersonal,
                    style: TextStyle(
                      fontSize: 16,
                      color: AppColors.textSecondary,
                    ),
                    textAlign: TextAlign.center,
                  ),
                ],
              ),
            ),
            const SizedBox(height: 20),

            // Información de contacto
            Container(
              width: double.infinity,
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                color: AppColors.cardColor,
                borderRadius: BorderRadius.circular(15),
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    'Información de Contacto',
                    style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                      color: AppColors.textDark,
                    ),
                  ),
                  const SizedBox(height: 15),

                  // Email
                  Row(
                    children: [
                      Icon(
                        Icons.email,
                        color: AppColors.accentColor,
                        size: 24,
                      ),
                      const SizedBox(width: 15),
                      Expanded(
                        child: Text(
                          AppTexts.email,
                          style: TextStyle(
                            fontSize: 16,
                            color: AppColors.textSecondary,
                          ),
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 15),

                  // Teléfono
                  Row(
                    children: [
                      Icon(
                        Icons.phone,
                        color: AppColors.accentColor,
                        size: 24,
                      ),
                      const SizedBox(width: 15),
                      Expanded(
                        child: Text(
                          AppTexts.telefono,
                          style: TextStyle(
                            fontSize: 16,
                            color: AppColors.textSecondary,
                          ),
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 15),

                  // Ubicación
                  Row(
                    children: [
                      Icon(
                        Icons.location_on,
                        color: AppColors.accentColor,
                        size: 24,
                      ),
                      const SizedBox(width: 15),
                      Expanded(
                        child: Text(
                          AppTexts.ubicacion,
                          style: TextStyle(
                            fontSize: 16,
                            color: AppColors.textSecondary,
                          ),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
