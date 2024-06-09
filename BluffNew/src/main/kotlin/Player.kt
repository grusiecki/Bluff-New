package org.example

class Player : Hand() {
    var numberOfCards = 1;
    var active = false;
    var name = "";

    fun increaseCard() {
        numberOfCards++;
    }
}