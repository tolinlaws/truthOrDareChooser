package finalProject.teamSeven.truthordarechooser

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class Define : AppCompatActivity(){
    lateinit var Truth1: EditText
    lateinit var Truth2: EditText
    lateinit var Truth3: EditText
    lateinit var Truth4: EditText
    lateinit var Truth5: EditText
    lateinit var Dare1: EditText
    lateinit var Dare2: EditText
    lateinit var Dare3: EditText
    lateinit var Dare4: EditText
    lateinit var Dare5: EditText
    lateinit var ADD: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_define)
        Truth1=findViewById(R.id.Truth1)
        Truth2=findViewById(R.id.Truth2)
        Truth3=findViewById(R.id.Truth3)
        Truth4=findViewById(R.id.Truth4)
        Truth5=findViewById(R.id.Truth5)
        Dare1=findViewById(R.id.Dare1)
        Dare2=findViewById(R.id.Dare2)
        Dare3=findViewById(R.id.Dare3)
        Dare4=findViewById(R.id.Dare4)
        Dare5=findViewById(R.id.Dare5)
        ADD=findViewById(R.id.ADD)
        ADD.setOnClickListener{

        }

    }
    private var exitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action === KeyEvent.ACTION_DOWN) {
            val intent = Intent()
            intent.setClass(this@Define,
                MainActivity::class.java)
            startActivity(intent)
        }
        return super.onKeyDown(keyCode, event)
    }
}