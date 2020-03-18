package homepath

import org.junit.Assert.assertEquals
import org.junit.Test

class WideTest {
    @Test
    fun testWide() {
        assertEquals(0, wide(0))
        assertEquals(3, wide(2))
        assertEquals(9, wide(4))
        assertEquals(33, wide(6))
        assertEquals(123, wide(8))
        assertEquals(459, wide(10))
    }
}