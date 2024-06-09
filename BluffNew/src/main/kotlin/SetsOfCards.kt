package org.example

enum class SetsOfCards(var rank: Int, var str: String) {
    ONECARD(0, "1 card"),
    PAIR(1, "pair"),
    TWOPAIRS(2, "two pairs"),
    THREE(3, "three"),
    STREET(4, "straight"),
    FULL(5, "full"),
    FOUR(6, "four"),
    FLUSH(7, "flush"),
    ROYALFLUSH(8, "royal flush")
}