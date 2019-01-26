package Practice

import java.util.*

fun main(args: Array<String>) {

    var result = 0
    val sc: Scanner = Scanner(System.`in`)
    println("x값을 입력하세요")
    var x = sc.nextLine()
    println("y값을 입력하세요")
    var y = sc.nextLine()
    println("연산자를 입력하세요")
    var opt = sc.nextLine()

    when (opt){
        "+" -> result = sum(x.toInt(), y.toInt())
        "-" -> result = minus(x.toInt(), y.toInt())
        "*" -> result = multiply(x.toInt(), y.toInt())
        "/" -> result = divide(x.toInt(), y.toInt())
    }

    println("결과 : $result")
}

fun sum(a: Int, b: Int) = a + b
fun minus(a: Int, b: Int) = a - b
fun multiply(a: Int, b: Int) = a * b
fun divide(a: Int, b: Int) = a / b