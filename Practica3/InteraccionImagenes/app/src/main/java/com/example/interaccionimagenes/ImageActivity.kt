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

        // posición seleccionada
        val selectedPosition = intent.getIntExtra("spinner_position", 0)

        //  when para seleccionar la imagen
        val imageResource = when (selectedPosition) {
            0 -> R.drawable.image1
            1 -> R.drawable.image2
            2 -> R.drawable.image3
            else -> R.drawable.image1
        }

        imageView.setImageResource(imageResource)

        backButton.setOnClickListener {
            // volver a la actividad anterior
            finish()
        }
    }
}
