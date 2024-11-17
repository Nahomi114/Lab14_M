package com.example.lab14_mo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class CreateNoteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateNoteView()
        }
    }
}

@Composable
fun CreateNoteView() {
    Text(text = "Pantalla para crear una nueva nota.")
}
