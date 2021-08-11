package na.severinchik.lesson2

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    val appContext by lazy { Application().baseContext }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Person(name = "jOHN").name
    }
}

val valTypeInt: Int = 42
var varTypeInt: Int = 42

val doubleType = varTypeInt.toDouble()

val i = 0

val array = Array(5, { i -> (i * i).toString() })
//array = 0 1*1 2*2 3*3 4*4
//array = 0 1 4 9 16

fun lambda(arg: Any): Any {
    val argInt: Int = arg as Int
    return (argInt * argInt).toString()
}

var var1: Int? = 0
var var2: Int = 2

val resultSum = var1?.times(2)

val whenVariable: Int = 42

val arrayList = arrayListOf<Int>(32, 5, 646, 3)

fun whenExample() {


    when (whenVariable) {
        42 -> println(whenVariable)
        42, 69, 666 -> println(whenVariable)
        in 1..42 -> println(whenVariable)
        in arrayList -> println()
        else -> println()
    }

}


val range: IntRange = var2..whenVariable


open class Person(var name: String) {
    constructor(name: String, age: Int) : this(name) {

        val birthdayYear = 2021 - age
    }
}

class SuperPerson(name: String, surname: String) : Person(name) {}

open class Rectangle() {
    open fun draw() {
        print("")
    }

    open val borderColor = ""
}

class FilledRectangle : Rectangle() {
    val filler = Filler()

    override fun draw() {
        filler.drawAndFill()
    }

    override val borderColor: String get() = "black"


    inner class Filler {
        fun fill() { /* ... */
        }

        fun drawAndFill() {
            super@FilledRectangle.draw()
            fill()
            println("Нарисованный прямоугольник заполнен ${super@FilledRectangle.borderColor} цветом.")
        }
    }
}

fun main() {
    val filler = FilledRectangle().Filler()
    filler.drawAndFill()
}

interface Shape {

    fun drawBorder()
    fun drawBody()
    fun fill()

    fun draw() {
        drawBody()
        drawBorder()
        fill()
    }

    fun dontdothis() = Application().baseContext
}


abstract class Abstractia {
    open val count = 3

    abstract fun doMagic()

    fun superMagic() {
        //TODO
        doMagic()
    }
}


class User {

    private var _isOnline = false

    val isOnline
        get() = false

    var a = Int


    var name: String = ""
        get() = Application().baseContext.toString()
        set(value) {
            field = value
        }

    init {
        name = ""


    }
}


fun Int.returnNull(): Int? = null

//fun main() {
//    var counter: Int? = null
//
//    counter = 0
//    counter++
//    counter = counter.returnNull()
//
//    var result = (5).sqrt()
//    result.sqrtResult
//
//
//    val i = counter.ifNotNull()
//
//    var su = SuperUser("","")
//    var su2 = su.copy(name = "1")
//}

private fun Int.sqrt(): Int = this * this



fun Any?.ifNotNull(): Any {
    if (this != null) {
        return this!!
    } else {
        return throw NullPointerException()
    }

}

val Int.sqrtResult: Int
    get() = this * this

val String.Companion.EMPTY
    get() = ""

val String.Companion.SPACE
    get() = " "


data class SuperUser(val name:String,val surname: String)

sealed class APIResponseState{
    object Loading: APIResponseState()
    data class Loaded(val message: String):APIResponseState()
    data class Error(val messageError: String):APIResponseState()
}



fun requestSuccess():APIResponseState = APIResponseState.Loaded("Johny")

//fun main() {
//   val result = requestSuccess()
//
//    when(result){
//        is APIResponseState.Error -> println("Error ${result.messageError}")
//        is APIResponseState.Loaded -> println("")
//        APIResponseState.Loading -> TODO()
//        A -> TODO()
//    }
//}