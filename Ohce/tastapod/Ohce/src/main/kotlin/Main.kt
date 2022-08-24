import ohce.now
import ohce.ohceSession
import java.io.PrintWriter

fun main(args: Array<String>) {
    ohceSession(args[0], now(), generateSequence { readLine() }, PrintWriter(System.out, true))
}
