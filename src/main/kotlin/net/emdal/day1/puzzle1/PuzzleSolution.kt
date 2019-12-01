package net.emdal.day1.puzzle1

import net.emdal.SolutionPrinter

class PuzzleSolution(override val day: Int = 1, override val puzzle: Int = 1) : SolutionPrinter() {

    private fun fuelRequired(mass: Int) = (mass / 3) - 2

    override fun solve(): Any = puzzleInputLines().map(String::toInt).map(::fuelRequired).sum()
}
