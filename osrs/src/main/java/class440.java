import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("pg")
public class class440 {
   @ObfuscatedName("h")
   public final Object field3917;
   @ObfuscatedName("e")
   public final Object field3916;

   public class440(Object var1, Object var2) {
      this.field3917 = var1;
      this.field3916 = var2;
   }

   @Export("hashCode")
   @ObfuscatedName("hashCode")
   public int hashCode() {
      int var1 = 0;
      if (this.field3917 != null) {
         var1 += this.field3917.hashCode();
      }

      if (this.field3916 != null) {
         var1 += 31 * this.field3916.hashCode();
      }

      return var1;
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof class440) {
         class440 var2 = (class440)var1;
         if (this.field3917 == null) {
            if (var2.field3917 != null) {
               return false;
            }
         } else if (!this.field3917.equals(var2.field3917)) {
            return false;
         }

         if (this.field3916 == null) {
            if (var2.field3916 != null) {
               return false;
            }
         } else if (!this.field3916.equals(var2.field3916)) {
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
      return this.field3917 + ", " + this.field3916;
   }
}
