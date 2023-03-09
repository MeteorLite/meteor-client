import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qv")
public class class425 implements class430 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lri;"
   )
   public final class455 field3768;

   @ObfuscatedSignature(
      descriptor = "(Lrn;)V"
   )
   class425(class456 var1) {
      this.field3768 = var1;
   }

   @ObfuscatedSignature(
      descriptor = "(Lql;)V"
   )
   public class425(class426 var1) {
      this(new class456(var1));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "2004463497"
   )
   public int method2209(int var1) {
      return this.field3768.vmethod8144(var1);
   }
}
