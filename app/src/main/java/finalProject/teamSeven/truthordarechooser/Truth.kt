package finalProject.teamSeven.truthordarechooser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.system.exitProcess

class Truth : AppCompatActivity() {
    val question=arrayOf("我在你眼裡什麼樣?",
        "認同沒有性的愛情嗎?",
        "你做過最羞恥的一件事是?",
        "談過幾次戀愛?",
        "第一個喜歡的異性叫什麼名字?",
        "用一句話概括自己(20個字以內)",
        "令你最鬱悶的外號是什麼。",
        "哪位長輩曾經你給了你比較大的影響?具體說說。",
        "兄弟姐妹和男/女兄弟姐妹那個重要",
        "他/她們身上什麼特質吸引你?",
        "有沒有在某個場合聽某首歌突然飆淚?",
        "最喜歡在座哪位異性",
        "走錯過男女廁所嗎?",
        "對姐弟戀、同性戀和雙性戀等非傳統戀愛的看法?",
        "對你而言，感情和友情哪個比較重要?",
        "你如何看待愛情變成親情?",
        "多久換一次內褲。",
        "你親吻過多少人?",
        "你的小癖好是什麼。",
        "你認為養家的應該是女性還是男性?",
        "你現在喜歡誰?",
        "小貓和小狗更喜歡哪一個?",
        "最後一次發自內心的笑是什麼時候?",
        "如果你今天晚上就會死掉，而且無法與任何人聯絡，你最遺憾還沒有告訴別人什麼事?為什麼還沒說呢?",
        "妻子和媽掉到水裡，只能救一個，你救哪一個?",
        "堅持最久的習慣或愛好是?",
        "愛一個人怎樣表達，能夠得到芳心?",
        "在最愛的人面前做過最囧的事是什麼。",
        "你認為男人善變還是女人善變",
        "最長一次連續睡著了多久。",
        "如果突然獲得500萬(稅後)，會怎麼安排?",
        "內衣/褲顏色",
        "你此刻穿什麼牌子的內衣。",
        "你跟幾個異性上過床。",
        "你在乎別人看你的眼光嗎?",
        "你會不會在意另一半的過去，為什麼?",
        "第一次是和誰?",
        "情人節最想收到什麼禮物?",
        "你被打的最慘的一次是因為什麼?",
        "愛情事業和家庭，你怎麼排序?",
        "做過最浪漫的事?",
        "你覺得分手後還當朋友嗎?",
        "你最害怕什麼?",
        "如果你的高中同學在KTV坐檯，你恰巧碰到她了，你會?",
        "大學一共掛過幾門課?",
        "到目前為止你做過最瘋狂的事是?",
        "你認為沒有愛可以性嗎?",
        "和異性發生過最曖昧的事情。",
        "比較喜歡父親還是母親?",
        "你希望成名嗎?在哪一方面?",
        "心情特別煩躁的時候會有什麼習慣?",
        "在愛情和麵包著兩者之間，只能選擇一個，你選擇什麼?",
        "你和在座的一位異性都幹過戀人之間的什麼事。",
        "你最喜歡五官中的哪一個?",
        "你考過的最低分是多少?" ,
        "請說出在座誰昨天沒有洗澡" ,
        "假如可以選擇世界上任何人，你希望邀請誰共進晚餐?",
        "如果你另一半的前任死了，你另一半在你面前痛哭，你如何反應?",
        "有人撒你一身油，對你說：別擔心，有奧妙全自動，你怎麼辦?",
        "假如明天早上起床後能獲得任何一種能力或特質，你希望是什麼?",
        "你身上有沒有胎記?長在什麼地方，什麼形狀?",
        "說出室友最讓你受不了的習慣",
        "大學到現在共掛過幾門課?",
        "百事或可口，你選哪一個?",
        "另一半一口氣吃了50串羊肉串，你想說什麼",
        "說真的，你整過容嗎?",
        "喜歡什麼姿勢?",
        "最受不了別人對你說什麼?",
        "讓你一直念念不忘的一位異性的名字?為什麼?",
        "你最喜歡看哪部電影?是什麼題材?",
        "睡覺後一晚上要起來上幾次廁所?",
        "收到過最難忘的禮物是什麼。",
        "你屬於一見鍾情還是日久生情型?",
        "你最怕的事情或東西是什麼",
        "如果讓你選擇做一個電影中的角色，你會選誰呢?",
        "你最受不了別人對你做什麼。",
        "雙胞胎，哥哥叫天龍，弟弟叫啥好?",
        "和另一半一起去海灘，有位美麗(帥氣)的異性請你幫TA擦防晒，你會怎麼做?",
        "最想做的事情是?",
        "描述一下自己有哪些出乎意料的神操作?",
        "如果有一天，你生命中最貴重的東西離你而去了，你會怎麼辦?",
        "有一天和你吵架，你怎麼辦?",
        "你覺得自己的臉皮薄還是厚?",
        "你最想養的寵物是什麼?",
        "此刻你最喜歡的人是誰?",
        "每天睡覺前都會想起的人是誰",
        "去年讓你覺得最傷心的事情是什麼?",
        "自己做過最丟臉的事是什麼。",
        "最反感別人的什麼行為?",
        "身上哪個部位最敏感?",
        "突然有個人問你，你對處女座的人有什麼看法?",
        "正專注中一件事突然被打斷你會?",
        "你覺得一見鍾情三見傾情和日久生情，哪個更是你的風格?",
        "男(女)朋友和狗狗你選哪個?",
        "你最近一次做春夢是什麼樣子的。",
        "與喜歡的人見面，會穿成什麼樣?",
        "和你做兄弟姐妹，最起碼的標準是什麼?",
        "你覺得在做的人誰最性感",
        "你能接受約泡嗎",
        "假設你可以跟全世界的某一個人一夜情，你會選誰")
    lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_truth)
        //val submit_T:Button= findViewById(R.id.submit)
        //submit_T.setOnClickListener{show_question()}

        text=findViewById(R.id.result)
        val ret:Button= findViewById(R.id.return_back)
        ret.setOnClickListener{
            finish()
            val intent = Intent()
            intent.setClass(this@Truth,
                Bottle::class.java)
            startActivity(intent)
        }
        show_question()
    }
    private fun show_question()
    {
        val C= Random.nextInt(1, question.size-1)
        text.setText(question[C])
    }
    private var exitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
        return super.onKeyDown(keyCode, event)
    }
}