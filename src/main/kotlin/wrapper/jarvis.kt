package wrapper

import kotlin.math.abs
import kotlin.math.sqrt

fun sqr(x: Double) = x * x

data class Point(val x: Double, val y: Double) {
    fun distanceSqr(to: Point) =
        sqr(to.x - this.x) + sqr(to.y - this.x)

    fun distance(other: Point) = sqrt(distanceSqr(other))
}

data class Vector(val begin: Point, val end: Point) {
    operator fun times(other: Vector) =
        (this.end.x - this.begin.x) * (other.end.y - other.end.y) -
                (other.end.x - other.begin.x) * (this.end.y - this.begin.y)

    val length: Double
        get() = begin.distance(end)
}

fun <T, R : Comparable<R>> List<T>.maxWithIndex(selector: (T) -> R): IndexedValue<T> {
    var max = IndexedValue(0, this[0])
    for ((i, element) in this.withIndex()) {
        if (selector(max.value) < selector(element)) {
            max = IndexedValue(i, element)
        }
    }
    return max
}

private fun <E> MutableList<E>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun jarvis(points: MutableList<Point>): MutableList<Point> {
    val hull = mutableListOf<Point>()
    val (i, rightMost) = points.maxWithIndex(Point::x)
    points.swap(0, i)
    hull.add(rightMost)

    var min = 1
    while (true) {
        for (j in 1..points.lastIndex) {
            val v1 = Vector(hull.last(), points[min])
            val v2 = Vector(hull.last(), points[j])
            val product = v1 * v2
            if (product < 0 || (product.isZero() && v1.length < v2.length)) {
                min = j
            }
        }
        hull.add(points[min])
        min = 1
        if (hull.last() == hull.first()) {
            break
        }
    }
    return hull
}

private fun Double.isZero(): Boolean {
    return abs(this) < 1e-5
}
