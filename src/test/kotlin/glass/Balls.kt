package glass

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Balls {
    @Test
    fun withOneBall() {
        mapOf(
            5 to 5,
            7 to 7,
            8 to 8,
            10 to 10,
            93 to 93,
            99 to 99,
            102 to 102,
            104 to 104
        ).forEach { (height, expected) ->
                assertEquals(
                    expected, throwsCount(height, 1),
                    "throwsCount($height, 1)"
                )
            }
    }

    @Test
    fun withTwoBalls() {
        mapOf(
            5 to 3,
            7 to 4,
            8 to 4,
            10 to 4,
            93 to 14,
            99 to 14,
            102 to 14,
            104 to 14
        ).forEach { (height, expected) ->
            assertEquals(
                expected, throwsCount(height, 2),
                "throwsCount($height, 2)"
            )
        }
    }

    @Test
    fun withThreeBalls() {
        mapOf(
            5 to 3,
            7 to 3,
            8 to 4,
            10 to 4,
            93 to 9,
            99 to 9,
            102 to 9,
            104 to 9
        ).forEach { (height, expected) ->
            assertEquals(
                expected, throwsCount(height, 3),
                "throwsCount($height, 3)"
            )
        }
    }
}