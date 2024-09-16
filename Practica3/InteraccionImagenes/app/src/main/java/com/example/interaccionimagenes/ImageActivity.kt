package com.example.interaccionimagenes

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityimage)

        imageView = findViewById(R.id.imageView)
        backButton = findViewById(R.id.backButton)

        // Obtener la posición seleccionada del Intent
        val selectedPosition = intent.getIntExtra("spinner_position", 0)

        // Usar el bloque when para seleccionar la imagen
        val imageResource = when (selectedPosition) {
            0 -> R.drawable.image1 // Asegúrate de tener image1.png en res/drawable
            1 -> R.drawable.image2 // Asegúrate de tener image2.png en res/drawable
            2 -> R.drawable.image3 // Asegúrate de tener image3.png en res/drawable
            else -> R.drawable.image1 // Default case
        }

        // Configurar la imagen en el ImageView
        imageView.setImageResource(imageResource)

        backButton.setOnClickListener {
            // Volver a la actividad anterior
            finish()
        }
    }
}
