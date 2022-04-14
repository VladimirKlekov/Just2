package ru.netology

import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.minutes

const val ONE_MINUTE = 60
const val ONE_HOUR = 3600
const val ONE_DAY = 86400
const val SECOND_DAY = 172800
const val THREE_DAY = 259200


const val TEXT_ONE_MINUTE: String = " минуту назад. "
const val TEXT_TWO_MINUTES: String = " минуты назад "
const val TEXT_MINUT: String = " минут назад "
const val TEXT_HOUR_AGO: String = " час назад "
const val TEXT_HOUR_AGO_A: String = " часа назад "
const val TEXT_HOUR_AGO_OV: String = " часов назад "

fun main() {

    while (true) {
        var result = Random.nextInt(0..THREE_DAY)
        println("Выберите действие")
        println("1.Автоматический режим")
        println("2.Ручной режим")
        println("Введите end для выхода из программы")
        println("_____________________________________")

        val chek = readln()
        if (chek == "end") {
            println("Программа завершена! Спасибо за помощь в учебе!!!\uD83E\uDD17")
            break
        }
        val input = chek?.toInt()

        when (input) {
            1 -> print(result)
            2 -> {
                println("Введите количество секунд"); result = readln().toInt(); print(result)
            }
            else -> {
                print("Ошибка ввода. Выберите правильный вариант")
            }

        }
    }
}

fun print(result: Int) {
    println("_____________________________________")
    print("Пользователь был(а) ")
    println(agoToTextMinutes(result))
    println("_____________________________________")
}

fun agoToTextMinutes(result: Int): String {
    when (result) {
        in 0 until ONE_MINUTE -> return "только что"
        in ONE_MINUTE until ONE_HOUR -> return checkingMinutes(result)
        in ONE_HOUR until ONE_DAY -> return checkingHours(result)
        in ONE_DAY until SECOND_DAY -> return "сегодня \uD83E\uDD15"
        in SECOND_DAY until THREE_DAY -> return "вчера \uD83D\uDE34"
        else -> return "давно ☠"
    }
}

fun checkingMinutes(result: Int): String {
    val resultMinutes = result / 60
    if (resultMinutes % 10 == 1 && resultMinutes % 100 != 11) {
        val answer = resultMinutes.toString()
        return answer + TEXT_ONE_MINUTE
    } else if (resultMinutes % 100 != 13 && resultMinutes % 100 != 12 && resultMinutes % 100 != 14 && (resultMinutes % 10 == 2 || resultMinutes % 10 == 3 || resultMinutes % 10 == 4)) {
        val answer = resultMinutes.toString()
        return answer + TEXT_TWO_MINUTES
    } else {
        val answer = resultMinutes.toString()
        return answer + TEXT_MINUT
    }

}

fun checkingHours(result: Int): String {
    val resultHours = result / 3600
    if (resultHours == 1 || resultHours == 21) {
        val answer = resultHours.toString()
        return answer + TEXT_HOUR_AGO
    } else if (resultHours == 2 || resultHours == 3 || resultHours == 4 || resultHours == 22 || resultHours == 23 || resultHours == 24) {
        val answer = resultHours.toString()
        return answer + TEXT_HOUR_AGO_A
    } else {
        val answer = resultHours.toString()
        return answer + TEXT_HOUR_AGO_OV

    }
}









