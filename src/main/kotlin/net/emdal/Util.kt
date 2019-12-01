package net.emdal

import java.io.File
import kotlin.system.measureNanoTime

interface Puzzle {
    val day: Int
    val puzzle: Int

    fun path() = "src/main/resources/day$day/puzzle$puzzle/input.txt"
    fun puzzleInputText(): String = File(path()).readText()
    fun puzzleInputLines() = File(path()).readLines()
}

interface Solution {
    fun solve():Any
}

abstract class SolutionPrinter : Puzzle, Solution {
    fun printSolution(): Long {
        lateinit var solution:Any
        val timeSpent = measureNanoTime {
            solution = solve()
        }
        println("Day $day Puzzle $puzzle solved in $timeSpent nanoseconds. solution: $solution")
        return timeSpent
    }
}

