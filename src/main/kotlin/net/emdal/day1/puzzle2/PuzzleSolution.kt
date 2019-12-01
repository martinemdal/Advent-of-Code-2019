package net.emdal.day1.puzzle2

import net.emdal.SolutionPrinter

class PuzzleSolution(override val day: Int = 1, override val puzzle: Int = 2) : SolutionPrinter() {

    private fun fuelRequired(mass: Int) = (mass / 3) - 2

    data class FuelNeeded(val fuelAccountedFor: Int, val fuelNotAccountedFor: Int)

    private tailrec fun FuelNeeded.accountForFuelWeight(): FuelNeeded = when {
        fuelNotAccountedFor < 0 -> this
        else -> {
            val fuelNeeded = fuelRequired(fuelNotAccountedFor)
            this.copy(fuelAccountedFor = fuelAccountedFor + fuelNotAccountedFor, fuelNotAccountedFor = fuelNeeded)
                .accountForFuelWeight()
        }
    }

    override fun solve() = puzzleInputLines()
        .map(String::toInt)
        .map { FuelNeeded(0, fuelRequired(it)) }
        .map { it.accountForFuelWeight().fuelAccountedFor }
        .sum()
}
