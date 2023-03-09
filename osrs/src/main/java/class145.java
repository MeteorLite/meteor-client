import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class145 extends class140 {
   @ObfuscatedName("an")
   @Export("ArchiveDiskActionHandler_thread")
   static Thread ArchiveDiskActionHandler_thread;
   @ObfuscatedName("aj")
   int field1313;
   @ObfuscatedName("al")
   int field1316;
   @ObfuscatedName("ac")
   int field1314;
   @ObfuscatedName("ab")
   int field1315;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfo;"
   )
   final class143 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfo;)V"
   )
   class145(class143 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-1979280996"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      this.field1313 = var1.readInt();
      this.field1315 = var1.readInt();
      this.field1316 = var1.readUnsignedByte();
      this.field1314 = var1.readUnsignedByte();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lfi;B)V",
      garbageValue = "29"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method800(this.field1313, this.field1315, this.field1316, this.field1314);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lne;I)V",
      garbageValue = "-493974812"
   )
   public static void method764(AbstractArchive var0) {
      FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lew;FFFFFFFFI)V",
      garbageValue = "1761714022"
   )
   static void method767(class127 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var0 != null) {
         float var9 = var4 - var1;
         if (0.0D != (double)var9) {
            float var10 = var2 - var1;
            float var11 = var3 - var1;
            float[] var12 = new float[]{var10 / var9, var11 / var9};
            var0.field1221 = var12[0] == 0.33333334F && 0.6666667F == var12[1];
            float var13 = var12[0];
            float var14 = var12[1];
            if ((double)var12[0] < 0.0D) {
               var12[0] = 0.0F;
            }

            if ((double)var12[1] > 1.0D) {
               var12[1] = 1.0F;
            }

            float var15;
            if ((double)var12[0] > 1.0D || var12[1] < -1.0F) {
               var12[1] = 1.0F - var12[1];
               if (var12[0] < 0.0F) {
                  var12[0] = 0.0F;
               }

               if (var12[1] < 0.0F) {
                  var12[1] = 0.0F;
               }

               if (var12[0] > 1.0F || var12[1] > 1.0F) {
                  var15 = (float)(1.0D + (double)var12[1] * ((double)var12[1] - 2.0D) + (double)(var12[0] * (var12[1] + (var12[0] - 2.0F))));
                  if (var15 + class123.field1167 > 0.0F) {
                     Client.method384(var12);
                  }
               }

               var12[1] = 1.0F - var12[1];
            }

            float var10000;
            if (var13 != var12[0]) {
               var10000 = var1 + var9 * var12[0];
               if (0.0D != (double)var13) {
                  var6 = var5 + var12[0] * (var6 - var5) / var13;
               }
            }

            if (var12[1] != var14) {
               var10000 = var1 + var12[1] * var9;
               if (1.0D != (double)var14) {
                  var7 = (float)((double)var8 - (double)(var8 - var7) * (1.0D - (double)var12[1]) / (1.0D - (double)var14));
               }
            }

            var0.field1207 = var1;
            var0.field1206 = var4;
            var15 = var12[0];
            float var16 = var12[1];
            float var17 = var15 - 0.0F;
            float var18 = var16 - var15;
            float var19 = 1.0F - var16;
            float var20 = var18 - var17;
            var0.field1202 = var19 - var18 - var20;
            var0.field1209 = var20 + var20 + var20;
            var0.field1208 = var17 + var17 + var17;
            var0.field1223 = 0.0F;
            DesktopPlatformInfoProvider.method2241(var5, var6, var7, var8, var0);
         }
      }
   }
}
