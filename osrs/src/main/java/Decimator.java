import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("Decimator")
public class Decimator {
   @ObfuscatedName("aq")
   static byte[][][] field300;
   @ObfuscatedName("ab")
   @Export("inputRate")
   int inputRate;
   @ObfuscatedName("an")
   @Export("outputRate")
   int outputRate;
   @ObfuscatedName("ao")
   @Export("table")
   int[][] table;

   public Decimator(int var1, int var2) {
      if (var2 != var1) {
         int var3 = Client.method385(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.inputRate = var1;
         this.outputRate = var2;
         this.table = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.table[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if (var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
            if (var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = ((double)var8 - var6) * 3.141592653589793D;
               double var14 = var10;
               if (var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(0.5D + var14 * 65536.0D);
            }
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "([BI)[B",
      garbageValue = "581070602"
   )
   @Export("resample")
   byte[] resample(byte[] var1) {
      if (this.table != null) {
         int var2 = (int)((long)var1.length * (long)this.outputRate / (long)this.inputRate) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.table[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.outputRate;
            var9 = var5 / this.inputRate;
            var4 += var9;
            var5 -= var9 * this.inputRate;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if (var10 < -128) {
               var1[var6] = -128;
            } else if (var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "1978966471"
   )
   @Export("scaleRate")
   int scaleRate(int var1) {
      if (this.table != null) {
         var1 = (int)((long)this.outputRate * (long)var1 / (long)this.inputRate);
      }

      return var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "122"
   )
   @Export("scalePosition")
   int scalePosition(int var1) {
      if (this.table != null) {
         var1 = (int)((long)this.outputRate * (long)var1 / (long)this.inputRate) + 6;
      }

      return var1;
   }

   @ObfuscatedName("al")
   public static boolean method312(long var0) {
      return var0 != 0L && !ClanSettings.method792(var0);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)[B",
      garbageValue = "-1641012787"
   )
   @Export("ByteArrayPool_getArray")
   public static synchronized byte[] ByteArrayPool_getArray(int var0) {
      return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "([BIIII[Liz;B)V",
      garbageValue = "75"
   )
   static final void method311(byte[] var0, int var1, int var2, int var3, int var4, CollisionMap[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if (var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var12 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               int var10 = var8 + var1;
               int var11 = var9 + var2;
               WorldMapScaleHandler.loadTerrain(var12, var7, var10, var11, var3 + var10, var11 + var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "421048908"
   )
   static int method305() {
      return Login.loginIndex;
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-617298505"
   )
   static final void method309() {
      if (ObjTypeCustomisation.field1453) {
         class174.method906();
         ObjTypeCustomisation.field1453 = false;
      }

   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIIIIII)V",
      garbageValue = "-2138006752"
   )
   @Export("updatePendingSpawn")
   static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      PendingSpawn var10 = null;

      for(PendingSpawn var11 = (PendingSpawn)Client.pendingSpawns.last(); var11 != null; var11 = (PendingSpawn)Client.pendingSpawns.previous()) {
         if (var0 == var11.plane && var11.x == var1 && var2 == var11.y && var3 == var11.type) {
            var10 = var11;
            break;
         }
      }

      if (var10 == null) {
         var10 = new PendingSpawn();
         var10.plane = var0;
         var10.type = var3;
         var10.x = var1;
         var10.y = var2;
         var10.field922 = -1;
         class27.method108(var10);
         Client.pendingSpawns.addFirst(var10);
      }

      var10.id = var4;
      var10.objectType = var5;
      var10.rotation = var6;
      var10.startCycle = var8;
      var10.endCycle = var9;
      var10.method499(var7);
   }
}
