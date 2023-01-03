import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qr")
public class class456 implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lqr;"
   )
   public static final class456 field3970 = new class456(0, 0, Integer.class, new class453());
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lqr;"
   )
   public static final class456 field3967 = new class456(2, 1, Long.class, new class455());
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lqr;"
   )
   public static final class456 field3968 = new class456(1, 2, String.class, new class457());
   @ObfuscatedName("x")
   public final int field3969;
   @ObfuscatedName("m")
   public final int field3972;
   @ObfuscatedName("q")
   public final Class field3971;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lqu;"
   )
   final class452 field3966;

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/Class;Lqu;)V"
   )
   class456(int var1, int var2, Class var3, class452 var4) {
      this.field3969 = var1;
      this.field3972 = var2;
      this.field3971 = var3;
      this.field3966 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field3972;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)Ljava/lang/Object;",
      garbageValue = "-667358219"
   )
   public Object method2301(Buffer var1) {
      return this.field3966.vmethod8273(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(S)[Lqr;",
      garbageValue = "155"
   )
   public static class456[] method2303() {
      return new class456[]{field3970, field3967, field3968};
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IB)Ljava/lang/String;",
      garbageValue = "-107"
   )
   static String method2305(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IILgg;Lgw;I)Z",
      garbageValue = "-2047038701"
   )
   static final boolean method2306(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class205.directions[var6][var7] = 99;
      class205.distances[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class205.bufferX[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class205.bufferY[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class205.bufferX[var11];
         var5 = class205.bufferY[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.xInset;
         int var14 = var5 - var3.yInset;
         if (var2.hasArrived(1, var4, var5, var3)) {
            class205.field1851 = var4;
            class205.field1855 = var5;
            return true;
         }

         int var15 = class205.distances[var16][var17] + 1;
         if (var16 > 0 && class205.directions[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class205.bufferX[var18] = var4 - 1;
            class205.bufferY[var18] = var5;
            var18 = var18 + 1 & 4095;
            class205.directions[var16 - 1][var17] = 2;
            class205.distances[var16 - 1][var17] = var15;
         }

         if (var16 < 127 && class205.directions[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class205.bufferX[var18] = var4 + 1;
            class205.bufferY[var18] = var5;
            var18 = var18 + 1 & 4095;
            class205.directions[var16 + 1][var17] = 8;
            class205.distances[var16 + 1][var17] = var15;
         }

         if (var17 > 0 && class205.directions[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class205.bufferX[var18] = var4;
            class205.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class205.directions[var16][var17 - 1] = 1;
            class205.distances[var16][var17 - 1] = var15;
         }

         if (var17 < 127 && class205.directions[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class205.bufferX[var18] = var4;
            class205.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class205.directions[var16][var17 + 1] = 4;
            class205.distances[var16][var17 + 1] = var15;
         }

         if (var16 > 0 && var17 > 0 && class205.directions[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class205.bufferX[var18] = var4 - 1;
            class205.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class205.directions[var16 - 1][var17 - 1] = 3;
            class205.distances[var16 - 1][var17 - 1] = var15;
         }

         if (var16 < 127 && var17 > 0 && class205.directions[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class205.bufferX[var18] = var4 + 1;
            class205.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class205.directions[var16 + 1][var17 - 1] = 9;
            class205.distances[var16 + 1][var17 - 1] = var15;
         }

         if (var16 > 0 && var17 < 127 && class205.directions[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class205.bufferX[var18] = var4 - 1;
            class205.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class205.directions[var16 - 1][var17 + 1] = 6;
            class205.distances[var16 - 1][var17 + 1] = var15;
         }

         if (var16 < 127 && var17 < 127 && class205.directions[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class205.bufferX[var18] = var4 + 1;
            class205.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class205.directions[var16 + 1][var17 + 1] = 12;
            class205.distances[var16 + 1][var17 + 1] = var15;
         }
      }

      class205.field1851 = var4;
      class205.field1855 = var5;
      return false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Class;B)Lqr;",
      garbageValue = "56"
   )
   public static class456 method2299(Class var0) {
      class456[] var1 = method2303();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class456 var3 = var1[var2];
         if (var3.field3971 == var0) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;Lqy;I)V",
      garbageValue = "383102179"
   )
   public static void method2300(Object var0, Buffer var1) {
      class452 var2 = method2304(var0.getClass());
      var2.vmethod8274(var0, var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Class;B)Lqu;",
      garbageValue = "-2"
   )
   static class452 method2304(Class var0) {
      class456 var1 = method2299(var0);
      if (var1 == null) {
         throw new IllegalArgumentException();
      } else {
         return var1.field3966;
      }
   }
}
