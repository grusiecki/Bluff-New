package org.example.setCheckers

import org.example.Card
import org.example.Figure
import org.example.Player

abstract class CheckIfExist {

    var listOfPlayers = ArrayList<Player>()
    var listOfCards = ArrayList<Card>()
    fun getAllPlayedCards(listOfPlayers: ArrayList<Player>): ArrayList<Card> {
        for (player in listOfPlayers) {
            for (card in player.hand) {
                listOfCards.add(card)
            }
        }
        return listOfCards
    }
    fun validator(answer1: String ): Figure{

        val figure: Figure = if (answer1 == "9") {
            Figure.valueOf("NINE")
        } else if (answer1 == "10") {
            Figure.valueOf("TEN")
        } else {
            Figure.valueOf(answer1.uppercase())
        }
        return figure;
    }

    abstract fun check(listOfCards: ArrayList<Card>, answer1: String, answer2: String): Boolean
}