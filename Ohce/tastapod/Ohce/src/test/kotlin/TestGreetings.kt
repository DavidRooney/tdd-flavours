import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import kotlin.test.assertEquals

class TestGreetings {

    @Test
    fun `greets in the morning`() {
        // given
        // Ohce with clock set to morning
        val output = ByteArrayOutputStream()

        sayHello("Diego", Time(hh=7), output)

        // it says good morning
        assertEquals("¡Buenos días Diego!", output.toString())
    }
}
