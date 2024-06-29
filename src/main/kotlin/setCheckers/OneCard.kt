package org.example.setCheckers

import org.example.Card
import org.example.Figure
import org.example.setCheckers.CheckIfExist

class OneCard : CheckIfExist() {


    override fun check(listOfCards: ArrayList<Card>, card: String): Boolean {
        val listOfFigures = ArrayList<Figure>()
        for (cards in listOfCards) {
            listOfFigures.add(cards.figure)
        }
        val figure: Figure = if(card == "9"){
            Figure.valueOf("NINE")
        }else if(card == "10"){
            Figure.valueOf("TEN")
        }else{
            Figure.valueOf(card.uppercase())
        }

        val contain = listOfFigures.contains(figure)
        return contain
    }
}