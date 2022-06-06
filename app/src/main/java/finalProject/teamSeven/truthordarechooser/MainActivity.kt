package finalProject.teamSeven.truthordarechooser

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var bottle: ImageView
    val delay: Long = 5000
    var lastClickTime: Long = 0
    var angle:Float = 0.0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottle=findViewById(R.id.bottle)
        bottle.setImageResource(R.drawable.images)
        bottle.setOnClickListener{
            val currentTime = SystemClock.uptimeMillis()
            if (currentTime - lastClickTime >  delay) {
                lastClickTime = currentTime;
                rotate()
            }
        }
    }
    private fun rotate() {
            val R = Random.nextInt(1, 25)
            val F = Random.nextFloat() * 10000
            angle = F/R
            val round = bottle.animate().rotationBy(F / R).setDuration(2500)
                .setInterpolator(LinearInterpolator())
            round.start()

            var text: String
            object : CountDownTimer(3000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    text = "seconds remaining: " + millisUntilFinished / 1000
                }

                override fun onFinish() {
                    stop_rotate()
                }
            }.start()
    }
    fun stop_rotate()
    {
        val builder=AlertDialog.Builder(this@MainActivity)
        builder.setTitle("測試測試")
            .setMessage("真心話 or 大冒險")
            .setPositiveButton("真心話"){_, _ -> truth() }
            .setNegativeButton("大冒險"){_, _ -> dare() }
            .show()
    }
    fun truth(){
        val intent = Intent()
        /*傳遞angle到intent*/
        intent.putExtra("angle",angle)
        intent.setClass(this@MainActivity,
            Truth::class.java)
        startActivity(intent)
    }
    fun dare(){
        val intent = Intent()
        /*傳遞angle到intent*/
        intent.putExtra("angle",angle)
        intent.setClass(this@MainActivity,
            Dare::class.java)
        startActivity(intent)
    }
}