package finalProject.teamSeven.truthordarechooser

import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread
import kotlin.concurrent.timer
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var bottle: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottle=findViewById(R.id.bottle)
        bottle.setImageResource(R.drawable.images)
        bottle.setOnClickListener{rotate()}
    }
    private fun rotate() {
        val R=Random.nextInt(1, 25)
        val F= Random.nextFloat()*10000
        bottle.animate().rotationBy(F/R).setDuration(2500).setInterpolator(LinearInterpolator()).start()

    }
}