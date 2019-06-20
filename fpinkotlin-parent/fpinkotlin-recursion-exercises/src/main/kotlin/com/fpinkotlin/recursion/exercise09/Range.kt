package com.fpinkotlin.recursion.exercise09


fun range(start: Int, end: Int): List<Int> {
    if (start >= end) return emptyList()
    var i = start
    var l = emptyList<Int>()
    while (i < end) {
        l = l + i
        i += 1
    }
    return l
}