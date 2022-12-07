import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public abstract class RouteStrategy {
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   public static AbstractRasterProvider rasterProvider;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2015601201
   )
   public int approxDestinationX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 941706195
   )
   public int approxDestinationY;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -20945427
   )
   public int approxDestinationSizeX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -390996803
   )
   public int approxDestinationSizeY;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IIILgw;I)Z",
      garbageValue = "1813316312"
   )
   protected abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(CB)Z",
      garbageValue = "39"
   )
   public static final boolean method4181(char var0) {
      if (Character.isISOControl(var0)) {
         return false;
      } else if (ObjectComposition.isAlphaNumeric(var0)) {
         return true;
      } else {
         char[] var1 = class447.field4842;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if (var0 == var3) {
               return true;
            }
         }

         var1 = class447.field4841;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if (var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "16"
   )
   static final void method4180(int var0, int var1) {
      if (Client.hintArrowType == 2) {
         ScriptFrame.worldToScreen(Client.field531 * 64 + (Client.hintArrowX - class154.baseX * 64 << 7), (Client.hintArrowY - class365.baseY * 64 << 7) + Client.field626 * 4096, Client.field530 * 4);
         if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
            class358.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
         }

      }
   }
}
