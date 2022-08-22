import org.junit.jupiter.api.Test
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.test.assertEquals

class TestGreetings {

    @Test
    fun `greets in the morning`() {
        // given
        // Ohce with clock set to morning
        val output = StringWriter()

        sayHello("Diego", Time(hh=7), PrintWriter(output))

        // it says good morning
        assertEquals("¡Buenos días Diego!", output.toString())
    }
}
