import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;


@Implements("JSONObject$Null")
@ObfuscatedName("org/json/JSONObject$Null")
final class JSONObject$Null {
   JSONObject$Null() {
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      return var1 == null || this == var1;
   }

   public String toString() {
      return "null";
   }

   public final Object clone() {
      return this;
   }
}
