package knapsack

class Knapsack(val capacity: Int) {
    private val items = mutableSetOf<Item>()
    private var spaceTaken = 0
    private var cost = 0
    val spaceLeft: Int
        get() = capacity - spaceTaken

    fun put(item: Item) {
        items.add(item)
        spaceTaken += item.weight
        cost += item.cost
    }
}

fun cheapestKnapsack(items: Array<Item>, knapsackCapacity: Int): Knapsack {
    val knapsacks = Array(knapsackCapacity + 1) { i -> Knapsack(i) }
    for (i in 1..items.size) {
        for (k in (knapsackCapacity - 1) downTo items[i].weight) {
            if (knapsacks[k].spaceLeft == items[i].weight) {
                knapsacks[k].put(items[i])
            }
            if (items[k - items[i].weight].cost + items[i].cost > items[k].cost) {

            }
        }
    }

    return knapsacks.last()
}