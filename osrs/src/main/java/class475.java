import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rz")
public class class475 {
   @ObfuscatedName("h")
   public final int field4047;
   @ObfuscatedName("e")
   public Object field4048;

   public class475(int var1) {
      this.field4047 = var1;
   }

   public class475(int var1, Object var2) {
      this.field4047 = var1;
      this.field4048 = var2;
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (!(var1 instanceof class475)) {
         return false;
      } else {
         class475 var2 = (class475)var1;
         if (var2.field4048 == null && this.field4048 != null) {
            return false;
         } else if (this.field4048 == null && var2.field4048 != null) {
            return false;
         } else {
            return var2.field4047 == this.field4047 && var2.field4048.equals(this.field4048);
         }
      }
   }

   @ObfuscatedName("hashCode")
   public int hashCode() {
      return super.hashCode();
   }
}
