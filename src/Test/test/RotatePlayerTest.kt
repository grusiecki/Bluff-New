import org.example.Game
import org.example.Player
import kotlin.test.Test
import kotlin.test.assertEquals

class RotatePlayerTest {
    @Test
    fun rotatePlayerTest(){
        var playerList = ArrayList<Player>()
        val player1 = Player()
        val player2 = Player()
        val player3 = Player()
        val player4 = Player()
        playerList.add(player1)
        playerList.add(player2)
        playerList.add(player3)
        playerList.add(player4)

        val game = Game()
        game.rotatePlayers(playerList, player3)
        assertEquals(player3, playerList[0])

    }
}