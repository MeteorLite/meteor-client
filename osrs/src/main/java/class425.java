import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qj")
public final class class425 {
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "[Lqj;"
   )
   public static class425[] field3793 = new class425[0];
   @ObfuscatedName("aw")
   static int field3796;
   @ObfuscatedName("ac")
   public static int field3794;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lqj;"
   )
   public static final class425 field3792;
   @ObfuscatedName("jg")
   static int field3798;
    @ObfuscatedName("kc")
    @ObfuscatedSignature(
            descriptor = "[Ltq;"
    )
    static SpritePixels[] headIconPrayerSprites;
   @ObfuscatedName("au")
   public float[] field3797 = new float[16];

   static {
      WorldMapSection1.method1539(100);
      field3792 = new class425();
   }

   public class425() {
      this.method2250();
   }

   @ObfuscatedSignature(
      descriptor = "(Lqj;)V"
   )
   public class425(class425 var1) {
      this.method2252(var1);
   }

   @ObfuscatedSignature(
      descriptor = "(Lsg;Z)V"
   )
   public class425(Buffer var1, boolean var2) {
      this.method2247(var1, var2);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1198141071"
   )
   public void method2249() {
      class425[] var1 = field3793;
      synchronized(field3793) {
         if (field3794 < field3796 - 1) {
            field3793[++field3794 - 1] = this;
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Lsg;ZB)V",
      garbageValue = "39"
   )
   void method2247(Buffer var1, boolean var2) {
      if (var2) {
         class426 var3 = new class426();
         var3.method2266(MusicPatchNode.method1678(var1.readShort()));
         var3.method2267(MusicPatchNode.method1678(var1.readShort()));
         var3.method2268(MusicPatchNode.method1678(var1.readShort()));
         var3.method2265((float)var1.readShort(), (float)var1.readShort(), (float)var1.readShort());
         this.method2257(var3);
      } else {
         for(int var4 = 0; var4 < 16; ++var4) {
            this.field3797[var4] = var1.method2487();
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(S)[F",
      garbageValue = "18255"
   )
   float[] method2248() {
      float[] var1 = new float[3];
      if ((double)this.field3797[2] < 0.999D && (double)this.field3797[2] > -0.999D) {
         var1[1] = (float)(-Math.asin((double)this.field3797[2]));
         double var2 = Math.cos((double)var1[1]);
         var1[0] = (float)Math.atan2((double)this.field3797[6] / var2, (double)this.field3797[10] / var2);
         var1[2] = (float)Math.atan2((double)this.field3797[1] / var2, (double)this.field3797[0] / var2);
      } else {
         var1[0] = 0.0F;
         var1[1] = (float)Math.atan2((double)this.field3797[2], 0.0D);
         var1[2] = (float)Math.atan2((double)(-this.field3797[9]), (double)this.field3797[5]);
      }

      return var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)[F",
      garbageValue = "2011587647"
   )
   public float[] method2246() {
      float[] var1 = new float[]{(float)(-Math.asin((double)this.field3797[6])), 0.0F, 0.0F};
      double var2 = Math.cos((double)var1[0]);
      double var4;
      double var6;
      if (Math.abs(var2) > 0.005D) {
         var4 = (double)this.field3797[2];
         var6 = (double)this.field3797[10];
         double var8 = (double)this.field3797[4];
         double var10 = (double)this.field3797[5];
         var1[1] = (float)Math.atan2(var4, var6);
         var1[2] = (float)Math.atan2(var8, var10);
      } else {
         var4 = (double)this.field3797[1];
         var6 = (double)this.field3797[0];
         if (this.field3797[6] < 0.0F) {
            var1[1] = (float)Math.atan2(var4, var6);
         } else {
            var1[1] = (float)(-Math.atan2(var4, var6));
         }

         var1[2] = 0.0F;
      }

      return var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-10"
   )
   public void method2250() {
      this.field3797[0] = 1.0F;
      this.field3797[1] = 0.0F;
      this.field3797[2] = 0.0F;
      this.field3797[3] = 0.0F;
      this.field3797[4] = 0.0F;
      this.field3797[5] = 1.0F;
      this.field3797[6] = 0.0F;
      this.field3797[7] = 0.0F;
      this.field3797[8] = 0.0F;
      this.field3797[9] = 0.0F;
      this.field3797[10] = 1.0F;
      this.field3797[11] = 0.0F;
      this.field3797[12] = 0.0F;
      this.field3797[13] = 0.0F;
      this.field3797[14] = 0.0F;
      this.field3797[15] = 1.0F;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1283851159"
   )
   public void method2251() {
      this.field3797[0] = 0.0F;
      this.field3797[1] = 0.0F;
      this.field3797[2] = 0.0F;
      this.field3797[3] = 0.0F;
      this.field3797[4] = 0.0F;
      this.field3797[5] = 0.0F;
      this.field3797[6] = 0.0F;
      this.field3797[7] = 0.0F;
      this.field3797[8] = 0.0F;
      this.field3797[9] = 0.0F;
      this.field3797[10] = 0.0F;
      this.field3797[11] = 0.0F;
      this.field3797[12] = 0.0F;
      this.field3797[13] = 0.0F;
      this.field3797[14] = 0.0F;
      this.field3797[15] = 0.0F;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lqj;I)V",
      garbageValue = "1919850341"
   )
   public void method2252(class425 var1) {
      System.arraycopy(var1.field3797, 0, this.field3797, 0, 16);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(FI)V",
      garbageValue = "-2059885087"
   )
   public void method2253(float var1) {
      this.method2260(var1, var1, var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(FFFI)V",
      garbageValue = "-814200416"
   )
   public void method2260(float var1, float var2, float var3) {
      this.method2250();
      this.field3797[0] = var1;
      this.field3797[5] = var2;
      this.field3797[10] = var3;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(Lqj;I)V",
      garbageValue = "-1643954745"
   )
   public void method2254(class425 var1) {
      for(int var2 = 0; var2 < this.field3797.length; ++var2) {
         this.field3797[var2] += var1.field3797[var2];
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lqj;I)V",
      garbageValue = "2018256268"
   )
   public void method2255(class425 var1) {
      float var2 = this.field3797[3] * var1.field3797[12] + this.field3797[2] * var1.field3797[8] + var1.field3797[4] * this.field3797[1] + var1.field3797[0] * this.field3797[0];
      float var3 = var1.field3797[13] * this.field3797[3] + var1.field3797[1] * this.field3797[0] + this.field3797[1] * var1.field3797[5] + var1.field3797[9] * this.field3797[2];
      float var4 = this.field3797[0] * var1.field3797[2] + var1.field3797[6] * this.field3797[1] + this.field3797[2] * var1.field3797[10] + var1.field3797[14] * this.field3797[3];
      float var5 = this.field3797[2] * var1.field3797[11] + this.field3797[1] * var1.field3797[7] + this.field3797[0] * var1.field3797[3] + this.field3797[3] * var1.field3797[15];
      float var6 = this.field3797[5] * var1.field3797[4] + this.field3797[4] * var1.field3797[0] + var1.field3797[8] * this.field3797[6] + this.field3797[7] * var1.field3797[12];
      float var7 = var1.field3797[13] * this.field3797[7] + this.field3797[6] * var1.field3797[9] + this.field3797[5] * var1.field3797[5] + var1.field3797[1] * this.field3797[4];
      float var8 = var1.field3797[2] * this.field3797[4] + this.field3797[5] * var1.field3797[6] + var1.field3797[10] * this.field3797[6] + var1.field3797[14] * this.field3797[7];
      float var9 = this.field3797[6] * var1.field3797[11] + var1.field3797[3] * this.field3797[4] + var1.field3797[7] * this.field3797[5] + this.field3797[7] * var1.field3797[15];
      float var10 = var1.field3797[0] * this.field3797[8] + this.field3797[9] * var1.field3797[4] + var1.field3797[8] * this.field3797[10] + this.field3797[11] * var1.field3797[12];
      float var11 = var1.field3797[13] * this.field3797[11] + this.field3797[9] * var1.field3797[5] + var1.field3797[1] * this.field3797[8] + this.field3797[10] * var1.field3797[9];
      float var12 = this.field3797[11] * var1.field3797[14] + var1.field3797[6] * this.field3797[9] + var1.field3797[2] * this.field3797[8] + this.field3797[10] * var1.field3797[10];
      float var13 = var1.field3797[3] * this.field3797[8] + var1.field3797[7] * this.field3797[9] + this.field3797[10] * var1.field3797[11] + this.field3797[11] * var1.field3797[15];
      float var14 = this.field3797[14] * var1.field3797[8] + var1.field3797[4] * this.field3797[13] + this.field3797[12] * var1.field3797[0] + this.field3797[15] * var1.field3797[12];
      float var15 = this.field3797[12] * var1.field3797[1] + this.field3797[13] * var1.field3797[5] + this.field3797[14] * var1.field3797[9] + this.field3797[15] * var1.field3797[13];
      float var16 = var1.field3797[14] * this.field3797[15] + var1.field3797[2] * this.field3797[12] + this.field3797[13] * var1.field3797[6] + var1.field3797[10] * this.field3797[14];
      float var17 = var1.field3797[7] * this.field3797[13] + this.field3797[12] * var1.field3797[3] + this.field3797[14] * var1.field3797[11] + var1.field3797[15] * this.field3797[15];
      this.field3797[0] = var2;
      this.field3797[1] = var3;
      this.field3797[2] = var4;
      this.field3797[3] = var5;
      this.field3797[4] = var6;
      this.field3797[5] = var7;
      this.field3797[6] = var8;
      this.field3797[7] = var9;
      this.field3797[8] = var10;
      this.field3797[9] = var11;
      this.field3797[10] = var12;
      this.field3797[11] = var13;
      this.field3797[12] = var14;
      this.field3797[13] = var15;
      this.field3797[14] = var16;
      this.field3797[15] = var17;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(Lqx;B)V",
      garbageValue = "-48"
   )
   public void method2256(class424 var1) {
      float var2 = var1.field3791 * var1.field3791;
      float var3 = var1.field3791 * var1.field3788;
      float var4 = var1.field3789 * var1.field3791;
      float var5 = var1.field3791 * var1.field3790;
      float var6 = var1.field3788 * var1.field3788;
      float var7 = var1.field3788 * var1.field3789;
      float var8 = var1.field3790 * var1.field3788;
      float var9 = var1.field3789 * var1.field3789;
      float var10 = var1.field3790 * var1.field3789;
      float var11 = var1.field3790 * var1.field3790;
      this.field3797[0] = var6 + var2 - var11 - var9;
      this.field3797[1] = var5 + var7 + var5 + var7;
      this.field3797[2] = var8 + (var8 - var4 - var4);
      this.field3797[4] = var7 + (var7 - var5 - var5);
      this.field3797[5] = var9 + var2 - var6 - var11;
      this.field3797[6] = var10 + var3 + var10 + var3;
      this.field3797[8] = var4 + var8 + var4 + var8;
      this.field3797[9] = var10 - var3 - var3 + var10;
      this.field3797[10] = var2 + var11 - var9 - var6;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(Lqc;B)V",
      garbageValue = "87"
   )
   void method2257(class426 var1) {
      this.field3797[0] = var1.field3810;
      this.field3797[1] = var1.field3799;
      this.field3797[2] = var1.field3800;
      this.field3797[3] = 0.0F;
      this.field3797[4] = var1.field3801;
      this.field3797[5] = var1.field3802;
      this.field3797[6] = var1.field3803;
      this.field3797[7] = 0.0F;
      this.field3797[8] = var1.field3804;
      this.field3797[9] = var1.field3805;
      this.field3797[10] = var1.field3806;
      this.field3797[11] = 0.0F;
      this.field3797[12] = var1.field3807;
      this.field3797[13] = var1.field3808;
      this.field3797[14] = var1.field3809;
      this.field3797[15] = 1.0F;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(I)F",
      garbageValue = "-671681757"
   )
   float method2258() {
      return this.field3797[8] * this.field3797[7] * this.field3797[2] * this.field3797[13] + this.field3797[2] * this.field3797[5] * this.field3797[11] * this.field3797[12] + (this.field3797[4] * this.field3797[2] * this.field3797[9] * this.field3797[15] + this.field3797[12] * this.field3797[1] * this.field3797[7] * this.field3797[10] + (this.field3797[8] * this.field3797[6] * this.field3797[1] * this.field3797[15] + this.field3797[14] * this.field3797[1] * this.field3797[4] * this.field3797[11] + (this.field3797[0] * this.field3797[7] * this.field3797[9] * this.field3797[14] + this.field3797[0] * this.field3797[6] * this.field3797[11] * this.field3797[13] + (this.field3797[5] * this.field3797[0] * this.field3797[10] * this.field3797[15] - this.field3797[14] * this.field3797[5] * this.field3797[0] * this.field3797[11] - this.field3797[15] * this.field3797[0] * this.field3797[6] * this.field3797[9]) - this.field3797[10] * this.field3797[0] * this.field3797[7] * this.field3797[13] - this.field3797[1] * this.field3797[4] * this.field3797[10] * this.field3797[15]) - this.field3797[12] * this.field3797[11] * this.field3797[1] * this.field3797[6] - this.field3797[14] * this.field3797[1] * this.field3797[7] * this.field3797[8]) - this.field3797[2] * this.field3797[4] * this.field3797[11] * this.field3797[13] - this.field3797[15] * this.field3797[2] * this.field3797[5] * this.field3797[8]) - this.field3797[12] * this.field3797[9] * this.field3797[2] * this.field3797[7] - this.field3797[9] * this.field3797[3] * this.field3797[4] * this.field3797[14] + this.field3797[13] * this.field3797[10] * this.field3797[4] * this.field3797[3] + this.field3797[3] * this.field3797[5] * this.field3797[8] * this.field3797[14] - this.field3797[12] * this.field3797[5] * this.field3797[3] * this.field3797[10] - this.field3797[8] * this.field3797[6] * this.field3797[3] * this.field3797[13] + this.field3797[12] * this.field3797[3] * this.field3797[6] * this.field3797[9];
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-49766360"
   )
   public void method2259() {
      float var1 = 1.0F / this.method2258();
      float var2 = var1 * (this.field3797[7] * this.field3797[9] * this.field3797[14] + this.field3797[11] * this.field3797[6] * this.field3797[13] + (this.field3797[5] * this.field3797[10] * this.field3797[15] - this.field3797[14] * this.field3797[5] * this.field3797[11] - this.field3797[6] * this.field3797[9] * this.field3797[15]) - this.field3797[13] * this.field3797[7] * this.field3797[10]);
      float var3 = (-this.field3797[1] * this.field3797[10] * this.field3797[15] + this.field3797[1] * this.field3797[11] * this.field3797[14] + this.field3797[15] * this.field3797[2] * this.field3797[9] - this.field3797[11] * this.field3797[2] * this.field3797[13] - this.field3797[14] * this.field3797[3] * this.field3797[9] + this.field3797[3] * this.field3797[10] * this.field3797[13]) * var1;
      float var4 = var1 * (this.field3797[7] * this.field3797[2] * this.field3797[13] + (this.field3797[15] * this.field3797[6] * this.field3797[1] - this.field3797[1] * this.field3797[7] * this.field3797[14] - this.field3797[15] * this.field3797[5] * this.field3797[2]) + this.field3797[14] * this.field3797[3] * this.field3797[5] - this.field3797[6] * this.field3797[3] * this.field3797[13]);
      float var5 = var1 * (this.field3797[9] * this.field3797[3] * this.field3797[6] + (this.field3797[5] * this.field3797[2] * this.field3797[11] + this.field3797[1] * this.field3797[7] * this.field3797[10] + this.field3797[11] * this.field3797[6] * -this.field3797[1] - this.field3797[9] * this.field3797[2] * this.field3797[7] - this.field3797[10] * this.field3797[3] * this.field3797[5]));
      float var6 = var1 * (this.field3797[12] * this.field3797[10] * this.field3797[7] + (this.field3797[15] * this.field3797[8] * this.field3797[6] + this.field3797[11] * this.field3797[4] * this.field3797[14] + this.field3797[15] * -this.field3797[4] * this.field3797[10] - this.field3797[6] * this.field3797[11] * this.field3797[12] - this.field3797[7] * this.field3797[8] * this.field3797[14]));
      float var7 = (this.field3797[12] * this.field3797[2] * this.field3797[11] + (this.field3797[15] * this.field3797[10] * this.field3797[0] - this.field3797[14] * this.field3797[11] * this.field3797[0] - this.field3797[8] * this.field3797[2] * this.field3797[15]) + this.field3797[14] * this.field3797[3] * this.field3797[8] - this.field3797[12] * this.field3797[3] * this.field3797[10]) * var1;
      float var8 = var1 * (this.field3797[12] * this.field3797[6] * this.field3797[3] + (this.field3797[15] * -this.field3797[0] * this.field3797[6] + this.field3797[14] * this.field3797[7] * this.field3797[0] + this.field3797[2] * this.field3797[4] * this.field3797[15] - this.field3797[2] * this.field3797[7] * this.field3797[12] - this.field3797[14] * this.field3797[4] * this.field3797[3]));
      float var9 = var1 * (this.field3797[4] * this.field3797[3] * this.field3797[10] + this.field3797[8] * this.field3797[7] * this.field3797[2] + (this.field3797[0] * this.field3797[6] * this.field3797[11] - this.field3797[10] * this.field3797[7] * this.field3797[0] - this.field3797[11] * this.field3797[2] * this.field3797[4]) - this.field3797[6] * this.field3797[3] * this.field3797[8]);
      float var10 = var1 * (this.field3797[13] * this.field3797[7] * this.field3797[8] + this.field3797[5] * this.field3797[11] * this.field3797[12] + (this.field3797[15] * this.field3797[9] * this.field3797[4] - this.field3797[4] * this.field3797[11] * this.field3797[13] - this.field3797[8] * this.field3797[5] * this.field3797[15]) - this.field3797[12] * this.field3797[7] * this.field3797[9]);
      float var11 = var1 * (this.field3797[9] * -this.field3797[0] * this.field3797[15] + this.field3797[0] * this.field3797[11] * this.field3797[13] + this.field3797[1] * this.field3797[8] * this.field3797[15] - this.field3797[1] * this.field3797[11] * this.field3797[12] - this.field3797[8] * this.field3797[3] * this.field3797[13] + this.field3797[12] * this.field3797[9] * this.field3797[3]);
      float var12 = var1 * (this.field3797[5] * this.field3797[0] * this.field3797[15] - this.field3797[13] * this.field3797[0] * this.field3797[7] - this.field3797[1] * this.field3797[4] * this.field3797[15] + this.field3797[12] * this.field3797[7] * this.field3797[1] + this.field3797[3] * this.field3797[4] * this.field3797[13] - this.field3797[3] * this.field3797[5] * this.field3797[12]);
      float var13 = (this.field3797[4] * this.field3797[1] * this.field3797[11] + this.field3797[9] * this.field3797[0] * this.field3797[7] + -this.field3797[0] * this.field3797[5] * this.field3797[11] - this.field3797[1] * this.field3797[7] * this.field3797[8] - this.field3797[3] * this.field3797[4] * this.field3797[9] + this.field3797[3] * this.field3797[5] * this.field3797[8]) * var1;
      float var14 = (this.field3797[12] * this.field3797[9] * this.field3797[6] + (this.field3797[9] * -this.field3797[4] * this.field3797[14] + this.field3797[4] * this.field3797[10] * this.field3797[13] + this.field3797[8] * this.field3797[5] * this.field3797[14] - this.field3797[12] * this.field3797[10] * this.field3797[5] - this.field3797[8] * this.field3797[6] * this.field3797[13])) * var1;
      float var15 = (this.field3797[12] * this.field3797[1] * this.field3797[10] + (this.field3797[9] * this.field3797[0] * this.field3797[14] - this.field3797[10] * this.field3797[0] * this.field3797[13] - this.field3797[14] * this.field3797[1] * this.field3797[8]) + this.field3797[8] * this.field3797[2] * this.field3797[13] - this.field3797[2] * this.field3797[9] * this.field3797[12]) * var1;
      float var16 = var1 * (this.field3797[14] * this.field3797[1] * this.field3797[4] + this.field3797[5] * -this.field3797[0] * this.field3797[14] + this.field3797[6] * this.field3797[0] * this.field3797[13] - this.field3797[12] * this.field3797[1] * this.field3797[6] - this.field3797[4] * this.field3797[2] * this.field3797[13] + this.field3797[5] * this.field3797[2] * this.field3797[12]);
      float var17 = var1 * (this.field3797[10] * this.field3797[5] * this.field3797[0] - this.field3797[9] * this.field3797[6] * this.field3797[0] - this.field3797[10] * this.field3797[1] * this.field3797[4] + this.field3797[8] * this.field3797[1] * this.field3797[6] + this.field3797[4] * this.field3797[2] * this.field3797[9] - this.field3797[8] * this.field3797[5] * this.field3797[2]);
      this.field3797[0] = var2;
      this.field3797[1] = var3;
      this.field3797[2] = var4;
      this.field3797[3] = var5;
      this.field3797[4] = var6;
      this.field3797[5] = var7;
      this.field3797[6] = var8;
      this.field3797[7] = var9;
      this.field3797[8] = var10;
      this.field3797[9] = var11;
      this.field3797[10] = var12;
      this.field3797[11] = var13;
      this.field3797[12] = var14;
      this.field3797[13] = var15;
      this.field3797[14] = var16;
      this.field3797[15] = var17;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)[F",
      garbageValue = "-1193193638"
   )
   public float[] method2261() {
      float[] var1 = new float[3];
      class423 var2 = new class423(this.field3797[0], this.field3797[1], this.field3797[2]);
      class423 var3 = new class423(this.field3797[4], this.field3797[5], this.field3797[6]);
      class423 var4 = new class423(this.field3797[8], this.field3797[9], this.field3797[10]);
      var1[0] = var2.method2239();
      var1[1] = var3.method2239();
      var1[2] = var4.method2239();
      return var1;
   }

    @ObfuscatedName("toString")
    public String toString() {
      StringBuilder var1 = new StringBuilder();
      this.method2246();
      this.method2248();

      for(int var2 = 0; var2 < 4; ++var2) {
         for(int var3 = 0; var3 < 4; ++var3) {
            if (var3 > 0) {
               var1.append("\t");
            }

            float var4 = this.field3797[var3 + var2 * 4];
            if (Math.sqrt((double)(var4 * var4)) < 9.999999747378752E-5D) {
               var4 = 0.0F;
            }

            var1.append(var4);
         }

         var1.append("\n");
      }

      return var1.toString();
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (!(var1 instanceof class425)) {
         return false;
      } else {
         class425 var2 = (class425)var1;

         for(int var3 = 0; var3 < 16; ++var3) {
            if (var2.field3797[var3] != this.field3797[var3]) {
               return false;
            }
         }

         return true;
      }
   }

    @ObfuscatedName("hashCode")
    public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      int var3 = var2 * 31 + Arrays.hashCode(this.field3797);
      return var3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)[Lfl;",
      garbageValue = "1631895479"
   )
   static class134[] method2263() {
      return new class134[]{class134.field1291, class134.field1298, class134.field1290, class134.field1293, class134.field1288, class134.field1292, class134.field1289, class134.field1294, class134.field1295};
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1975852814"
   )
   static final int method2262(int var0) {
      return Math.abs(var0 - class125.cameraYaw) > 1024 ? (var0 < class125.cameraYaw ? 1 : -1) * 2048 + var0 : var0;
   }

   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "32"
   )
   static final void method2264() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionsCount - 1; ++var1) {
            if (Client.menuOpcodes[var1] < 1000 && Client.menuOpcodes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuActions[var1];
               Client.menuActions[var1] = Client.menuActions[var1 + 1];
               Client.menuActions[var1 + 1] = var3;
               int var4 = Client.menuOpcodes[var1];
               Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
               Client.menuOpcodes[var1 + 1] = var4;
               var4 = Client.menuArguments1[var1];
               Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
               Client.menuArguments1[var1 + 1] = var4;
               var4 = Client.menuArguments2[var1];
               Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
               Client.menuArguments2[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               var4 = Client.menuItemIds[var1];
               Client.menuItemIds[var1] = Client.menuItemIds[var1 + 1];
               Client.menuItemIds[var1 + 1] = var4;
               boolean var5 = Client.menuShiftClick[var1];
               Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
               Client.menuShiftClick[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }
}
