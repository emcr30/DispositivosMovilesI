// Interacción con imágenes y spinners
// Evelyn Milagros Chipana Ramos
// Creación: 15-09-2024
// Finalización: 15-09-2024

package com.example.interaccionimagenes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button

    // Recursos en drawable
    private val imageNames = listOf("Image 1", "Image 2", "Image 3")
    private val imageResources = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSpinner = findViewById(R.id.imageSpinner)
        nextButton = findViewById(R.id.nextButton)

        // Configurar el spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        imageSpinner.adapter = adapter

        // Restaurar spinner
        savedInstanceState?.let {
            val spinnerPosition = it.getInt("spinner_position")
            imageSpinner.setSelection(spinnerPosition)
        }

        nextButton.setOnClickListener {
            // Obtener la posición seleccionada
            val selectedIndex = imageSpinner.selectedItemPosition

            // Comenzar la segunda actividad
            val intent = Intent(this, ImageActivity::class.java).apply {
                putExtra("spinner_position", selectedIndex)
            }
            startActivity(intent)
        }
    }

    // Guardar el estado del spinner
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("spinner_position", imageSpinner.selectedItemPosition)
    }
}
