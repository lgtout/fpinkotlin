package com.fpinkotlin.functions.exercise02


fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C = { a -> f(g(a)) }

// Define a generic compose. The exercise dos not consist in writing the implementation, but the signature.