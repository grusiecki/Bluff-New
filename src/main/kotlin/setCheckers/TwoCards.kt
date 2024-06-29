package org.example.setCheckers

import org.example.Card
import org.example.Figure

class TwoCards: CheckIfExist() {
    override fun check(listOfCards: ArrayList<Card>, card: String): Boolean {
        val listOfFigures = ArrayList<Figure>()
        for (card in listOfCards) {
            listOfFigures.add(card.figure)
        }
        val figure = Figure.valueOf(card.uppercase())
        val contain = listOfFigures.contains(figure)
        return contain    }
}