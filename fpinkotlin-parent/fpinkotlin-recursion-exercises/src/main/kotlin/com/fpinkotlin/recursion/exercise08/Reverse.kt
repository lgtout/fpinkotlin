package com.fpinkotlin.recursion.exercise08

import com.fpinkotlin.recursion.exercise06.foldRight


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

fun <T> prepend(list: List<T>, elem: T): List<T> =
    (list.reversed() + elem).reversed()

fun <T> reverse(list: List<T>): List<T> = foldLeft(list, emptyList(), ::prepend)

fun <T> prepend1(list: List<T>, elem: T): List<T> =
        foldLeft(list, listOf(elem)) { ls, el -> ls + el}

fun <T> reverse1(list: List<T>): List<T> = foldLeft(list, emptyList(), ::prepend1)

fun <T> reverse2(list: List<T>): List<T> = foldLeft(list, emptyList(),
    { ls: List<T>, elem: T ->  ls + elem }).reversed()
