package com.cdrussell.mockitoexample

import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class GameTestJvm {

    private lateinit var game: Game
    private val mockNumberGenerator: NumberGenerator = mock()

    @Test
    fun whenSingleDieGameUsedThenOnlyOneDieRolled() {
        setupGame(numberDice = 1)
        game.rollDice()
        verify(mockNumberGenerator).generate()
    }

    @Test
    fun whenTwoDiceGameUsedThenTwoDiceRolled() {
        setupGame(numberDice = 2)
        game.rollDice()
        verify(mockNumberGenerator, times(2)).generate()
    }

    private fun setupGame(numberDice: Int) {
        game = Game(numberDice = numberDice, mockNumberGenerator)
    }
}
