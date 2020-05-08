package extra

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContinuousArrayKtTest {
    @Test
    fun missingItemTest() {
        assertEquals(
            23,
            missingItem((0..40).skip(23))
        )
    }

    @Test
    fun missingFirst() {
        assertEquals(
            0,
            missingItem((0..40).skip(0))
        )
    }

    private fun IntRange.skip(oneElement: Int) =
        this.filter { it != oneElement }.asSequence()
}