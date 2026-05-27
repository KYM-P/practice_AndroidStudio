package com.example.bcsdbeginner_practice

import android.widget.Button
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.IllegalArgumentException
import java.util.Objects
import java.util.Scanner
import kotlin.random.Random

/* 기본 문법 */
/*
  ; 사용 안함
  변수명 { 매개 변수 -> 실행문 } // lambda 식 함수
 */

// 늦은 바인딩
lateinit var lateinitBtn : Button
/*
lateinit > 늦은 바인딩
매번 변하는 값을 넣으므로 var 만 사용 가능
Int, Double 등 Primitive 타입들 사용 불가
 */

// val lazyBtn : Button by lazy {"msg"}
/*
lazy > 늦은 바인딩
한번만 늦은 초기화 가능 그러므로 val 선언
 */

fun variable () { /* 변수 지정 (var) */

    // 변수 자동 인식 (var 변수명)
    var num = 10 // 변수 선언

    // long 타입
    var numLong = 10L
    // float 타입
    var numFloat = 1.0f
    // num = numLong 오류 why? 자료형 다름
    num = numLong.toInt() // 가능

    // String 타입
    var str = "String" // str = num.toString() 가능 / str[0] 가능
    str.uppercase()
    str.lowercase()

    // 변수 수동 지정 (var 변수명: 자료형)
    var chr : Char = 'a' // 변수 선언

    // 술어 변수
    val predicate1 = { i:Int -> i > 0 } // predicate(술어) 변수

    val string1 = { i : Int, s : String  -> "${i} + ${s}"}
}

fun invariable () { /* 상수 지정 (val) */

    // 상수 선언
    val numFinal = 11 // 초기화 이후 값 변경 불가
}

/* const 상수 *main 보다 먼저 컴파일 >> 성능상 우위 / 전역 으로만 선언 가능 */
const val numConstInMemo = 0

fun applied () { /* 변수, 상수 응용 */

    // 응용 용 변수, 상수
    var num = 10 // 변수 선언
    var str = "String"

    // Math.max() 대체
    kotlin.math.max(num,10)

    // random 값 지정
    var numRandom = Random.nextInt() // int 범위 내
    Random.nextInt(0,100) // 0에서 99까지 (100-1)
    Random.nextDouble(0.0, 1.0) // 0.0에서 1.0까지 강제 형변환

    // type 확인
    println(num is Int)

    // 문자열 포함
    println("Hello World $str !") // 문자열 사이에 들어갈 때는 양옆 공백 필요
    println("Hello World ${str}!")

    // 강제 형변환
    numRandom.toDouble()
    // 형변환(스마트 캐스팅) // 변환 가능시 에만 변환
    numRandom as Double // as? 로 nullCheck 가능

    // 형 검사
    numRandom is Int // 해당 타입이 Int 면 true / 검사 이후 해당 주기 동안 해당 타입 메소드 사용 가능

    // 형 출력
    numRandom.javaClass // 해당 타입의 경로를 반환 한다

    // null 타입
    var nNum : Int? = null // 변수 명: 타입? 형태
    // num = nNum *오류

    // null check way 1
    if (nNum != null) {
        num = nNum
    }
    // null check way 2
    nNum?.let {} // nNum 이 null 이 아니면 let 실행
    num = nNum!! // null 강제 해제

    // type check
    if (num is Int)print("isInt") // 부모 is 아들 => true / * type check 이후 아들의 메소드, 변수 사용 가능

    // 문자열 응용
    var str2 = """ hi
        | my name is str2
        """.trimMargin()
    str.startsWith("S") // 문자열이 해당 문자열로 시작하면 True
    str.endsWith("g") // 문자열이 해당 문자열로 끝나면 True
    str.uppercase() // 문자열의 알파벳 모두 대문자로 변환
    str.lowercase() // 문자열의 알파벳 모두 소문자로 변환
    str.contains("s") // 해당 문자열을 포함하고있는지 검사 후 있다면 True
    str.slice(0..2) // 해당 index 부분을 잘라낸 문자열 반환
    str.substring(3) // 0부터 해당 index 부분을 제외한 문자열 반환
    str.split(",") // 해당 문자열을 구분자 기준으로 나누어 반환
    str.split(",").map {it.toInt()} // 해당 문자열을 구분자 기준으로 나누고 map 형식으로 반환 { 각 요소를 int로 변환 }

    str.equals(str2) // str2와 같으면 true / 대, 소문자 구분 X
    str == str2 // 위의 식을 Kotlin 에서 간단하게 사용 가능
    str === str2 // 둘의 문자열 주소값이 같은지 비교 / java 에서는 str == str2

    str.compareTo(str2)
    // str 과 str2 가 시작 문자가 같고 포함 관계에 있다면 문자열 차이만큼 값 반환 / 예시: "abcd" , "a" 면  3
    str < str2 // str 이 사전순 비교로 str2 보다 작은 지 반환
    
}

