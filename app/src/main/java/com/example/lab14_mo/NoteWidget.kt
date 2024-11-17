package com.example.lab14_mo

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

// Renombramos la clase a NoteWidget
class NoteWidget : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = NoteWidgetContent()
}
