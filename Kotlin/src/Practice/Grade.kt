package Practice

fun main(args: Array<String>) {
    var scoreArray = arrayOf(90, 19, 51, 73, 69)
    for (item in scoreArray) {
        print("$item : ")
        getGrade(item)
    }
}

fun getGrade(score: Int) = when(score){
    in 90..100 -> println("A")
    in 80..89 -> println("B")
    in 70..79 -> println("C")
    in 60..69 -> println("D")
    in 50..59 -> println("E")
    else -> println("F")
}