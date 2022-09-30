package com.gl4.tp

fun main(argv : Array<String> ){
    //print("Hello")
    //var message: String ? = "My message can possibly be null !"
    //message?.uppercase()
    /*var hello:String = "Hello"
    hello = "Hello world!"

    println("$hello")

    var toto:String = "Toto"

    println(toto)

    var message: String? = "I’m learning Kotlin!"
    message = null
    println(message.toString())

    fun somme(a:Int, b:Int):Int{
        return a+b
    }
    fun sayMyName(name:String) { println(" $name ") }
    fun sayHello()="Hello"
    println(sayHello())*/

    val listOfRectangle = listOf(Rectangle(),
        Rectangle(q=Point(2,2)), Rectangle
            (p= Point(2,5)),Rectangle(p= Point(4,1),q=Point(2,0))
    )

    //test toString() fun
    for(i in listOfRectangle.indices) {
        println(listOfRectangle[i])
    }

    //test surface() fun
    for(i in listOfRectangle.indices) {
        println(listOfRectangle[i].surface())
    }
}