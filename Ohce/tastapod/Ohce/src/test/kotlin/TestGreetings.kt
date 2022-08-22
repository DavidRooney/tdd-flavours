import org.junit.jupiter.api.Test
import java.io.PrintWriter
import java.io.StringWriter
import java.time.LocalDateTime
import kotlin.test.assertEquals

class TestGreetings {

    fun greet(hour: Int, name: String): String {
        val output = StringWriter()
        sayHello(name, Time(hour = hour), PrintWriter(output))
        return output.toString()
    }

    @Test
    fun `greets different people`() {
        assertEquals("¡Buenos días Diego!", greet(7, "Diego"))
        assertEquals("¡Buenos días Dora!", greet(7, "Dora"))
    }

    @Test
    fun `greets at different times of day`() {
        assertEquals("¡Buenas noches Diego!", greet(0, "Diego"))
        assertEquals("¡Buenas noches Diego!", greet(5, "Diego"))
        assertEquals("¡Buenos días Diego!", greet(6, "Diego"))
        assertEquals("¡Buenos días Diego!", greet(11, "Diego"))
        assertEquals("¡Buenas tardes Diego!", greet(12, "Diego"))
        assertEquals("¡Buenas tardes Diego!", greet(19, "Diego"))
        assertEquals("¡Buenas noches Diego!", greet(20, "Diego"))
        assertEquals("¡Buenas noches Diego!", greet(23, "Diego"))
    }

    @Test
    fun `defaults to current time of day`() {
        // For the purists, some double-entry bookkeeping I wouldn't usually bother with
        val now = LocalDateTime.now()
        assertEquals(Time(now.hour, now.minute), now())
    }
}
