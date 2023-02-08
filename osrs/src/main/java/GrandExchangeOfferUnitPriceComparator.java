import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mx")
@Implements("GrandExchangeOfferUnitPriceComparator")
final class GrandExchangeOfferUnitPriceComparator implements Comparator {
    @ObfuscatedName("vz")
    @ObfuscatedSignature(
            descriptor = "Lqf;"
    )
    static WorldMap worldMap;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lmv;Lmv;B)I",
            garbageValue = "75"
    )
    int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.unitPrice < var2.grandExchangeOffer.unitPrice ? -1 : (var2.grandExchangeOffer.unitPrice == var1.grandExchangeOffer.unitPrice ? 0 : 1);
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      return super.equals(var1);
   }

    @ObfuscatedName("compare")
    public int compare(Object var1, Object var2) {
      return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1038582693"
   )
   static int method1863(int var0) {
      return class28.KeyHandler_keyCodes[var0];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-269331071"
   )
   static int method1864(CharSequence var0, int var1, boolean var2) {
      if (var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if (var7 == 0) {
               if (var8 == '-') {
                  var3 = true;
                  continue;
               }

               if (var8 == '+') {
                  continue;
               }
            }

            int var10;
            if (var8 >= '0' && var8 <= '9') {
               var10 = var8 - 48;
            } else if (var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - 55;
            } else {
               if (var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if (var10 >= var1) {
               throw new NumberFormatException();
            }

            if (var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if (var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if (!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("" + var1);
      }
   }
}
