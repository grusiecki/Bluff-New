package org.example.setCheckers

import org.example.Card
import org.example.Figure

class FourCards: CheckIfExist() {
    override fun check(listOfCards: ArrayList<Card>, card: String): Boolean {
        val listOfFigures = ArrayList<Figure>()
        val contain :Boolean
        for (card1 in listOfCards) {
            listOfFigures.add(card1.figure)
        }
        val figure: Figure = if(card == "9"){
            Figure.valueOf("NINE")
        }else if(card == "10"){
            Figure.valueOf("TEN")
        }else{
            Figure.valueOf(card.uppercase())
        }
        val occurrences = listOfFigures.count{it == figure}
        contain = occurrences >= 4
        return contain    }
}