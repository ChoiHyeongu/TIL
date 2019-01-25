fun main(args: Array<String>) {
    printProduct("3", "4")
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