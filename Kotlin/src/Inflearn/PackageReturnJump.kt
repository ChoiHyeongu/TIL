package Inflearn

import PackageTest.callA
import PackageTest.*

fun main(args: Array<String>) {
    callA()
    callB()
    callC()
    println("------------------------------------------------")

    loop@ for (i in 1..10) {
        println("--- i: $i ---")

        for (j in 1..10) {
            println("j: $j")
            if (i + j > 12) {
                println("i+j: ${i + j}")
                break@loop
            }
        }
    }
    println("------------------------------------------------")

    loop@ for (i in 1..10) {
        println("--- i: $i ---")
        for (j in 1..10) {
            if (j < 2) {
                continue@loop
            }
            println("j: $j")
        }
    }
    println("------------------------------------------------")

    labelReturn1()
    println("------------------------------------------------")
    labelReturn2()
    println("------------------------------------------------")
    labelReturn3()
    println("------------------------------------------------")
    println(labelRetrun4())
    println("------------------------------------------------")
}

fun labelReturn1() {
    var ints = listOf(0, 1, 2, 3)

    ints.forEach(fun(value: Int) {
        if (value == 1) return
        println(value)
    })
    println("End")
}
fun labelReturn2() {
    var ints = listOf(0, 1, 2, 3)

    ints.forEach label@{
        if (it == 1) return@label
        println(it)
    }
    println("End")
}
fun labelReturn3() {
    var ints = listOf(0, 1, 2, 3)

    ints.forEach {
        if (it == 1) return@forEach
        println(it)
    }
    println("End")
}
fun labelRetrun4(): List<String> {
    var ints = listOf(0, 1, 2, 3)
    val result = ints.map{
        if(it == 0) {return@map "Zero"}
        "number $it"
    }
    return result
}