fun inputOutput () {
    /* 입력 */

    // Scanner
    var reader = Scanner(System.`in`)
    reader.next()
    reader.nextInt()

    // BufferedReader
    // 기본 형태 / var br = BufferedReader(InputStreamReader(System.`in`))
    var br = System.`in`.bufferedReader() // 축약 형태
}

fun dataType () { /* 자료형 목록 */

    // 리스트
    val list1 = listOf(0,1,2,3) // 원형 / val list1 : MutableList<Int> = mutableListOf<Int>(0,1,2,3)
    list1.get(2) // 메소드 접근 가능
    list1[0] // 색인 접근 가능
    list1.toMutableList() // 요소를 유지 하는 MutableList 형태로 반환

    // 그외
    var ListT1 = List(5) { it } // [0, 1, 2, 3, 4]
    var ListT2 = List(5) { 0 } // [0, 0, 0, 0, 0]
    var ListT3 = List(5) { 'a' + it } // [a, b, c, d, e]

    // 배열
    val array1 = arrayOf(0,1,2) // 요소 변경 가능 / 크기 변경 불가
    array1[0] = 10

    // MutableList
    var list2: MutableList<Int> = mutableListOf(0, 1)
    list2[0] = 10 // 해당 index가 없어도 문법 오류가 안남!! / 단 RuntimeError
    // 첨삭 가능
    list2.add(6)
    list2.remove(0) // 해당 요소값과 일치하는 1개 항목 제거
    list2.removeAt(1) // index 1 번 요소 제거 / 해당 index가 없어도 문법 오류가 안남!! / 단 RuntimeError
    list2.removeAll(listOf(1)) // 해당 리스트의 항목과 일치하는 모든 항목 제거
    list2.set(1,0) // set(index, item) 해당 index 의 값을 item으로 변경
    list2.add(1,0) // add(index, item) 해당 index 에 값을 추가 / 뒤의 요소는 밀림
    list2.toList() // 요소를 유지 하는 List 형태로 반환
    list2.distinct() // 리스트 내 중복 요소 제거

    // 리스트 응용
    list1.joinToString("") // 해당 요소들을 문자열로 바꾸어 합친 문자열을 반환 , 구분자 문자는 ""내부
        // filter
    list1.filter { it > 2 } // 조건에 맞는 모든 요소 반환
        // find, firstOrNull
    list1.find { it > 2 } // 조건에 맞는 한가지 요소 반환 / 없으면 예외 발생
    list1.firstOrNull { it > 2 } // 조건에 맞는 한가지 요소 반환 / 없으면 null
    list1.lastOrNull { it > 2 } // 조건에 맞는 마지막 요소 반환 / 없으면 null
    list1.filterNotNull() // Null 이 아닌 모든 요소 반환
        // sum
    list1.sum() // 정수형 리스트일 때 모든 값 sum
        // take, drop
    list1.takeLast(2) // 리스트 뒤의 2개 요소 반환
    list1.take(2) // 리스트 앞의 2개 요소 반환
    list1.takeWhile { it > 2 } // 리스트 앞에서 해당 조건에 부합하는 요소 반환
    list1.drop(3) // 리스트 앞의 2개 요소를 제외하고 반환
    list1.dropWhile { it > 2 } // 리스트 앞에서 해당 조건에 부합하는 요소를 제외하고 반환
    // 술어 변수 응용
    val predicate1 = { i:Int -> i > 0 } // predicate(술어) 변수
    list1.filterNot(predicate1) // 해당 술어에 만족하지 않는 모든 요소 반환
}

