package org.example

class Deck(): Hand() {
    fun create(){
        for(color in Color.entries)
    {
        for (figure in Figure.entries) {
            val c1: Card = Card(
                color,
                figure
            )
            add(c1);
        }
    }}
    fun shuffle(){
        hand.shuffle()
    }


}