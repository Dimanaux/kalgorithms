package cities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CitiesTest {
    @Test
    fun `should work`() {
        assertEquals(
            listOf("KAZAN", "NIL", "LOS-ANGELES", "SAMARA"),
            cities(setOf("KAZAN", "NIL", "LOS-ANGELES", "SAMARA"))
        )
    }

    @Test
    fun `should work again`() {
        assertEquals(
            listOf("KAZAN", "NIL", "LOS-ANGELES", "SAMARA"),
            cities(setOf("NIL", "LOS-ANGELES", "KAZAN", "SAMARA"))
        )
    }

    @Test
    fun `kk k`() {

    }
}