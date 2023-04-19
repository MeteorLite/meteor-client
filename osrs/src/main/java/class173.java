import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class173 {
    @ObfuscatedName("kb")
    @ObfuscatedSignature(
            descriptor = "[Ltq;"
    )
    static SpritePixels[] crossSprites;
   @ObfuscatedName("ac")
   public String field1447;
   @ObfuscatedName("au")
   public float[] field1448;
   @ObfuscatedName("ab")
   public int field1449;
   @ObfuscatedName("aq")
   public int field1450;
   @ObfuscatedName("al")
   public int field1446;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lgy;"
   )
   @ObfuscatedName("this$0")
   final class166 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgy;)V"
   )
   class173(class166 var1) {
      this.this$0 = var1;
      this.field1448 = new float[4];
      this.field1449 = 1;
      this.field1450 = 1;
      this.field1446 = 0;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-955607746"
   )
   public static int method956(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if (var4 <= 127) {
            ++var2;
         } else if (var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("aw")
   public static boolean method957(long var0) {
      boolean var2 = 0L != var0;
      if (var2) {
         boolean var3 = (int)(var0 >>> 16 & 1L) == 1;
         var2 = !var3;
      }

      return var2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "61"
   )
   public static void method958() {
      NPCComposition.NpcDefinition_cached.clear();
      NPCComposition.NpcDefinition_cachedModels.clear();
   }

   @ObfuscatedName("nk")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "14"
   )
   static void method955() {
      if (Client.oculusOrbState == 1) {
         Client.oculusOrbOnLocalPlayer = true;
      }

   }
}
