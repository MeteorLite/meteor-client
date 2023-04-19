import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class70 {
   @ObfuscatedName("af")
   static final BigInteger field726 = new BigInteger("10001", 16);
   @ObfuscatedName("an")
   static final BigInteger field727 = new BigInteger("caa2a7bee781b3652a5a550b5318cb074141ad9dbd06389622fbd58a3947aeb27e79771809fb6e20de92d7cdbe34830805ebad9bb17640a45878eea57edbb1d808a6122150c097b7a4960054ccc5e98fc0a139709f6f1a3dbf0bfc4559d63ba568b3860a7d477756bd21bb37f989b4522af2d3ee6af1781654acbafd740072c1", 16);
    @ObfuscatedName("cn")
    @ObfuscatedSignature(
            descriptor = "Lsw;"
    )
    static LoginType loginType;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "698228402"
   )
   public static int method442(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(IIII)D",
      garbageValue = "-426403722"
   )
   static double method443(int var0, int var1, int var2) {
      double var3 = var1 > 0 ? (double)Math.max(0.0F, Math.min(1.0F, (float)var0 / (float)var1)) : 1.0D;
      if (var3 > 0.0D && var3 < 1.0D) {
         double var5;
         double var7;
         switch(var2) {
         case 0:
            return var3;
         case 1:
            return 1.0D - Math.cos(var3 * 3.141592653589793D / 2.0D);
         case 2:
            return Math.sin(var3 * 3.141592653589793D / 2.0D);
         case 3:
            return -(Math.cos(var3 * 3.141592653589793D) - 1.0D) / 2.0D;
         case 4:
            return var3 * var3;
         case 5:
            return 1.0D - (1.0D - var3) * (1.0D - var3);
         case 6:
            return var3 < 0.5D ? var3 * var3 * 2.0D : 1.0D - Math.pow(2.0D + var3 * -2.0D, 2.0D) / 2.0D;
         case 7:
            return var3 * var3 * var3;
         case 8:
            return 1.0D - Math.pow(1.0D - var3, 3.0D);
         case 9:
            return var3 < 0.5D ? var3 * 4.0D * var3 * var3 : 1.0D - Math.pow(2.0D + var3 * -2.0D, 3.0D) / 2.0D;
         case 10:
            return var3 * var3 * var3 * var3;
         case 11:
            return 1.0D - Math.pow(1.0D - var3, 4.0D);
         case 12:
            return var3 < 0.5D ? var3 * var3 * var3 * var3 * 8.0D : 1.0D - Math.pow(var3 * -2.0D + 2.0D, 4.0D) / 2.0D;
         case 13:
            return var3 * var3 * var3 * var3 * var3;
         case 14:
            return 1.0D - Math.pow(1.0D - var3, 5.0D);
         case 15:
            return var3 < 0.5D ? var3 * var3 * var3 * 8.0D * var3 * var3 : 1.0D - Math.pow(var3 * -2.0D + 2.0D, 5.0D) / 2.0D;
         case 16:
            return Math.pow(2.0D, var3 * 10.0D - 10.0D);
         case 17:
            return 1.0D - Math.pow(2.0D, var3 * -10.0D);
         case 18:
            return var3 < 0.5D ? Math.pow(2.0D, var3 * 20.0D + 10.0D) / 2.0D : (2.0D - Math.pow(2.0D, 10.0D + var3 * -20.0D)) / 2.0D;
         case 19:
            return 1.0D - Math.sqrt(1.0D - Math.pow(var3, 2.0D));
         case 20:
            return Math.sqrt(1.0D - Math.pow(var3 - 1.0D, 2.0D));
         case 21:
            return var3 < 0.5D ? (1.0D - Math.sqrt(1.0D - Math.pow(var3 * 2.0D, 2.0D))) / 2.0D : (Math.sqrt(1.0D - Math.pow(2.0D + var3 * -2.0D, 2.0D)) + 1.0D) / 2.0D;
         case 22:
            var5 = 1.70158D;
            var7 = 2.70158D;
            return var3 * 2.70158D * var3 * var3 - var3 * 1.70158D * var3;
         case 23:
            var5 = 1.70158D;
            var7 = 2.70158D;
            return 1.0D + 2.70158D * Math.pow(var3 - 1.0D, 3.0D) + 1.70158D * Math.pow(var3 - 1.0D, 2.0D);
         case 24:
            var5 = 1.70158D;
            var7 = 2.5949095D;
            return var3 < 0.5D ? Math.pow(var3 * 2.0D, 2.0D) * (var3 * 7.189819D - 2.5949095D) / 2.0D : (Math.pow(var3 * 2.0D - 2.0D, 2.0D) * (2.5949095D + (var3 * 2.0D - 2.0D) * 3.5949095D) + 2.0D) / 2.0D;
         case 25:
            var5 = 2.0943951023931953D;
            return -Math.pow(2.0D, var3 * 10.0D - 10.0D) * Math.sin((var3 * 10.0D - 10.75D) * 2.0943951023931953D);
         case 26:
            var5 = 2.0943951023931953D;
            return Math.pow(2.0D, var3 * -10.0D) * Math.sin((var3 * 10.0D - 0.75D) * 2.0943951023931953D) + 1.0D;
         case 27:
            var5 = 1.3962634015954636D;
            var7 = Math.sin((var3 * 20.0D - 11.125D) * 1.3962634015954636D);
            return var3 < 0.5D ? -(Math.pow(2.0D, var3 * 20.0D - 10.0D) * var7) / 2.0D : Math.pow(2.0D, var3 * -20.0D + 10.0D) * var7 / 2.0D + 1.0D;
         default:
            return var3;
         }
      } else {
         return var3 <= 0.0D ? 0.0D : 1.0D;
      }
   }
}
