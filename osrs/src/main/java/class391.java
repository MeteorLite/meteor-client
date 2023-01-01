import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oy")
public class class391 extends Link {
   @ObfuscatedName("h")
   public int field4520 = (int)(Message.method1197() / 1000L);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lrp;"
   )
   public Username field4521;
   @ObfuscatedName("v")
   public short field4522;

   @ObfuscatedSignature(
      descriptor = "(Lrp;I)V"
   )
   class391(Username var1, int var2) {
      this.field4521 = var1;
      this.field4522 = (short)var2;
   }
}
