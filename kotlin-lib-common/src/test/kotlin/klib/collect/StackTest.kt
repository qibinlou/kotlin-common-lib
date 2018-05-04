package klib.collect

import klib.collect.exception.EmptyStackException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class StackTest {

    @Test
    fun testPushInt() {
        val stack = Stack<Int>()
        stack.push(0)
        stack.push(0)
        stack.push(1)
        stack.push(-1)
        stack.push(0)
        assertEquals(stack.size, 5)
        assertEquals(stack.peak(), 0)
    }

    @Test
    fun testPushString() {
        val stack = Stack<String>()
        stack.push("")
        stack.push(" ")
        stack.push("a")
        stack.push("b")
        stack.push("")
        assertEquals(stack.size, 5)
        assertEquals(stack.peak(), "")
    }

    @Test
    fun testPushNullableString() {
        val stack = Stack<String?>()
        stack.push("")
        stack.push(" ")
        stack.push(null)
        assertEquals(stack.size, 3)
        assertEquals(stack.peak(), null)
        stack.push("a")
        stack.push("a")
        assertEquals(stack.size, 5)
        assertEquals(stack.peak(), "a")
    }

    @Test
    fun testIsEmpty() {
        val stack = Stack<Double>()
        assertTrue(stack.isEmpty())
        stack.push(0.618)
        assertFalse(stack.isEmpty())
        stack.pop()
        assertTrue(stack.isEmpty())
    }

    @Test
    fun testPop() {
        val stack = Stack<Any?>()
        stack.push(0)
        stack.push(3.14)
        stack.push("foo")
        stack.push(EmptyStackException())
        stack.push(null)
        assertEquals(stack.size, 5)
        assertEquals(stack.pop(), null)
        assertTrue(stack.pop() is EmptyStackException)
        assertTrue(stack.pop() == "foo")
        assertTrue(stack.pop() == 3.14)
        assertTrue(stack.pop() == 0)

    }


}
