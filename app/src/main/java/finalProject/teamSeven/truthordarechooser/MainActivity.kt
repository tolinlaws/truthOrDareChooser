package finalProject.teamSeven.truthordarechooser

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var goBottle: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goBottle=findViewById(R.id.goBottle)
        goBottle.setOnClickListener{
            val intent = Intent(this@MainActivity, Bottle::class.java)
            startActivity(intent)
        }
        if (intent.getBooleanExtra("EXIT", false)) {
            finish();
        }
    }
    private var exitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action === KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 3000) {
                Toast.makeText(applicationContext, "再按一次退出此程式", Toast.LENGTH_SHORT).show()
                //Toast.makeText(applicationContext, "${activities.size}", Toast.LENGTH_SHORT).show()
                exitTime = System.currentTimeMillis()
            } else {
                finish()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}