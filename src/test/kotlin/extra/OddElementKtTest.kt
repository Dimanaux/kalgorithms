package extra

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OddElementKtTest {
    @Test
    fun oddElementTest() {
        assertEquals(
            3,
            oddElement(listOf(1, 2, 3, 2, 1).asSequence())
        )
    }

    @Test
    fun oddElementWithZero() {
        assertEquals(
            0,
            oddElement(listOf(0, 4, 3, 3, 4).asSequence())
        )
    }
}
