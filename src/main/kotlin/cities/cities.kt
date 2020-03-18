package cities

class Cities(val cities: Set<String>) {
    private val graph = mutableMapOf<String, List<String>>()

    init {
        // KAZAN, NIL, LOS-ANGELES, SAMARA
        // { KAZAN: [NIL], NIL: [LOS-ANGELES], LOS-ANGELES: [SAMARA], SAMARA: [] }
        cities.forEach { predecessor ->
            graph[predecessor] = cities.filter { successor ->
                predecessor.last() == successor.first() && predecessor != successor
            }
        }
    }

    fun play(): List<String>? {
        val firstCandidates = cities.toMutableSet()
        for ((_, successors) in graph) {
            firstCandidates.removeAll(successors)
        }
        var predecessor = firstCandidates.firstOrNull() ?: graph.keys.first()
        while (graph.isNotEmpty()) {
        }
        return TODO()
    }

    private fun nextFor(predecessor: String) {

    }
}