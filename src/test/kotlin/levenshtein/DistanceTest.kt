package levenshtein

import junit.framework.Assert.assertEquals
import org.junit.Test

class DistanceTest {
    @Test
    fun simpleTest() = assertEquals(2, distance("moloko", "kolokol"))

    @Test
    fun sillyTest() = assertEquals(3, distance("aaa", "bb"))

    @Test
    fun emptyTest() = assertEquals(0, distance("", ""))

    @Test
    fun oneEmptyTest() = assertEquals(3, distance("", "abc"))

    @Test
    fun equalTest() = assertEquals(0, distance("abc", "abc"))
}