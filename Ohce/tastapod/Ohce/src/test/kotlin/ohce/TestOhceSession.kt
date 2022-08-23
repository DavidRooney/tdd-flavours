package ohce

import org.junit.jupiter.api.Test
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.test.assertEquals


class TestOhceSession {
    @Test
    fun `runs an ohce session`() {
        val name = "Pedro"
        val time = Time(hour = 8)

        val inputLines = """
            hola
            oto
            stop
            Stop!
        """.trimIndent()


        val input = inputLines.splitToSequence("\n")
        val output = StringWriter()

        ohceSession(name, time, input, PrintWriter(output))

        val expected = """
            ¡Buenos días Pedro!
            aloh
            oto
            ¡Bonita palabra!
            pots
            Adios Pedro
        """.trimIndent() + "\n"

        assertEquals(expected, output.toString())
    }
}
