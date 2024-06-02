package org.example

class BiggerOrSmallerSet {
fun biggerOrSmaller(before: String, new: String): Int{
    var rankBefore = 0;
    var rankNew = 0;
    val searchOne = SetsOfCards::str findBy before;
    val searchTwo = SetsOfCards::str findBy new;
    rankBefore = searchOne!!.rank;
    rankNew = searchTwo!!.rank;
    if(rankBefore > rankNew){
        return 0
    }else if( rankBefore == rankNew){
        return 1
    }else {
        return 2
    }

}
    infix inline fun <reified E : Enum<E>, V> ((E) -> V).findBy(value: V): E? {
        return enumValues<E>().firstOrNull { this(it) == value }
    }
}