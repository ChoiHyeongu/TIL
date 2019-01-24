fun main(args: Array<String>) {
    var x = 3
    var y = 2

    println(sum(x, y))
    println(minus(x, y))
    println(multiply(x, y))
    println(divide(x, y))
}

fun sum(a: Int, b: Int) = a + b
fun minus(a: Int, b: Int) =  a - b
fun multiply(a: Int, b: Int) =  a * b
fun divide(a: Int, b: Int) = a / b