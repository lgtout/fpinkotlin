package com.fpinkotlin.recursion.exercise14


fun <T> List<T>.head(): T =
    if (this.isEmpty())
        throw IllegalArgumentException("head called on empty list")
    else
        this[0]

fun <T> List<T>.tail(): List<T> =
    if (this.isEmpty())
        throw IllegalArgumentException("tail called on empty list")
    else
        this.subList(1, this.size)

fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U {
    tailrec fun foldLeft_(list: List<T>, acc: U, f: (U, T) -> U): U =
        if (list.isEmpty())
            acc
        else
            foldLeft_(list.tail(), f(acc, list.head()), f)
    return foldLeft_(list, z, f)
}

fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    tailrec fun go(seed: T, acc: List<T>): List<T> {
        return if (!p(seed)) acc
        else {
            val nextSeed = f(seed)
            go(nextSeed, acc + seed)
//            go(nextSeed, foldLeft(acc, listOf(seed)) { lst, elm -> listOf(elm) + lst })
        }
    }
    return go(seed, emptyList())
}
