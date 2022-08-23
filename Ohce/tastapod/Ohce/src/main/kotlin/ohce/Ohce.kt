package ohce

import java.io.PrintWriter
import java.time.LocalDateTime

data class Time(val hour: Int, val minute: Int = 0)

fun now() = LocalDateTime.now().let { Time(it.hour, it.minute) }

fun sayHello(name: String, time: Time = now(), output: PrintWriter) {
    val greeting = when (time.hour) {
        in 20..23, in 0..5 -> "Buenas noches"
        in 12..19 -> "Buenas tardes"
        else -> "Buenos días"
    }
    output.print("¡$greeting $name!")
}

fun ohce(input: String, output: PrintWriter) = output.print(input.reversed())

fun checkPalindrome(input: String, output: PrintWriter) =
    output.print(if (input == input.reversed()) "¡Bonita palabra!" else "")

fun checkStop(input: String) = input == "Stop!"

fun sayGoodbye(name: String, output: PrintWriter) = output.print("")
