package com.gs.first.com.gs.test

import com.gs.test.SuanFa
//对于扩展函数，Kotlin的语法，要求你用简短的名称，所以在导入声明时，关键字as就是解决命名冲突的唯一方式。
import string.lastChar as lastChar2

const val STRING = "Hello, Kotlin!"

fun main(args: Array<String>){
    val set = setOf(1, 2, 3, 4, 5, 6, 88)
    val list = listOf("a", "b", "c")
    val map = mapOf(1 to "aa", 3.to("sd"), 77 to "sgrger", 4 to "fore")
    for (num in set.withIndex()){//Set也可以调用withIndex
        print("$num, ")
    }
    println("\n ${set.javaClass}, ${list.javaClass}, ${map.javaClass}")
    println("${list}最后一个数据=${list.last()}，${set}最大值=${set.max()}")

    println(set.joinToString(postfix = "]", prefix = "["))
    println("扩展函数，join=${list.join()}")
    println("顶层属性$STRING")
    //对于扩展函数，Kotlin的语法，要求你用简短的名称，所以在导入声明时，关键字as就是解决命名冲突的唯一方式。
    println("扩展属性，字符串最后一个字符=${"aaadf1".lastChar2}")
    println("扩展函数，是否创建一个正方形${Rectangle(width = 5, height = 8).createSquare()}")
    println("扩展函数，java中调用扩展函数=${SuanFa.callKotlin()}")

    val view: View = Button()
    view.click()
    view.showOff()

    val array = arrayOf(list)
    val list2 = listOf("args", array)
    println(list2)
    varargFun("a", "b", "v", *args, "m")

    println("12.345-6.A".split("-", "."))
    parsePath2("C:/Users/longlong.bu/Desktop/数据结构/课件/1.1绪论.ppt")

    val kotlinLogo = """| //
                       .|//
                       .|/ \ $ 99""".trimMargin(".")
    println(kotlinLogo)

    saveUser(User(1, "", ""))
}

class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave(){
    fun validate(value: String, fieldName: String){
        if (value.isEmpty()){
            throw IllegalArgumentException("不能保存该用户${id}：${fieldName}为空")
        }
    }
    validate(name, "姓名1")
    validate(address, "地址1")
}

fun saveUser(user: User){

    user.validateBeforeSave()

    if(user.name.isEmpty()){
        throw IllegalArgumentException("不能保存该用户${user.id}：姓名2为空")
    }
    if(user.address.isEmpty()){
        throw IllegalArgumentException("不能保存该用户${user.id}：地址2为空")
    }
}

fun parsePath(path: String){
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("解析路径：目录：${directory}，文件名：$fileName，扩展名：${extension}")
}

fun parsePath2(path: String){
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult != null){
        val (directory, fileName, extension) = matchResult.destructured
        println("解析路径：目录：${directory}，文件名：$fileName，扩展名：${extension}")
    }
}

infix fun Any.to(other: Any) = Pair(this, other)

fun varargFun(vararg args: String){
    for (a in args){
        print("$a ")
    }
}

fun View.showOff() = println("View showOff")

fun Button.showOff() = println("Button showOff")

open class View{
    open fun click() = println("View clicked")
}

class Button: View(){
    override fun click() = println("Button clicked")
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