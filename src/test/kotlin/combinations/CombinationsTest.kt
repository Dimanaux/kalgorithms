package combinations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombinationsTest {
    @Test
    fun test() {
        assertEquals(1, combinations(0, 0))

        assertEquals(1, combinations(1, 0))
        assertEquals(1, combinations(1, 1))

        assertEquals(1, combinations(2, 0))
        assertEquals(2, combinations(2, 1))
        assertEquals(1, combinations(2, 2))

        assertEquals(1, combinations(3, 0))
        assertEquals(3, combinations(3, 1))
        assertEquals(3, combinations(3, 2))
        assertEquals(1, combinations(3, 3))

        assertEquals(1, combinations(4, 0))
        assertEquals(4, combinations(4, 1))
        assertEquals(6, combinations(4, 2))
        assertEquals(4, combinations(4, 3))
        assertEquals(1, combinations(4, 4))
    }
}