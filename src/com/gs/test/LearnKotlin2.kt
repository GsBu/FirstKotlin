package com.gs.first.com.gs.test

import com.gs.test.SuanFa
//对于扩展函数，Kotlin的语法，要求你用简短的名称，所以在导入声明时，关键字as就是解决命名冲突的唯一方式。
import string.lastChar as lastChar2

const val STRING = "Hello, Kotlin!"

fun main(args: Array<String>){
    val set = setOf(1, 2, 3, 4, 5, 6, 88)
    val list = listOf("a", "b", "c")
    val map = mapOf(1 to "aa", 3 to "sd", 77 to "sgrger", 4 to "fore")
    for (num in set.withIndex()){//Set也可以调用withIndex
        print("$num, ")
    }
    println("\n ${set.javaClass}, ${list.javaClass}, ${map.javaClass}")
    println("${list}最后一个数据=${list.last()}，${set}最大值=${set.max()}")

    println(set.joinToString(postfix = "]", prefix = "["))
    println("扩展函数，join=${list.join()}")
    println("顶层属性$STRING")
    //对于扩展函数，Kotlin的语法，要求你用简短的名称，所以在导入声明时，关键字as就是解决命名冲突的唯一方式。
    println("扩展函数，字符串最后一个字符=${"aaadf1".lastChar2()}")
    println("扩展函数，是否创建一个正方形${Rectangle(width = 5, height = 8).createSquare()}")
    println("扩展函数，java中调用扩展函数=${SuanFa.callKotlin()}")

}

fun Rectangle.createSquare(): Boolean {
    println("接收者对象的宽=${this.width}，高=${this.height}")
    return this.createSquare(8).isSquare
}
//对于扩展函数，Kotlin的语法，要求你用简短的名称，所以在导入声明时，关键字as就是解决命名冲突的唯一方式。
fun String.lastChar(): Char = get(length - 1)

fun <T> Collection<T>.joinToString(separatorf: String = ", ", prefix: String = "", postfix: String = ""): String{
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()){
        if (index > 0) result.append(separatorf)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(a: String = "*", b: String = "{", c: String = "}") = joinToString(a, b, c)