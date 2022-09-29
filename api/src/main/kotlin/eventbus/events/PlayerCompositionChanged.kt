package eventbus.events

import lombok.Value
import net.runelite.api.Player

/**
 * This will fire whenever the [net.runelite.api.PlayerComposition] hash changes.
 */
class PlayerCompositionChanged(player: Player)