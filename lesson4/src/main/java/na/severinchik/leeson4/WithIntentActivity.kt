package na.severinchik.leeson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WithIntentActivity : AppCompatActivity() {

    var count: Int = 0
    var name: String = ""
    //получение аргумента из Intent при помощи lazy свойства
    val user: User by lazy { intent.getParcelableExtra(USER) ?: User.DEFAULT }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_intent)

        //получение аргумента из Intent и отображение его в Log'aх
        intent.getStringExtra(MenuActivity.NAME).also {
            println("-->> getStringExtra: $it")
        }
        //получение аргумента из Intent с Элвис оператором(?:) он позволит в случае если аргумент не выдан поставить значение по умолчанию
        name = intent.getStringExtra(MenuActivity.NAME) ?: ""
        //получение аргумента из Intent с Элвис с значением по умолчанию
        count = intent.getIntExtra(COUNT, 0)


    }
}


val String.Companion.EMPTY
    get() = ""
val Int.Companion.Undefined
    get() = -1