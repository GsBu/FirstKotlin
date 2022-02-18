package com.gs.first.com.gs.test.shejimoshi

fun main(){
    val superBody = SuperBody(Body())
    superBody.chuanYi()
    //使用扩展函数，实现和装饰模式一样的功能
    Body().superChuanYi()
}

interface Person1 {
    fun chuanYi()
}

class Body: Person1{
    override fun chuanYi() {
        println("男孩穿衣服")
    }
}

//扩展函数实现了和装饰模式一样的功能
fun Body.superChuanYi(){
    println("穿衣前先洗澡2222")
    this.chuanYi()
}

class SuperBody(val person1: Person1): Person1{
    override fun chuanYi() {
        println("穿衣前先洗澡1111")
        person1.chuanYi()
    }
}
