package com.fpinkotlin.lists.exercise15


import com.fpinkotlin.lists.exercise15.List.Companion.flatten
import com.fpinkotlin.lists.exercise15.List.Companion.flattenViaCoFoldRight
import com.fpinkotlin.lists.exercise15.List.Companion.flattenViaFoldLeft
import com.fpinkotlin.lists.exercise15.List.Companion.flattenViaFoldRight
import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec
import java.util.*

class ListTest: StringSpec() {

    init {

        "flattenViaCoFoldRight" {
            forAll(100, IntListListGenerator()) { list ->
                val sum1 = list.foldLeft("") { x -> { y -> x + y.foldLeft("") { a -> { b -> a + b } } } }
                val sum2 = flattenViaCoFoldRight(list).foldLeft("") { a -> { b -> a + b } }
                sum1 == sum2
            }
        }
        "flattenViaFoldRight" {
            forAll(100, IntListListGenerator()) { list ->
                val sum1 = list.foldLeft("") { x -> { y -> x + y.foldLeft("") { a -> { b -> a + b } } } }
                val sum2 = flattenViaFoldRight(list).foldLeft("") { a -> { b -> a + b } }
                sum1 == sum2
            }
        }
        "flattenViaFoldLeft" {
            forAll(100, IntListListGenerator()) { list ->
                val sum1 = list.foldLeft("") { x -> { y -> x + y.foldLeft("") { a -> { b -> a + b } } } }
                val sum2 = flattenViaFoldLeft(list).foldLeft("") { a -> { b -> a + b } }
                sum1 == sum2
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

class IntListListGenerator : Gen<List<List<Int>>> {

    val random = Random()

    override fun constants(): Iterable<List<List<Int>>> = listOf()

    override fun random(): Sequence<List<List<Int>>> =
        Gen.list(Gen.choose(0, 100))
            .random()
            .map { List(*(IntListGenerator()
                .random()
                .map { it.second }
                .take(random.nextInt(100)))
                .toList()
                .toTypedArray()) }
}


