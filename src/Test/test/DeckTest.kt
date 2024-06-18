import org.example.Deck
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeckTest {
    private val deck = Deck()

    @BeforeEach
    fun createB() {
        deck.create()
    }

    @Test
    fun createDeckTest() {

        val result = deck.hand

        assertEquals("9", result[0].figure.str)
        assertEquals("heart", result[0].color.str)
    }

    @Test
    fun shuffleDeckTest() {
        val beforeShuffle1 = deck.hand[1]
        val beforeShuffle2 = deck.hand[2]
        deck.shuffle()
        val afterShuffle1 = deck.hand[1]
        val afterShuffle2 = deck.hand[2]
        var passed = false
        if(beforeShuffle1 != afterShuffle1 && beforeShuffle2 != afterShuffle2){
            passed = true
        }
        assertEquals(true, passed)
    }
    // Dodaj więcej testów według potrzeb
}