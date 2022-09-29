package net.runelite.packets;

import java.util.ArrayList;

public class ObfuscatedClientPacket {
    public String name;
    public int opcode;
    public int size;
    public ArrayList<ObfuscatedBufferStructure> structure = new ArrayList<>();
    public ObfuscatedClientPacket() {

    }
}
