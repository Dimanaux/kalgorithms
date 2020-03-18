package glass

import java.lang.Integer.max
import java.lang.Math.min

fun throwsCount(height: Int, balls: Int): Int {
    /**
     * start with table
     * \ 0 1 2 3 4 5 ...
     * 0 0 0 0 0 0 0
     * 1 0 1 1 1 1 1
     * 2 0
     * 3 0
     * 4 0
     * 5 0
     * .
     * .
     * .
     */
    val d = Array(balls + 1) { ball ->
        IntArray(height + 1) { floor ->
            when {
                ball == 0 -> 0
                floor == 1 -> 1
                ball == 1 -> floor
                floor == 0 -> 0
                else -> 10000
            }
        }
    }

    for (ballsLeft in 2..balls) {
        for (floor in 2..height) {
            for (drop in 1..floor) {
                d[ballsLeft][floor] = min(
                    d[ballsLeft][floor],
                    1 + max(d[ballsLeft - 1][drop - 1], d[ballsLeft][floor - drop])
                )
            }
        }
    }

    return d[balls][height]
}
