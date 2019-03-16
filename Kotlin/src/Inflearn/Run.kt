package Inflearn

fun main(args: Array<String>){
    applyTest()
}

fun applyTest() {
    println("== apply ==")
    val string = "a"
    val result = string.apply {
        println("this = $this, it = none")
        2
    }
    println("result $result")
}