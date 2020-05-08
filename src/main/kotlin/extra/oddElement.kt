package extra

fun oddElement(sequence: Sequence<Int>) =
    sequence.reduce(Int::xor)
