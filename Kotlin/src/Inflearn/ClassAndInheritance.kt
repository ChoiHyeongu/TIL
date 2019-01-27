package Inflearn

//class Person constructor(firstName: String) {}
// 어노테이션이나 접근지정자가 없을 때는 기본 생성자의 constructor 생략 가능

class Customer(name: String) {
    var fullName = name
    init { println("Customer initialized with value $name") }
}

class Person(val name: String){
    constructor(name: String, parent: Person) : this(name){} //보조 생성자
    constructor(): this("최형우", Person()) // 보조 생성자
}

fun main(args: Array<String>) {
    var obj = Customer("CHU")
    println(obj)
    println(obj.fullName)
    println("------------------------------------------------")
}