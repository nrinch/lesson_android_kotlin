package na.severinchik.leeson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


const val COUNT: String = "count"
const val USER: String = "user"

class MenuActivity : AppCompatActivity() {

    val user = User("John", "Doe", 42)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun toActivityWithIntent(view: View) {

        // Intent с передаваемым параметром в виде экземпляра объекта
        Intent(this, WithIntentActivity::class.java).also {
            it.putExtra(USER, user)
            startActivity(it)
        }
        // Intent с передаваемым параметром в виде числа Intent
//        Intent(this, WithIntentActivity::class.java).also {
//            it.putExtra(COUNT, 42)
//            startActivity(it)
//        }

        // Intent с передаваемым параметром в виде строки
//        Intent(this, WithIntentActivity::class.java).also {
//            it.putExtra(NAME,"Jonh")
//            startActivity(it)
//        }
    }

    fun toActivityWithLifecycle(view: View) {
        startActivity(Intent(this, LifecycleActivity::class.java))
    }

    fun toActivityWithCalculator(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }

    companion object {
        const val NAME = "name"
    }
}

/**
 * Парсиализацию объекта, что позволит передавать данный объект в Intent
 **/
data class User(val name: String, val surname: String, val age: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(surname)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)

        }

        val DEFAULT = User(String.EMPTY, String.EMPTY, Int.Undefined)
    }
}

/**
 * При помощи аннотации @Parcelize данный класс будет поддерживать парсиализацию, что позволит передавать данный объект в Intent
 **/
@Parcelize
data class SuperUser(val name: String, val surname: String, val age: Int) : Parcelable {
    companion object {
        val DEFAULT = SuperUser(String.EMPTY, String.EMPTY, Int.Undefined)

    }
}

/**
 * При помощи аннотации @Serializable данный класс будет поддерживать корректную сериализацию, для корректной реализации данной сериализации необходимо подключить библиотеки в build.gradle lesson4 (строки помечены) и в build.gradle Project
 **/
@Serializable
data class Response(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String
)
