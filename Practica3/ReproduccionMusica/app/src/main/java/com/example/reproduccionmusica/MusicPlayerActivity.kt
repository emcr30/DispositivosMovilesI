import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
        val btnStop: Button = findViewById(R.id.btn_stop)

        // Muestra el nombre del audio
        tvAudioName.text = audioName

        // Carga una imagen asociada (por ejemplo, puedes poner una imagen por defecto)
        ivAudioImage.setImageResource(R.drawable.default_audio_image)

        // Selecciona el archivo de audio basado en el nombre
        val audioResId = when (audioName) {
            "Audio 1" -> R.raw.audio1
            "Audio 2" -> R.raw.audio2
            "Audio 3" -> R.raw.audio3
            "Audio 4" -> R.raw.audio4
            "Audio 5" -> R.raw.audio5
            else -> R.raw.audio1
        }

        // Inicializa el MediaPlayer con el audio seleccionado
        mediaPlayer = MediaPlayer.create(this, audioResId)

        // Lógica para los botones de reproducción
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

        btnStop.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.stop()
                isPlaying = false
                mediaPlayer = MediaPlayer.create(this, audioResId)  // Para reiniciar el MediaPlayer
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()  // Libera recursos
    }
}