fun conditional () { /* 조건문 목록 */

    // 조건문 용 변수
    var index = 5

    // if 문 (java 와 동일)
    if (index > 0) {
        println("index is PositiveNumber")
    }else {
        println("index is Zero or NegativeNumber")
    }

    // if 문 응용 (if 문으로 결과 리턴)
    var result = if (index > 0) {
        "index is PositiveNumber"
    }else{
        "index is Zero or NegativeNumber"
    }

    // if 문 응용2 (if 문으로 3항 연산)
    var isOverTen = if(index > 10) "Yes" else "No" // if 문으로 3항 연산

    // when 문 *단 위에서 부터 읽어 조건이 겹쳐도 먼저 조건에 부합하는 결과 1개만을 반환
    when {
        index > 10 -> {
            // index 가 10 초과 일 때 실행
        }
        index > 20 -> {
            // index 가 20 초과 일 때 실행
        }else -> {
        // index 가 위 두 조건이 아닐 때 실행
        }
    }
}

fun iteration () { /* 반복문 목록 */

    // 반복문 용 리스트
    val items = listOf(1, 2, 3, 4, 5)

    // 반복문 for (리스트 대입1)
    for (item in items) {
        print(item) // item[0] item[1] ... item[4] / * 5번 시행
    }
    // 반복문 for (리스트 대입2)
    for (item in items.reversed()) {
        print(item) // item[0] item[1] ... item[4] / * 5번 시행
    }

    // 반복문 for (정수 구간1)
    for (i in 0..items.size){ // 0 ~ item.size 까지 *(중요)
        print(i) // 0 1 ... 5 / * 6번 시행
    }
    // 반복문 for (정수 구간2)
    for (i in items.size downTo(0)){ // item.size ~ 0 까지 *(중요)
        print(i) // 5 4 ... 0 / * 6번 시행
    }
    // 반복문 for (정수 구간3)
    for (i in items.size downTo(0) step (2)){ // item.size ~ 1 까지 *(중요) // step(간격) *downTo 가 아니여도 사용 가능
        print(i) // 5 3 1 / * 3번 시행
    }
    // 반복문 for (정수 구간4)
    for (i in 0 until items.count()) {
        print(i) // 0 1 2 ... 4 / * 5번 시행
    }

    // 반복문 forEach (리스트 대입) / list 명.forEach { 대입자 -> 시행문 }
    items.forEach{ item -> //
        print(item) // item[0] item[1] ... item[4] / * 5번 시행
    }

    // while 문은 java 와 동일 (생략)
}

fun exception () { /* 예외 */

    // 예외 용 리스트
    val items = listOf(1, 2, 3, 4, 5)

    // 예외
    try {
        val item = items[7] // outOfBounce
    }catch (e: Exception) {
        println(e.message)
    }

}

/* 함수 */

// 기본 형태 / 함수명(매개 변수): 반환 타입 {}
fun isFunA(a:Int, b:String): Int {
    return a
}
// 축약 형태 / 함수명(매개 변수) = 반환값 / 반환 타입 생략
fun isFunB(a:Int,b:String) = a

// callBack 함수 (해당 함수 이후 다음 함수 호출)
// 기본 형태 / 함수명(매개 변수, callBack 명칭: (callBack 함수의 매개 인자) -> 반환 타입 = {callBack 함수 실행문}) {}
// 축약 형태 / 함수명(매개 변수, callBack 명칭: (callBack 함수의 매개 인자) -> 반환 타입) {} / 단 callBack 함수 실행문 재정의 필요
// is FunC 내부에서 call() 함수 실행가능   * 위 callBack 함수의 매개 인자는 call() 내부에서 it 으로 사용 가능
fun isFunC(a: Int, call: (Int) -> Unit = { println("call isFunC, $a, $it")}) { // Unit / return 값이 void
    call(5) // callBack 실행 / 이때 매개 인자는 callBack 함수 내에서 it 으로 사용 가능
    /* 외부에서 isFunC 호출시
    // 일반
    isFunC(10) // "call isFunC, 10, 5"

    // 재정의 하여 사용
    isFunC(12){
        println("call isFunC, 재정의, $a, $it")
    } // "call isFunC, 재정의, 12, 8"
    */
}

