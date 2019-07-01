package com.fpinkotlin.lists.exercise19


import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class ListTest: StringSpec() {

    init {

        "filterViaFoldLeft" {
            forAll(IntListGenerator()) { (array, list) ->
                sum(list.filterViaFoldLeft { it % 2 == 0 }) == array.fold(0) { a, b -> a + if (b % 2 == 0) b else 0 }
            }
        }
        "filterViaCoFoldRight" {
            forAll(IntListGenerator()) { (array, list) ->
                sum(list.filterViaCoFoldRight { it % 2 == 0 }) == array.fold(0) { a, b -> a + if (b % 2 == 0) b else 0 }
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
