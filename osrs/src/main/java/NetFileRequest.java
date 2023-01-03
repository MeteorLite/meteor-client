import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   Archive archive;
   @ObfuscatedName("e")
   int crc;
   @ObfuscatedName("v")
   byte padding;
}
