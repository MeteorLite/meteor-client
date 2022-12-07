import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pk")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1696581137
   )
   int field4700;
   @ObfuscatedName("at")
   boolean field4712;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -616314079
   )
   int field4702;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1322171453
   )
   int field4714;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1721213915
   )
   int field4704;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1060935769
   )
   int field4705;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1680914369
   )
   int field4706;
   @ObfuscatedName("az")
   boolean field4719;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1977940473
   )
   int field4708;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1625606725
   )
   int field4709;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1936122295
   )
   int field4710;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -325910601
   )
   int field4724;
   @ObfuscatedName("aw")
   String field4717;
   @ObfuscatedName("aj")
   String field4721;
   @ObfuscatedName("aq")
   String field4694;
   @ObfuscatedName("ap")
   String field4692;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1556899685
   )
   int field4716;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 730782471
   )
   int field4701;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 966550467
   )
   int field4720;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1361935411
   )
   int field4713;
   @ObfuscatedName("be")
   String field4703;
   @ObfuscatedName("bf")
   String field4718;
   @ObfuscatedName("bo")
   int[] field4722 = new int[3];
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -315982999
   )
   int field4723;
   @ObfuscatedName("bw")
   String field4707;
   @ObfuscatedName("bp")
   String field4725;

   PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
      this.field4700 = var1;
      this.field4712 = var2;
      this.field4702 = var3;
      this.field4714 = var4;
      this.field4704 = var5;
      this.field4705 = var6;
      this.field4706 = var7;
      this.field4719 = var8;
      this.field4708 = var9;
      this.field4709 = var10;
      this.field4710 = var11;
      this.field4724 = var12;
      this.field4717 = var13;
      this.field4721 = var14;
      this.field4694 = var15;
      this.field4692 = var16;
      this.field4716 = var17;
      this.field4701 = var18;
      this.field4720 = var19;
      this.field4713 = var20;
      this.field4703 = var21;
      this.field4718 = var22;
      this.field4722 = var23;
      this.field4723 = var24;
      this.field4707 = var25;
      this.field4725 = var26;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "0"
   )
   @Export("write")
   public void write(Buffer var1) {
      var1.writeByte(9);
      var1.writeByte(this.field4700);
      var1.writeByte(this.field4712 ? 1 : 0);
      var1.writeShort(this.field4702);
      var1.writeByte(this.field4714);
      var1.writeByte(this.field4704);
      var1.writeByte(this.field4705);
      var1.writeByte(this.field4706);
      var1.writeByte(this.field4719 ? 1 : 0);
      var1.writeShort(this.field4708);
      var1.writeByte(this.field4709);
      var1.writeMedium(this.field4710);
      var1.writeShort(this.field4724);
      var1.writeStringCp1252NullCircumfixed(this.field4717);
      var1.writeStringCp1252NullCircumfixed(this.field4721);
      var1.writeStringCp1252NullCircumfixed(this.field4694);
      var1.writeStringCp1252NullCircumfixed(this.field4692);
      var1.writeByte(this.field4701);
      var1.writeShort(this.field4716);
      var1.writeStringCp1252NullCircumfixed(this.field4703);
      var1.writeStringCp1252NullCircumfixed(this.field4718);
      var1.writeByte(this.field4720);
      var1.writeByte(this.field4713);

      for(int var2 = 0; var2 < this.field4722.length; ++var2) {
         var1.writeInt(this.field4722[var2]);
      }

      var1.writeInt(this.field4723);
      var1.writeStringCp1252NullCircumfixed(this.field4707);
      var1.writeStringCp1252NullCircumfixed(this.field4725);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "316580569"
   )
   @Export("size")
   public int size() {
      byte var1 = 39;
      int var2 = var1 + FaceNormal.method4618(this.field4717);
      var2 += FaceNormal.method4618(this.field4721);
      var2 += FaceNormal.method4618(this.field4694);
      var2 += FaceNormal.method4618(this.field4692);
      var2 += FaceNormal.method4618(this.field4703);
      var2 += FaceNormal.method4618(this.field4718);
      var2 += FaceNormal.method4618(this.field4707);
      var2 += FaceNormal.method4618(this.field4725);
      return var2;
   }
}
