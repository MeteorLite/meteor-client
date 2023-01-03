import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nz")
public final class class385 implements Comparable {
   @ObfuscatedName("h")
   Object field3669;
   @ObfuscatedName("e")
   Object field3668;
   @ObfuscatedName("v")
   long field3667;
   @ObfuscatedName("x")
   long field3670;

   class385(Object var1, Object var2) {
      this.field3669 = var1;
      this.field3668 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lnz;I)I",
      garbageValue = "16470781"
   )
   int method2019(class385 var1) {
      if (this.field3670 < var1.field3670) {
         return -1;
      } else {
         return this.field3670 > var1.field3670 ? 1 : 0;
      }
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (var1 instanceof class385) {
         return this.field3668.equals(((class385)var1).field3668);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("hashCode")
   public int hashCode() {
      return this.field3668.hashCode();
   }

   @ObfuscatedName("compareTo")
   public int compareTo(Object var1) {
      return this.method2019((class385)var1);
   }
}
