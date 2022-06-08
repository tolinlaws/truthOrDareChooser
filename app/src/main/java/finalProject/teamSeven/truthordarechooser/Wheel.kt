package finalProject.teamSeven.truthordarechooser

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt
import kotlin.random.Random

class Wheel : AppCompatActivity() {
    lateinit var wheel: ImageView
    val delay: Long = 5000
    var lastClickTime: Long = 0
    var angle:Float = 0.0F
    lateinit var textview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheel)
        wheel=findViewById(R.id.wheel)
        wheel.setImageResource(R.drawable.wheel)
        wheel.setOnClickListener{
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
        val round = wheel.animate().rotationBy((F / R)+3600).setDuration(2500)
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
        val builder= AlertDialog.Builder(this@Wheel)
        Toast.makeText(this, "${angle}", LENGTH_LONG).show()
        var angleInt: Int = angle.roundToInt()
        //odd: truth, even:dare
        if (((angleInt%360)/45)%2  == 1){
            builder.setTitle("大冒險")
                //.setMessage("真心話 or 大冒險")
                //.setPositiveButton("真心話"){_, _ -> truth() }
                .setNegativeButton("大冒險"){_, _ -> dare() }
                .show()
        }
        else{
            builder.setTitle("真心話")
                //.setMessage("真心話 or 大冒險")
                //.setPositiveButton("真心話"){_, _ -> truth() }
                .setNegativeButton("真心話"){_, _ -> truth() }
                .show()
        }
    }
    fun truth(){
        val intent = Intent()
        /*傳遞angle到intent*/
        intent.putExtra("angle",angle)
        intent.setClass(this@Wheel,
            Truth::class.java)
        startActivity(intent)
    }
    fun dare(){
        val intent = Intent()
        /*傳遞angle到intent*/
        intent.putExtra("angle",angle)
        intent.setClass(this@Wheel,
            Dare::class.java)
        startActivity(intent)
    }
}