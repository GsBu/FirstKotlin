package com.gs.first.com.gs.test

fun main(args: Array<String>){
    println("类、对象、接口")
    MyButton().click()
}

interface Clickable{
    fun click()
}

class MyButton : Clickable{
    override fun click() {
        println("自定义按钮")
    }
}