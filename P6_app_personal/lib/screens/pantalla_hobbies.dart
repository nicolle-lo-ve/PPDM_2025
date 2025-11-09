/*
* Descripción: Pantalla que muestra los hobbies e intereses del usuario
* Autor: Nicolle Lozano
* Fecha creación: 03/11/2025
* Fecha última modificación: 04/11/2025
*/

import 'package:flutter/material.dart';
import 'utils/app_colors.dart';
import 'utils/app_texts.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(AppTexts.tituloHobbies),
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
            // Título principal
            Container(
              width: double.infinity,
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                color: AppColors.cardColor,
                borderRadius: BorderRadius.circular(15),
              ),
              child: Column(
                children: [
                  Icon(
                    Icons.star,
                    color: AppColors.accentColor,
                    size: 40,
                  ),
                  const SizedBox(height: 10),
                  Text(
                    AppTexts.descripcionHobbies,
                    style: TextStyle(
                      fontSize: 18,
                      color: AppColors.textDark,
                      fontWeight: FontWeight.w500,
                    ),
                    textAlign: TextAlign.center,
                  ),
                ],
              ),
            ),
            const SizedBox(height: 30),

            // Lista de hobbies
            _buildHobbyCard(
              AppTexts.hobbyProgramacion,
              AppTexts.descripcionProgramacion,
              Icons.code,
              'https://pbs.twimg.com/media/EIW55xzXsAAxVRH.jpg',
            ),
            const SizedBox(height: 20),

            _buildHobbyCard(
              AppTexts.hobbyFotografia,
              AppTexts.descripcionFotografia,
              Icons.camera_alt,
              'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgMkBgHJUgWMT8s0XhFh-9xbCu1l6vQMX_0dFqUGzOYXbqSjNCyjygBvkcOFa9cx65rcYevOcSmLMhzC9_iHD4LAcSzsb-kMwbAZvXN8Sdlg-RQ1H4SRK1pV0uPIAeskMt9XREPIjwB6ME/s1600/Misti%252C+also+known+as+Putina+is+a+stratovolcano+located+in+Arequipa_baja.jpg',
            ),
            const SizedBox(height: 20),

            _buildHobbyCard(
              AppTexts.hobbyLectura,
              AppTexts.descripcionLectura,
              Icons.book,
              'https://cdn.pixabay.com/photo/2014/10/22/15/28/reading-498103_1280.jpg',
            ),
            const SizedBox(height: 20),

            _buildHobbyCard(
              AppTexts.hobbyMusica,
              AppTexts.descripcionMusica,
              Icons.music_note,
              'https://media.tenor.com/q0LOTp2lumIAAAAM/cat-listening-to-music.gif',
            ),
            const SizedBox(height: 20),

            _buildHobbyCard(
              AppTexts.hobbyDeportes,
              AppTexts.descripcionDeportes,
              Icons.sports_soccer,
              'https://media.istockphoto.com/id/612403968/es/foto/deporte-gato-va-a-hacer-ejercicio-con-peso.jpg?s=612x612&w=0&k=20&c=2YhGft_hxUXOl97eAVkBP7X7zrHrl2_lFHy3K-EOe_o=',
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildHobbyCard(String titulo, String descripcion, IconData icono, String imagenUrl) {
    return Container(
      width: double.infinity,
      decoration: BoxDecoration(
        color: AppColors.cardColor,
        borderRadius: BorderRadius.circular(15),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Imagen
          ClipRRect(
            borderRadius: const BorderRadius.only(
              topLeft: Radius.circular(15),
              topRight: Radius.circular(15),
            ),
            child: Image.network(
              imagenUrl,
              height: 150,
              width: double.infinity,
              fit: BoxFit.cover,
              errorBuilder: (context, error, stackTrace) {
                return Container(
                  height: 150,
                  color: AppColors.backgroundColor,
                  child: Icon(
                    icono,
                    size: 50,
                    color: AppColors.accentColor,
                  ),
                );
              },
            ),
          ),

          // Contenido
          Padding(
            padding: const EdgeInsets.all(15.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    Icon(
                      icono,
                      color: AppColors.accentColor,
                      size: 24,
                    ),
                    const SizedBox(width: 10),
                    Text(
                      titulo,
                      style: TextStyle(
                        fontSize: 20,
                        fontWeight: FontWeight.bold,
                        color: AppColors.textDark,
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 8),
                Text(
                  descripcion,
                  style: TextStyle(
                    fontSize: 14,
                    color: AppColors.textSecondary,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
