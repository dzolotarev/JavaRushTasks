package com.javarush.task.pro.task05.task0503

/**
 * @author Denis Zolotarev
 */

val array = intArrayOf(-1, 2, 3, -4, -5)
val array1 = arrayOf<Int>(-1, 2, 3, -4, -5)
val array2 = arrayOf(-1, 2, 3, -4, -5)

fun main() {
    for (index in array.indices) {
        if (array[index] % 2 == 0) {
            array[index] = -array[index]
        }
    }
    println(array[0])
    println(array[1])
    println(array[2])
    println(array[3])
    println(array[4])
}