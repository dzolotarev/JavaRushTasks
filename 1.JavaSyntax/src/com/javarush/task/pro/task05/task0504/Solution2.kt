package com.javarush.task.pro.task05.task0504

/**
 * @author Denis Zolotarev
 */

val firstArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
val secondArray = intArrayOf(10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
var resultArray = arrayOf<Int>()

fun main() {
    resultArray = Array(firstArray.size + secondArray.size) { 0 }
    for (i in firstArray.indices) {
        resultArray[i] = firstArray[i]
    }

    for (i in secondArray.indices) {
        resultArray[firstArray.size + i] = secondArray[i]
    }

    resultArray.forEach { x -> print("$x, ") }
}