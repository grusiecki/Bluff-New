package org.example

class Checkers {
    fun checkAnswerSetOfCards(typeSet: String): Pair<Boolean, Boolean> {
        val correct: Boolean
        val check: Boolean
        when (typeSet) {
            "1 card", "pair", "two pairs", "three", "straight", "full", "four", "flush", "royal flush" -> {
                correct = true;
                check = false;
            }

            "check" -> {
                correct = true;
                check = true;
            }

            else -> {
                correct = false;
                check = false
                println("Wrong word! Choose correct set or check! (1 card, pair, two pairs, three, straight, full, four, flush, royal flush")

            }
        }
        val pair = Pair(correct, check)
        return pair;
    }

    fun checkAnswerCardLevel(set: String): Pair<Boolean, Pair<String, String>> {
        var checker = false;
        var answer1 = "9";
        var answer2 = "10"
        var answer: String;
        var pair: Pair<Boolean, Pair<String, String>> = Pair(checker, Pair(answer1, answer2));
        var smallPair: Pair<Boolean, String> = Pair(checker, answer1);
        when (set) {
            "1 card", "pair", "three", "four" -> {
                smallPair = checkNameCard();
                pair = Pair(smallPair.first, Pair(smallPair.second, smallPair.second))
            }

            "flush" -> {
                smallPair = checkColor();
                pair = Pair(smallPair.first, Pair(smallPair.second, smallPair.second))
            }

            "straight" -> {
                smallPair = checkSmallOrBig();
                pair = Pair(smallPair.first, Pair(smallPair.second, smallPair.second))
            }

            "two pairs" -> {
                println("first pair:");
                smallPair = checkNameCard();
                answer1 = smallPair.second
                println("second pair:");
                smallPair = checkNameCard();
                answer2 = smallPair.second
                var bool = smallPair.first
                if (answer1 == answer2) {
                    println("Pairs cannot be the same")
                    bool = false
                }
                pair = Pair(bool, Pair(answer1, answer2))
            }

            "full" -> {
                println("three of kind:");
                smallPair = checkNameCard();
                answer1 = smallPair.second
                println("pair:");
                smallPair = checkNameCard();
                answer2 = smallPair.second
                var bool = smallPair.first
                if (answer1 == answer2) {
                    println("Three of kind and pair cannot be the same")
                    bool = false
                }
                pair = Pair(bool, Pair(answer1, answer2))
            }

            "royal flush" -> {
                smallPair = checkSmallOrBig();
                answer1 = smallPair.second
                smallPair = checkColor();
                answer2 = smallPair.second
                pair = Pair(smallPair.first, Pair(answer1, answer2))
            }
        }
        return pair
    }

    private fun checkColor(): Pair<Boolean, String> {
        var checker = false;
        var answer = "spade";
        while (!checker) {
            println("of: (heart, diamond, club, spade)")
            answer = readln();
            if (answer == "heart" || answer == "diamond" || answer == "club" || answer == "spade") {

                checker = true;
            }
            if (!checker) {
                println("write correct answer(heart, diamond, club, spade)");
            }
        }
        return Pair(checker, answer);
    }

    private fun checkSmallOrBig(): Pair<Boolean, String> {
        var checker = false;
        var answer = "small";
        while (!checker) {
            println("small or big")
            answer = readln()
            if (answer == "small" || answer == "big") {
                checker = true;
            }
            if (!checker) {
                println("write correct answer(small or big)");
            }
        }
        return Pair(checker, answer);
    }

    private fun checkNameCard(): Pair<Boolean, String> {
        var checker = false;
        var answer = "9"
        var levelOfAnswer: Int;

        while (!checker) {
            println("of: (9, 10, jack, queen, king, ace)")
            answer = readln()
            if (answer == "9" || answer == "10" || answer == "jack" || answer == "queen" || answer == "king" || answer == "ace") {
                checker = true

            }
            if (!checker) {
                println("write correct card(9, 10, jack, queen, king, ace");
            }
        }

        return Pair(checker, answer);
    }

    infix inline fun <reified E : Enum<E>, V> ((E) -> V).findBy(value: V): E? {
        return enumValues<E>().firstOrNull { this(it) == value }
    }

    fun biggerOrSmallerSet(before: String, new: String): Int {
        var rankBefore = 0;
        var rankNew = 0;
        val searchOne = SetsOfCards::str findBy before;
        val searchTwo = SetsOfCards::str findBy new;
        rankBefore = searchOne!!.rank;
        rankNew = searchTwo!!.rank;
        if (rankBefore > rankNew) {
            return 0
        } else if (rankBefore == rankNew) {
            return 1
        } else {
            return 2
        }

    }

    fun biggerOrSmallerCard(before: String, new: String): Int {
        var rankBefore = 0;
        var rankNew = 0;
        val searchOne = Figure::str findBy before;
        val searchTwo = Figure::str findBy new;
        rankBefore = searchOne!!.rank;
        rankNew = searchTwo!!.rank;
        if (rankBefore > rankNew) {
            return 0
        } else if (rankBefore == rankNew) {
            return 1
        } else {
            return 2
        }
    }

    fun biggerOrSmallerColor(before: String, new: String): Int {
        var rankBefore = 0;
        var rankNew = 0;
        val searchOne = Color::str findBy before;
        val searchTwo = Color::str findBy new;
        rankBefore = searchOne!!.rank;
        rankNew = searchTwo!!.rank;
        if (rankBefore >= rankNew) {
            return 0
        } else {
            return 1
        }
    }
}