package com.gs.first.com.gs.test

interface Expr
class Num(val num: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num=${e.num}")
                e.num
            }
            is Sum -> {
                val left = eval(e.left)
                val right = eval(e.right)
                println("sum=$left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("不")
        }
