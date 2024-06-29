package org.example.setCheckers

import org.example.Card
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

    abstract fun check(listOfCards: ArrayList<Card>, card: String): Boolean
}