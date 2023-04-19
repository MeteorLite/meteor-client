import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class140 extends class139 {
   @ObfuscatedName("af")
   int field1318;
   @ObfuscatedName("an")
   boolean field1317;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfa;)V"
   )
   class140(class142 var1) {
      this.this$0 = var1;
      this.field1318 = -1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "168736686"
    )
    void vmethod3254(Buffer var1) {
      this.field1318 = var1.readUnsignedShort();
      this.field1317 = var1.readUnsignedByte() == 1;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lfj;I)V",
            garbageValue = "1712319228"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method860(this.field1318, this.field1317);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "81"
   )
   public static int method806(int var0) {
      return class295.field2716[var0];
   }
}
