package net.emdal

import kotlin.system.measureTimeMillis


fun main() {
    measureTimeMillis {
        net.emdal.day1.puzzle1.PuzzleSolution().printSolution()
        net.emdal.day1.puzzle2.PuzzleSolution().printSolution()
    }.let {
        println("Total runtime of all advent of code jobs: $it milliseconds.")
    }
}