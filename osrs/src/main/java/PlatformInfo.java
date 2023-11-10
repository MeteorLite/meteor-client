import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sb")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("bg")
	int field3959;
	@ObfuscatedName("ba")
	boolean field3957;
	@ObfuscatedName("bm")
	int field3963;
	@ObfuscatedName("bp")
	int field3965;
	@ObfuscatedName("bw")
	int field3970;
	@ObfuscatedName("bj")
	int field3961;
	@ObfuscatedName("bn")
	int field3964;
	@ObfuscatedName("bo")
	boolean field3958;
	@ObfuscatedName("bt")
	int field3968;
	@ObfuscatedName("bu")
	int field3969;
	@ObfuscatedName("bh")
	int field3960;
	@ObfuscatedName("bz")
	int field3971;
	@ObfuscatedName("bc")
	String field3976;
	@ObfuscatedName("bs")
	String field3977;
	@ObfuscatedName("bx")
	String field3978;
	@ObfuscatedName("bb")
	String field3975;
	@ObfuscatedName("bk")
	int field3962;
	@ObfuscatedName("br")
	int field3967;
	@ObfuscatedName("bq")
	int field3966;
	@ObfuscatedName("cf")
	int field3972;
	@ObfuscatedName("cg")
	String field3980;
	@ObfuscatedName("cv")
	String field3982;
	@ObfuscatedName("cx")
	int[] field3974;
	@ObfuscatedName("cp")
	int field3973;
	@ObfuscatedName("ce")
	String field3979;
	@ObfuscatedName("ci")
	String field3981;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
		this.field3974 = new int[3];
		this.field3959 = var1;
		this.field3957 = var2;
		this.field3963 = var3;
		this.field3965 = var4;
		this.field3970 = var5;
		this.field3961 = var6;
		this.field3964 = var7;
		this.field3958 = var8;
		this.field3968 = var9;
		this.field3969 = var10;
		this.field3960 = var11;
		this.field3971 = var12;
		this.field3976 = var13;
		this.field3977 = var14;
		this.field3978 = var15;
		this.field3975 = var16;
		this.field3962 = var17;
		this.field3967 = var18;
		this.field3966 = var19;
		this.field3972 = var20;
		this.field3980 = var21;
		this.field3982 = var22;
		this.field3974 = var23;
		this.field3973 = var24;
		this.field3979 = var25;
		this.field3981 = var26;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "1412255226"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(9);
		var1.writeByte(this.field3959);
		var1.writeByte(this.field3957 ? 1 : 0);
		var1.writeShort(this.field3963);
		var1.writeByte(this.field3965);
		var1.writeByte(this.field3970);
		var1.writeByte(this.field3961);
		var1.writeByte(this.field3964);
		var1.writeByte(this.field3958 ? 1 : 0);
		var1.writeShort(this.field3968);
		var1.writeByte(this.field3969);
		var1.writeMedium(this.field3960);
		var1.writeShort(this.field3971);
		var1.writeStringCp1252NullCircumfixed(this.field3976);
		var1.writeStringCp1252NullCircumfixed(this.field3977);
		var1.writeStringCp1252NullCircumfixed(this.field3978);
		var1.writeStringCp1252NullCircumfixed(this.field3975);
		var1.writeByte(this.field3967);
		var1.writeShort(this.field3962);
		var1.writeStringCp1252NullCircumfixed(this.field3980);
		var1.writeStringCp1252NullCircumfixed(this.field3982);
		var1.writeByte(this.field3966);
		var1.writeByte(this.field3972);

		for (int var2 = 0; var2 < this.field3974.length; ++var2) {
			var1.writeInt(this.field3974[var2]);
		}

		var1.writeInt(this.field3973);
		var1.writeStringCp1252NullCircumfixed(this.field3979);
		var1.writeStringCp1252NullCircumfixed(this.field3981);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2077819620"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		String var4 = this.field3976;
		int var3 = var4.length() + 2;
		int var26 = var1 + var3;
		String var7 = this.field3977;
		int var6 = var7.length() + 2;
		var26 += var6;
		String var10 = this.field3978;
		int var9 = var10.length() + 2;
		var26 += var9;
		String var13 = this.field3975;
		int var12 = var13.length() + 2;
		var26 += var12;
		String var16 = this.field3980;
		int var15 = var16.length() + 2;
		var26 += var15;
		String var19 = this.field3982;
		int var18 = var19.length() + 2;
		var26 += var18;
		String var22 = this.field3979;
		int var21 = var22.length() + 2;
		var26 += var21;
		String var25 = this.field3981;
		int var24 = var25.length() + 2;
		var26 += var24;
		return var26;
	}
}