package eventbus.events

import net.runelite.api.Player

/**
 * This will fire whenever the [net.runelite.api.PlayerComposition] hash changes.
 */
class PlayerCompositionChanged(player: Player)