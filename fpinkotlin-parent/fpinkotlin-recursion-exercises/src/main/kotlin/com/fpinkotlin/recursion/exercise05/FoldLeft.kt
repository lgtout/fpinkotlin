package com.fpinkotlin.recursion.exercise05

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

tailrec fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U =
    if (list.isEmpty()) z
    else foldLeft(list.tail(), f(z, list.head()), f)

fun sum(list: List<Int>): Int = foldLeft(list, 0, Int::plus)

fun string(list: List<Char>): String = foldLeft(list, "", String::plus)
