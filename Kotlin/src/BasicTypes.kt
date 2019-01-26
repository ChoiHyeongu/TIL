fun main(args: Array<String>) {
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_1242_1342_3512L /* _ 표기 가능*/

    //Java 플랫폼에서 숫자형은 JVM primitive type
    var a: Int = 10000
    var b: Int = 10000
    println("a === b: ${a === b}")
    println("a == b: ${a == b}")
    println("------------------------------------------------")

    //Nullable이나 제네릭의 경우에는 박싱됨
    //박싱된 경우 identify를 유지 하지 않음
    var x: Int = 10000
    var y: Int? = 10000
    println("a === b: ${x === y}")
    println("a == b: ${x == y}")
    println("------------------------------------------------")

    //작은 타입은 큰 타입의 하위 타입이 아님, 즉 작은 타입에서 큰 타입으로 대입이 안됨
    val intVar: Int = 1
    val longVar: Long = intVar.toLong()
    val intVar2: Int = longVar.toInt()
    //명시적 변환
    println("------------------------------------------------")

    println('0'.toInt())
    println("------------------------------------------------")

    var array: Array<String> = arrayOf("코틀린", "강좌")
    println(array.get(0))
    println(array[0])
    println(array.size)
    println("------------------------------------------------")

    val arrayA = Array(5, { i -> i.toString() })
    val arrayB = arrayOf("0", "1", "2", "3", "4")

    println("arrayA")
    for (i in arrayA) print(i + "")
    println()
    println("arrayB")
    for (i in arrayB) print(i + "")
    println()
    println("------------------------------------------------")

    val arrayC: IntArray = intArrayOf(1, 2, 3)
    arrayC[0] = 7
    println(arrayC.get(0))
    println(arrayC[0])
    println(arrayC.size)
    println("------------------------------------------------")

    var stringVar: String = "Kotlin"
    println(stringVar.get(0))
    println(stringVar[0])
    println(stringVar.length)

    for (i in stringVar) print(i + "")
    println()
    println("------------------------------------------------")

    val rawString = """
       이것은 코틀린의
       raw String 입니다.
    """
    println(rawString)
    println("------------------------------------------------")
}

fun check(c: Char) {
    // if(c == 1){/*  */} char은 숫자 취급 안됨
    if (c == 'a') {/*  */
    }
}