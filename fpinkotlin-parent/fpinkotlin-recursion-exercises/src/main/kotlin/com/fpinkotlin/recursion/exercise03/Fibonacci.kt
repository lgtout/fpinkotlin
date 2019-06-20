package com.fpinkotlin.recursion.exercise03

import java.math.BigInteger

fun fib(x: Int): BigInteger {
    var result = BigInteger.ZERO
    fun go(nMinusOne: Int, nMinusTwo: Int) {
        if (nMinusOne == 1 && nMinusTwo == 0) result += BigInteger.valueOf(2)
        else if (nMinusOne == 1 && nMinusTwo == 0) result += BigInteger.ONE
        else  
        TODO()
    }
    TODO()
//    return go(x)
//    return if (x == 0 || x == 1) BigInteger.ONE
//    else fib1(x - 1) + fib1(x - 2)
}

fun fib3(x: Int): BigInteger {
    var r: Triple<BigInteger, Int, Int>
    fun go(a: Int, b: Int, r: Triple<BigInteger, Int, Int>):
            Triple<BigInteger, Int, Int> {
        return when {
            a == 0 -> r.copy(r.first + BigInteger.ONE, 0)
            b == 0 -> r.copy(r.first + BigInteger.ONE, third = 0)
            a > 0 -> go(a - 1, a - 2, r)
            b > 0 -> go(b - 1, b - 2, r)
            else -> r
        }
    }
//    go(x - 1, x - 2, Triple(BigInteger.ZERO, ))
//    return r
    TODO()
}

fun fib2(a: Int, b: Int): BigInteger {
    val left = if (a == 0) BigInteger.ONE
    else fib2(a - 1, a - 2)
    val right = if (b == 0) BigInteger.ONE
    else fib2(b - 1, b - 2)
    return left + right
}

fun fib1(x: Int): BigInteger {
    return if (x == 0 || x == 1) BigInteger.ONE
    else fib1(x - 1) + fib1(x - 2)
}

fun main(args: Array<String>) {
    listOf(fib1(0),
        fib1(1),
        fib1(2),
        fib1(3),
        fib1(4),
        fib1(5)).withIndex().toList().let {
        println(it)
    }
}
