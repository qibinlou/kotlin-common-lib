package klib.collect

import klib.collect.exception.EmptyStackException


class Stack<E> : IStack<E> {

    private var elements: MutableList<E> = mutableListOf()

    override val size: Int
        get() = elements.size

    override fun push(element: E) {
        elements.add(element)
    }

    override fun pop(): E {
        if (elements.isEmpty()) {
            throw EmptyStackException()
        }
        val element = elements.last()
        elements.removeAt(elements.lastIndex)
        return element
    }

    override fun peak(): E {
        if (elements.isEmpty()) {
            throw EmptyStackException()
        }
        return elements.last()
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

}