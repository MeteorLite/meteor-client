import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kw")
public abstract class class269 implements class271 {
   @ObfuscatedName("ua")
   @Export("cameraMoveToHeight")
   static int cameraMoveToHeight;
   @ObfuscatedName("aj")
   protected int field2405;

   @ObfuscatedSignature(
      descriptor = "(Lml;Lnq;I)V"
   )
   protected class269(StudioGame var1, Language var2, int var3) {
      this.field2405 = var3;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)Lhm;",
      garbageValue = "-111"
   )
   @Export("StructDefinition_getStructDefinition")
   public static StructComposition StructDefinition_getStructDefinition(int var0) {
      StructComposition var1 = (StructComposition)StructComposition.StructDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = StructComposition.StructDefinition_archive.takeFile(34, var0);
         var1 = new StructComposition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.postDecode();
         StructComposition.StructDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lne;II)V",
      garbageValue = "-690030829"
   )
   static void method1515(AbstractArchive var0, int var1) {
      if ((var1 & 536870912) != 0) {
         Login.logoSprite = class368.SpriteBuffer_getIndexedSpriteByName(var0, "logo_deadman_mode", "");
      } else if ((var1 & 1073741824) != 0) {
         Login.logoSprite = class368.SpriteBuffer_getIndexedSpriteByName(var0, "logo_seasonal_mode", "");
      } else if ((var1 & 256) != 0) {
         Login.logoSprite = class368.SpriteBuffer_getIndexedSpriteByName(var0, "logo_speedrunning", "");
      } else {
         Login.logoSprite = class368.SpriteBuffer_getIndexedSpriteByName(var0, "logo", "");
      }

   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      descriptor = "(Ldh;IILis;I)V",
      garbageValue = "941778768"
   )
   static final void method1516(Player var0, int var1, int var2, MoveSpeed var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.transformedSize();
      if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if (var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var9 = var0.transformedSize();
            Client.field444.approxDestinationX = var1;
            Client.field444.approxDestinationY = var2;
            Client.field444.approxDestinationSizeX = 1;
            Client.field444.approxDestinationSizeY = 1;
            ApproximateRouteStrategy var10 = Client.field444;
            int var11 = class16.method60(var4, var5, var9, var10, Client.collisionMaps[var0.plane], true, Client.field416, Client.field645);
            if (var11 >= 1) {
               for(int var12 = 0; var12 < var11 - 1; ++var12) {
                  var0.method491(Client.field416[var12], Client.field645[var12], var3);
               }

            }
         }
      }
   }
}
