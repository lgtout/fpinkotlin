package com.fpinkotlin.recursion.exercise01


tailrec fun add(a: Int, b: Int): Int = if (a == 0) b else add(inc(a), dec(b))

fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

