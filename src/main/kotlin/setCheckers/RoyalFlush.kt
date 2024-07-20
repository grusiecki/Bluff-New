package org.example.setCheckers

import org.example.Card
import org.example.Color
import org.example.Figure

class RoyalFlush: CheckIfExist() {
    override fun check(listOfCards: ArrayList<Card>, answer1: String, answer2: String): Boolean {

        var contain = false
        val color: Color = validatorColor(answer2)
        val nine  = Card(color, Figure.NINE)
        val ten = Card(color,Figure.TEN)
        val jack = Card(color, Figure.JACK)
        val queen = Card(color, Figure.QUEEN)
        val king = Card(color, Figure.KING)
        val ace = Card(color, Figure.ACE)

        if (listOfCards.contains(ten) && listOfCards.contains(jack) && listOfCards.contains(queen) && listOfCards.contains(king
            )){
                if (answer1 == "small") {
                    contain = listOfCards.contains(nine)
                } else if (answer1 == "big") {
                    contain = listOfCards.contains(ace)
                }
            }else {
            contain = false

        }
        return contain
    }
}