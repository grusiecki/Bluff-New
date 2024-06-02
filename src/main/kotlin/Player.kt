package org.example

class Player: Hand() {
    var numberOfCards = 1;
    var active = false;
    var name = "";
    var setDecision = "";
    var cardDecision1 = "";
    var cardDecision2 = "";
    fun increaseCard(){
        numberOfCards++;
    }
}