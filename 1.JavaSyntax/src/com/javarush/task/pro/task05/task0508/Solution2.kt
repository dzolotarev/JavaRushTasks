package com.javarush.task.pro.task05.task0508

/**
 * @author Denis Zolotarev
 */

var strings = arrayOf<String?>()

fun main() {
    strings = Array(6) { null }
    for (i in 0 until 6) {
        strings[i] = readln()
    }



    println(strings.joinToString())
}