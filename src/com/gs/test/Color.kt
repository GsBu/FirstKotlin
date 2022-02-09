package com.gs.first.com.gs.test

enum class Color (val r: Int, val g: Int, val b: Int){
    RED(255,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0),
    BLUE(0,0,255);
    
    fun rgb(): Int{
        return (r * 256 + g) * 256 + b
    }
}