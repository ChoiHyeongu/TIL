package Inflearn

import java.util.*

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)

    println("Describe 값")
    var whenVar = describe("Hello")
    println(whenVar)
    println("------------------------------------------------")
    val x = sc.nextLine()
    if(x.toInt() in 1..10)
        println("Fits in range")
    else
        println("Not within range")

    println("------------------------------------------------")

    for(i in 1..5){
        print(i)
    }
    println()
    println("------------------------------------------------")

    val listof = listOf("Apple", "Banana", "Kiwi")
    for (item in listof)
        println(item)

    println("------------------------------------------------")

    val setof = setOf("Apple", "Banana", "Kiwi")
    when{
        "Orange" in setof -> println("Juicy")
        "Apple" in setof -> println("Apple is fine too")
    }
    println("------------------------------------------------")

    val fruits = listOf("apple","abocado", "banana", "kiwi", "orange")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach {println(it)}

    println("------------------------------------------------")
    printProduct("3", "4")
    println("------------------------------------------------")
}

fun describe(obj:Any): String =
        when (obj){
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a String"
            else -> "Unknown"
        }

fun parseInt(str: String): Int? {
    return str.toInt()
}

fun printProduct(arg1: String, arg2: String){
    val x: Int? = parseInt(arg1)
    val y: Int? = parseInt(arg2)

    if (x != null && y != null){
        println(x * y)
    } else {
        println("Either $arg1 or $arg2 is not a number")
    }
}