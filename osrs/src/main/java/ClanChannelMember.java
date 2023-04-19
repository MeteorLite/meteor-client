import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
@Implements("ClanChannelMember")
public class ClanChannelMember {
   @ObfuscatedName("af")
   @Export("rank")
   public byte rank;
   @ObfuscatedName("an")
   @Export("world")
   public int world;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Ltm;"
   )
   @Export("username")
   public Username username;
}
