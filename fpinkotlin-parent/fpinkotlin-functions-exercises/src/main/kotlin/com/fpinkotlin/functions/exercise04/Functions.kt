package com.fpinkotlin.functions.exercise04


class Functions

fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

fun <T, U, V> compose(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }

val add: (Int) -> (Int) -> Int = { a -> { b -> a + b } }

// Define a value function composing two (Int) -> Int functions
val compose: ((Int) -> Int) -> ((Int) -> Int) -> ((Int) -> Int) = { a: (Int) -> Int ->
    { b: (Int) -> Int ->
        { n: Int -> a(b(n)) }
    }
}