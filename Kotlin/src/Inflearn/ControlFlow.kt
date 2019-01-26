package Inflearn

fun main(args: Array<String>) {
    var a = 3
    var b = 2

    val max = if (a > b) a else b
    val max2 = if (a > b) {
        println("Choos a")
        a
    } else {
        println("Choos b")
        b
    }
    println("max : $max, max2 : $max2")
    println("------------------------------------------------")

    var x = 4
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        3, 4 -> println("x == 3 == 4")
        else -> println("x is neither 1 nor 2")
    }
    println("------------------------------------------------")

    val y = 3
    when (y) {
        parseInt("3") -> println("s encodes x")
        1 + 2 -> println("3")
        else -> println("s does not encdoe x")
    }
    println("------------------------------------------------")

    val validNumber = listOf(3, 6, 9)
    when (x) {
        in validNumber -> println("x is valid")
        in 1..10 -> println("x is in the range")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }
    println("------------------------------------------------")

    var collection = listOf(1, 2, 3, 4, 5)
    collection.iterator()
    for (item in collection) {
        print(item)
    }
    println()
    println("------------------------------------------------")

    val array = arrayOf(1, 2, 3, 4, 5)
    array.iterator()
    for (i in array) {
        println("$i: $array[i]}")
    }
    println("------------------------------------------------")

    val array2 = arrayOf("가", "나", "다")
    for (i in array2.indices) {
        println("$i: ${array2[i]}")
    }
    println("------------------------------------------------")
    for ((index, value) in array2.withIndex()) {
        println("$index: ${value}")
    }
    println("------------------------------------------------")
/* do - while 문 body에 지역변수 선언 및 사용 가능*/
//    do{
//        var x = 0
//    } while (x < 3)
}

fun hasPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}
