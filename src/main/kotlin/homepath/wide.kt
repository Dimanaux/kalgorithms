package homepath

fun wide(n: Int): Int =
    when {
        (n == 0 || n % 2 != 0) -> 0
        n == 2 -> 3
        else -> {
            val predecessors = mutableListOf(0, 3)
            var sum = predecessors.sum()
            while (predecessors.size < n / 2 + 1) {
                predecessors.add(sum * 2 + predecessors.last())
                sum += predecessors.last()
            }
            predecessors.last()
        }
    }
