package Inflearn

//class Person constructor(firstName: String) {}
// 어노테이션이나 접근지정자가 없을 때는 기본 생성자의 constructor 생략 가능

class Customer(name: String) {
    var fullName = name

    init {
        println("Customer initialized with value $name")
    }
}

class Person(val name: String) {
    constructor(name: String, parent: Person) : this(name) {} //보조 생성자
    constructor() : this("최형우", Person()) // 보조 생성자
}

class Example1 {} // == class Example1 : Any() 명시를 안했을 시 Any 상속 Any-> equals(), hashCode(), toString()

open class classA(x: Int) {
    open fun test() {
        println("class A")
    }

    open fun A() {
        println("class")
    }
}

interface interfaceA {
    fun A() {
        println("interface")}
}

class classB(a: Int) : classA(a) {
    override fun test() {
        println("class B")
    }
}

class classC() : classA(1), interfaceA {
    override fun A() {
        println("1")
        super<classA>.A()
        println("2")
        super<interfaceA>.A()
        println("3")
    }
}

open class Base {
    open fun v() {}
    fun nv() {}
}

abstract class AbsClass{
    abstract fun f()
}

class MyClass(): AbsClass(){
    override fun f() {

    }
}

fun main(args: Array<String>) {
    var obj = Customer("CHU")
    println(obj)
    println(obj.fullName)
    println("------------------------------------------------")
    val obj2 = classC()
    obj2.A()
    println("------------------------------------------------")
}