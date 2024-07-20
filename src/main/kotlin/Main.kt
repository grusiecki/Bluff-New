package org.example

import org.example.setCheckers.OneCard

fun main() {
//    val deck: Deck

//    }

    val game = Game();
    val oneCard = OneCard();
    game.beforeFirstGame();
    game.enterName();
    game.setCards();
    game.round();




}