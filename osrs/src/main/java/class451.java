import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rv")
public class class451 {
   @ObfuscatedName("aj")
   public final Object field3892;
   @ObfuscatedName("al")
   public final Object field3893;

   public class451(Object var1, Object var2) {
      this.field3892 = var1;
      this.field3893 = var2;
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof class451) {
         class451 var2 = (class451)var1;
         if (this.field3892 == null) {
            if (var2.field3892 != null) {
               return false;
            }
         } else if (!this.field3892.equals(var2.field3892)) {
            return false;
         }

         if (this.field3893 == null) {
            if (var2.field3893 != null) {
               return false;
            }
         } else if (!this.field3893.equals(var2.field3893)) {
            return false;
         }

         return true;
      } else {
         return false;
      }
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      return this.field3892 + ", " + this.field3893;
   }

   @Export("hashCode")
   @ObfuscatedName("hashCode")
   public int hashCode() {
      int var1 = 0;
      if (this.field3892 != null) {
         var1 += this.field3892.hashCode();
      }

      if (this.field3893 != null) {
         var1 += 31 * this.field3893.hashCode();
      }

      return var1;
   }
}
