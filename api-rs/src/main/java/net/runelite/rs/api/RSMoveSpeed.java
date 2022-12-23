package net.runelite.rs.api;

import net.runelite.api.MoveSpeed;
import net.runelite.mapping.Import;

/**
 * @author Kris | 10/12/2021
 */
public interface RSMoveSpeed extends MoveSpeed {
    @Import("speed")
    @Override
    byte speed();
}
