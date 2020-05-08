package homepath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

class NarrowTest {
    @Test
    @Disabled
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    fun recursiveNaive() {
        testSome { narrowRecursive(it) }
    }

    @Test
    fun recursive() {
        testSome { narrowTailRecursive(it) }
    }

    @Test
    fun loop() {
        testSome { narrowLoop(it) }
    }

    private inline
    fun testSome(narrow: (Int) -> Int) {
        repeat(1_000_000_000) {
            assertEquals(0, narrow(0))
            assertEquals(1, narrow(1))
            assertEquals(1, narrow(2))
            assertEquals(2, narrow(3))
            assertEquals(3, narrow(4))
            assertEquals(5, narrow(5))
            assertEquals(17711, narrow(22))
            assertEquals(102334155, narrow(40))
            assertEquals(165580141, narrow(41))
        }
    }
}
