package org.example

class Game() {
    private var numberOfPlayersStr = "0"
    private var numberOfPlayers = 0
    var listOfPlayers = ArrayList<Player>()
    private var deck = Deck()
    var currentAnswer1 = "9"

    fun beforeFirstGame() {
        do {
            println("Enter number of players (2-4)")
            numberOfPlayersStr = readln()
            if (numberOfPlayersStr != "2" && numberOfPlayersStr != "3" && numberOfPlayersStr != "4") {
                println("Wrong quantity - select number from 2 to 4")
            }
        } while (numberOfPlayersStr != "2" && numberOfPlayersStr != "3" && numberOfPlayersStr != "4")
        deck.create()
        numberOfPlayers = numberOfPlayersStr.toInt()
    }

    fun enterName() {
        for (i in 1..numberOfPlayers) {
            val player = Player()
            println("Enter name of Player $i")
            readln().also { player.name = it }
            player.active = true
            listOfPlayers.add(player)
        }
    }

    fun setCards() {
        deck.shuffle()
        for (player in listOfPlayers) {
            for (card in 1..player.numberOfCards) {
                player.add(deck.hand[card])
            }
        }
    }

    //ogarnac licytacje
    fun round() {
        var typeSet = "1 card"
        var beforeSet = "1 card"

        var currentAnswer2 = "9"
        var previousAnswer1 = "8"
        var previousAnswer2 = "8"
        var checker = Pair(false, false)
        var check = false
        var pairAnswer: Pair<Boolean, Pair<String, String>>
        var biggerOrSmaller: Int
        while (!check) {
            for (player in listOfPlayers) {
                while (checker == Pair(false, false)) {
                    println("${player.name}: write what kind of set is in playing deck or check (1 card, pair, two pairs, three, straight, full, four, flush, royal flush")
                    typeSet = readln()
                    val ch1 = Checkers()
                    checker = ch1.checkAnswerSetOfCards(typeSet)
                    if (checker == Pair(true, false)) {
                        biggerOrSmaller = ch1.biggerOrSmallerSet(beforeSet, typeSet)
                        when (biggerOrSmaller) {
                            0 -> {
                                checker = falseInfo()
                            }
                            1 -> {
                                pairAnswer = ch1.checkAnswerCardLevel(typeSet)
                                when (typeSet) {
                                    "1 card", "pair", "three", "four" -> {
                                        currentAnswer1 = pairAnswer.second.first
                                        biggerOrSmaller = ch1.biggerOrSmallerCard(previousAnswer1, currentAnswer1)
                                        if (biggerOrSmaller == 0 || biggerOrSmaller == 1) {
                                            checker = falseInfo()
                                        }
                                    }

                                    "flush" -> {
                                        currentAnswer1 = pairAnswer.second.first
                                        biggerOrSmaller = ch1.biggerOrSmallerColor(previousAnswer1, currentAnswer1)
                                        if (biggerOrSmaller == 0 || biggerOrSmaller == 1) {
                                            checker = falseInfo()
                                        }
                                    }

                                    "straight" -> {
                                        currentAnswer1 = pairAnswer.second.first
                                        if (currentAnswer1 == "small" && previousAnswer1 == "big" || currentAnswer1 == "small" && previousAnswer1 == "small" || currentAnswer1 == "big" && previousAnswer1 == "big") {
                                            checker = falseInfo()
                                        }
                                    }

                                    "two pairs" -> {
                                        currentAnswer1 = pairAnswer.second.first
                                        currentAnswer2 = pairAnswer.second.second
                                        var currentBiggerPair: String
                                        var previousBiggerPair: String
                                        var currentSmallerPair: String
                                        var previousSmallerPair: String
                                        biggerOrSmaller = ch1.biggerOrSmallerCard(currentAnswer1, currentAnswer2)
                                        if (biggerOrSmaller == 0) {
                                            currentBiggerPair = currentAnswer1
                                            currentSmallerPair = currentAnswer2
                                        } else {
                                            currentBiggerPair = currentAnswer2
                                            currentSmallerPair = currentAnswer1
                                        }
                                        biggerOrSmaller = ch1.biggerOrSmallerCard(previousAnswer1, previousAnswer2)
                                        if (biggerOrSmaller == 0) {
                                            previousBiggerPair = previousAnswer1
                                            previousSmallerPair = previousAnswer2
                                        } else {
                                            previousBiggerPair = previousAnswer2
                                            previousSmallerPair = previousAnswer1
                                        }
                                        biggerOrSmaller = ch1.biggerOrSmallerCard(previousBiggerPair, currentBiggerPair)
                                        if (biggerOrSmaller == 0) {
                                            checker = falseInfo()
                                        } else if (biggerOrSmaller == 1) {
                                            biggerOrSmaller =
                                                ch1.biggerOrSmallerCard(previousSmallerPair, currentSmallerPair)
                                            if (biggerOrSmaller == 0) {
                                                checker = falseInfo()
                                            }

                                        }
                                    }

                                    "full" -> {
                                        currentAnswer1 = pairAnswer.second.first
                                        currentAnswer2 = pairAnswer.second.second
                                        biggerOrSmaller = ch1.biggerOrSmallerCard(previousAnswer1, currentAnswer1)
                                        if (biggerOrSmaller == 0) {
                                            checker = falseInfo()
                                        } else if (biggerOrSmaller == 1) {
                                            biggerOrSmaller = ch1.biggerOrSmallerCard(previousAnswer2, currentAnswer2)
                                            if (biggerOrSmaller == 0) {
                                                checker = falseInfo()
                                            } else if (!pairAnswer.first) {
                                                checker = Pair(false, false)
                                            }
                                        }
                                    }

                                    "royal flush" -> {
                                        currentAnswer1 = pairAnswer.second.first
                                        currentAnswer2 = pairAnswer.second.second
                                        if (currentAnswer1 == "small" && previousAnswer1 == "big") {
                                            checker = falseInfo()
                                        } else if (currentAnswer1 == "small" && previousAnswer1 == "small" || currentAnswer1 == "big" && previousAnswer1 == "big") {
                                            biggerOrSmaller = ch1.biggerOrSmallerColor(previousAnswer2, currentAnswer2)
                                            if (biggerOrSmaller == 0) {
                                                checker = falseInfo()
                                            }
                                        }

                                    }

                                }
                            }
                            else -> {
                                pairAnswer = ch1.checkAnswerCardLevel(typeSet)
                                checker = Pair(pairAnswer.first, false)
                                currentAnswer1 = pairAnswer.second.first
                                currentAnswer2 = pairAnswer.second.second
                            }
                        }
                    }

                }
                if (checker == Pair(true, false)) {
                    checker = Pair(false, false)
                    beforeSet = typeSet
                    previousAnswer1 = currentAnswer1
                    previousAnswer2 = currentAnswer2
                }
            }
//
            check = checker.second

        }


    }

    private fun falseInfo(): Pair<Boolean, Boolean> {
        println("Set cannot be smaller then previous player")
        return Pair(false, false)
    }

}