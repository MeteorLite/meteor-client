import java.util.Arrays;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class201 implements class30 {
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      descriptor = "Lrx;"
   )
   static SpritePixels compass;
   @ObfuscatedName("h")
   char[] field1832 = new char[128];
   @ObfuscatedName("e")
   int[] field1821 = new int[128];
   @ObfuscatedName("v")
   public int[] field1828 = new int[128];
   @ObfuscatedName("x")
   public int pressedKeysCount = 0;
   @ObfuscatedName("m")
   int[] field1824 = new int[128];
   @ObfuscatedName("q")
   int field1825 = 0;
   @ObfuscatedName("f")
   int field1826 = 0;
   @ObfuscatedName("r")
   int field1827 = 0;
   @ObfuscatedName("u")
   int field1822 = 0;
   @ObfuscatedName("b")
   boolean[] field1829 = new boolean[112];
   @ObfuscatedName("j")
   boolean[] field1830 = new boolean[112];
   @ObfuscatedName("g")
   boolean[] field1823 = new boolean[112];
   @ObfuscatedName("i")
   public char field1820;
   @ObfuscatedName("o")
   public int field1833;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1119176744"
   )
   public boolean vmethod3949(int var1) {
      this.method1079(var1);
      this.field1829[var1] = true;
      this.field1830[var1] = true;
      this.field1823[var1] = false;
      this.field1828[++this.pressedKeysCount - 1] = var1;
      return true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-916991313"
   )
   public boolean vmethod3989(int var1) {
      this.field1829[var1] = false;
      this.field1830[var1] = false;
      this.field1823[var1] = true;
      this.field1824[++this.field1825 - 1] = var1;
      return true;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "-258182"
   )
   public boolean vmethod3951(char var1) {
      int var2 = this.field1827 + 1 & 127;
      if (var2 != this.field1826) {
         this.field1821[this.field1827] = -1;
         this.field1832[this.field1827] = var1;
         this.field1827 = var2;
      }

      return false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(ZI)Z",
      garbageValue = "333814410"
   )
   public boolean vmethod3953(boolean var1) {
      return false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "41"
   )
   void method1079(int var1) {
      int var2 = this.field1827 + 1 & 127;
      if (var2 != this.field1826) {
         this.field1821[this.field1827] = var1;
         this.field1832[this.field1827] = 0;
         this.field1827 = var2;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-45"
   )
   public void method1081() {
      this.field1826 = this.field1822;
      this.field1822 = this.field1827;
      this.pressedKeysCount = 0;
      this.field1825 = 0;
      Arrays.fill(this.field1830, false);
      Arrays.fill(this.field1823, false);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "7"
   )
   public final boolean method1087() {
      if (this.field1822 == this.field1826) {
         return false;
      } else {
         this.field1833 = this.field1821[this.field1826];
         this.field1820 = this.field1832[this.field1826];
         this.field1826 = this.field1826 + 1 & 127;
         return true;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "903181500"
   )
   public boolean method1088(int var1) {
      return var1 >= 0 && var1 < 112 ? this.field1830[var1] : false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "0"
   )
   public boolean getKeyPressed(int var1) {
      return var1 >= 0 && var1 < 112 ? this.field1829[var1] : false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1557864328"
   )
   public boolean method1082(int var1) {
      return var1 >= 0 && var1 < 112 ? this.field1823[var1] : false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(B)[I",
      garbageValue = "5"
   )
   public int[] method1084() {
      int[] var1 = new int[this.pressedKeysCount];

      for(int var2 = 0; var2 < this.pressedKeysCount; ++var2) {
         var1[var2] = this.field1828[var2];
      }

      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "-2137693462"
   )
   public int[] method1085() {
      int[] var1 = new int[this.field1825];

      for(int var2 = 0; var2 < this.field1825; ++var2) {
         var1[var2] = this.field1824[var2];
      }

      return var1;
   }

   @ObfuscatedName("h")
   public static final int method1086(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if (0.0D != var2) {
         double var12;
         if (var4 < 0.5D) {
            var12 = (1.0D + var2) * var4;
         } else {
            var12 = var4 + var2 - var2 * var4;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = 0.3333333333333333D + var0;
         if (var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if (var20 < 0.0D) {
            ++var20;
         }

         if (var16 * 6.0D < 1.0D) {
            var6 = 6.0D * (var12 - var14) * var16 + var14;
         } else if (var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if (var16 * 3.0D < 2.0D) {
            var6 = var14 + 6.0D * (0.6666666666666666D - var16) * (var12 - var14);
         } else {
            var6 = var14;
         }

         if (var0 * 6.0D < 1.0D) {
            var8 = var0 * 6.0D * (var12 - var14) + var14;
         } else if (var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if (var0 * 3.0D < 2.0D) {
            var8 = var14 + 6.0D * (0.6666666666666666D - var0) * (var12 - var14);
         } else {
            var8 = var14;
         }

         if (var20 * 6.0D < 1.0D) {
            var10 = 6.0D * (var12 - var14) * var20 + var14;
         } else if (2.0D * var20 < 1.0D) {
            var10 = var12;
         } else if (var20 * 3.0D < 2.0D) {
            var10 = (var12 - var14) * (0.6666666666666666D - var20) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(var8 * 256.0D);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }
}
