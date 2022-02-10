package com.gs.first.com.gs.test

fun main(args: Array<String>){
    val set = setOf(1, 2, 3, 4, 5, 6, 88)
    val list = listOf("a", "b", "c")
    val map = mapOf(1 to "aa", 3 to "sd", 77 to "sgrger", 4 to "fore")
    for (num in set.withIndex()){//Set也可以调用withIndex
        print("$num, ")
    }
    println("\n ${set.javaClass}, ${list.javaClass}, ${map.javaClass}")
    println("${list}最后一个数据=${list.last()}，${set}最大值=${set.max()}")

    println(joinToString(list, "(", postfix = ")", prefix = "6"))
}

fun <T>joinToString(collection: Collection<T>, separatorf: String = ", ", prefix: String = "", postfix: String = ""): String{
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()){
        if (index > 0) result.append(separatorf)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}