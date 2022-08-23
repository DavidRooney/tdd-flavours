package ohce

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.test.assertEquals

class TestEchoing {
    private fun ohceWith(input: String) = with(StringWriter()) {
        ohce(input, PrintWriter(this))
        toString()
    }

    @Test
    fun `reverses its input`() {
        assertEquals("sdrawkcab", ohceWith("backwards"))
        assertEquals("abba", ohceWith("abba"))
    }

    @Test
    fun `recognises palindromes`() {
        assertFalse(isPalindrome("not a palindrome"))
        assertTrue(isPalindrome("abba o abba"))
    }

    @Test
    fun `recognises Stop!`() {
        assertFalse(isStop("don't stop yet"))
        assertTrue(isStop("Stop!"))
    }
}
