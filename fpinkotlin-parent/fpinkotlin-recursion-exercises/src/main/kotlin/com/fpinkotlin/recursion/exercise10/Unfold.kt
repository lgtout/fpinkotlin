package com.fpinkotlin.recursion.exercise10


fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    var el = seed
    val result = mutableListOf<T>()
    while (p(el)) {
        result.add(el)
        el = f(el)
    }
    return result
}

