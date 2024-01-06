package com.javarush.task.pro.task05.task0507

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

    var arrayMaxValue = array.max()

    println(arrayMaxValue)

    arrayMaxValue = Int.MIN_VALUE

    //1
    for ((index, value) in array.withIndex()) {
        //println("Значение индекса $index равно $value")
        if (arrayMaxValue < array[index]) {
            arrayMaxValue = value
        }
    }

    println(arrayMaxValue)

    //2
    for (index in array.indices) {
        //println("Значение индекса $index равно ${array[index]}")
        if (arrayMaxValue < array[index]) {
            arrayMaxValue = array[index]
        }
    }

    println(arrayMaxValue)

    //3
    for (value in array) {
        // println("Значение элемента равно $i")
        if (arrayMaxValue < value) {
            arrayMaxValue = value
        }
    }

    println(arrayMaxValue)

    //4
    array.forEach { value ->
        if (arrayMaxValue < value) {
            arrayMaxValue = value
        }
    }

    println(arrayMaxValue)

    //5
    array.forEachIndexed { index, value ->
        arrayMaxValue = if (arrayMaxValue < array[index]) value else arrayMaxValue
    }

    println(arrayMaxValue)
}