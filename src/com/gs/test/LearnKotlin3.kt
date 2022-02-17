package com.gs.first.com.gs.test

fun main(args: Array<String>){
    println("类、对象、接口")
    MyButton().click()
    MyButton().showOff()
    val myButton = RichButton()
    myButton.disable()
    TalkButton().click()
    MyStateButton().getCurrentState()
    MyUser("ss")

    println("${PrivateUser("test@qq.com").nickname}")
    println("${SubUser("test@qq.com").nickname}")
}

interface MyUser33{
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class PrivateUser(override val email: String): MyUser33

class SubUser(override val email: String): MyUser33{
    override val nickname: String
        get() = email.substringBefore(".")
}

class FacebookUser(val accountId: Int): MyUser33{
    override val email: String = getFacebookEmail(accountId)
    override val nickname: String = getFacebookName(accountId)
}

fun FacebookUser.getFacebookEmail(accountId: Int) : String{
    return ""
}

fun FacebookUser.getFacebookName(accountId: Int) : String{
    return ""
}

class Child2(name: String): Parent(name){

}

class Child: Parent{
    constructor(name: String): this(name, ""){
    }

    constructor(name: String, aa: String): super(name){

    }
}

open class Parent{
    constructor(name: String){

    }
}

class MyUser4(_name: String): MyUser(_name){

}

class MyUser3(val name: String = "aa")

class MyUser2(_name: String){
    val name = _name
}

open class MyUser internal constructor(_name: String){
    val name: String = _name
    init {
        println("初始化语句块1，参数${_name}")
    }
    init {
        println("初始化语句块2，参数${_name}")
    }
    fun a(){

    }
}

interface State: java.io.Serializable

interface MyView{
    val a: String
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class MyStateButton : MyView{
    override val a: String = "a"
    override fun getCurrentState(): State {
        return ButtonState()
    }

    inner class ButtonState : State{
        fun getOuterA(){
            this@MyStateButton.a
        }
    }
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