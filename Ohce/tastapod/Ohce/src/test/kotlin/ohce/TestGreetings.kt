package ohce

import org.junit.jupiter.api.Test
import java.io.PrintWriter
import java.io.StringWriter
import java.time.LocalDateTime
import kotlin.test.assertEquals

class TestGreetings {

    private fun sayHelloWith(hour: Int, name: String) = with(StringWriter()) {
        sayHello(name, Time(hour = hour), PrintWriter(this))
        toString()
    }

    @Test
    fun `greets different people`() {
        assertEquals("¡Buenos días Diego!", sayHelloWith(7, "Diego"))
        assertEquals("¡Buenos días Dora!", sayHelloWith(7, "Dora"))
    }

    @Test
    fun `greets at different times of day`() {
        assertEquals("¡Buenas noches Diego!", sayHelloWith(0, "Diego"))
        assertEquals("¡Buenas noches Diego!", sayHelloWith(5, "Diego"))
        assertEquals("¡Buenos días Diego!", sayHelloWith(6, "Diego"))
        assertEquals("¡Buenos días Diego!", sayHelloWith(11, "Diego"))
        assertEquals("¡Buenas tardes Diego!", sayHelloWith(12, "Diego"))
        assertEquals("¡Buenas tardes Diego!", sayHelloWith(19, "Diego"))
        assertEquals("¡Buenas noches Diego!", sayHelloWith(20, "Diego"))
        assertEquals("¡Buenas noches Diego!", sayHelloWith(23, "Diego"))
    }

    @Test
    fun `defaults to current time of day`() {
        // For the purists, some double-entry bookkeeping I wouldn't usually bother with
        val currentTime = LocalDateTime.now()
        assertEquals(Time(currentTime.hour, currentTime.minute), now())
    }

    private fun sayGoodbyWith(name: String) = with (StringWriter()) {
        sayGoodbye(name, PrintWriter(this))
        toString()
    }

    @Test
    fun `says goodbye`() {
        assertEquals("Adios Diego", sayGoodbyWith("Diego"))
    }

}
