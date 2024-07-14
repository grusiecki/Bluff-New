import org.example.Color
import org.example.Card
import org.example.Figure
import org.example.setCheckers.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CheckIfExistTest {

    private val nineHeart: Card = Card(Color.HEART,Figure.NINE)
    private val tenHeart: Card = Card(Color.HEART,Figure.TEN)
    private val jackHeart: Card = Card(Color.HEART,Figure.JACK)
    private val queenHeart: Card = Card(Color.HEART,Figure.QUEEN)
    private val kingHeart: Card = Card(Color.HEART,Figure.KING)
    private val aceHeart: Card = Card(Color.HEART,Figure.ACE)
    private val aceClub: Card = Card(Color.CLUB,Figure.ACE)
    @Test
    fun checkOneCardPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val oneCard = OneCard()
        val passed =oneCard.check(deck, "9","mockup")
        assertEquals(true, passed)
    }
    @Test
    fun checkOneCardNegative(){

        val deck: ArrayList<Card> = arrayListOf()

        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val oneCard = OneCard()
        val passed =oneCard.check(deck, "9","mockup")
        assertEquals(false, passed)
    }
    @Test
    fun checkTwoCardPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val twoCards = TwoCards()
        val passed = twoCards.check(deck, "9","mockup")
        assertEquals(true, passed)
    }
    @Test
    fun checkTwoCardNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val twoCards = TwoCards()
        val passed = twoCards.check(deck, "9","mockup")
        assertEquals(false, passed)
    }
    @Test
    fun checkThreeCardPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val threeCards = ThreeCards()
        val passed = threeCards.check(deck, "9","mockup")
        assertEquals(true, passed)
    }
    @Test
    fun checkThreeCardNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val threeCards = ThreeCards()
        val passed = threeCards.check(deck, "9","mockup")
        assertEquals(false, passed)
    }
    @Test
    fun checkFourCardPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(kingHeart)
        val fourCards = FourCards()
        val passed = fourCards.check(deck, "9","mockup")
        assertEquals(true, passed)
    }
    @Test
    fun checkFourCardNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val fourCards = FourCards()
        val passed = fourCards.check(deck, "9","mockup")
        assertEquals(false, passed)
    }
    @Test
    fun checkTwoPairsPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(jackHeart)
        deck.add(jackHeart)
        deck.add(jackHeart)
        val twoPairs = TwoPairs()
        val passed = twoPairs.check(deck, "9","Jack")
        assertEquals(true, passed)
    }
    @Test
    fun checkTwoPairsNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val twoPairs = TwoPairs()
        val passed = twoPairs.check(deck, "9","Jack")
        assertEquals(false, passed)
    }
    @Test
    fun checkFullPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(tenHeart)
        deck.add(tenHeart)
        deck.add(tenHeart)
        deck.add(queenHeart)
        deck.add(queenHeart)
        val full = Full()
        val passed = full.check(deck, "10","Queen")
        assertEquals(true, passed)
    }
    @Test
    fun checkFullNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(nineHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val full = Full()
        val passed = full.check(deck, "9","Jack")
        assertEquals(false, passed)
    }
    @Test
    fun checkSmallStraightPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val straight = Straight()
        val passed = straight.check(deck, "small","")
        assertEquals(true, passed)
    }
    @Test
    fun checkSmallStraightNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        deck.add(aceHeart)
        val straight = Straight()
        val passed = straight.check(deck, "small","")
        assertEquals(false, passed)
    }
    @Test
    fun checkBigStraightPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        deck.add(aceHeart)
        val straight = Straight()
        val passed = straight.check(deck, "big","")
        assertEquals(true, passed)
    }
    @Test
    fun checkBigStraightNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(jackHeart)

        val straight = Straight()
        val passed = straight.check(deck, "big","")
        assertEquals(false, passed)
    }
    @Test
    fun checkFlushPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        deck.add(aceHeart)
        val flush = Flush()
        val passed = flush.check(deck, "heart","")
        assertEquals(true, passed)
    }
    @Test
    fun checkFlushNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(aceClub)

        val flush = Flush()
        val passed = flush.check(deck, "heart","")
        assertEquals(false, passed)
    }
    @Test
    fun checkSmallRoyalFlushPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        val straight = Straight()
        val passed = straight.check(deck, "small","heart")
        assertEquals(true, passed)
    }
    @Test
    fun checkSmallRoyalFlushNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        deck.add(aceClub)
        val straight = Straight()
        val passed = straight.check(deck, "small","heart")
        assertEquals(false, passed)
    }
    @Test
    fun checkBigRoyalFlushPositive(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(kingHeart)
        deck.add(aceHeart)
        val straight = Straight()
        val passed = straight.check(deck, "big","heart")
        assertEquals(true, passed)
    }
    @Test
    fun checkBigRoyalFlushNegative(){

        val deck: ArrayList<Card> = arrayListOf()
        deck.add(nineHeart)
        deck.add(tenHeart)
        deck.add(jackHeart)
        deck.add(queenHeart)
        deck.add(jackHeart)

        val straight = Straight()
        val passed = straight.check(deck, "big","heart")
        assertEquals(false, passed)
    }
}