package homepath

fun narrowRecursive(n: Int): Int =
    when (n) {
        0 -> 0
        1 -> 1
        else -> narrowRecursive(n - 1) + narrowRecursive(n - 2)
    }


tailrec
fun narrowTailRecursive(n: Int, pred: Int = 0, succ: Int = 1): Int =
    when (n) {
        0 -> pred
        else -> narrowTailRecursive(n - 1, succ, pred + succ)
    }


fun narrowLoop(n: Int): Int {
    var pred = 0
    var succ = 1
    var newSucc: Int
    for (i in 1..n) {
        newSucc = pred + succ
        pred = succ
        succ = newSucc
    }
    return pred
}
