import java.io.PrintWriter

data class Time(val hh: Int, val mm: Int = 0)

fun sayHello(name: String, time: Time, output: PrintWriter) {
    output.print("¡Buenos días $name!")
}
