package eventbus.events

import meteor.Event

/**
 * @author Kris | 07/04/2022
 */
data class RunEnergyChangedEvent(
    val newEnergy: Int
) : Event()