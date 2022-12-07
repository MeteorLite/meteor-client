import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("po")
public class ByteArrayNode extends Node {
   @ObfuscatedName("h")
   public byte[] byteArray;

   public ByteArrayNode(byte[] var1) {
      this.byteArray = var1;
   }
}
