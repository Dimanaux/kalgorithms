package trapeze

import java.util.*
import kotlin.collections.ArrayList

data class Trapeze(val firstAngle: Int, val secondAngle: Int) {
    constructor(b: Int, c: Int, d: Int) : this(b, c - d)

    var id = 0
    fun id(id: Int): Trapeze {
        this.id = id
        return this
    }
}

/**
 *  Tells the order of trapezes on metal tape
 *  which produces no waste
 */
fun trapezes(trapezes: Set<Trapeze>): List<Trapeze> {
    val graph = mutableMapOf<Int, MutableSet<Trapeze>>()

    for (trapeze in trapezes) {
        val (f, _) = trapeze
        if (graph[f] == null) {
            graph[f] = mutableSetOf()
        }
        graph[f]!!.add(trapeze)
    }

    val tempStack = LinkedList<Trapeze>()
    val path = ArrayList<Trapeze>(trapezes.size)

    var currentNode = 0

    do {
        val adjacent = graph[currentNode] ?: throw IllegalArgumentException("No way.")
        val next = adjacent.firstOrNull()

        // if unexplored adjacent nodes present
        if (next != null) {
            // remember it
            tempStack.push(next)
            // mark as explored
            adjacent.remove(next)
            // proceed to this node
            currentNode = next.secondAngle
        } else {
            if (tempStack.isEmpty()) {
                throw IllegalArgumentException("No way.")
            }
            // step back
            val trapeze = tempStack.pop()
            // this is the last known node of way out
            path.add(trapeze)
            currentNode = trapeze.firstAngle
        }
    } while (tempStack.isNotEmpty())

    // add remembered note to map
    while (tempStack.isNotEmpty()) {
        path.add(tempStack.pop())
    }

    // we added them from end to begin
    return path.reversed()
}

