package finalProject.teamSeven.truthordarechooser;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Decide : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                System.exit(0)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
