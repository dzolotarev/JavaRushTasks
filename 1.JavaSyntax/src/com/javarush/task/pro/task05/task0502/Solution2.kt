package com.javarush.task.pro.task05.task0502

/**
 * @author Denis Zolotarev
 */
val ODD: String = "Нечётный"
val EVEN: String = "Чётный"
val strings = Array<String>(5) { _ -> "" }

fun main() {
    strings[0] = EVEN
    strings[1] = ODD
    strings[2] = EVEN
    strings.set(3, ODD)
    strings.set(4, EVEN)

    print("index = 0")
    println(" value = " + strings[0])
    print("index = 1")
    println(" value = " + strings.get(1))
    print("index = 2")
    println(" value = " + strings.get(2))
    print("index = 3")
    println(" value = " + strings[3])
    print("index = 4")
    println(" value = " + strings[1])
}