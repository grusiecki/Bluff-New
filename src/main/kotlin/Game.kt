package org.example

import org.example.setCheckers.*

class Game() {
    private var numberOfPlayersStr = "0"
    private var numberOfPlayers = 0
    var listOfPlayers = ArrayList<Player>()
    var listOfCards = ArrayList<Card>()
    private var deck = Deck()
    var currentAnswer1 = "9"
    var currentAnswer2 = "9"
    var previousSet = "1 card"
    var previousPlayer = Player()
    var actualPlayer = Player()
    var actualLoosingPlayer = Player()
    var previousLoosingPlayer = Player()


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

    private fun setCards() {
        deck.shuffle()
        deck.shuffle()
        for (player in listOfPlayers) {
            player.hand.clear()
            for (card in 1..player.numberOfCards) {
                player.add(deck.hand[card])
                listOfCards.add(deck.hand[card])
                println(deck.hand[card].figure)
            }
        }

    }

    fun round() {
        var typeSet = "1 card"
        var beforeSet = "1 card"
        var previousAnswer1 = "8"
        var previousAnswer2 = "8"
        var checker = Pair(false, false)
        var check = false
        var pairAnswer: Pair<Boolean, Pair<String, String>>
        var biggerOrSmaller: Int
        while (listOfPlayers.size > 1) {
            beforeSet = "1 card"
            previousAnswer1 = "8"
            previousAnswer2 = "8"
            setCards()
            var interactions = 0
            while (!check) {


                for (player in listOfPlayers) {
                    while (checker == Pair(false, false)) {
                        actualPlayer = player
                        println("${player.name}: write what kind of set is in playing deck or check (1 card, pair, two pairs, three, straight, full, four, flush, royal flush")
                        typeSet = readln()
                        val ch1 = Checkers()
                        if(interactions==0){
                            previousLoosingPlayer = player
                            if(typeSet=="check"){
                                println("You cannot check at first move - there is nothing to check!")
                                checker = Pair(false, false)
                            } else{
                                checker = ch1.checkAnswerSetOfCards(typeSet)
                            }
                        }else {
                            checker = ch1.checkAnswerSetOfCards(typeSet)
                        }
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
                                            biggerOrSmaller =
                                                ch1.biggerOrSmallerCard(previousBiggerPair, currentBiggerPair)
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
                                                biggerOrSmaller =
                                                    ch1.biggerOrSmallerCard(previousAnswer2, currentAnswer2)
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
                                                biggerOrSmaller =
                                                    ch1.biggerOrSmallerColor(previousAnswer2, currentAnswer2)
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
                        previousPlayer = player
                        check = checker.second

                    } else if (checker == Pair(true, true)) {
                        checker = Pair(false, true)
                        check = checker.second
                        actualLoosingPlayer = checkIfExist(
                            beforeSet,
                            previousAnswer1,
                            previousAnswer2,
                            previousPlayer,
                            actualPlayer,
                            listOfCards
                        )
                        println("${actualLoosingPlayer.name} is loosing the round!")

                        if (actualLoosingPlayer.numberOfCards > 5) {
                            println("${actualLoosingPlayer.name} is loosing the game!")
                            listOfPlayers.remove(actualLoosingPlayer)
                            if (listOfPlayers.size < 2) {
                                break
                            }
                        }

                    }
                    interactions++
                }
//


            }
            checker = Pair(false, false)
            check = false
            listOfCards.clear()
            if(previousLoosingPlayer != actualLoosingPlayer){rotatePlayers(listOfPlayers, actualLoosingPlayer)}
        }
        println("GAME OVER")


    }

    private fun falseInfo(): Pair<Boolean, Boolean> {
        println("Set cannot be smaller then previous player")
        return Pair(false, false)
    }

    private fun checkIfExist(
        typeOfSet: String,
        answer1: String,
        answer2: String,
        previousPlayer: Player,
        actualPlayer: Player,
        listOfCards: ArrayList<Card>
    ): Player {
        var exist = false
        var player = Player()
        when (typeOfSet) {
            "1 card" -> {
                val oneCard = OneCard()
                exist = oneCard.check(listOfCards, answer1, answer2)
                player = whoGetsTheCard(exist, actualPlayer, previousPlayer)
            }

            "pair" -> {
                val pair = OnePair()
                exist = pair.check(listOfCards, answer1, answer2)
                player = whoGetsTheCard(exist, actualPlayer, previousPlayer)
            }

            "two pairs" -> {
                val twoPairs = TwoPairs()
                exist = twoPairs.check(listOfCards, answer1, answer2)
                player = whoGetsTheCard(exist, actualPlayer, previousPlayer)
            }

            "three" -> {
                val three = ThreeCards()
                exist = three.check(listOfCards, answer1, answer2)
                player = whoGetsTheCard(exist, actualPlayer, previousPlayer)
            }

            "straight" -> {
                val straight = Straight()
                exist = straight.check(listOfCards, answer1, answer2)
                player = whoGetsTheCard(exist, actualPlayer, previousPlayer)
            }

            "full" -> {
                val full = Full()
                exist = full.check(listOfCards, answer1, answer2)
                player = whoGetsTheCard(exist, actualPlayer, previousPlayer)
            }

            "four" -> {
                val four = FourCards()
                exist = four.check(listOfCards, answer1, answer2)
                player = whoGetsTheCard(exist, actualPlayer, previousPlayer)
            }

            "flush" -> {
                val flush = Flush()
                exist = flush.check(listOfCards, answer1, answer2)
                player = whoGetsTheCard(exist, actualPlayer, previousPlayer)
            }

            "royal flush" -> {
                val royalFlush = RoyalFlush()
                exist = royalFlush.check(listOfCards, answer1, answer2)
                player = whoGetsTheCard(exist, actualPlayer, previousPlayer)
            }
        }
        return player
    }

    private fun whoGetsTheCard(exist: Boolean, actualPlayer: Player, previousPlayer: Player): Player {
        if (exist) {
            actualPlayer.numberOfCards++
            return actualPlayer
        } else {
            previousPlayer.numberOfCards++
            return previousPlayer
        }
    }

    private fun rotatePlayers(players: ArrayList<Player>, loser: Player) {
        val loserIndex = players.indexOf(loser)
        if (loserIndex != -1) {

            val newOrder = players.subList(loserIndex, players.size) + players.subList(0, loserIndex)
            players.clear()
            players.addAll(newOrder)
        }
    }
//TODO adding test for ending game, check wtf with deck of cards, make test for looser starts next round
}