import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rm")
public class class482 {
    @ObfuscatedName("sm")
    @ObfuscatedSignature(
            descriptor = "Lfm;"
    )
    static ClanChannel guestClanChannel;
   @ObfuscatedName("f")
   public final int field4059;
   @ObfuscatedName("w")
   public Object field4060;

   public class482(int var1) {
      this.field4059 = var1;
   }

   public class482(int var1, Object var2) {
      this.field4059 = var1;
      this.field4060 = var2;
   }

    @ObfuscatedName("hashCode")
    public int hashCode() {
      return super.hashCode();
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (!(var1 instanceof class482)) {
         return false;
      } else {
         class482 var2 = (class482)var1;
         if (var2.field4060 == null && this.field4060 != null) {
            return false;
         } else if (this.field4060 == null && var2.field4060 != null) {
            return false;
         } else {
            return this.field4059 == var2.field4059 && var2.field4060.equals(this.field4060);
         }
      }
   }
}
