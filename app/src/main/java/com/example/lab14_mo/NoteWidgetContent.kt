package com.example.lab14_mo

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.text.FontWeight

class NoteWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        // Asegúrate de usar GlanceTheme para aplicar el tema correctamente
        provideContent {
            GlanceTheme {
                MyContent()  // Llamada a la función Composable MyContent
            }
        }
    }

    // Función Composable para construir el contenido del widget
    @Composable
    fun MyContent() {
        Column(
            modifier = GlanceModifier.fillMaxSize()
                .background(GlanceTheme.colors.primary) // Fondo verde (ajustado a primary)
                .padding(16.dp), // Espaciado alrededor del widget
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título del widget con mayor estilo
            Text(
                text = "Notas recientes",
                style = TextStyle(
                    fontSize = 20.sp, // Mayor tamaño de fuente
                    color = GlanceTheme.colors.onPrimary, // Color del texto en base al fondo
                    fontWeight = FontWeight.Bold
                ),
                modifier = GlanceModifier.padding(bottom = 12.dp)
            )

            // Lista de notas (simulada) con iconos
            Column(modifier = GlanceModifier.padding(bottom = 12.dp)) {
                // Cada nota tiene un espaciado entre ellas y un ícono
                NoteItem("1. Realizar ejercicio 6 am")
                NoteItem("2. Desayunar a las 7 am")
                NoteItem("3. Almorzar a las 3 pm")
            }

            // Botón para añadir nueva nota con ícono
            Row(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = GlanceModifier.padding(top = 12.dp)
            ) {
                Button(
                    text = "Nueva Nota",
                    onClick = actionStartActivity<CreateNoteActivity>(),
                    modifier = GlanceModifier.padding(8.dp)
                )
            }
        }
    }

    // Componente reutilizable para mostrar una nota con íconos
    @Composable
    fun NoteItem(noteText: String) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = GlanceModifier.padding(bottom = 8.dp) // Espaciado entre las notas
        ) {
            // Agregar un icono al lado de cada nota
            Image(
                provider = ImageProvider(R.drawable.ic_note), // Reemplaza con tu ícono
                contentDescription = "Ícono de nota", // Descripción para accesibilidad
                modifier = GlanceModifier.padding(end = 3.dp) // Espaciado entre el ícono y el texto
            )
            Text(
                text = noteText,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = GlanceTheme.colors.onBackground
                )
            )
        }
    }
}
