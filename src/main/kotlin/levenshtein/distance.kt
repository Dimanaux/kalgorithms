package levenshtein

import kotlin.math.min

fun min(a: Int, b: Int, c: Int) = min(a, min(b, c))

/**
 * Finds Levenshtein distance.
 * Levenshtein distance is equal to minimum number of transformation
 * applied to the first sequence to get the second sequence (String).
 * Transformation can be:
 * 1) Drop a character
 * 2) Add any character
 * 3) Replace any character to another
 * Takes O(n * m) both time and space.
 */
fun distance(a: String, b: String): Int {
    /**
     * Create a table, and initialize it like this:
     * 0 1 2 3 4 5 ... b.length
     * 1 0 0 0 0 0
     * 2 0 0 0 0 0
     * 3 0 0 0 0 0
     * 4 0 0 0 0 0
     * ...
     * a.length ...
     * It represents the distance between a.substring(i)
     * and b.substring(j) where x.substring(n) = first n characters of x.
     * Distance between "" and "" is 0.
     * Distance between "" and any string of length x is x (just add those x characters).
     */
    val distance = Array(a.length + 1) { i ->
        IntArray(b.length + 1) { j ->
            if (j == 0 || i == 0) i + j
            else 0
        }
    }

    /**
     * What is distance between a.substring(i) and b.substring(j)?
     * If a[i] = b[j] then it is the same as a.substring(i - 1) and b.substring(j - 1),
     * because if we don't have to change this last character to get strings equal.
     * Only some of the previous.
     * Otherwise it we have to drop the last char/add one/replace it from/to/in some string.
     * And since we know the distance of substrings of less size, we can just find minimum from them
     * and add 1 to get distance for current substrings.
     */
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            distance[i][j] =
                if (a[i - 1] == b[j - 1]) {
                    distance[i - 1][j - 1]
                } else {
                    1 + min(
                        distance[i - 1][j],
                        distance[i][j - 1],
                        distance[i - 1][j - 1]
                    )
                }
        }
    }
    return distance[a.length][b.length]
}
