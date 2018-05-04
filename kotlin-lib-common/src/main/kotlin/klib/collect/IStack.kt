package klib.collect


interface IStack<E> {
    val size: Int

    fun push(element: E)
    fun pop(): E
    fun peak(): E
    fun isEmpty(): Boolean
}