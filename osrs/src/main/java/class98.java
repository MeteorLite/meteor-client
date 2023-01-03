import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class98 {
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      descriptor = "Lra;"
   )
   static IndexedSprite field1070;
   @ObfuscatedName("h")
   int field1069;
   @ObfuscatedName("e")
   int field1066;
   @ObfuscatedName("v")
   int field1067;
   @ObfuscatedName("x")
   int field1068;

   class98(int var1, int var2, int var3, int var4) {
      this.field1069 = var1;
      this.field1066 = var2;
      this.field1067 = var3;
      this.field1068 = var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2043447441"
   )
   int method593() {
      return this.field1069;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "0"
   )
   int method594() {
      return this.field1066;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "857409779"
   )
   int method595() {
      return this.field1067;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "47"
   )
   int method596() {
      return this.field1068;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Lgn;I)Z",
      garbageValue = "970496704"
   )
   static boolean method597(ObjectComposition var0) {
      if (var0.transforms != null) {
         int[] var1 = var0.transforms;

         for(int var2 = 0; var2 < var1.length; ++var2) {
            int var3 = var1[var2];
            ObjectComposition var4 = VarpDefinition.getObjectDefinition(var3);
            if (var4.mapIconId != -1) {
               return true;
            }
         }
      } else if (var0.mapIconId != -1) {
         return true;
      }

      return false;
   }
}
