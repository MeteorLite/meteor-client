import java.util.Arrays;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oj")
public final class class410 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "[Loj;"
   )
   static class410[] field3761 = new class410[0];
   @ObfuscatedName("v")
   static int field3765 = 100;
   @ObfuscatedName("x")
   static int field3760;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Loj;"
   )
   public static final class410 field3764;
   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      descriptor = "[Lrx;"
   )
   static SpritePixels[] headIconPrayerSprites;
   @ObfuscatedName("m")
   public float[] field3763 = new float[16];

   static {
      field3761 = new class410[100];
      field3760 = 0;
      field3764 = new class410();
   }

   public class410() {
      this.method2131();
   }

   @ObfuscatedSignature(
      descriptor = "(Loj;)V"
   )
   public class410(class410 var1) {
      this.method2133(var1);
   }

   @ObfuscatedSignature(
      descriptor = "(Lqy;Z)V"
   )
   public class410(Buffer var1, boolean var2) {
      this.method2128(var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1020610059"
   )
   public void method2141() {
      class410[] var1 = field3761;
      synchronized(field3761) {
         if (field3760 < field3765 - 1) {
            field3761[++field3760 - 1] = this;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lqy;ZI)V",
      garbageValue = "271698512"
   )
   void method2128(Buffer var1, boolean var2) {
      if (var2) {
         class411 var3 = new class411();
         int var6 = var1.readShort();
         var6 &= 16383;
         float var5 = (float)((double)((float)var6 / 16384.0F) * 6.283185307179586D);
         var3.method2145(var5);
         int var9 = var1.readShort();
         var9 &= 16383;
         float var8 = (float)((double)((float)var9 / 16384.0F) * 6.283185307179586D);
         var3.method2146(var8);
         int var12 = var1.readShort();
         var12 &= 16383;
         float var11 = (float)(6.283185307179586D * (double)((float)var12 / 16384.0F));
         var3.method2149(var11);
         var3.method2148((float)var1.readShort(), (float)var1.readShort(), (float)var1.readShort());
         this.method2138(var3);
      } else {
         for(int var13 = 0; var13 < 16; ++var13) {
            this.field3763[var13] = var1.method2354();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(B)[F",
      garbageValue = "22"
   )
   float[] method2129() {
      float[] var1 = new float[3];
      if ((double)this.field3763[2] < 0.999D && (double)this.field3763[2] > -0.999D) {
         var1[1] = (float)(-Math.asin((double)this.field3763[2]));
         double var2 = Math.cos((double)var1[1]);
         var1[0] = (float)Math.atan2((double)this.field3763[6] / var2, (double)this.field3763[10] / var2);
         var1[2] = (float)Math.atan2((double)this.field3763[1] / var2, (double)this.field3763[0] / var2);
      } else {
         var1[0] = 0.0F;
         var1[1] = (float)Math.atan2((double)this.field3763[2], 0.0D);
         var1[2] = (float)Math.atan2((double)(-this.field3763[9]), (double)this.field3763[5]);
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)[F",
      garbageValue = "-999012260"
   )
   public float[] method2130() {
      float[] var1 = new float[]{(float)(-Math.asin((double)this.field3763[6])), 0.0F, 0.0F};
      double var2 = Math.cos((double)var1[0]);
      double var4;
      double var6;
      if (Math.abs(var2) > 0.005D) {
         var4 = (double)this.field3763[2];
         var6 = (double)this.field3763[10];
         double var8 = (double)this.field3763[4];
         double var10 = (double)this.field3763[5];
         var1[1] = (float)Math.atan2(var4, var6);
         var1[2] = (float)Math.atan2(var8, var10);
      } else {
         var4 = (double)this.field3763[1];
         var6 = (double)this.field3763[0];
         if (this.field3763[6] < 0.0F) {
            var1[1] = (float)Math.atan2(var4, var6);
         } else {
            var1[1] = (float)(-Math.atan2(var4, var6));
         }

         var1[2] = 0.0F;
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-51"
   )
   void method2131() {
      this.field3763[0] = 1.0F;
      this.field3763[1] = 0.0F;
      this.field3763[2] = 0.0F;
      this.field3763[3] = 0.0F;
      this.field3763[4] = 0.0F;
      this.field3763[5] = 1.0F;
      this.field3763[6] = 0.0F;
      this.field3763[7] = 0.0F;
      this.field3763[8] = 0.0F;
      this.field3763[9] = 0.0F;
      this.field3763[10] = 1.0F;
      this.field3763[11] = 0.0F;
      this.field3763[12] = 0.0F;
      this.field3763[13] = 0.0F;
      this.field3763[14] = 0.0F;
      this.field3763[15] = 1.0F;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "395260364"
   )
   public void method2132() {
      this.field3763[0] = 0.0F;
      this.field3763[1] = 0.0F;
      this.field3763[2] = 0.0F;
      this.field3763[3] = 0.0F;
      this.field3763[4] = 0.0F;
      this.field3763[5] = 0.0F;
      this.field3763[6] = 0.0F;
      this.field3763[7] = 0.0F;
      this.field3763[8] = 0.0F;
      this.field3763[9] = 0.0F;
      this.field3763[10] = 0.0F;
      this.field3763[11] = 0.0F;
      this.field3763[12] = 0.0F;
      this.field3763[13] = 0.0F;
      this.field3763[14] = 0.0F;
      this.field3763[15] = 0.0F;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(Loj;I)V",
      garbageValue = "-584495645"
   )
   public void method2133(class410 var1) {
      System.arraycopy(var1.field3763, 0, this.field3763, 0, 16);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(FS)V",
      garbageValue = "-2109"
   )
   public void method2134(float var1) {
      this.method2135(var1, var1, var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(FFFI)V",
      garbageValue = "-504827889"
   )
   public void method2135(float var1, float var2, float var3) {
      this.method2131();
      this.field3763[0] = var1;
      this.field3763[5] = var2;
      this.field3763[10] = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(Loj;I)V",
      garbageValue = "-496202053"
   )
   public void method2143(class410 var1) {
      for(int var2 = 0; var2 < this.field3763.length; ++var2) {
         this.field3763[var2] += var1.field3763[var2];
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(Loj;I)V",
      garbageValue = "1995782349"
   )
   public void method2136(class410 var1) {
      float var2 = this.field3763[3] * var1.field3763[12] + this.field3763[2] * var1.field3763[8] + var1.field3763[4] * this.field3763[1] + var1.field3763[0] * this.field3763[0];
      float var3 = this.field3763[1] * var1.field3763[5] + var1.field3763[1] * this.field3763[0] + var1.field3763[9] * this.field3763[2] + var1.field3763[13] * this.field3763[3];
      float var4 = this.field3763[1] * var1.field3763[6] + var1.field3763[2] * this.field3763[0] + var1.field3763[10] * this.field3763[2] + this.field3763[3] * var1.field3763[14];
      float var5 = this.field3763[3] * var1.field3763[15] + this.field3763[2] * var1.field3763[11] + var1.field3763[3] * this.field3763[0] + var1.field3763[7] * this.field3763[1];
      float var6 = var1.field3763[0] * this.field3763[4] + var1.field3763[4] * this.field3763[5] + var1.field3763[8] * this.field3763[6] + this.field3763[7] * var1.field3763[12];
      float var7 = var1.field3763[13] * this.field3763[7] + var1.field3763[1] * this.field3763[4] + this.field3763[5] * var1.field3763[5] + this.field3763[6] * var1.field3763[9];
      float var8 = var1.field3763[14] * this.field3763[7] + var1.field3763[10] * this.field3763[6] + var1.field3763[6] * this.field3763[5] + var1.field3763[2] * this.field3763[4];
      float var9 = this.field3763[5] * var1.field3763[7] + var1.field3763[3] * this.field3763[4] + this.field3763[6] * var1.field3763[11] + var1.field3763[15] * this.field3763[7];
      float var10 = var1.field3763[12] * this.field3763[11] + this.field3763[10] * var1.field3763[8] + var1.field3763[0] * this.field3763[8] + this.field3763[9] * var1.field3763[4];
      float var11 = this.field3763[11] * var1.field3763[13] + this.field3763[9] * var1.field3763[5] + var1.field3763[1] * this.field3763[8] + var1.field3763[9] * this.field3763[10];
      float var12 = this.field3763[9] * var1.field3763[6] + var1.field3763[2] * this.field3763[8] + var1.field3763[10] * this.field3763[10] + this.field3763[11] * var1.field3763[14];
      float var13 = var1.field3763[11] * this.field3763[10] + this.field3763[9] * var1.field3763[7] + this.field3763[8] * var1.field3763[3] + var1.field3763[15] * this.field3763[11];
      float var14 = this.field3763[15] * var1.field3763[12] + var1.field3763[8] * this.field3763[14] + var1.field3763[4] * this.field3763[13] + var1.field3763[0] * this.field3763[12];
      float var15 = this.field3763[12] * var1.field3763[1] + this.field3763[13] * var1.field3763[5] + this.field3763[14] * var1.field3763[9] + var1.field3763[13] * this.field3763[15];
      float var16 = var1.field3763[14] * this.field3763[15] + var1.field3763[10] * this.field3763[14] + var1.field3763[6] * this.field3763[13] + var1.field3763[2] * this.field3763[12];
      float var17 = var1.field3763[15] * this.field3763[15] + this.field3763[13] * var1.field3763[7] + var1.field3763[3] * this.field3763[12] + var1.field3763[11] * this.field3763[14];
      this.field3763[0] = var2;
      this.field3763[1] = var3;
      this.field3763[2] = var4;
      this.field3763[3] = var5;
      this.field3763[4] = var6;
      this.field3763[5] = var7;
      this.field3763[6] = var8;
      this.field3763[7] = var9;
      this.field3763[8] = var10;
      this.field3763[9] = var11;
      this.field3763[10] = var12;
      this.field3763[11] = var13;
      this.field3763[12] = var14;
      this.field3763[13] = var15;
      this.field3763[14] = var16;
      this.field3763[15] = var17;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lop;B)V",
      garbageValue = "8"
   )
   public void method2137(class409 var1) {
      float var2 = var1.field3759 * var1.field3759;
      float var3 = var1.field3756 * var1.field3759;
      float var4 = var1.field3753 * var1.field3759;
      float var5 = var1.field3758 * var1.field3759;
      float var6 = var1.field3756 * var1.field3756;
      float var7 = var1.field3756 * var1.field3753;
      float var8 = var1.field3756 * var1.field3758;
      float var9 = var1.field3753 * var1.field3753;
      float var10 = var1.field3753 * var1.field3758;
      float var11 = var1.field3758 * var1.field3758;
      this.field3763[0] = var6 + var2 - var11 - var9;
      this.field3763[1] = var7 + var7 + var5 + var5;
      this.field3763[2] = var8 + (var8 - var4 - var4);
      this.field3763[4] = var7 + (var7 - var5 - var5);
      this.field3763[5] = var9 + var2 - var6 - var11;
      this.field3763[6] = var3 + var10 + var3 + var10;
      this.field3763[8] = var4 + var8 + var8 + var4;
      this.field3763[9] = var10 - var3 - var3 + var10;
      this.field3763[10] = var2 + var11 - var9 - var6;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(Loc;I)V",
      garbageValue = "1326296862"
   )
   void method2138(class411 var1) {
      this.field3763[0] = var1.field3774;
      this.field3763[1] = var1.field3767;
      this.field3763[2] = var1.field3768;
      this.field3763[3] = 0.0F;
      this.field3763[4] = var1.field3775;
      this.field3763[5] = var1.field3770;
      this.field3763[6] = var1.field3771;
      this.field3763[7] = 0.0F;
      this.field3763[8] = var1.field3772;
      this.field3763[9] = var1.field3773;
      this.field3763[10] = var1.field3766;
      this.field3763[11] = 0.0F;
      this.field3763[12] = var1.field3777;
      this.field3763[13] = var1.field3776;
      this.field3763[14] = var1.field3769;
      this.field3763[15] = 1.0F;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(B)F",
      garbageValue = "-72"
   )
   float method2142() {
      return this.field3763[12] * this.field3763[6] * this.field3763[3] * this.field3763[9] + (this.field3763[13] * this.field3763[3] * this.field3763[4] * this.field3763[10] + (this.field3763[11] * this.field3763[2] * this.field3763[5] * this.field3763[12] + (this.field3763[15] * this.field3763[2] * this.field3763[4] * this.field3763[9] + this.field3763[15] * this.field3763[10] * this.field3763[5] * this.field3763[0] - this.field3763[11] * this.field3763[5] * this.field3763[0] * this.field3763[14] - this.field3763[15] * this.field3763[9] * this.field3763[0] * this.field3763[6] + this.field3763[13] * this.field3763[0] * this.field3763[6] * this.field3763[11] + this.field3763[0] * this.field3763[7] * this.field3763[9] * this.field3763[14] - this.field3763[13] * this.field3763[10] * this.field3763[0] * this.field3763[7] - this.field3763[15] * this.field3763[4] * this.field3763[1] * this.field3763[10] + this.field3763[14] * this.field3763[4] * this.field3763[1] * this.field3763[11] + this.field3763[15] * this.field3763[8] * this.field3763[1] * this.field3763[6] - this.field3763[12] * this.field3763[11] * this.field3763[1] * this.field3763[6] - this.field3763[8] * this.field3763[1] * this.field3763[7] * this.field3763[14] + this.field3763[12] * this.field3763[7] * this.field3763[1] * this.field3763[10] - this.field3763[13] * this.field3763[11] * this.field3763[4] * this.field3763[2] - this.field3763[8] * this.field3763[5] * this.field3763[2] * this.field3763[15]) + this.field3763[7] * this.field3763[2] * this.field3763[8] * this.field3763[13] - this.field3763[7] * this.field3763[2] * this.field3763[9] * this.field3763[12] - this.field3763[3] * this.field3763[4] * this.field3763[9] * this.field3763[14]) + this.field3763[3] * this.field3763[5] * this.field3763[8] * this.field3763[14] - this.field3763[10] * this.field3763[5] * this.field3763[3] * this.field3763[12] - this.field3763[8] * this.field3763[3] * this.field3763[6] * this.field3763[13]);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-6"
   )
   public void method2139() {
      float var1 = 1.0F / this.method2142();
      float var2 = (this.field3763[14] * this.field3763[7] * this.field3763[9] + this.field3763[11] * this.field3763[6] * this.field3763[13] + (this.field3763[15] * this.field3763[10] * this.field3763[5] - this.field3763[14] * this.field3763[5] * this.field3763[11] - this.field3763[9] * this.field3763[6] * this.field3763[15]) - this.field3763[10] * this.field3763[7] * this.field3763[13]) * var1;
      float var3 = var1 * (this.field3763[10] * this.field3763[3] * this.field3763[13] + (this.field3763[15] * this.field3763[9] * this.field3763[2] + this.field3763[14] * this.field3763[1] * this.field3763[11] + this.field3763[15] * -this.field3763[1] * this.field3763[10] - this.field3763[13] * this.field3763[2] * this.field3763[11] - this.field3763[3] * this.field3763[9] * this.field3763[14]));
      float var4 = var1 * (this.field3763[13] * this.field3763[7] * this.field3763[2] + (this.field3763[6] * this.field3763[1] * this.field3763[15] - this.field3763[14] * this.field3763[1] * this.field3763[7] - this.field3763[2] * this.field3763[5] * this.field3763[15]) + this.field3763[5] * this.field3763[3] * this.field3763[14] - this.field3763[6] * this.field3763[3] * this.field3763[13]);
      float var5 = (this.field3763[6] * this.field3763[3] * this.field3763[9] + (this.field3763[11] * this.field3763[2] * this.field3763[5] + this.field3763[1] * this.field3763[7] * this.field3763[10] + -this.field3763[1] * this.field3763[6] * this.field3763[11] - this.field3763[9] * this.field3763[7] * this.field3763[2] - this.field3763[10] * this.field3763[5] * this.field3763[3])) * var1;
      float var6 = var1 * (this.field3763[7] * this.field3763[10] * this.field3763[12] + (-this.field3763[4] * this.field3763[10] * this.field3763[15] + this.field3763[4] * this.field3763[11] * this.field3763[14] + this.field3763[6] * this.field3763[8] * this.field3763[15] - this.field3763[6] * this.field3763[11] * this.field3763[12] - this.field3763[14] * this.field3763[7] * this.field3763[8]));
      float var7 = (this.field3763[10] * this.field3763[0] * this.field3763[15] - this.field3763[14] * this.field3763[0] * this.field3763[11] - this.field3763[15] * this.field3763[8] * this.field3763[2] + this.field3763[2] * this.field3763[11] * this.field3763[12] + this.field3763[14] * this.field3763[8] * this.field3763[3] - this.field3763[10] * this.field3763[3] * this.field3763[12]) * var1;
      float var8 = var1 * (this.field3763[12] * this.field3763[6] * this.field3763[3] + (this.field3763[14] * this.field3763[0] * this.field3763[7] + this.field3763[15] * -this.field3763[0] * this.field3763[6] + this.field3763[15] * this.field3763[2] * this.field3763[4] - this.field3763[7] * this.field3763[2] * this.field3763[12] - this.field3763[4] * this.field3763[3] * this.field3763[14]));
      float var9 = (this.field3763[4] * this.field3763[3] * this.field3763[10] + this.field3763[2] * this.field3763[7] * this.field3763[8] + (this.field3763[6] * this.field3763[0] * this.field3763[11] - this.field3763[0] * this.field3763[7] * this.field3763[10] - this.field3763[11] * this.field3763[4] * this.field3763[2]) - this.field3763[6] * this.field3763[3] * this.field3763[8]) * var1;
      float var10 = var1 * (this.field3763[11] * this.field3763[5] * this.field3763[12] + (this.field3763[15] * this.field3763[4] * this.field3763[9] - this.field3763[4] * this.field3763[11] * this.field3763[13] - this.field3763[15] * this.field3763[5] * this.field3763[8]) + this.field3763[7] * this.field3763[8] * this.field3763[13] - this.field3763[9] * this.field3763[7] * this.field3763[12]);
      float var11 = var1 * (this.field3763[9] * this.field3763[3] * this.field3763[12] + (this.field3763[9] * -this.field3763[0] * this.field3763[15] + this.field3763[0] * this.field3763[11] * this.field3763[13] + this.field3763[1] * this.field3763[8] * this.field3763[15] - this.field3763[12] * this.field3763[11] * this.field3763[1] - this.field3763[13] * this.field3763[8] * this.field3763[3]));
      float var12 = (this.field3763[13] * this.field3763[4] * this.field3763[3] + this.field3763[12] * this.field3763[7] * this.field3763[1] + (this.field3763[0] * this.field3763[5] * this.field3763[15] - this.field3763[7] * this.field3763[0] * this.field3763[13] - this.field3763[15] * this.field3763[1] * this.field3763[4]) - this.field3763[12] * this.field3763[5] * this.field3763[3]) * var1;
      float var13 = (this.field3763[5] * this.field3763[3] * this.field3763[8] + (this.field3763[4] * this.field3763[1] * this.field3763[11] + this.field3763[9] * this.field3763[0] * this.field3763[7] + this.field3763[5] * -this.field3763[0] * this.field3763[11] - this.field3763[8] * this.field3763[7] * this.field3763[1] - this.field3763[4] * this.field3763[3] * this.field3763[9])) * var1;
      float var14 = (this.field3763[12] * this.field3763[6] * this.field3763[9] + (this.field3763[14] * this.field3763[5] * this.field3763[8] + this.field3763[13] * this.field3763[10] * this.field3763[4] + -this.field3763[4] * this.field3763[9] * this.field3763[14] - this.field3763[12] * this.field3763[5] * this.field3763[10] - this.field3763[13] * this.field3763[6] * this.field3763[8])) * var1;
      float var15 = (this.field3763[14] * this.field3763[9] * this.field3763[0] - this.field3763[10] * this.field3763[0] * this.field3763[13] - this.field3763[1] * this.field3763[8] * this.field3763[14] + this.field3763[10] * this.field3763[1] * this.field3763[12] + this.field3763[13] * this.field3763[8] * this.field3763[2] - this.field3763[12] * this.field3763[2] * this.field3763[9]) * var1;
      float var16 = var1 * (this.field3763[14] * this.field3763[1] * this.field3763[4] + this.field3763[14] * -this.field3763[0] * this.field3763[5] + this.field3763[13] * this.field3763[0] * this.field3763[6] - this.field3763[12] * this.field3763[6] * this.field3763[1] - this.field3763[13] * this.field3763[2] * this.field3763[4] + this.field3763[5] * this.field3763[2] * this.field3763[12]);
      float var17 = (this.field3763[8] * this.field3763[1] * this.field3763[6] + (this.field3763[10] * this.field3763[5] * this.field3763[0] - this.field3763[0] * this.field3763[6] * this.field3763[9] - this.field3763[4] * this.field3763[1] * this.field3763[10]) + this.field3763[4] * this.field3763[2] * this.field3763[9] - this.field3763[2] * this.field3763[5] * this.field3763[8]) * var1;
      this.field3763[0] = var2;
      this.field3763[1] = var3;
      this.field3763[2] = var4;
      this.field3763[3] = var5;
      this.field3763[4] = var6;
      this.field3763[5] = var7;
      this.field3763[6] = var8;
      this.field3763[7] = var9;
      this.field3763[8] = var10;
      this.field3763[9] = var11;
      this.field3763[10] = var12;
      this.field3763[11] = var13;
      this.field3763[12] = var14;
      this.field3763[13] = var15;
      this.field3763[14] = var16;
      this.field3763[15] = var17;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(I)[F",
      garbageValue = "1949764600"
   )
   public float[] method2140() {
      float[] var1 = new float[3];
      class408 var2 = new class408(this.field3763[0], this.field3763[1], this.field3763[2]);
      class408 var3 = new class408(this.field3763[4], this.field3763[5], this.field3763[6]);
      class408 var4 = new class408(this.field3763[8], this.field3763[9], this.field3763[10]);
      var1[0] = var2.method2122();
      var1[1] = var3.method2122();
      var1[2] = var4.method2122();
      return var1;
   }

   @ObfuscatedName("hashCode")
   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      int var3 = 31 * var2 + Arrays.hashCode(this.field3763);
      return var3;
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (!(var1 instanceof class410)) {
         return false;
      } else {
         class410 var2 = (class410)var1;

         for(int var3 = 0; var3 < 16; ++var3) {
            if (var2.field3763[var3] != this.field3763[var3]) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("toString")
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      this.method2130();
      this.method2129();

      for(int var2 = 0; var2 < 4; ++var2) {
         for(int var3 = 0; var3 < 4; ++var3) {
            if (var3 > 0) {
               var1.append("\t");
            }

            float var4 = this.field3763[var3 + var2 * 4];
            if (Math.sqrt((double)(var4 * var4)) < 9.999999747378752E-5D) {
               var4 = 0.0F;
            }

            var1.append(var4);
         }

         var1.append("\n");
      }

      return var1.toString();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/Date;B)Z",
      garbageValue = "-34"
   )
   static boolean method2144(Date var0) {
      Date var1 = class200.method1073();
      return var0.after(var1);
   }
}
