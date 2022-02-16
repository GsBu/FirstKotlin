package com.gs.first.com.gs.test

fun main(args: Array<String>){
    println("类、对象、接口")
    MyButton().click()
    MyButton().showOff()
    val myButton = RichButton()
    myButton.disable()
    TalkButton().click()
}

internal open class TalkButton : Clickable{
    override fun click() {
        println("自定义按钮：TalkButton")
    }

    private fun yell() = println("Hey!")

    protected fun whisper() = println("whisper!")
}

internal fun TalkButton.giveSpeech(){
    click()
}

abstract class Animated{
    abstract fun animated()
    open fun stopAnimating(){

    }

    fun animateTwice(){

    }
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

open class MyButton : Clickable, Clickable2{
    fun disable(){
        println("父类disable")
    }

    final override fun click() {
        println("自定义按钮")
    }

    override fun showOff() {
        super<Clickable2>.showOff()
        super<Clickable>.showOff()
        super<Clickable2>.showOff()
    }
}

class RichButton : MyButton(){

    fun disable2() {
        println("子类disable")
    }
}