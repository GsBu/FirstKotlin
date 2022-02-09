package com.gs.first

import com.gs.first.com.gs.test.Person
import com.gs.first.com.gs.test.Student
import com.gs.first.com.gs.test.createRandomRectangle

val PI = 3.1415
var c =77777

fun main() {
    var a: Int = 44
    val b = 3
    val c: Int = 3
    val p = Person("aa", false)
    val s = Student("aa", 111.9)
    var sum: Int = sum(22, 55)
    var s1: String = "a is $a, \$a"
    a =4
    var s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
    /* 注释从这里开始
    /* 包含嵌套的注释 */
       并且在这里结束。 */
    println("Hello world! $sum, ${sum(2,3)}, $PI, $c, ${printSum(2, 5)}")
    println(sum)
    printSum(44, 5)
    println("4和8比，${maxOf(4, 8)}大, ${parseInt("555e")}")
    var sss = parseInt("222")
    createRandomRectangle()
}

/**
 * 计算两值之和
 */
fun sum(a: Int, b: Int): Int = a + b

fun printSum(a: Int, b: Int){
    //打印出来
    println("sum of $a and $b is ${sum(a, b)}, $c")
}

fun maxOf(a: Int, b: Int) = if(a > b) a else b

fun parseInt(str: String): Int?{
    return str.toIntOrNull()
}