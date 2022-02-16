package com.gs.first.com.gs.test

fun main(args: Array<String>){
    println("类、对象、接口")
    MyButton().click()
    MyButton().showOff()
}

interface Clickable{
    fun click()
    fun showOff(){
        println("默认实现111")
    }
}

interface Clickable2{
    fun click()
    fun showOff(){
        println("默认实现222")
    }
}

class MyButton : Clickable, Clickable2{
    override fun click() {
        println("自定义按钮")
    }

    override fun showOff() {
        super<Clickable2>.showOff()
        super<Clickable>.showOff()
        super<Clickable2>.showOff()
    }
}