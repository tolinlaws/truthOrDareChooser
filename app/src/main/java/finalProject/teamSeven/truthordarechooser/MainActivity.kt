package finalProject.teamSeven.truthordarechooser

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var bottle: ImageView
    lateinit var define: Button
    lateinit var goWheel: Button
    val delay: Long = 5000
    var lastClickTime: Long = 0
    var angle:Float = 0.0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottle=findViewById(R.id.bottle)
        define=findViewById(R.id.define)
        goWheel=findViewById(R.id.goWheel)
        goWheel.isVisible=false
        goWheel.setOnClickListener{
            wheel()
        }
        bottle.setImageResource(R.drawable.images)
        bottle.setOnClickListener{
            val currentTime = SystemClock.uptimeMillis()
            if (currentTime - lastClickTime >  delay) {
                if (!goWheel.isVisible) {
                    define.isClickable = false
                    lastClickTime = currentTime;
                    rotate()
                }
            }
        }
    }
    private fun rotate() {
            val R = Random.nextInt(1, 25)
            val F = Random.nextFloat() * 10000
            angle = F/R
            val round = bottle.animate().rotationBy((F / R)+3600).setDuration(2500)
                .setInterpolator(LinearInterpolator())
            round.start()

            var text: String
            object : CountDownTimer(3000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    text = "seconds remaining: " + millisUntilFinished / 1000
                }

                override fun onFinish() {
                    goWheel.isVisible=true
                    define.isClickable=true
                }
            }.start()
    }
    fun wheel(){
        val intent = Intent()
        /*傳遞angle到intent*/
        intent.putExtra("angle",angle)
        intent.setClass(this@MainActivity,
            Wheel::class.java)
        goWheel.isVisible=false
        startActivity(intent)
    }
}