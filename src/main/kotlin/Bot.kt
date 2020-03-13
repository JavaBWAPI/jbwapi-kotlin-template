import bwapi.BWClient
import bwapi.DefaultBWListener
import bwapi.Game

class Bot : DefaultBWListener() {
    private var bwClient = BWClient(this)
    private lateinit var game: Game

    override fun onStart() {
        game = bwClient.game
    }

    override fun onFrame() {
        game.drawTextScreen(100, 100, "Hello World!")
    }

    fun start() {
        bwClient.startGame()
    }
}

fun main() {
    val bot = Bot()
    bot.start()
}
