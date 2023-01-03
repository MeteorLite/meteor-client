import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oy")
public class class391 extends Link {
   @ObfuscatedName("h")
   public int field3684 = (int)(Message.method344() / 1000L);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lrp;"
   )
   public Username field3685;
   @ObfuscatedName("v")
   public short field3686;

   @ObfuscatedSignature(
      descriptor = "(Lrp;I)V"
   )
   class391(Username var1, int var2) {
      this.field3685 = var1;
      this.field3686 = (short)var2;
   }
}
