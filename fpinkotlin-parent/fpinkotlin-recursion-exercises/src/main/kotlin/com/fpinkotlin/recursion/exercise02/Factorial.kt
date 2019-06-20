package com.fpinkotlin.recursion.exercise02

object Factorial {
    val factorial1: (Int) -> Int = { n ->
        fun foo(n: Int): Int {
            return if (n == 0) 1
            else n * foo(n - 1)
        }
        foo(n)
    }
    val factorial2: (Int) -> Int = { n ->
        if (n == 0) 1
        else n * foo(n - 1)
    }
    private fun foo(n: Int): Int {
        return factorial2(n)
    }
    lateinit var factorial3: (Int) -> Int
    init {
        factorial3 = { n ->
            if (n == 0) 1
            else n * factorial(n - 1)
        }
    }
    val factorial: (Int) -> Int by lazy { { n: Int ->
        if (n == 0) 1
        else n * factorial(n - 1)
    } }
}