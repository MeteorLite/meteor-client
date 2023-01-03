import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
   @ObfuscatedName("h")
   int field294;

   @ObfuscatedName("h")
   abstract void remove2();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Laz;)I"
   )
   abstract int update();
}
