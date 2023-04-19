import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rg")
public class class461 {
   @ObfuscatedName("af")
   public final Object field3972;
   @ObfuscatedName("an")
   public final Object field3973;

   public class461(Object var1, Object var2) {
      this.field3972 = var1;
      this.field3973 = var2;
   }

    @ObfuscatedName("toString")
    public String toString() {
      return this.field3972 + ", " + this.field3973;
   }

    @ObfuscatedName("hashCode")
    public int hashCode() {
      int var1 = 0;
      if (this.field3972 != null) {
         var1 += this.field3972.hashCode();
      }

      if (this.field3973 != null) {
         var1 += 31 * this.field3973.hashCode();
      }

      return var1;
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof class461) {
         class461 var2 = (class461)var1;
         if (this.field3972 == null) {
            if (var2.field3972 != null) {
               return false;
            }
         } else if (!this.field3972.equals(var2.field3972)) {
            return false;
         }

         if (this.field3973 == null) {
            if (var2.field3973 != null) {
               return false;
            }
         } else if (!this.field3973.equals(var2.field3973)) {
            return false;
         }

         return true;
      } else {
         return false;
      }
   }
}
