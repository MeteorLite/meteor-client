package meteor.api.widgets


import Main.client
import meteor.api.game.GameThread
import java.util.*

enum class DialogOption(val widgetUid: Int, val menuIndex: Int) {
    NPC_CONTINUE(15138820, -1), PLAYER_CONTINUE(14221316, -1), QUEST(12648448, 0), ITEM_ONE(12648448, -1), ITEM_TWO(
        12648448,
        0
    ),
    CHAT_OPTION_ONE(14352385, 1), CHAT_OPTION_TWO(14352385, 2), CHAT_OPTION_THREE(14352385, 3), CHAT_OPTION_FOUR(
        14352385,
        4
    ),
    CHAT_OPTION_FIVE(14352385, 5), PLAIN_CONTINUE(15007746, -1), PLAIN_CONTINUE_TWO(720900, -1);

    fun process() {
        GameThread.invoke { client.processDialog(widgetUid, menuIndex) }
    }

    companion object {
        fun of(widgetUid: Int, menuIndex: Int): DialogOption? {
            return Arrays.stream(values())
                .filter { option: DialogOption? -> option!!.widgetUid == widgetUid && option.menuIndex == menuIndex }
                .findFirst()
                .orElse(null)
        }
    }
}