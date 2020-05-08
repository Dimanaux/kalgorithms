package cities

import java.util.*
import kotlin.collections.ArrayList

/**
 * Find first suitable city
 */
fun first(cities: Set<String>, graph: Map<Char, MutableSet<String>>): Char {
    val firstCandidates = cities.map(String::first).toSet() - cities.map(String::last)
    return firstCandidates.firstOrNull() ?: graph.keys.first()
}

/**
 * Map has no empty sets
 */
fun MutableMap<Char, MutableSet<String>>.notEmpty() : Boolean {
    for ((_, set) in this) {
        if (set.isNotEmpty()) {
            return true
        }
    }
    return false
}

fun cities(cities: Set<String>): List<String> {
    val graph: MutableMap<Char, MutableSet<String>> = mutableMapOf()
    for (city in cities) {
        graph.putIfAbsent(city.first(), mutableSetOf())
        graph[city.first()]!!.add(city)
    }

    val tempStack = LinkedList<String>()
    val game = ArrayList<String>(cities.size)

    var currentNode = first(cities, graph)

    do {
        val adjacent = graph[currentNode]
        val next = adjacent?.firstOrNull()

        // if unexplored adjacent nodes present
        if (next != null) {
            // remember it
            tempStack.push(next)
            // mark as explored
            adjacent.remove(next)
            // proceed to this node
            currentNode = next.last()
        } else {
            if (tempStack.isEmpty()) {
                break
            }
            // step back
            val trapeze = tempStack.pop()
            // this is the last known node of way out
            game.add(trapeze)
            currentNode = trapeze.first()
        }
    } while (graph.notEmpty())

    // add remembered note to map
    while (tempStack.isNotEmpty()) {
        game.add(tempStack.pop())
    }
    return game.reversed()
}
