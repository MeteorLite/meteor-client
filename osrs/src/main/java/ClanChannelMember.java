import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("ClanChannelMember")
public class ClanChannelMember {
    @ObfuscatedName("af")
    public byte rank;
    @ObfuscatedName("an")
    public int world;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Ltm;"
    )
    public Username username;
}
