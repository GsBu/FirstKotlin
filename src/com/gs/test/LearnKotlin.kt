package com.gs.first.com.gs.test

import java.util.*
import javax.print.attribute.IntegerSyntax

fun main(args: Array<String>){
    val a: Int
    val b: Int = 8
    a = 11
    val c = "ssssss"
    val person = Person("测试", false)
    println("${a}和${b}的小值：" + min(a, b))

    val rectangle = createRandomRectangle()
    println("随机创建一个矩形，高=${rectangle.height}，宽=${rectangle.width}，是否是正方形=${rectangle.isSquare}")
    println("颜色值=${getMnemonic2(Color.BLUE, Color.RED)}")

    println("求和=${eval(Sum(Sum(Num(1), Num(2)), Num(4)))}")

    for (i in 100 downTo 10){
        print("${fizzBuzz(i)} ")
    }
    println("\n遍历map")
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A' until 'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((a, b) in binaryReps){
        print("$a = $b，")
    }
    println("\n遍历Array")
    val list = arrayListOf("10", "11", "101")
    for ((index, value) in list.withIndex()){
        print("$index = $value，")
    }
    println("\n${isLetter('q')} ${isNotDigit('x')} ${recognize('0')}")
    //这里字符串是按照字母表顺序进行比较，因为String就是这样实现Comparable的。t在s之后，所以结果为false
    println("tKotlin" in "Java".."Scala")
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(n : Char) = n !in '0'..'9'

fun recognize(c: Char) = when(c){
    in '0'..'9' -> "是数字"
    in 'a'..'z', in 'A'..'Z' -> "是字母"
    else -> "未知"
}

fun fizzBuzz(num : Int) =
    when{
        num % 15 == 0 -> "FizzBuzz"
        num % 3 == 0 -> "Fizz"
        num % 5 == 0 -> "Buzz"
        else -> "$num"
    }

fun min(a: Int, b: Int):Int {
    return if (a > b) b else a
}

fun getMnemonic(color1 : Color, color2 : Color) =
        when(setOf(color1, color2)){
            setOf(Color.RED, Color.BLUE) -> "RedBlue Or BlueRed"
            else -> "error"
        }

fun getMnemonic2(color1 : Color, color2 : Color) =
        when{
            (color1 == Color.RED && color2 == Color.BLUE) ||
            (color1 == Color.BLUE && color2 == Color.RED) -> "RedBlue Or BlueRed"
            else -> "error"
        }