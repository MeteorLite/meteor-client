import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class ClanChannelMember {
   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static Archive archive10;
   @ObfuscatedName("h")
   public byte rank;
   @ObfuscatedName("e")
   public int world;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lrp;"
   )
   public Username username;

   @ObfuscatedName("e")
   public static int method3084(long var0) {
      return (int)(var0 >>> 0 & 127L);
   }
}
