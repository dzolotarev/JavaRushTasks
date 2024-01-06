package com.javarush.task.pro.task05.task0505

/**
 * @author Denis Zolotarev
 */

fun main() {
    val n = readln().toInt()
    if (n <= 0) {
        println("Введено $n. Введите число больше нуля")
        return
    }
    val array = IntArray(n)
    for (i in 0 until n) {
        array[i] = readln().toInt()
    }

    if (n and 1 != 0) {
//        for (i in n - 1 downTo 0) {
//            println(array[i])
//        }
        array.reversed().forEach { x -> println(x) }
    } else {
//        for (i in 0 until n) {
//            println(array[i])
//        }
        array.forEach { x -> println(x) }
        println(array.joinToString("|","[","]"))
    }

}