import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rv")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
   @ObfuscatedName("bo")
   int field3876;
   @ObfuscatedName("bz")
   boolean field3853;
   @ObfuscatedName("bm")
   int field3854;
   @ObfuscatedName("bd")
   int field3855;
   @ObfuscatedName("bt")
   int field3856;
   @ObfuscatedName("bj")
   int field3871;
   @ObfuscatedName("bn")
   int field3858;
   @ObfuscatedName("bs")
   boolean field3863;
   @ObfuscatedName("br")
   int field3877;
   @ObfuscatedName("bg")
   int field3870;
   @ObfuscatedName("bf")
   int field3852;
   @ObfuscatedName("bq")
   int field3857;
   @ObfuscatedName("ba")
   String field3865;
   @ObfuscatedName("bv")
   String field3866;
   @ObfuscatedName("bl")
   String field3867;
   @ObfuscatedName("bp")
   String field3868;
   @ObfuscatedName("bc")
   int field3864;
   @ObfuscatedName("bh")
   int field3869;
   @ObfuscatedName("bw")
   int field3862;
   @ObfuscatedName("ce")
   int field3859;
   @ObfuscatedName("ci")
   String field3872;
   @ObfuscatedName("cs")
   String field3861;
   @ObfuscatedName("cc")
   int[] field3873 = new int[3];
   @ObfuscatedName("cn")
   int field3875;
   @ObfuscatedName("ca")
   String field3860;
   @ObfuscatedName("cu")
   String field3874;

   PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
      this.field3876 = var1;
      this.field3853 = var2;
      this.field3854 = var3;
      this.field3855 = var4;
      this.field3856 = var5;
      this.field3871 = var6;
      this.field3858 = var7;
      this.field3863 = var8;
      this.field3877 = var9;
      this.field3870 = var10;
      this.field3852 = var11;
      this.field3857 = var12;
      this.field3865 = var13;
      this.field3866 = var14;
      this.field3867 = var15;
      this.field3868 = var16;
      this.field3864 = var17;
      this.field3869 = var18;
      this.field3862 = var19;
      this.field3859 = var20;
      this.field3872 = var21;
      this.field3861 = var22;
      this.field3873 = var23;
      this.field3875 = var24;
      this.field3860 = var25;
      this.field3874 = var26;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;B)V",
            garbageValue = "15"
    )
    public void write(Buffer var1) {
      var1.writeByte(9);
      var1.writeByte(this.field3876);
      var1.writeByte(this.field3853 ? 1 : 0);
      var1.writeShort(this.field3854);
      var1.writeByte(this.field3855);
      var1.writeByte(this.field3856);
      var1.writeByte(this.field3871);
      var1.writeByte(this.field3858);
      var1.writeByte(this.field3863 ? 1 : 0);
      var1.writeShort(this.field3877);
      var1.writeByte(this.field3870);
      var1.writeMedium(this.field3852);
      var1.writeShort(this.field3857);
      var1.writeStringCp1252NullCircumfixed(this.field3865);
      var1.writeStringCp1252NullCircumfixed(this.field3866);
      var1.writeStringCp1252NullCircumfixed(this.field3867);
      var1.writeStringCp1252NullCircumfixed(this.field3868);
      var1.writeByte(this.field3869);
      var1.writeShort(this.field3864);
      var1.writeStringCp1252NullCircumfixed(this.field3872);
      var1.writeStringCp1252NullCircumfixed(this.field3861);
      var1.writeByte(this.field3862);
      var1.writeByte(this.field3859);

      for(int var2 = 0; var2 < this.field3873.length; ++var2) {
         var1.writeInt(this.field3873[var2]);
      }

      var1.writeInt(this.field3875);
      var1.writeStringCp1252NullCircumfixed(this.field3860);
      var1.writeStringCp1252NullCircumfixed(this.field3874);
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "70"
    )
    public int size() {
      byte var1 = 39;
      int var2 = var1 + ObjTypeCustomisation.method971(this.field3865);
      var2 += ObjTypeCustomisation.method971(this.field3866);
      var2 += ObjTypeCustomisation.method971(this.field3867);
      var2 += ObjTypeCustomisation.method971(this.field3868);
      var2 += ObjTypeCustomisation.method971(this.field3872);
      var2 += ObjTypeCustomisation.method971(this.field3861);
      var2 += ObjTypeCustomisation.method971(this.field3860);
      var2 += ObjTypeCustomisation.method971(this.field3874);
      return var2;
   }
}
