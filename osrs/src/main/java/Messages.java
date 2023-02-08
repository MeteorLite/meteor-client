import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("Messages")
public class Messages {
    @ObfuscatedName("f")
    static final Map Messages_channels = new HashMap();
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lqu;"
    )
    static final IterableNodeHashTable Messages_hashTable = new IterableNodeHashTable(1024);
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lmc;"
    )
    static final IterableDualNodeQueue Messages_queue = new IterableDualNodeQueue();
    @ObfuscatedName("s")
    static int Messages_count = 0;
   @ObfuscatedName("b")
   static boolean field1118;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Lda;FZI)F",
      garbageValue = "-2108882173"
   )
   static float method617(class125 var0, float var1, boolean var2) {
      float var3 = 0.0F;
      if (var0 != null && var0.method701() != 0) {
         float var4 = (float)var0.field1208[0].field1173;
         float var5 = (float)var0.field1208[var0.method701() - 1].field1173;
         float var6 = var5 - var4;
         if ((double)var6 == 0.0D) {
            return var0.field1208[0].field1167;
         } else {
            float var7 = 0.0F;
            if (var1 > var5) {
               var7 = (var1 - var5) / var6;
            } else {
               var7 = (var1 - var4) / var6;
            }

            double var8 = (double)((int)var7);
            float var10 = Math.abs((float)((double)var7 - var8));
            float var11 = var10 * var6;
            var8 = Math.abs(var8 + 1.0D);
            double var12 = var8 / 2.0D;
            double var14 = (double)((int)var12);
            var10 = (float)(var12 - var14);
            float var16;
            float var17;
            if (var2) {
               if (var0.field1206 == class123.field1196) {
                  if ((double)var10 != 0.0D) {
                     var11 += var4;
                  } else {
                     var11 = var5 - var11;
                  }
               } else if (var0.field1206 != class123.field1194 && var0.field1206 != class123.field1197) {
                  if (var0.field1206 == class123.field1195) {
                     var11 = var4 - var1;
                     var16 = var0.field1208[0].field1169;
                     var17 = var0.field1208[0].field1170;
                     var3 = var0.field1208[0].field1167;
                     if (0.0D != (double)var16) {
                        var3 -= var17 * var11 / var16;
                     }

                     return var3;
                  }
               } else {
                  var11 = var5 - var11;
               }
            } else if (var0.field1223 == class123.field1196) {
               if (0.0D != (double)var10) {
                  var11 = var5 - var11;
               } else {
                  var11 += var4;
               }
            } else if (var0.field1223 != class123.field1194 && var0.field1223 != class123.field1197) {
               if (var0.field1223 == class123.field1195) {
                  var11 = var1 - var5;
                  var16 = var0.field1208[var0.method701() - 1].field1172;
                  var17 = var0.field1208[var0.method701() - 1].field1171;
                  var3 = var0.field1208[var0.method701() - 1].field1167;
                  if (0.0D != (double)var16) {
                     var3 += var17 * var11 / var16;
                  }

                  return var3;
               }
            } else {
               var11 += var4;
            }

            var3 = UrlRequester.method635(var0, var11);
            float var18;
            if (var2 && var0.field1206 == class123.field1197) {
               var18 = var0.field1208[var0.method701() - 1].field1167 - var0.field1208[0].field1167;
               var3 = (float)((double)var3 - var8 * (double)var18);
            } else if (!var2 && var0.field1223 == class123.field1197) {
               var18 = var0.field1208[var0.method701() - 1].field1167 - var0.field1208[0].field1167;
               var3 = (float)((double)var3 + var8 * (double)var18);
            }

            return var3;
         }
      } else {
         return var3;
      }
   }
}
