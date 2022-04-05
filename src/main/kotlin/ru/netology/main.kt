package ru.netology

import kotlin.random.Random
import kotlin.random.nextInt

const val ONE_MINUTE = 60
const val ONE_HOUR = 3600
const val ONE_DAY = 86400
const val SECOND_DAY = 172800
const val THREE_DAY = 259200
const val STOP: Int = 0


fun main() {

    while (true) {
        val result = Random.nextInt(0..THREE_DAY)

        println("_____________________________________")
        println("Выберите соответствующий пункт меню: ")
        println("1.Продолжить проверку")
        println("2.Выйти")
        val chek = readln().toInt()
        if (chek == 2) {
            println("Программа завершена!")
            break
        }

        when (result) {
            in 0..ONE_MINUTE -> println("Пользователь был(а) только что")
            in ONE_MINUTE + 1..ONE_HOUR -> minutes(result)
            in ONE_HOUR + 1..ONE_DAY -> hours(result)
            in ONE_DAY + 1..SECOND_DAY -> println("Пользователь был(а) сегодня")
            in SECOND_DAY + 1..THREE_DAY -> println("Пользователь был(а) вчера")
            else -> println("Пользователь был(а) давно")
        }
    }
}
    fun minutes(result: Int) {
        val resultMinutes = result/60
        if(resultMinutes %10 == 1 && resultMinutes %100 != 11) {
            println("Пользователь был(а) $resultMinutes минуту назад")
        }else if(resultMinutes %100 != 13 && resultMinutes %100 != 12 && resultMinutes %100 != 14 &&( resultMinutes %10 == 2 || resultMinutes %10 == 3 || resultMinutes %10 == 4)){
            println("Пользователь был(а) $resultMinutes минуты назад")
        }else {
            println("Пользователь был(а) $resultMinutes минут назад")
        }

    }
fun hours(result: Int) {
    val resultHours = result/3600
    if (resultHours  == 1 || resultHours  == 21) {
        println("Пользователь был(а) $resultHours час назад")
    } else if (resultHours  == 2 || resultHours  == 3|| resultHours  == 4 || resultHours  == 22 || resultHours == 23 || resultHours == 24) {
        println("Пользователь был(а) $resultHours часа назад")
    } else {
        println("Пользователь был(а) $resultHours часов назад")
    }
}
fun days() {
    val result = Random.nextInt(ONE_DAY..SECOND_DAY)
    if (result  < SECOND_DAY ) {
        println("Пользователь был(а) 1 день назад")
    } else {
        println("Пользователь был(а) 2 дня назад")
    }

}


