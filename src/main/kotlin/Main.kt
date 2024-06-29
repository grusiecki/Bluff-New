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
  //  game.round();

    var list = oneCard.getAllPlayedCards(game.listOfPlayers)
    println(oneCard.check(list, game.currentAnswer1))


}