import org.junit.jupiter.api.Test
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.test.assertEquals

class TestEchoing {
    private fun ohceWith(input: String): String {
        val output = StringWriter()
        ohce(input, PrintWriter(output))
        return output.toString()
    }

    @Test
    fun `reverses its input`() {
        assertEquals("sdrawkcab", ohceWith("backwards"))
    }
}
