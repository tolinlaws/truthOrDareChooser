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
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.random.Random
import kotlin.system.exitProcess

class Bottle : AppCompatActivity() {
    lateinit var bottle: ImageView
    lateinit var define: Button
    lateinit var goWheel: Button
    lateinit var mediaPlayer: MediaPlayer
    val delay: Long = 5000
    var lastClickTime: Long = 0
    var angle:Float = 0.0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottle)
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
                    lastClickTime = currentTime
                    rotate()
                    mediaPlayer = MediaPlayer.create(this, R.raw.yee)
                    mediaPlayer.start()
                }
            }
        }
        if (intent.getBooleanExtra("EXIT", false)) {
            finish();
        }
    }
    private fun rotate() {
        val R = Random.nextInt(1, 25)
        val F = Random.nextFloat() * 10000
        angle = F/R
        val round = bottle.animate().rotationBy((F / R)+3600).setDuration(6500)
            .setInterpolator(LinearInterpolator())
        round.start()

        var text: String
        object : CountDownTimer(6500, 1000) {

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
        intent.setClass(this@Bottle,
            Wheel::class.java)
        goWheel.isVisible=false
        startActivity(intent)
    }
    private var exitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action === KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 3000) {
                Toast.makeText(applicationContext, "再按一次退出此程式", Toast.LENGTH_SHORT).show()
                //Toast.makeText(applicationContext, "${activities.size}", Toast.LENGTH_SHORT).show()
                exitTime = System.currentTimeMillis()
            } else {
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent.putExtra("EXIT", true)
                startActivity(intent)
                //finish()
                //ActivityFinishAll()
                exitProcess(0)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}