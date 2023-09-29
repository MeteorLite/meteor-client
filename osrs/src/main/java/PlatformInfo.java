import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sx")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("ba")
	int field3962;
	@ObfuscatedName("bz")
	boolean field3961;
	@ObfuscatedName("bb")
	int field3963;
	@ObfuscatedName("bo")
	int field3969;
	@ObfuscatedName("bp")
	int field3970;
	@ObfuscatedName("bt")
	int field3973;
	@ObfuscatedName("bm")
	int field3968;
	@ObfuscatedName("br")
	boolean field3960;
	@ObfuscatedName("bs")
	int field3972;
	@ObfuscatedName("bc")
	int field3964;
	@ObfuscatedName("bf")
	int field3965;
	@ObfuscatedName("bh")
	int field3966;
	@ObfuscatedName("bl")
	String field3980;
	@ObfuscatedName("bg")
	String field3978;
	@ObfuscatedName("bj")
	String field3979;
	@ObfuscatedName("bx")
	String field3981;
	@ObfuscatedName("bi")
	int field3967;
	@ObfuscatedName("bq")
	int field3971;
	@ObfuscatedName("bw")
	int field3974;
	@ObfuscatedName("ce")
	int field3976;
	@ObfuscatedName("cu")
	String field3984;
	@ObfuscatedName("cw")
	String field3985;
	@ObfuscatedName("co")
	int[] field3977;
	@ObfuscatedName("cc")
	int field3975;
	@ObfuscatedName("cg")
	String field3982;
	@ObfuscatedName("cq")
	String field3983;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
		this.field3977 = new int[3];
		this.field3962 = var1;
		this.field3961 = var2;
		this.field3963 = var3;
		this.field3969 = var4;
		this.field3970 = var5;
		this.field3973 = var6;
		this.field3968 = var7;
		this.field3960 = var8;
		this.field3972 = var9;
		this.field3964 = var10;
		this.field3965 = var11;
		this.field3966 = var12;
		this.field3980 = var13;
		this.field3978 = var14;
		this.field3979 = var15;
		this.field3981 = var16;
		this.field3967 = var17;
		this.field3971 = var18;
		this.field3974 = var19;
		this.field3976 = var20;
		this.field3984 = var21;
		this.field3985 = var22;
		this.field3977 = var23;
		this.field3975 = var24;
		this.field3982 = var25;
		this.field3983 = var26;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "1684641716"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(9);
		var1.writeByte(this.field3962);
		var1.writeByte(this.field3961 ? 1 : 0);
		var1.writeShort(this.field3963);
		var1.writeByte(this.field3969);
		var1.writeByte(this.field3970);
		var1.writeByte(this.field3973);
		var1.writeByte(this.field3968);
		var1.writeByte(this.field3960 ? 1 : 0);
		var1.writeShort(this.field3972);
		var1.writeByte(this.field3964);
		var1.writeMedium(this.field3965);
		var1.writeShort(this.field3966);
		var1.writeStringCp1252NullCircumfixed(this.field3980);
		var1.writeStringCp1252NullCircumfixed(this.field3978);
		var1.writeStringCp1252NullCircumfixed(this.field3979);
		var1.writeStringCp1252NullCircumfixed(this.field3981);
		var1.writeByte(this.field3971);
		var1.writeShort(this.field3967);
		var1.writeStringCp1252NullCircumfixed(this.field3984);
		var1.writeStringCp1252NullCircumfixed(this.field3985);
		var1.writeByte(this.field3974);
		var1.writeByte(this.field3976);

		for (int var2 = 0; var2 < this.field3977.length; ++var2) {
			var1.writeInt(this.field3977[var2]);
		}

		var1.writeInt(this.field3975);
		var1.writeStringCp1252NullCircumfixed(this.field3982);
		var1.writeStringCp1252NullCircumfixed(this.field3983);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "725870581"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		String var4 = this.field3980;
		int var3 = var4.length() + 2;
		int var26 = var1 + var3;
		String var7 = this.field3978;
		int var6 = var7.length() + 2;
		var26 += var6;
		String var10 = this.field3979;
		int var9 = var10.length() + 2;
		var26 += var9;
		String var13 = this.field3981;
		int var12 = var13.length() + 2;
		var26 += var12;
		String var16 = this.field3984;
		int var15 = var16.length() + 2;
		var26 += var15;
		String var19 = this.field3985;
		int var18 = var19.length() + 2;
		var26 += var18;
		String var22 = this.field3982;
		int var21 = var22.length() + 2;
		var26 += var21;
		String var25 = this.field3983;
		int var24 = var25.length() + 2;
		var26 += var24;
		return var26;
	}
}