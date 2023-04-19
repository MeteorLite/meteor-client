import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("te")
public class class497 {
   @ObfuscatedName("af")
   public final int field4105;
   @ObfuscatedName("an")
   public Object field4104;

   public class497(int var1) {
      this.field4105 = var1;
   }

   public class497(int var1, Object var2) {
      this.field4105 = var1;
      this.field4104 = var2;
   }

    @ObfuscatedName("hashCode")
    public int hashCode() {
      return super.hashCode();
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (!(var1 instanceof class497)) {
         return false;
      } else {
         class497 var2 = (class497)var1;
         if (var2.field4104 == null && this.field4104 != null) {
            return false;
         } else if (this.field4104 == null && var2.field4104 != null) {
            return false;
         } else {
            return var2.field4105 == this.field4105 && var2.field4104.equals(this.field4104);
         }
      }
   }
}
