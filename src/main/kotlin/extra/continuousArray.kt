package extra

/**
 * finds missing item in continuous array
 * missingItem 0,..(i-1),(i+1),..(n-1)
 * will return i
 */
fun missingItem(sequence: Sequence<Int>): Int {
    var sum = 0
    var count = 0
    sequence.forEach { x ->
        count += 1
        sum += x
    }
    return count * (count + 1) / 2 - sum
}

fun missingItem(array: Array<Int>): Int {
    return array.size * (array.size + 1) / 2 - array.sum()
}

fun twoMissingItems(array: Array<Int>): Set<Int> {
    val missing = (0..(array.size + 2)).toMutableSet()
    array.forEach { item -> missing.remove(item) }
    return missing
}

fun twoMissingItems2(array: Array<Int>): Set<Int> {
    val missing = BooleanArray(array.size + 2) { true }
    array.forEach { missing[it] = false }
    val missingItems = mutableSetOf<Int>()
    missing.forEachIndexed { i, b ->
        if (b) {
            missingItems.add(i)
        }
    }
    return missingItems
}
