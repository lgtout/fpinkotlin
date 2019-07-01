package com.fpinkotlin.lists.exercise18


import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class ListTest: StringSpec() {

    init {

        "mapViaFoldLeft" {
            forAll(IntListGenerator()) { pair ->
                sum(pair.second.mapViaFoldLeft { it * 3 }) == sum(pair.second) * 3
            }
        }
        "mapViaFoldRight" {
            forAll(IntListGenerator()) { pair ->
                sum(pair.second.mapViaFoldRight { it * 3 }) == sum(pair.second) * 3
            }
        }
        "mapViaCoFoldRight" {
            forAll(IntListGenerator()) { pair ->
                sum(pair.second.mapViaCoFoldRight { it * 3 }) == sum(pair.second) * 3
            }
        }
    }
}

class IntListGenerator(private val min: Int = Int.MIN_VALUE, private val max: Int = Int.MAX_VALUE): Gen<Pair<Array<Int>, List<Int>>> {

    override fun constants(): Iterable<Pair<Array<Int>, List<Int>>> =
        Gen.list(Gen.choose(min, max)).constants().map { list -> list.toTypedArray().let { Pair(it, List(*(it))) } }

    override fun random(): Sequence<Pair<Array<Int>, List<Int>>> =
        Gen.list(Gen.choose(min, max)).random().map { list -> list.toTypedArray().let { Pair(it, List(*(it))) } }
}

fun main(args: Array<String>) {
    val testLimit = 35000
    val array = Array(testLimit) {i -> i.toLong() }
    val testList: List<Long> = List(*array)
    val start = System.currentTimeMillis()
    testList.mapViaFoldLeft { it * 2 }
    println(System.currentTimeMillis() - start)
}