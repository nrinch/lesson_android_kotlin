package na.severinchik.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
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

val arrayList = arrayListOf<Int>(32,5,646,3)

fun whenExample() {



    when (whenVariable) {
        42 -> println(whenVariable)
        42, 69, 666 -> println(whenVariable)
        in 1..42 -> println(whenVariable)
        in arrayList -> println()
        else -> println()
    }

}


val range:IntRange = var2..whenVariable



open class Person(var name:String){
    constructor(name:String, age:Int):this(name)
    {

    val birthdayYear = 2021 - age
    }
}

class SuperPerson(name:String,surname:String):Person(name){}



