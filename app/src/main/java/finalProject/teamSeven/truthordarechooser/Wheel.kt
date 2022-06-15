package finalProject.teamSeven.truthordarechooser

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.KeyEvent
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.math.roundToInt
import kotlin.random.Random
import kotlin.system.exitProcess

class Wheel : AppCompatActivity() {
    lateinit var wheel: ImageView
    lateinit var Truthbtn: Button
    lateinit var Darebtn: Button
    lateinit var mediaPlayer: MediaPlayer
    val delay: Long = 5000
    var lastClickTime: Long = 0
    var angle:Float = 0.0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheel)
        wheel=findViewById(R.id.wheel)
        Truthbtn=findViewById(R.id.Truth)
        Darebtn=findViewById(R.id.Dare)
        wheel.setImageResource(R.drawable.wheel)
        Truthbtn.isVisible=false
        Darebtn.isVisible= false
        Truthbtn.isEnabled=false
        Darebtn.isEnabled=false
        Truthbtn.setOnClickListener{truth()}
        Darebtn.setOnClickListener{dare()}
        Truthbtn.setOnClickListener{
            finish()
            truth()}
        Darebtn.setOnClickListener{
            finish()
            dare()}
        wheel.setOnClickListener{
            if(!Truthbtn.isVisible || !Darebtn.isVisible){
                val currentTime = SystemClock.uptimeMillis()
                wheel.isEnabled=false
                if (currentTime - lastClickTime >  delay) {
                    lastClickTime = currentTime
                    rotate()
                    mediaPlayer = MediaPlayer.create(this, R.raw.hahahahaha)
                    mediaPlayer.start()
                }
            }
        }
    }
    fun rotate() {
        val R = Random.nextInt(1, 25)
        val F = Random.nextFloat() * 10000
        angle = F/R
        val round = wheel.animate().rotationBy((F / R)+3600).setDuration(5400)
            .setInterpolator(LinearInterpolator())
        round.start()

        var text: String
        object : CountDownTimer(5900, 1000) {

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
        AlertDialog.Builder(this@Wheel)
        val angleInt: Int = angle.roundToInt()
        //odd: truth, even:dare
        if (((angleInt%360)/45)%2  == 1){
            Darebtn.isVisible=true
            Darebtn.isEnabled=true
        }
        else{
            Truthbtn.isVisible=true
            Truthbtn.isEnabled=true
        }
    }
    fun truth(){
        val intent = Intent()
        intent.setClass(this@Wheel,
            Truth::class.java)
        startActivity(intent)
    }
    fun dare(){
        val intent = Intent()
        intent.setClass(this@Wheel,
            Dare::class.java)
        startActivity(intent)
    }
    private var exitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action === KeyEvent.ACTION_DOWN) {
            val intent = Intent()
            mediaPlayer.release()
            intent.setClass(this@Wheel,
                MainActivity::class.java)
            startActivity(intent)
        }
        return super.onKeyDown(keyCode, event)
    }
}