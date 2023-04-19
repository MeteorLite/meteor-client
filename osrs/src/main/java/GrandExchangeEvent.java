import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nu")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("il")
   static long field3524;
    @ObfuscatedName("af")
    public final int world;
    @ObfuscatedName("an")
    public final long age;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lnb;"
    )
    public final GrandExchangeOffer grandExchangeOffer;
    @ObfuscatedName("ac")
    String offerName;
    @ObfuscatedName("au")
    String previousOfferName;

   @ObfuscatedSignature(
      descriptor = "(Lsg;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.offerName = var1.readStringCp1252NullTerminated();
      this.previousOfferName = var1.readStringCp1252NullTerminated();
      this.world = var1.readUnsignedShort();
      this.age = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method1928(2);
      this.grandExchangeOffer.method1927(var2);
      this.grandExchangeOffer.unitPrice = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.currentQuantity = 0;
      this.grandExchangeOffer.currentPrice = 0;
      this.grandExchangeOffer.id = var3;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "513475535"
    )
    public String getOfferName() {
      return this.offerName;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "-171427168"
    )
    public String getPreviousOfferName() {
      return this.previousOfferName;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lek;FI)F",
      garbageValue = "-756597622"
   )
   static float method1923(class125 var0, float var1) {
      if (var0 != null && var0.method748() != 0) {
         if (var1 < (float)var0.field1219[0].field1175) {
            return var0.field1220 == class123.field1207 ? var0.field1219[0].field1178 : Message.method358(var0, var1, true);
         } else if (var1 > (float)var0.field1219[var0.method748() - 1].field1175) {
            return var0.field1236 == class123.field1207 ? var0.field1219[var0.method748() - 1].field1178 : Message.method358(var0, var1, false);
         } else if (var0.field1216) {
            return var0.field1219[0].field1178;
         } else {
            class120 var2 = var0.method747(var1);
            boolean var3 = false;
            boolean var4 = false;
            if (var2 == null) {
               return 0.0F;
            } else {
               float var5;
               float var6;
               float var7;
               if ((double)var2.field1176 == 0.0D && (double)var2.field1173 == 0.0D) {
                  var3 = true;
               } else if (Float.MAX_VALUE == var2.field1176 && Float.MAX_VALUE == var2.field1173) {
                  var4 = true;
               } else if (var2.field1177 != null) {
                  if (var0.field1232) {
                     var5 = (float)var2.field1175;
                     float var9 = var2.field1178;
                     var6 = var5 + var2.field1176 * 0.33333334F;
                     float var10 = var9 + var2.field1173 * 0.33333334F;
                     float var8 = (float)var2.field1177.field1175;
                     float var12 = var2.field1177.field1178;
                     var7 = var8 - 0.33333334F * var2.field1177.field1174;
                     float var11 = var12 - 0.33333334F * var2.field1177.field1172;
                     if (var0.field1231) {
                        ParamComposition.method1062(var0, var5, var6, var7, var8, var9, var10, var11, var12);
                     } else if (var0 != null) {
                        var0.field1221 = var5;
                        float var13 = var8 - var5;
                        float var14 = var12 - var9;
                        float var15 = var6 - var5;
                        float var16 = 0.0F;
                        float var17 = 0.0F;
                        if ((double)var15 != 0.0D) {
                           var16 = (var10 - var9) / var15;
                        }

                        var15 = var8 - var7;
                        if (0.0D != (double)var15) {
                           var17 = (var12 - var11) / var15;
                        }

                        float var18 = 1.0F / (var13 * var13);
                        float var19 = var13 * var16;
                        float var20 = var17 * var13;
                        var0.field1223 = (var20 + var19 - var14 - var14) * var18 / var13;
                        var0.field1224 = (var14 + var14 + var14 - var19 - var19 - var20) * var18;
                        var0.field1237 = var16;
                        var0.field1226 = var9;
                     }

                     var0.field1232 = false;
                  }
               } else {
                  var3 = true;
               }

               if (var3) {
                  return var2.field1178;
               } else if (var4) {
                  return var1 != (float)var2.field1175 && var2.field1177 != null ? var2.field1177.field1178 : var2.field1178;
               } else if (var0.field1231) {
                  if (var0 == null) {
                     var5 = 0.0F;
                  } else {
                     if (var1 == var0.field1221) {
                        var6 = 0.0F;
                     } else if (var0.field1229 == var1) {
                        var6 = 1.0F;
                     } else {
                        var6 = (var1 - var0.field1221) / (var0.field1229 - var0.field1221);
                     }

                     if (var0.field1217) {
                        var7 = var6;
                     } else {
                        class121.field1183[3] = var0.field1226;
                        class121.field1183[2] = var0.field1237;
                        class121.field1183[1] = var0.field1224;
                        class121.field1183[0] = var0.field1223 - var6;
                        class121.field1182[0] = 0.0F;
                        class121.field1182[1] = 0.0F;
                        class121.field1182[2] = 0.0F;
                        class121.field1182[3] = 0.0F;
                        class121.field1182[4] = 0.0F;
                        int var21 = class103.method638(class121.field1183, 3, 0.0F, true, 1.0F, true, class121.field1182);
                        if (var21 == 1) {
                           var7 = class121.field1182[0];
                        } else {
                           var7 = 0.0F;
                        }
                     }

                     var5 = var0.field1227 + (var0.field1228 + (var0.field1230 * var7 + var0.field1225) * var7) * var7;
                  }

                  return var5;
               } else {
                  return class14.method58(var0, var1);
               }
            }
         }
      } else {
         return 0.0F;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "157863063"
   )
   public static void method1922() {
      HealthBarDefinition.HealthBarDefinition_cached.clear();
      HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
   }
}
