package finalProject.teamSeven.truthordarechooser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class Trust : AppCompatActivity() {
    val question=arrayOf("1、我在你眼裡什麼樣?",
        "2、認同沒有性的愛情麼。",
        "3、你做過最羞恥的一件事是?",
        "4、談過幾次戀愛?",
        "5、第一個喜歡的異性叫什麼名字?",
        "6、用一句話概括自己(20個字以內)",
        "7、你覺得自我最鬱悶的外號是什麼。",
        "8、哪位長輩曾經你給了你比較大的影響?具體說說。",
        "9、兄弟姐妹和男/女兄弟姐妹那個重要",
        "10、他/她們身上什麼特質吸引你?")
    lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trust)
        val submit_T:Button= findViewById(R.id.submit)
        submit_T.setOnClickListener{show_question()}
        text=findViewById(R.id.result)
        val ret:Button= findViewById(R.id.return_back)
        ret.setOnClickListener{finish()}
    }
    private fun show_question()
    {
        val C= Random.nextInt(1, 10)
        text.setText(question[C])
    }
}