package com.cdrussell.mockitoexample

interface NumberGenerator {

    fun generate(): Int
}

class Game(private val numberDice: Int, private val numberGenerator: NumberGenerator) {

    fun rollDice(): Int {
        var total = 0
        repeat(numberDice) { total += numberGenerator.generate() }
        return total
    }
}
