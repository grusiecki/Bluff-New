import org.example.Color
import org.example.Card
import org.example.Figure
import org.example.setCheckers.FourCards
import org.example.setCheckers.OneCard
import org.example.setCheckers.ThreeCards
import org.example.setCheckers.TwoCards
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class CheckIfExistTest {

    private val card1: Card = Card(Color.HEART,Figure.NINE)
    private val card2: Card = Card(Color.HEART,Figure.TEN)
    private val card3: Card = Card(Color.HEART,Figure.JACK)
    private val card4: Card = Card(Color.HEART,Figure.QUEEN)
    private val card5: Card = Card(Color.HEART,Figure.KING)
    @Test
    fun checkOneCardPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(card1)
        deck.add(card2)
        deck.add(card3)
        deck.add(card4)
        deck.add(card5)
        val oneCard = OneCard()
        val passed =oneCard.check(deck, "9")
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
        val passed =oneCard.check(deck, "9")
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
        val passed = twoCards.check(deck, "9")
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
        val passed = twoCards.check(deck, "9")
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
        val passed = threeCards.check(deck, "9")
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
        val passed = threeCards.check(deck, "9")
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
        val passed = fourCards.check(deck, "9")
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
        val passed = fourCards.check(deck, "9")
        assertEquals(false, passed)
    }
}