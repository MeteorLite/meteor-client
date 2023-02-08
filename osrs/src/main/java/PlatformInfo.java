import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pu")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
   @ObfuscatedName("al")
   int field3831;
   @ObfuscatedName("at")
   boolean field3835;
   @ObfuscatedName("aj")
   int field3834;
   @ObfuscatedName("ax")
   int field3837;
   @ObfuscatedName("az")
   int field3842;
   @ObfuscatedName("ap")
   int field3839;
   @ObfuscatedName("ay")
   int field3833;
   @ObfuscatedName("ac")
   boolean field3840;
   @ObfuscatedName("av")
   int field3838;
   @ObfuscatedName("aq")
   int field3841;
   @ObfuscatedName("au")
   int field3854;
   @ObfuscatedName("ae")
   int field3843;
   @ObfuscatedName("ah")
   String field3844;
   @ObfuscatedName("ad")
   String field3845;
   @ObfuscatedName("ab")
   String field3846;
   @ObfuscatedName("an")
   String field3847;
   @ObfuscatedName("am")
   int field3848;
   @ObfuscatedName("as")
   int field3836;
   @ObfuscatedName("ao")
   int field3850;
   @ObfuscatedName("bj")
   int field3851;
   @ObfuscatedName("bf")
   String field3832;
   @ObfuscatedName("bz")
   String field3852;
   @ObfuscatedName("br")
   int[] field3853 = new int[3];
   @ObfuscatedName("bm")
   int field3849;
   @ObfuscatedName("be")
   String field3855;
   @ObfuscatedName("bo")
   String field3856;

   PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
      this.field3831 = var1;
      this.field3835 = var2;
      this.field3834 = var3;
      this.field3837 = var4;
      this.field3842 = var5;
      this.field3839 = var6;
      this.field3833 = var7;
      this.field3840 = var8;
      this.field3838 = var9;
      this.field3841 = var10;
      this.field3854 = var11;
      this.field3843 = var12;
      this.field3844 = var13;
      this.field3845 = var14;
      this.field3846 = var15;
      this.field3847 = var16;
      this.field3848 = var17;
      this.field3836 = var18;
      this.field3850 = var19;
      this.field3851 = var20;
      this.field3832 = var21;
      this.field3852 = var22;
      this.field3853 = var23;
      this.field3849 = var24;
      this.field3855 = var25;
      this.field3856 = var26;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "1532139983"
    )
    public void write(Buffer var1) {
      var1.writeByte(9);
      var1.writeByte(this.field3831);
      var1.writeByte(this.field3835 ? 1 : 0);
      var1.writeShort(this.field3834);
      var1.writeByte(this.field3837);
      var1.writeByte(this.field3842);
      var1.writeByte(this.field3839);
      var1.writeByte(this.field3833);
      var1.writeByte(this.field3840 ? 1 : 0);
      var1.writeShort(this.field3838);
      var1.writeByte(this.field3841);
      var1.writeMedium(this.field3854);
      var1.writeShort(this.field3843);
      var1.writeStringCp1252NullCircumfixed(this.field3844);
      var1.writeStringCp1252NullCircumfixed(this.field3845);
      var1.writeStringCp1252NullCircumfixed(this.field3846);
      var1.writeStringCp1252NullCircumfixed(this.field3847);
      var1.writeByte(this.field3836);
      var1.writeShort(this.field3848);
      var1.writeStringCp1252NullCircumfixed(this.field3832);
      var1.writeStringCp1252NullCircumfixed(this.field3852);
      var1.writeByte(this.field3850);
      var1.writeByte(this.field3851);

      for(int var2 = 0; var2 < this.field3853.length; ++var2) {
         var1.writeInt(this.field3853[var2]);
      }

      var1.writeInt(this.field3849);
      var1.writeStringCp1252NullCircumfixed(this.field3855);
      var1.writeStringCp1252NullCircumfixed(this.field3856);
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1699578121"
    )
    public int size() {
      byte var1 = 39;
      String var4 = this.field3844;
      int var3 = var4.length() + 2;
      int var26 = var1 + var3;
      String var7 = this.field3845;
      int var6 = var7.length() + 2;
      var26 += var6;
      String var10 = this.field3846;
      int var9 = var10.length() + 2;
      var26 += var9;
      String var13 = this.field3847;
      int var12 = var13.length() + 2;
      var26 += var12;
      String var16 = this.field3832;
      int var15 = var16.length() + 2;
      var26 += var15;
      String var19 = this.field3852;
      int var18 = var19.length() + 2;
      var26 += var18;
      String var22 = this.field3855;
      int var21 = var22.length() + 2;
      var26 += var21;
      String var25 = this.field3856;
      int var24 = var25.length() + 2;
      var26 += var24;
      return var26;
   }
}
