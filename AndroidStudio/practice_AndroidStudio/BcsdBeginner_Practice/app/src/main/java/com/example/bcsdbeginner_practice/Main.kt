package com.example.bcsdbeginner_practice

fun main() {
    // ctrl + z + enter 시 null 입력 가능
    print("이름 입력: ")
    var name: String? = readLine()
    print("나이 입력: ")
    var age: String? = readLine()
    // Person 객체 생성
    var p = Person(name?:"Unknown", age?:"Unknown")
    println("name : ${p.name}, age : ${p.age}")
}
class Person(var name: String, var age: String) {
}
// 확장 함수
