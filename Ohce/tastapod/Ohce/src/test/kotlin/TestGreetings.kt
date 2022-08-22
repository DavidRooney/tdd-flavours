import org.junit.jupiter.api.Test
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.test.assertEquals

class TestGreetings {

    fun greet(hh: Int, name: String): String {
        val output = StringWriter()
        sayHello(name, Time(hh=hh), PrintWriter(output))
        return output.toString()
    }

    @Test
    fun `greets different people`() {
        assertEquals("¡Buenos días Diego!", greet(7, "Diego"))
        assertEquals("¡Buenos días Dora!", greet(7, "Dora"))
    }

    @Test
    fun `greets at different times of day`() {
        assertEquals("¡Buenas noches Diego!", greet(20, "Diego"))
    }
}
