package com.gs.first.com.gs.test

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