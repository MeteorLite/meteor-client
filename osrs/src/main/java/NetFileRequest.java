import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
public class NetFileRequest extends DualNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   Archive archive;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -533106433
   )
   int crc;
   @ObfuscatedName("v")
   byte padding;
}
