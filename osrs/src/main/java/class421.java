import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pq")
public class class421 implements class426 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lqs;"
   )
   public final class451 field3802;

   @ObfuscatedSignature(
      descriptor = "(Lqe;)V"
   )
   class421(class452 var1) {
      this.field3802 = var1;
   }

   @ObfuscatedSignature(
      descriptor = "(Lpo;)V"
   )
   public class421(class422 var1) {
      this(new class452(var1));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "70"
   )
   public int method2194(int var1) {
      return this.field3802.vmethod8144(var1);
   }
}
