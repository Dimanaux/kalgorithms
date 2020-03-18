package trapeze

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class TrapezeTest {
    /*
     *  50 140 100
     *  40 60 60
     *  0 80 30
     */
    @Test
    fun test() {
        assertEquals(
            listOf(3, 1, 2),
            trapezes(
                setOf(
                    Trapeze(50, 140, 100).id(1),
                    Trapeze(40, 60, 60).id(2),
                    Trapeze(0, 80, 30).id(3)
                )
            ).map { it.id }
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun test3() {
        assertEquals(
            listOf(1),
            trapezes(fixture("t3.txt").toSet())
        )
    }

    @Test
    fun test7() {
        assertEquals(
            listOf(1),
            trapezes(fixture("t7.txt").toSet())
        )
    }

    @Test
    fun test9() {
        assertEquals(
            listOf(1),
            trapezes(fixture("t9.txt").toSet())
        )
    }

    private fun fixture(file: String): List<Trapeze> {
        val traps = ArrayList<Trapeze>(1000)
        val scanner = Scanner(File(file))
        var i = 1
        while (scanner.hasNext()) {
            traps.add(
                Trapeze(
                    scanner.nextInt(), scanner.nextInt(), scanner.nextInt()
                ).id(i)
            )
            i++
        }
        return traps
    }
}
