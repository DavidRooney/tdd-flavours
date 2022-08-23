package ohce

import java.io.PrintWriter
import java.time.LocalDateTime

data class Time(val hour: Int, val minute: Int = 0)

fun now() = LocalDateTime.now().run { Time(hour = hour, minute = minute) }

fun sayHello(name: String, time: Time = now(), output: PrintWriter) {
    val greeting = when (time.hour) {
        in 20..23, in 0..5 -> "Buenas noches"
        in 12..19 -> "Buenas tardes"
        else -> "Buenos días"
    }
    output.print("¡$greeting $name!")
}

fun ohce(input: String, output: PrintWriter) =
    output.print(input.reversed())

fun isPalindrome(input: String) = input == input.reversed()

fun isStop(input: String) = input == "Stop!"

fun sayGoodbye(name: String, output: PrintWriter) =
    output.print("Adios $name")

fun ohceSession(
    name: String,
    time: Time = now(),
    input: Sequence<String> = generateSequence { readLine() },
    output: PrintWriter = PrintWriter(System.out, true) //autoflush
) {
    fun println(fn: () -> Unit) = output.run { fn(); println() }

    // start
    println { sayHello(name, time, output) }

    // iterate on input
    for (line in input) {
        if (isStop(line)) {
            break
        }

        println { ohce(line, output) }

        if (isPalindrome(line)) {
            output.println("¡Bonita palabra!")
        }
    }
    println { sayGoodbye(name, output) }
}
