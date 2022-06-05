package finalProject.teamSeven.truthordarechooser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class Dare : AppCompatActivity() {

    val question=arrayOf("背一位異性繞場一周",
            "抱一位異性直到下一輪真心話大冒險結束 （公主抱）",
            "與一位異性十指相扣，對視10秒",
            "邀請一位異性為你唱情歌，或邀請一位異性與你情歌對唱",
            "吃下每個人為你夾得菜（如果是辣椒……）",
            "親***（這個人可以事先指定），或者親一位異性，部位不限",
            "神情的吻牆10秒",
            "模仿古代特殊職業女子拉客",
            "模仿腦白金廣告，邊唱邊跳",
            "抓著鐵門喊“放我出去！”*5次")

    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dare)
        val submit_D: Button = findViewById(R.id.submit)
        submit_D.setOnClickListener{show_question()}
        text=findViewById(R.id.result)
        val ret: Button = findViewById(R.id.return_back)
        ret.setOnClickListener{finish()}
    }
    private fun show_question()
    {
        val C= Random.nextInt(1, 10)
        text.setText(question[C])
    }
}
