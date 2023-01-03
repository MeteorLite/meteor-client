import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pk")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
   @ObfuscatedName("ar")
   int field3821;
   @ObfuscatedName("at")
   boolean field3832;
   @ObfuscatedName("ay")
   int field3823;
   @ObfuscatedName("an")
   int field3834;
   @ObfuscatedName("ab")
   int field3825;
   @ObfuscatedName("al")
   int field3826;
   @ObfuscatedName("ag")
   int field3827;
   @ObfuscatedName("az")
   boolean field3838;
   @ObfuscatedName("ak")
   int field3829;
   @ObfuscatedName("af")
   int field3830;
   @ObfuscatedName("ax")
   int field3831;
   @ObfuscatedName("ah")
   int field3843;
   @ObfuscatedName("aw")
   String field3836;
   @ObfuscatedName("aj")
   String field3840;
   @ObfuscatedName("aq")
   String field3820;
   @ObfuscatedName("ap")
   String field3819;
   @ObfuscatedName("aa")
   int field3835;
   @ObfuscatedName("ae")
   int field3822;
   @ObfuscatedName("ac")
   int field3839;
   @ObfuscatedName("bh")
   int field3833;
   @ObfuscatedName("be")
   String field3824;
   @ObfuscatedName("bf")
   String field3837;
   @ObfuscatedName("bo")
   int[] field3841 = new int[3];
   @ObfuscatedName("by")
   int field3842;
   @ObfuscatedName("bw")
   String field3828;
   @ObfuscatedName("bp")
   String field3844;

   PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
      this.field3821 = var1;
      this.field3832 = var2;
      this.field3823 = var3;
      this.field3834 = var4;
      this.field3825 = var5;
      this.field3826 = var6;
      this.field3827 = var7;
      this.field3838 = var8;
      this.field3829 = var9;
      this.field3830 = var10;
      this.field3831 = var11;
      this.field3843 = var12;
      this.field3836 = var13;
      this.field3840 = var14;
      this.field3820 = var15;
      this.field3819 = var16;
      this.field3835 = var17;
      this.field3822 = var18;
      this.field3839 = var19;
      this.field3833 = var20;
      this.field3824 = var21;
      this.field3837 = var22;
      this.field3841 = var23;
      this.field3842 = var24;
      this.field3828 = var25;
      this.field3844 = var26;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "0"
   )
   @Export("write")
   public void write(Buffer var1) {
      var1.writeByte(9);
      var1.writeByte(this.field3821);
      var1.writeByte(this.field3832 ? 1 : 0);
      var1.writeShort(this.field3823);
      var1.writeByte(this.field3834);
      var1.writeByte(this.field3825);
      var1.writeByte(this.field3826);
      var1.writeByte(this.field3827);
      var1.writeByte(this.field3838 ? 1 : 0);
      var1.writeShort(this.field3829);
      var1.writeByte(this.field3830);
      var1.writeMedium(this.field3831);
      var1.writeShort(this.field3843);
      var1.writeStringCp1252NullCircumfixed(this.field3836);
      var1.writeStringCp1252NullCircumfixed(this.field3840);
      var1.writeStringCp1252NullCircumfixed(this.field3820);
      var1.writeStringCp1252NullCircumfixed(this.field3819);
      var1.writeByte(this.field3822);
      var1.writeShort(this.field3835);
      var1.writeStringCp1252NullCircumfixed(this.field3824);
      var1.writeStringCp1252NullCircumfixed(this.field3837);
      var1.writeByte(this.field3839);
      var1.writeByte(this.field3833);

      for(int var2 = 0; var2 < this.field3841.length; ++var2) {
         var1.writeInt(this.field3841[var2]);
      }

      var1.writeInt(this.field3842);
      var1.writeStringCp1252NullCircumfixed(this.field3828);
      var1.writeStringCp1252NullCircumfixed(this.field3844);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "316580569"
   )
   @Export("size")
   public int size() {
      byte var1 = 39;
      int var2 = var1 + FaceNormal.method1235(this.field3836);
      var2 += FaceNormal.method1235(this.field3840);
      var2 += FaceNormal.method1235(this.field3820);
      var2 += FaceNormal.method1235(this.field3819);
      var2 += FaceNormal.method1235(this.field3824);
      var2 += FaceNormal.method1235(this.field3837);
      var2 += FaceNormal.method1235(this.field3828);
      var2 += FaceNormal.method1235(this.field3844);
      return var2;
   }
}
