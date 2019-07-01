package com.fpinkotlin.lists.exercise16


import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class ListTest: StringSpec() {

    init {

        "tripleViaFoldLeft" {
            forAll(IntListGenerator()) { pair ->
                sum(tripleViaFoldLeft(pair.second)) == sum(pair.second) * 3
            }
        }
        "tripleViaFoldRight" {
            forAll(IntListGenerator()) { pair ->
                sum(tripleViaFoldRight(pair.second)) == sum(pair.second) * 3
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
