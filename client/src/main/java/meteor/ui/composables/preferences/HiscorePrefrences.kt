package meteor.ui.composables.preferences

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import meteor.Main
import meteor.hiscore.HiscoreClient
import meteor.hiscore.HiscoreEndpoint
import meteor.hiscore.HiscoreResult
import net.runelite.api.WorldType

var hiscoreresult: MutableState<HiscoreResult?> = mutableStateOf(null)
val hiscoreClient = HiscoreClient()

var username = mutableStateOf("")
fun getWorldEndpoint(): HiscoreEndpoint {
    if (Main.client.worldType.contains(WorldType.FRESH_START_WORLD)) {
        return HiscoreEndpoint.FRESH_START_WORLD
    }
    if (Main.client.worldType.contains(WorldType.DEADMAN)) {
        return HiscoreEndpoint.DEADMAN
    }
    return HiscoreEndpoint.NORMAL
}