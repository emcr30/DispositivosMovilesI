package com.example.reproduccionmusica;

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.reproduccionmusica.R

class MusicPlayerActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        val audioName = intent.getStringExtra("AUDIO_NAME")
        val tvAudioName: TextView = findViewById(R.id.tv_audio_name)
        val ivAudioImage: ImageView = findViewById(R.id.iv_audio_image)
        val btnPlay: Button = findViewById(R.id.btn_play)
        val btnPause: Button = findViewById(R.id.btn_pause)

        // muestra el nombre del audio
        tvAudioName.text = audioName

        // carga una imagen asociada (por ejemplo, puedes poner una imagen por defecto)
        ivAudioImage.setImageResource(R.drawable.image1)

        // Selecciona el archivo de audio basado en el nombre
        val audioResId = when (audioName) {
            "...Ready for it?" -> R.raw.audio1
            "End Game" -> R.raw.audio2
            "I Did Something Bad" -> R.raw.audio3
            "Don't Blame Me" -> R.raw.audio4
            "Delicate" -> R.raw.audio5
            else -> R.raw.audio1
        }

        // inicializa el MediaPlayer con el audio seleccionado
        mediaPlayer = MediaPlayer.create(this, audioResId)

        // lógica para los botones de reproducción
        btnPlay.setOnClickListener {
            if (!isPlaying) {
                mediaPlayer.start()
                isPlaying = true
            }
        }

        btnPause.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.pause()
                isPlaying = false
            }
        }

        // botón volver
        val backButton: Button = findViewById(R.id.btn_back)

        backButton.setOnClickListener {
            finish() // botón volver
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()  // libera recursos
    }
}
