package combinations

import java.util.*

fun combinations(n: Int, m: Int): Int {
    val row = LinkedList<Int>()
    row.add(0)
    row.add(1)
    row.add(0)
    repeat(n) {
        val iter = row.listIterator()
        var pred = iter.next()
        while (iter.hasNext()) {
            val succ = iter.next()
            iter.set(pred + succ)
            pred = succ
        }
        row.add(0)
    }
    return row[m + 1]
}

