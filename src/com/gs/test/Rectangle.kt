package com.gs.first.com.gs.test

import java.util.*


class Rectangle (val height: Int, val width: Int){
    val isSquare: Boolean get() = height == width
    fun isSquare2() = height == width

    fun createSquare(num: Int): Rectangle{
        return Rectangle(num, num)
    }
}

fun createRandomRectangle(): Rectangle{
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}