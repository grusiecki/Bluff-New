package org.example

open class Hand {

    lateinit var hand: ArrayList<Card>

    init {
        this.hand = arrayListOf()
     }
    fun clear(){
        hand.clear()
    }
    fun add(card: Card){
        hand.add(card)
    }
    fun show(): String {
        var str: String = ""
        for (c in hand){
            str += "${c.figure.name} ${c.color.name} "
        }
        return str
    }



}