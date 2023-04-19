import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public abstract class class273 implements class275 {
   @ObfuscatedName("af")
   protected int field2449;

   @ObfuscatedSignature(
      descriptor = "(Lmr;Lnx;I)V"
   )
   protected class273(StudioGame var1, Language var2, int var3) {
      this.field2449 = var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-975091517"
   )
   static void method1570() {
      ByteArrayPool.field3662.clear();
      ByteArrayPool.field3662.add(100);
      ByteArrayPool.field3662.add(5000);
      ByteArrayPool.field3662.add(10000);
      ByteArrayPool.field3662.add(30000);
   }
}
