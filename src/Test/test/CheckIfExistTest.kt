import org.example.Color
import org.example.Card
import org.example.Figure
import org.example.setCheckers.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CheckIfExistTest {

    private val card1: Card = Card(Color.HEART,Figure.NINE)
    private val card2: Card = Card(Color.HEART,Figure.TEN)
    private val card3: Card = Card(Color.HEART,Figure.JACK)
    private val card4: Card = Card(Color.HEART,Figure.QUEEN)
    private val card5: Card = Card(Color.HEART,Figure.KING)
    private val card6: Card = Card(Color.HEART,Figure.ACE)
    @Test
    fun checkOneCardPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card2)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        val oneCard = OneCard()
        val passed =oneCard.check(deck, "9","mockup")
        assertEquals(true, passed)
    }
    @Test
    fun checkOneCardNegative(){

        val deck: ArrayList<Card> = arrayListOf()

        deck.add(card2)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        val oneCard = OneCard()
        val passed =oneCard.check(deck, "9","mockup")
        assertEquals(false, passed)
    }
    @Test
    fun checkTwoCardPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card1)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        val twoCards = TwoCards()
        val passed = twoCards.check(deck, "9","mockup")
        assertEquals(true, passed)
    }
    @Test
    fun checkTwoCardNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card2)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        val twoCards = TwoCards()
        val passed = twoCards.check(deck, "9","mockup")
        assertEquals(false, passed)
    }
    @Test
    fun checkThreeCardPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card1)
        deck.add(card1)
        deck.add(card4)
        deck.add(card5)
        val threeCards = ThreeCards()
        val passed = threeCards.check(deck, "9","mockup")
        assertEquals(true, passed)
    }
    @Test
    fun checkThreeCardNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card1)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        val threeCards = ThreeCards()
        val passed = threeCards.check(deck, "9","mockup")
        assertEquals(false, passed)
    }
    @Test
    fun checkFourCardPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card1)
        deck.add(card1)
        deck.add(card1)
        deck.add(card5)
        val fourCards = FourCards()
        val passed = fourCards.check(deck, "9","mockup")
        assertEquals(true, passed)
    }
    @Test
    fun checkFourCardNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card1)
        deck.add(card1)
        deck.add(card4)
        deck.add(card5)
        val fourCards = FourCards()
        val passed = fourCards.check(deck, "9","mockup")
        assertEquals(false, passed)
    }
    @Test
    fun checkTwoPairsPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card1)
        deck.add(card3)
        deck.add(card3)
        deck.add(card3)
        val twoPairs = TwoPairs()
        val passed = twoPairs.check(deck, "9","Jack")
        assertEquals(true, passed)
    }
    @Test
    fun checkTwoPairsNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card1)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        val twoPairs = TwoPairs()
        val passed = twoPairs.check(deck, "9","Jack")
        assertEquals(false, passed)
    }
    @Test
    fun checkFullPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card2)
        deck.add(card2)
        deck.add(card2)
        deck.add(card4)
        deck.add(card4)
        val full = Full()
        val passed = full.check(deck, "10","Queen")
        assertEquals(true, passed)
    }
    @Test
    fun checkFullNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card1)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        val full = Full()
        val passed = full.check(deck, "9","Jack")
        assertEquals(false, passed)
    }
    @Test
    fun checkSmallStraightPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card2)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        val straight = Straight()
        val passed = straight.check(deck, "small","")
        assertEquals(true, passed)
    }
    @Test
    fun checkSmallStraightNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card2)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        deck.add(card6)
        val straight = Straight()
        val passed = straight.check(deck, "small","")
        assertEquals(false, passed)
    }
    @Test
    fun checkBigStraightPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card2)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        deck.add(card6)
        val straight = Straight()
        val passed = straight.check(deck, "big","")
        assertEquals(true, passed)
    }
    @Test
    fun checkBigStraightNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card2)
        deck.add(card3)
        deck.add(card4)
        deck.add(card3)

        val straight = Straight()
        val passed = straight.check(deck, "big","")
        assertEquals(false, passed)
    }
}