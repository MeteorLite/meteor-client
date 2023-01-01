import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pk")
public class PlatformInfo extends Node {
   @ObfuscatedName("ar")
   int field4700;
   @ObfuscatedName("at")
   boolean field4712;
   @ObfuscatedName("ay")
   int field4702;
   @ObfuscatedName("an")
   int field4714;
   @ObfuscatedName("ab")
   int field4704;
   @ObfuscatedName("al")
   int field4705;
   @ObfuscatedName("ag")
   int field4706;
   @ObfuscatedName("az")
   boolean field4719;
   @ObfuscatedName("ak")
   int field4708;
   @ObfuscatedName("af")
   int field4709;
   @ObfuscatedName("ax")
   int field4710;
   @ObfuscatedName("ah")
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
   int field4716;
   @ObfuscatedName("ae")
   int field4701;
   @ObfuscatedName("ac")
   int field4720;
   @ObfuscatedName("bh")
   int field4713;
   @ObfuscatedName("be")
   String field4703;
   @ObfuscatedName("bf")
   String field4718;
   @ObfuscatedName("bo")
   int[] field4722 = new int[3];
   @ObfuscatedName("by")
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
