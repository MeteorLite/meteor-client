package net.runelite.rs.api;

import net.runelite.api.packets.ClientPacket;
import net.runelite.mapping.Import;

public interface RSClientPacket extends ClientPacket
{
@Import("id")
@Override
int getId();

@Import("length")
@Override
int getLength();
}