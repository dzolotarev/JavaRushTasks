package com.javarush.task.pro.task05.task0506

/**
 * @author Denis Zolotarev
 */

var array = arrayOf<Int>()

fun main() {
    val n = readln().toInt()
    array = Array(n) { 0 }
    for (i in 0 until n) {
        array[i] = readln().toInt()
    }
    var arrayMin = Int.MAX_VALUE
    array.forEach { x ->
        if (arrayMin > x) {
            arrayMin = x
        }
    }

    //val arrayMin = array.min()
    println(arrayMin)
}