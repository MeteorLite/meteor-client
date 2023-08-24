import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sm")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("by")
	int field3943;
	@ObfuscatedName("bs")
	boolean field3930;
	@ObfuscatedName("bm")
	int field3937;
	@ObfuscatedName("bf")
	int field3934;
	@ObfuscatedName("bq")
	int field3939;
	@ObfuscatedName("ba")
	int field3931;
	@ObfuscatedName("bl")
	int field3936;
	@ObfuscatedName("bp")
	boolean field3929;
	@ObfuscatedName("bu")
	int field3941;
	@ObfuscatedName("bo")
	int field3938;
	@ObfuscatedName("br")
	int field3940;
	@ObfuscatedName("be")
	int field3933;
	@ObfuscatedName("bi")
	String field3947;
	@ObfuscatedName("bz")
	String field3950;
	@ObfuscatedName("bx")
	String field3949;
	@ObfuscatedName("bn")
	String field3948;
	@ObfuscatedName("bw")
	int field3942;
	@ObfuscatedName("bc")
	int field3932;
	@ObfuscatedName("bg")
	int field3935;
	@ObfuscatedName("cw")
	int field3945;
	@ObfuscatedName("cf")
	String field3951;
	@ObfuscatedName("cm")
	String field3952;
	@ObfuscatedName("cn")
	int[] field3946;
	@ObfuscatedName("cs")
	int field3944;
	@ObfuscatedName("cx")
	String field3954;
	@ObfuscatedName("cr")
	String field3953;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
		this.field3946 = new int[3];
		this.field3943 = var1;
		this.field3930 = var2;
		this.field3937 = var3;
		this.field3934 = var4;
		this.field3939 = var5;
		this.field3931 = var6;
		this.field3936 = var7;
		this.field3929 = var8;
		this.field3941 = var9;
		this.field3938 = var10;
		this.field3940 = var11;
		this.field3933 = var12;
		this.field3947 = var13;
		this.field3950 = var14;
		this.field3949 = var15;
		this.field3948 = var16;
		this.field3942 = var17;
		this.field3932 = var18;
		this.field3935 = var19;
		this.field3945 = var20;
		this.field3951 = var21;
		this.field3952 = var22;
		this.field3946 = var23;
		this.field3944 = var24;
		this.field3954 = var25;
		this.field3953 = var26;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "77"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(9);
		var1.writeByte(this.field3943);
		var1.writeByte(this.field3930 ? 1 : 0);
		var1.writeShort(this.field3937);
		var1.writeByte(this.field3934);
		var1.writeByte(this.field3939);
		var1.writeByte(this.field3931);
		var1.writeByte(this.field3936);
		var1.writeByte(this.field3929 ? 1 : 0);
		var1.writeShort(this.field3941);
		var1.writeByte(this.field3938);
		var1.writeMedium(this.field3940);
		var1.writeShort(this.field3933);
		var1.writeStringCp1252NullCircumfixed(this.field3947);
		var1.writeStringCp1252NullCircumfixed(this.field3950);
		var1.writeStringCp1252NullCircumfixed(this.field3949);
		var1.writeStringCp1252NullCircumfixed(this.field3948);
		var1.writeByte(this.field3932);
		var1.writeShort(this.field3942);
		var1.writeStringCp1252NullCircumfixed(this.field3951);
		var1.writeStringCp1252NullCircumfixed(this.field3952);
		var1.writeByte(this.field3935);
		var1.writeByte(this.field3945);

		for (int var2 = 0; var2 < this.field3946.length; ++var2) {
			var1.writeInt(this.field3946[var2]);
		}

		var1.writeInt(this.field3944);
		var1.writeStringCp1252NullCircumfixed(this.field3954);
		var1.writeStringCp1252NullCircumfixed(this.field3953);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1863641013"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		String var4 = this.field3947;
		int var3 = var4.length() + 2;
		int var26 = var3 + var1;
		String var7 = this.field3950;
		int var6 = var7.length() + 2;
		var26 += var6;
		String var10 = this.field3949;
		int var9 = var10.length() + 2;
		var26 += var9;
		String var13 = this.field3948;
		int var12 = var13.length() + 2;
		var26 += var12;
		String var16 = this.field3951;
		int var15 = var16.length() + 2;
		var26 += var15;
		String var19 = this.field3952;
		int var18 = var19.length() + 2;
		var26 += var18;
		String var22 = this.field3954;
		int var21 = var22.length() + 2;
		var26 += var21;
		String var25 = this.field3953;
		int var24 = var25.length() + 2;
		var26 += var24;
		return var26;
	}
}