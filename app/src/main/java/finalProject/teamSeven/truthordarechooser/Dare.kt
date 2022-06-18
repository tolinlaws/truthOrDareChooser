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

class Dare : AppCompatActivity() {

    val question=arrayOf("背在場一位人繞場一周",
        "公主抱在場一位人直到下一輪真心話大冒險結束 ",
        "與在場一位人十指相扣，對視10秒",
        "邀請在場一位人為你唱情歌，或邀請在場一位人與你情歌對唱",
        "吃下每個人為你夾得菜",
        "親在場其中一人，部位不限",
        "神情的吻牆10秒",
        "模仿古代特殊職業女子拉客",
        "抓著鐵門喊“放我出去！”*5次",
        "撓癢癢一分鐘",
        "親指定的物品",
        "用屁股寫名字",
        "對外大喊我是豬",
        "和在場某位異性對視兩分鐘",
        "表演脫衣舞或者走貓步",
        "重複大哭大笑三次，每次5秒",
        "表演芭蕾舞，原地旋轉10圈" ,
        "右手跨過後腦勺從左邊摸右眼" ,
        "讓在場的每個人在TA的臉上用口紅寫一個字。",
        "扮演白痴",
        "扮演精神病患",
        "扮演Gay",
        "扮演毒蟲",
        "扮演假文青",
        "扮演小粉紅",
        "扮演總統",
        "扮演8+9",
        "扮演渣男",
        "扮演直男",
        "扮演綠茶",
        "模仿一位自己熟悉的明星、歌星的動作、歌聲或說話方式。",
        "模仿一位自己動物的動作、動作說話方式。",
        "唱《兩隻老虎》、《兩隻老虎》、《小星星》、《世上只有媽媽好》其中一首並表演相應的動作。",
        "說繞口令: 劉奶奶找牛奶奶買牛奶，牛奶奶給劉奶奶拿牛奶，劉奶奶說牛奶奶的牛奶不如柳奶奶的牛奶，牛奶奶說柳奶奶的牛奶會流奶，柳奶奶聽見了大罵牛奶奶你的才會流奶，柳奶奶和牛奶奶潑牛奶嚇壞了劉奶奶，大罵再也不買柳奶奶和牛奶奶的牛奶。",
        "跳肚皮舞",
        "跳鋼管舞",
        "選一個男生 一邊捶他的胸一邊說：你好討厭哦~",
        "躺在床上擺pose說:飯在鍋裡，我在床上",
        "念以下繞口令：季姬寂，集雞，雞即棘雞。棘雞飢嘰，季姬及箕稷濟雞。雞既濟，躋姬笈，季姬忌，急咭雞，雞急，繼圾幾，季姬急，即籍箕擊雞，箕疾擊幾伎，伎即齏，雞嘰集幾基，季姬急極屐擊雞，雞既殛，季姬激，即記《季姬擊雞記》。",
        "用捲紙纏頭纏成阿拉丁的模樣，一直到遊戲結束。",
        "蒙眼/閉眼 後隨機和在座一位握手，猜中對方身份即為過關，如失敗則聽對方指令做一件事。",
        "做一個大家都滿意的鬼臉",
        "蹲在凳子上作便秘狀",
        "對手機裡第一個異性當場打電話表白，開擴音",
        "雙手緊扣，深情朗誦駱賓王的《鵝》",
        "頭頂簸箕，手拿掃帚，邊跳邊唱道：我愛勞動，我愛衛生",
        "扭屁股，唱”洗刷刷，洗刷刷”",
        "站起來,大喊”我是超人,我要回家了！”",
        "把自己的LINE暱稱改成“我是笨蛋”24小時",
        "模仿狗叫，5聲以上",
        "在廁所裡吃泡麵拍照為證",
        "大喊 燃燒吧，小宇宙～",
        "學超級名模走秀，繞桌子或教室一圈",
        "對人多的地方發射動感光波",
        "模仿雞生蛋",
        "做自己最性感、最妩媚的表情或動作",
        "模仿章魚哥",
        "模仿海綿寶寶",
        "模仿抖音影片裡的人物動作",
        "公布line中與最上方的人聊天的最後一句話",
        "努力讓舌頭舔到手肘",
        "打電話給父母說我愛你",
        "劈腿拉筋",
        "模仿一隻缺水的魚",
        "模仿本土劇任意經典橋段",
        "模仿韓劇任意經典橋段",
        "公布google中最新的搜尋紀錄",
        "分享你最近看過的YT影片",
        "吐舌頭直到下輪結束",
        "脫下鞋子聞自己的腳",
        "模仿暴龍打籃球",
        "自己跟自己深情擁吻",
        "口含水唱歌",
        "扮演畸形種巨人跑步",
        "原地轉10圈後走一段路",
        "模仿頭痛、心痛、肚子痛、腳痛、手痛等五種姿勢",
        "做出M字腿",
        "在頭上綁一根沖天炮",
        "按IG首頁第一篇貼文讚",
        "選一個人拍照，將line的頭像換成他",
        "打電話給隨機一位高中同學"

    )

    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dare)
        //val submit_D: Button = findViewById(R.id.submit)
        //submit_D.setOnClickListener{show_question()}
        text=findViewById(R.id.result)
        val ret: Button = findViewById(R.id.return_back)
        ret.setOnClickListener{ finish()
            val intent = Intent()
            intent.setClass(this@Dare,
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
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action === KeyEvent.ACTION_DOWN) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}