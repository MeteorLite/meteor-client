import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public abstract class PcmStreamMixerListener extends Node {
   @ObfuscatedName("h")
   int field429;

   @ObfuscatedName("h")
   abstract void remove2();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Laz;)I"
   )
   abstract int update();
}
