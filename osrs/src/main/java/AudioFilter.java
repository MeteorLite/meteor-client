import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("AudioFilter")
public class AudioFilter {
   @ObfuscatedName("q")
   static float[][] field303 = new float[2][8];
   @ObfuscatedName("f")
   @Export("coefficients")
   static int[][] coefficients = new int[2][8];
   @ObfuscatedName("r")
   static float field305;
   @ObfuscatedName("u")
   @Export("forwardMultiplier")
   static int forwardMultiplier;
   @ObfuscatedName("h")
   @Export("pairs")
   int[] pairs = new int[2];
   @ObfuscatedName("v")
   int[][][] field306 = new int[2][2][4];
   @ObfuscatedName("x")
   int[][][] field301 = new int[2][2][4];
   @ObfuscatedName("m")
   int[] field302 = new int[2];

   @ObfuscatedName("h")
   float method320(int var1, int var2, float var3) {
      float var4 = (float)this.field301[var1][0][var2] + var3 * (float)(this.field301[var1][1][var2] - this.field301[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("v")
   float method324(int var1, int var2, float var3) {
      float var4 = (float)this.field306[var1][0][var2] + var3 * (float)(this.field306[var1][1][var2] - this.field306[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return normalize(var4);
   }

   @ObfuscatedName("x")
   @Export("compute")
   int compute(int var1, float var2) {
      float var3;
      if (var1 == 0) {
         var3 = (float)this.field302[0] + (float)(this.field302[1] - this.field302[0]) * var2;
         var3 *= 0.0030517578F;
         field305 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         forwardMultiplier = (int)(field305 * 65536.0F);
      }

      if (this.pairs[var1] == 0) {
         return 0;
      } else {
         var3 = this.method320(var1, 0, var2);
         field303[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method324(var1, 0, var2));
         field303[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.pairs[var1]; ++var4) {
            var3 = this.method320(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method324(var1, var4, var2));
            float var6 = var3 * var3;
            field303[var1][var4 * 2 + 1] = field303[var1][var4 * 2 - 1] * var6;
            field303[var1][var4 * 2] = field303[var1][var4 * 2 - 1] * var5 + field303[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field303[var1][var7] += field303[var1][var7 - 1] * var5 + field303[var1][var7 - 2] * var6;
            }

            field303[var1][1] += field303[var1][0] * var5 + var6;
            field303[var1][0] += var5;
         }

         if (var1 == 0) {
            for(var4 = 0; var4 < this.pairs[0] * 2; ++var4) {
               field303[0][var4] *= field305;
            }
         }

         for(var4 = 0; var4 < this.pairs[var1] * 2; ++var4) {
            coefficients[var1][var4] = (int)(field303[var1][var4] * 65536.0F);
         }

         return this.pairs[var1] * 2;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Lqy;Lah;)V"
   )
   final void method323(Buffer var1, SoundEnvelope var2) {
      int var3 = var1.readUnsignedByte();
      this.pairs[0] = var3 >> 4;
      this.pairs[1] = var3 & 15;
      if (var3 != 0) {
         this.field302[0] = var1.readUnsignedShort();
         this.field302[1] = var1.readUnsignedShort();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.pairs[var5]; ++var6) {
               this.field306[var5][0][var6] = var1.readUnsignedShort();
               this.field301[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.pairs[var5]; ++var6) {
               if ((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field306[var5][1][var6] = var1.readUnsignedShort();
                  this.field301[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field306[var5][1][var6] = this.field306[var5][0][var6];
                  this.field301[var5][1][var6] = this.field301[var5][0][var6];
               }
            }
         }

         if (var4 != 0 || this.field302[1] != this.field302[0]) {
            var2.decodeSegments(var1);
         }
      } else {
         int[] var7 = this.field302;
         this.field302[1] = 0;
         var7[0] = 0;
      }

   }

   @ObfuscatedName("e")
   @Export("normalize")
   static float normalize(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }
}
