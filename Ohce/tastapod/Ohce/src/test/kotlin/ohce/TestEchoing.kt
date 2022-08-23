package ohce

import org.junit.jupiter.api.Assertions.assertFalse
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

    private fun checkPalindromeWith(input: String) = with(StringWriter()) {
        checkPalindrome(input, PrintWriter(this))
        toString()
    }

    @Test
    fun `recognises palindromes`() {
        assertEquals("", checkPalindromeWith("not a palindrome"))
        assertEquals("¡Bonita palabra!", checkPalindromeWith("abba o abba"))
    }

    @Test
    fun `recognises Stop!`() {
        assertFalse(checkStop("don't stop yet"))
    }
}
