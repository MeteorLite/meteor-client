import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class196 extends DualNode {
   @ObfuscatedName("ak")
   static int field1620;

   static {
      new EvictingDualNodeHashTable(64);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1118661589"
   )
   public static int method986() {
      return ViewportMouse.ViewportMouse_entityCount;
   }
}