// suspend 함수 (정지 함수)
suspend fun isFunD() { println("isFunD") } // 해당 함수가 시작하고 끝날 때 까지 해당 쓰레드 대기
/* suspend 함수는 suspend 함수 내부, thread 에서 실행 가능 혹은 코루틴 방식 이용
* lifecycle (해당 activity 의 생명 주기와 동일한 주기)
gradle 내부에 dependencies 항목 추가
implementation("androidx.lifecycle:lifecycle-runtime-ktx-android:2.8.6") // lifecycle 사용
사용법
* activity 내부 함수의 내부
lifecycleScope.launch {
            isFunD()
        }
 */

// 확장 함수
// 기본 형태 / fun 객체명.신규 함수 명(매개 변수 ... ) {}
fun MutableList<Int>.swap(index1:Int, index2:Int) {} // list형.swap(a, b) 으로 간단하게 사용 가능


fun elvis () {
    /* Elvis Operation */
    var str : String? = null
    var result = str?.length ?: -1 // str이 null 이 아니면 str.length, null 이면 -1
}

// 함수형 프로그래밍
fun fun1(p: (Int, String) -> String) { // (함수명 : (매개변수1, 매개변수2) -> 반환타입)
    val h : String = p(40, "hi")
}

val t = fun1({ i :Int, s :String -> "${i} + ${s}" }) // 함수 호출




/* class */
// 기본적으로 프로퍼티 제공
// 기본 형태 / class 명칭 (맴버 변수) { 내용 } / ()괄호 안 맴버 변수로 선언 시 자동으로 생성자 생성
class TestClass1(val name: String, var age: Int) {} // TestClass1(String, Int) 생성자 사용 가능 / 단 생성자가 있으므로 기본 생성자는 없음

// data 형태 / data class 명칭 (맴버 변수) { 내용 } / 자동으로 생성자 생성 / 자동으로 toString(), equals() 제공
data class TestClass2(val name: String, var age: Int, private val heigh: Int = 170) {// val 수정 불가, var 수정 가능 // var 선언 멤버 변수는 자동 getter, setter 지원, val 은 getter 만
    constructor(name: String, age: Int) : this(name, age, 0) { // 감소 생성자
    }
    constructor(name: String, age: Int, heigh: Int, weigh: Int) : this(name, age, heigh) { // 증가 생성자
        this.weigh = weigh
    }

    /* 객채가 만들어질 때 호출 / 초기값의 제한 요소를 넣으면 좋음x
    init {
        if (name.isEmpty()) throw IllegalArgumentException("noName")
        this.name = name
    }
    */
var weigh: Int = 0 // weigh 맴버 변수 선언
    private set // weigh 변수는 이제 외부에서의 변경(set)이 불가능
    get() = field // TestClass2.weigh 으로 getter 가능
}

/* interface */
interface TestInterface1 {
    fun t() {}
}

/* 상속 */
abstract class TestClassM1(){ // 상속을 줄 수 있는 클래스는 abstract class / or / open class 만 가능
    open fun move() { // open 예약어로 override 가능
        println("M1")
    }
}
// 기본 상속 / class 명칭 : 부모의 생성자, 인터페이스 명칭 , ... {}
class TestClassS1 : TestClassM1() , TestInterface1 {
    override fun move() { // override 예약어로 open 메소드의 override 가능
        println("S1")
    }
    override fun t(){} // 인터페이스 override
}

/* template */
class TestTemplateClass<T>(value: T) { // 변수에 수식어가 없으면 외부에서 접근 불가

}

/* 와일드 카드 */
fun wild1(list : List<*>) {} // 모든 T 가능 혹은 <T : Any> or <T : Any?> or <T> / * Any 는 null 불가
fun<T : Objects> wild2(list : List<out T>) {} // T와 T의 상위만 가능
fun<T : Objects> wild3(list : List<T>) {} // T와 T의 하위만 가능
fun<T> wild3(list : List<T>) where T : TestClassM1, T : Comparable<T> {} // TestClassM1의 하위 포함 + Comparable 을 구현한 T만 가능
// sealed class 를 통한 Int 와 String 만 받는 타입 제한
sealed class AllowedType
data class AllowedInt(val value: Int) : AllowedType()
data class AllowedString(val value: String) : AllowedType()
fun <T : AllowedType> handleInput(value: T) {
    when (value) {
        is AllowedInt -> println("Int value: ${value.value}")
        is AllowedString -> println("String value: ${value.value}")
    }
}