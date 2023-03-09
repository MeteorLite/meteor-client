import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qt")
public final class class421 {
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "[Lqt;"
   )
   public static class421[] field3746 = new class421[0];
   @ObfuscatedName("ac")
   static int field3744 = 100;
   @ObfuscatedName("ab")
   public static int field3745;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lqt;"
   )
   public static final class421 field3747;
   @ObfuscatedName("an")
   public float[] field3743 = new float[16];

   static {
      field3746 = new class421[100];
      field3745 = 0;
      field3747 = new class421();
   }

   public class421() {
      this.method2193();
   }

   @ObfuscatedSignature(
      descriptor = "(Lqt;)V"
   )
   public class421(class421 var1) {
      this.method2188(var1);
   }

   @ObfuscatedSignature(
      descriptor = "(Lsy;Z)V"
   )
   public class421(Buffer var1, boolean var2) {
      this.method2198(var1, var2);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1774903306"
   )
   public void method2200() {
      class421[] var1 = field3746;
      synchronized(field3746) {
         if (field3745 < field3744 - 1) {
            field3746[++field3745 - 1] = this;
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lsy;ZI)V",
      garbageValue = "-1704033205"
   )
   void method2198(Buffer var1, boolean var2) {
      if (var2) {
         class422 var3 = new class422();
         int var6 = var1.readShort();
         var6 &= 16383;
         float var5 = (float)((double)((float)var6 / 16384.0F) * 6.283185307179586D);
         var3.method2203(var5);
         int var9 = var1.readShort();
         var9 &= 16383;
         float var8 = (float)(6.283185307179586D * (double)((float)var9 / 16384.0F));
         var3.method2204(var8);
         int var12 = var1.readShort();
         var12 &= 16383;
         float var11 = (float)(6.283185307179586D * (double)((float)var12 / 16384.0F));
         var3.method2205(var11);
         var3.method2206((float)var1.readShort(), (float)var1.readShort(), (float)var1.readShort());
         this.method2201(var3);
      } else {
         for(int var13 = 0; var13 < 16; ++var13) {
            this.field3743[var13] = var1.method2414();
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)[F",
      garbageValue = "-101"
   )
   float[] method2185() {
      float[] var1 = new float[3];
      if ((double)this.field3743[2] < 0.999D && (double)this.field3743[2] > -0.999D) {
         var1[1] = (float)(-Math.asin((double)this.field3743[2]));
         double var2 = Math.cos((double)var1[1]);
         var1[0] = (float)Math.atan2((double)this.field3743[6] / var2, (double)this.field3743[10] / var2);
         var1[2] = (float)Math.atan2((double)this.field3743[1] / var2, (double)this.field3743[0] / var2);
      } else {
         var1[0] = 0.0F;
         var1[1] = (float)Math.atan2((double)this.field3743[2], 0.0D);
         var1[2] = (float)Math.atan2((double)(-this.field3743[9]), (double)this.field3743[5]);
      }

      return var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)[F",
      garbageValue = "1868274554"
   )
   public float[] method2195() {
      float[] var1 = new float[]{(float)(-Math.asin((double)this.field3743[6])), 0.0F, 0.0F};
      double var2 = Math.cos((double)var1[0]);
      double var4;
      double var6;
      if (Math.abs(var2) > 0.005D) {
         var4 = (double)this.field3743[2];
         var6 = (double)this.field3743[10];
         double var8 = (double)this.field3743[4];
         double var10 = (double)this.field3743[5];
         var1[1] = (float)Math.atan2(var4, var6);
         var1[2] = (float)Math.atan2(var8, var10);
      } else {
         var4 = (double)this.field3743[1];
         var6 = (double)this.field3743[0];
         if (this.field3743[6] < 0.0F) {
            var1[1] = (float)Math.atan2(var4, var6);
         } else {
            var1[1] = (float)(-Math.atan2(var4, var6));
         }

         var1[2] = 0.0F;
      }

      return var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1579547508"
   )
   public void method2193() {
      this.field3743[0] = 1.0F;
      this.field3743[1] = 0.0F;
      this.field3743[2] = 0.0F;
      this.field3743[3] = 0.0F;
      this.field3743[4] = 0.0F;
      this.field3743[5] = 1.0F;
      this.field3743[6] = 0.0F;
      this.field3743[7] = 0.0F;
      this.field3743[8] = 0.0F;
      this.field3743[9] = 0.0F;
      this.field3743[10] = 1.0F;
      this.field3743[11] = 0.0F;
      this.field3743[12] = 0.0F;
      this.field3743[13] = 0.0F;
      this.field3743[14] = 0.0F;
      this.field3743[15] = 1.0F;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "100"
   )
   public void method2196() {
      this.field3743[0] = 0.0F;
      this.field3743[1] = 0.0F;
      this.field3743[2] = 0.0F;
      this.field3743[3] = 0.0F;
      this.field3743[4] = 0.0F;
      this.field3743[5] = 0.0F;
      this.field3743[6] = 0.0F;
      this.field3743[7] = 0.0F;
      this.field3743[8] = 0.0F;
      this.field3743[9] = 0.0F;
      this.field3743[10] = 0.0F;
      this.field3743[11] = 0.0F;
      this.field3743[12] = 0.0F;
      this.field3743[13] = 0.0F;
      this.field3743[14] = 0.0F;
      this.field3743[15] = 0.0F;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Lqt;I)V",
      garbageValue = "-1594891298"
   )
   public void method2188(class421 var1) {
      System.arraycopy(var1.field3743, 0, this.field3743, 0, 16);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(FI)V",
      garbageValue = "-963333532"
   )
   public void method2187(float var1) {
      this.method2186(var1, var1, var1);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(FFFI)V",
      garbageValue = "-1492163658"
   )
   public void method2186(float var1, float var2, float var3) {
      this.method2193();
      this.field3743[0] = var1;
      this.field3743[5] = var2;
      this.field3743[10] = var3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Lqt;I)V",
      garbageValue = "1265956468"
   )
   public void method2199(class421 var1) {
      for(int var2 = 0; var2 < this.field3743.length; ++var2) {
         this.field3743[var2] += var1.field3743[var2];
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(Lqt;B)V",
      garbageValue = "27"
   )
   public void method2189(class421 var1) {
      float var2 = this.field3743[1] * var1.field3743[4] + this.field3743[0] * var1.field3743[0] + this.field3743[2] * var1.field3743[8] + this.field3743[3] * var1.field3743[12];
      float var3 = this.field3743[3] * var1.field3743[13] + this.field3743[2] * var1.field3743[9] + this.field3743[1] * var1.field3743[5] + var1.field3743[1] * this.field3743[0];
      float var4 = var1.field3743[10] * this.field3743[2] + var1.field3743[2] * this.field3743[0] + var1.field3743[6] * this.field3743[1] + this.field3743[3] * var1.field3743[14];
      float var5 = var1.field3743[7] * this.field3743[1] + var1.field3743[3] * this.field3743[0] + this.field3743[2] * var1.field3743[11] + var1.field3743[15] * this.field3743[3];
      float var6 = this.field3743[7] * var1.field3743[12] + this.field3743[6] * var1.field3743[8] + this.field3743[4] * var1.field3743[0] + this.field3743[5] * var1.field3743[4];
      float var7 = this.field3743[7] * var1.field3743[13] + var1.field3743[9] * this.field3743[6] + this.field3743[5] * var1.field3743[5] + var1.field3743[1] * this.field3743[4];
      float var8 = this.field3743[6] * var1.field3743[10] + this.field3743[5] * var1.field3743[6] + this.field3743[4] * var1.field3743[2] + var1.field3743[14] * this.field3743[7];
      float var9 = var1.field3743[15] * this.field3743[7] + this.field3743[4] * var1.field3743[3] + var1.field3743[7] * this.field3743[5] + this.field3743[6] * var1.field3743[11];
      float var10 = var1.field3743[12] * this.field3743[11] + var1.field3743[0] * this.field3743[8] + this.field3743[9] * var1.field3743[4] + this.field3743[10] * var1.field3743[8];
      float var11 = var1.field3743[13] * this.field3743[11] + var1.field3743[9] * this.field3743[10] + var1.field3743[5] * this.field3743[9] + var1.field3743[1] * this.field3743[8];
      float var12 = this.field3743[11] * var1.field3743[14] + var1.field3743[10] * this.field3743[10] + this.field3743[8] * var1.field3743[2] + var1.field3743[6] * this.field3743[9];
      float var13 = var1.field3743[11] * this.field3743[10] + var1.field3743[7] * this.field3743[9] + this.field3743[8] * var1.field3743[3] + var1.field3743[15] * this.field3743[11];
      float var14 = this.field3743[15] * var1.field3743[12] + this.field3743[13] * var1.field3743[4] + var1.field3743[0] * this.field3743[12] + this.field3743[14] * var1.field3743[8];
      float var15 = this.field3743[14] * var1.field3743[9] + this.field3743[12] * var1.field3743[1] + var1.field3743[5] * this.field3743[13] + var1.field3743[13] * this.field3743[15];
      float var16 = this.field3743[14] * var1.field3743[10] + var1.field3743[6] * this.field3743[13] + this.field3743[12] * var1.field3743[2] + this.field3743[15] * var1.field3743[14];
      float var17 = var1.field3743[15] * this.field3743[15] + this.field3743[14] * var1.field3743[11] + this.field3743[13] * var1.field3743[7] + this.field3743[12] * var1.field3743[3];
      this.field3743[0] = var2;
      this.field3743[1] = var3;
      this.field3743[2] = var4;
      this.field3743[3] = var5;
      this.field3743[4] = var6;
      this.field3743[5] = var7;
      this.field3743[6] = var8;
      this.field3743[7] = var9;
      this.field3743[8] = var10;
      this.field3743[9] = var11;
      this.field3743[10] = var12;
      this.field3743[11] = var13;
      this.field3743[12] = var14;
      this.field3743[13] = var15;
      this.field3743[14] = var16;
      this.field3743[15] = var17;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(Lqh;B)V",
      garbageValue = "-50"
   )
   public void method2190(class420 var1) {
      float var2 = var1.field3738 * var1.field3738;
      float var3 = var1.field3738 * var1.field3737;
      float var4 = var1.field3739 * var1.field3738;
      float var5 = var1.field3740 * var1.field3738;
      float var6 = var1.field3737 * var1.field3737;
      float var7 = var1.field3739 * var1.field3737;
      float var8 = var1.field3737 * var1.field3740;
      float var9 = var1.field3739 * var1.field3739;
      float var10 = var1.field3740 * var1.field3739;
      float var11 = var1.field3740 * var1.field3740;
      this.field3743[0] = var6 + var2 - var11 - var9;
      this.field3743[1] = var7 + var7 + var5 + var5;
      this.field3743[2] = var8 - var4 - var4 + var8;
      this.field3743[4] = var7 + (var7 - var5 - var5);
      this.field3743[5] = var9 + var2 - var6 - var11;
      this.field3743[6] = var3 + var3 + var10 + var10;
      this.field3743[8] = var8 + var8 + var4 + var4;
      this.field3743[9] = var10 + (var10 - var3 - var3);
      this.field3743[10] = var11 + var2 - var9 - var6;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(Lqx;B)V",
      garbageValue = "56"
   )
   void method2201(class422 var1) {
      this.field3743[0] = var1.field3754;
      this.field3743[1] = var1.field3759;
      this.field3743[2] = var1.field3750;
      this.field3743[3] = 0.0F;
      this.field3743[4] = var1.field3751;
      this.field3743[5] = var1.field3752;
      this.field3743[6] = var1.field3753;
      this.field3743[7] = 0.0F;
      this.field3743[8] = var1.field3748;
      this.field3743[9] = var1.field3755;
      this.field3743[10] = var1.field3756;
      this.field3743[11] = 0.0F;
      this.field3743[12] = var1.field3757;
      this.field3743[13] = var1.field3749;
      this.field3743[14] = var1.field3758;
      this.field3743[15] = 1.0F;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(B)F",
      garbageValue = "1"
   )
   float method2191() {
      return this.field3743[12] * this.field3743[3] * this.field3743[6] * this.field3743[9] + (this.field3743[10] * this.field3743[3] * this.field3743[4] * this.field3743[13] + (this.field3743[1] * this.field3743[6] * this.field3743[8] * this.field3743[15] + this.field3743[5] * this.field3743[0] * this.field3743[10] * this.field3743[15] - this.field3743[5] * this.field3743[0] * this.field3743[11] * this.field3743[14] - this.field3743[0] * this.field3743[6] * this.field3743[9] * this.field3743[15] + this.field3743[6] * this.field3743[0] * this.field3743[11] * this.field3743[13] + this.field3743[14] * this.field3743[9] * this.field3743[7] * this.field3743[0] - this.field3743[10] * this.field3743[7] * this.field3743[0] * this.field3743[13] - this.field3743[10] * this.field3743[1] * this.field3743[4] * this.field3743[15] + this.field3743[14] * this.field3743[4] * this.field3743[1] * this.field3743[11] - this.field3743[12] * this.field3743[11] * this.field3743[6] * this.field3743[1] - this.field3743[7] * this.field3743[1] * this.field3743[8] * this.field3743[14] + this.field3743[12] * this.field3743[7] * this.field3743[1] * this.field3743[10] + this.field3743[9] * this.field3743[4] * this.field3743[2] * this.field3743[15] - this.field3743[13] * this.field3743[4] * this.field3743[2] * this.field3743[11] - this.field3743[15] * this.field3743[5] * this.field3743[2] * this.field3743[8] + this.field3743[2] * this.field3743[5] * this.field3743[11] * this.field3743[12] + this.field3743[13] * this.field3743[8] * this.field3743[7] * this.field3743[2] - this.field3743[9] * this.field3743[7] * this.field3743[2] * this.field3743[12] - this.field3743[14] * this.field3743[3] * this.field3743[4] * this.field3743[9]) + this.field3743[14] * this.field3743[8] * this.field3743[5] * this.field3743[3] - this.field3743[5] * this.field3743[3] * this.field3743[10] * this.field3743[12] - this.field3743[3] * this.field3743[6] * this.field3743[8] * this.field3743[13]);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2129943862"
   )
   public void method2192() {
      float var1 = 1.0F / this.method2191();
      float var2 = var1 * (this.field3743[14] * this.field3743[9] * this.field3743[7] + this.field3743[13] * this.field3743[6] * this.field3743[11] + (this.field3743[10] * this.field3743[5] * this.field3743[15] - this.field3743[11] * this.field3743[5] * this.field3743[14] - this.field3743[15] * this.field3743[9] * this.field3743[6]) - this.field3743[13] * this.field3743[7] * this.field3743[10]);
      float var3 = var1 * (this.field3743[3] * this.field3743[10] * this.field3743[13] + (this.field3743[15] * -this.field3743[1] * this.field3743[10] + this.field3743[14] * this.field3743[11] * this.field3743[1] + this.field3743[15] * this.field3743[9] * this.field3743[2] - this.field3743[13] * this.field3743[2] * this.field3743[11] - this.field3743[3] * this.field3743[9] * this.field3743[14]));
      float var4 = var1 * (this.field3743[2] * this.field3743[7] * this.field3743[13] + (this.field3743[15] * this.field3743[6] * this.field3743[1] - this.field3743[1] * this.field3743[7] * this.field3743[14] - this.field3743[5] * this.field3743[2] * this.field3743[15]) + this.field3743[3] * this.field3743[5] * this.field3743[14] - this.field3743[13] * this.field3743[3] * this.field3743[6]);
      float var5 = (this.field3743[6] * -this.field3743[1] * this.field3743[11] + this.field3743[10] * this.field3743[1] * this.field3743[7] + this.field3743[11] * this.field3743[2] * this.field3743[5] - this.field3743[2] * this.field3743[7] * this.field3743[9] - this.field3743[10] * this.field3743[3] * this.field3743[5] + this.field3743[9] * this.field3743[3] * this.field3743[6]) * var1;
      float var6 = var1 * (this.field3743[12] * this.field3743[7] * this.field3743[10] + (this.field3743[14] * this.field3743[4] * this.field3743[11] + -this.field3743[4] * this.field3743[10] * this.field3743[15] + this.field3743[8] * this.field3743[6] * this.field3743[15] - this.field3743[12] * this.field3743[11] * this.field3743[6] - this.field3743[7] * this.field3743[8] * this.field3743[14]));
      float var7 = (this.field3743[12] * this.field3743[2] * this.field3743[11] + (this.field3743[15] * this.field3743[0] * this.field3743[10] - this.field3743[14] * this.field3743[11] * this.field3743[0] - this.field3743[8] * this.field3743[2] * this.field3743[15]) + this.field3743[14] * this.field3743[3] * this.field3743[8] - this.field3743[12] * this.field3743[10] * this.field3743[3]) * var1;
      float var8 = (this.field3743[4] * this.field3743[2] * this.field3743[15] + this.field3743[15] * this.field3743[6] * -this.field3743[0] + this.field3743[14] * this.field3743[0] * this.field3743[7] - this.field3743[2] * this.field3743[7] * this.field3743[12] - this.field3743[14] * this.field3743[4] * this.field3743[3] + this.field3743[6] * this.field3743[3] * this.field3743[12]) * var1;
      float var9 = var1 * (this.field3743[11] * this.field3743[0] * this.field3743[6] - this.field3743[10] * this.field3743[0] * this.field3743[7] - this.field3743[11] * this.field3743[4] * this.field3743[2] + this.field3743[7] * this.field3743[2] * this.field3743[8] + this.field3743[3] * this.field3743[4] * this.field3743[10] - this.field3743[8] * this.field3743[3] * this.field3743[6]);
      float var10 = (this.field3743[13] * this.field3743[8] * this.field3743[7] + this.field3743[15] * this.field3743[9] * this.field3743[4] - this.field3743[4] * this.field3743[11] * this.field3743[13] - this.field3743[5] * this.field3743[8] * this.field3743[15] + this.field3743[12] * this.field3743[11] * this.field3743[5] - this.field3743[7] * this.field3743[9] * this.field3743[12]) * var1;
      float var11 = (-this.field3743[0] * this.field3743[9] * this.field3743[15] + this.field3743[13] * this.field3743[11] * this.field3743[0] + this.field3743[8] * this.field3743[1] * this.field3743[15] - this.field3743[11] * this.field3743[1] * this.field3743[12] - this.field3743[8] * this.field3743[3] * this.field3743[13] + this.field3743[12] * this.field3743[9] * this.field3743[3]) * var1;
      float var12 = (this.field3743[3] * this.field3743[4] * this.field3743[13] + this.field3743[1] * this.field3743[7] * this.field3743[12] + (this.field3743[0] * this.field3743[5] * this.field3743[15] - this.field3743[13] * this.field3743[0] * this.field3743[7] - this.field3743[4] * this.field3743[1] * this.field3743[15]) - this.field3743[3] * this.field3743[5] * this.field3743[12]) * var1;
      float var13 = var1 * (this.field3743[0] * this.field3743[7] * this.field3743[9] + -this.field3743[0] * this.field3743[5] * this.field3743[11] + this.field3743[11] * this.field3743[1] * this.field3743[4] - this.field3743[8] * this.field3743[7] * this.field3743[1] - this.field3743[9] * this.field3743[3] * this.field3743[4] + this.field3743[8] * this.field3743[3] * this.field3743[5]);
      float var14 = var1 * (this.field3743[12] * this.field3743[9] * this.field3743[6] + (this.field3743[14] * this.field3743[9] * -this.field3743[4] + this.field3743[4] * this.field3743[10] * this.field3743[13] + this.field3743[14] * this.field3743[8] * this.field3743[5] - this.field3743[5] * this.field3743[10] * this.field3743[12] - this.field3743[6] * this.field3743[8] * this.field3743[13]));
      float var15 = var1 * (this.field3743[2] * this.field3743[8] * this.field3743[13] + this.field3743[12] * this.field3743[1] * this.field3743[10] + (this.field3743[14] * this.field3743[9] * this.field3743[0] - this.field3743[10] * this.field3743[0] * this.field3743[13] - this.field3743[1] * this.field3743[8] * this.field3743[14]) - this.field3743[2] * this.field3743[9] * this.field3743[12]);
      float var16 = (this.field3743[5] * this.field3743[2] * this.field3743[12] + (this.field3743[4] * this.field3743[1] * this.field3743[14] + -this.field3743[0] * this.field3743[5] * this.field3743[14] + this.field3743[13] * this.field3743[6] * this.field3743[0] - this.field3743[12] * this.field3743[1] * this.field3743[6] - this.field3743[4] * this.field3743[2] * this.field3743[13])) * var1;
      float var17 = var1 * (this.field3743[9] * this.field3743[4] * this.field3743[2] + this.field3743[8] * this.field3743[1] * this.field3743[6] + (this.field3743[5] * this.field3743[0] * this.field3743[10] - this.field3743[9] * this.field3743[0] * this.field3743[6] - this.field3743[10] * this.field3743[1] * this.field3743[4]) - this.field3743[5] * this.field3743[2] * this.field3743[8]);
      this.field3743[0] = var2;
      this.field3743[1] = var3;
      this.field3743[2] = var4;
      this.field3743[3] = var5;
      this.field3743[4] = var6;
      this.field3743[5] = var7;
      this.field3743[6] = var8;
      this.field3743[7] = var9;
      this.field3743[8] = var10;
      this.field3743[9] = var11;
      this.field3743[10] = var12;
      this.field3743[11] = var13;
      this.field3743[12] = var14;
      this.field3743[13] = var15;
      this.field3743[14] = var16;
      this.field3743[15] = var17;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(I)[F",
      garbageValue = "1849517045"
   )
   public float[] method2194() {
      float[] var1 = new float[3];
      class419 var2 = new class419(this.field3743[0], this.field3743[1], this.field3743[2]);
      class419 var3 = new class419(this.field3743[4], this.field3743[5], this.field3743[6]);
      class419 var4 = new class419(this.field3743[8], this.field3743[9], this.field3743[10]);
      var1[0] = var2.method2178();
      var1[1] = var3.method2178();
      var1[2] = var4.method2178();
      return var1;
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      this.method2195();
      this.method2185();

      for(int var2 = 0; var2 < 4; ++var2) {
         for(int var3 = 0; var3 < 4; ++var3) {
            if (var3 > 0) {
               var1.append("\t");
            }

            float var4 = this.field3743[var3 + var2 * 4];
            if (Math.sqrt((double)(var4 * var4)) < 9.999999747378752E-5D) {
               var4 = 0.0F;
            }

            var1.append(var4);
         }

         var1.append("\n");
      }

      return var1.toString();
   }

   @Export("hashCode")
   @ObfuscatedName("hashCode")
   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      int var3 = var2 * 31 + Arrays.hashCode(this.field3743);
      return var3;
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (!(var1 instanceof class421)) {
         return false;
      } else {
         class421 var2 = (class421)var1;

         for(int var3 = 0; var3 < 16; ++var3) {
            if (this.field3743[var3] != var2.field3743[var3]) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)Lgj;",
      garbageValue = "-1046185305"
   )
   public static Clock method2197() {
      try {
         return new NanoClock();
      } catch (Throwable var1) {
         return new MilliClock();
      }
   }
}
