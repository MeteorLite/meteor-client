import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("WorldMapID")
public class WorldMapID {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Ljx;"
   )
   static final WorldMapID field2375 = new WorldMapID(0);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Ljx;"
   )
   static final WorldMapID field2376 = new WorldMapID(1);
   @ObfuscatedName("ac")
   @Export("value")
   final int value;

   WorldMapID(int var1) {
      this.value = var1;
   }
}
