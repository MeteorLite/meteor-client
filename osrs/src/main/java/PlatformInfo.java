import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sy")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("bp")
	int field3924;
	@ObfuscatedName("bv")
	boolean field3918;
	@ObfuscatedName("bq")
	int field3925;
	@ObfuscatedName("bo")
	int field3923;
	@ObfuscatedName("br")
	int field3926;
	@ObfuscatedName("bw")
	int field3928;
	@ObfuscatedName("be")
	int field3919;
	@ObfuscatedName("bc")
	boolean field3917;
	@ObfuscatedName("bi")
	int field3921;
	@ObfuscatedName("bu")
	int field3927;
	@ObfuscatedName("bz")
	int field3931;
	@ObfuscatedName("bx")
	int field3929;
	@ObfuscatedName("bh")
	String field3935;
	@ObfuscatedName("bm")
	String field3937;
	@ObfuscatedName("bl")
	String field3936;
	@ObfuscatedName("bt")
	String field3938;
	@ObfuscatedName("by")
	int field3930;
	@ObfuscatedName("bg")
	int field3920;
	@ObfuscatedName("bj")
	int field3922;
	@ObfuscatedName("ct")
	int field3933;
	@ObfuscatedName("cf")
	String field3939;
	@ObfuscatedName("cz")
	String field3942;
	@ObfuscatedName("cb")
	int[] field3934;
	@ObfuscatedName("cs")
	int field3932;
	@ObfuscatedName("cj")
	String field3940;
	@ObfuscatedName("cn")
	String field3941;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
		this.field3934 = new int[3];
		this.field3924 = var1;
		this.field3918 = var2;
		this.field3925 = var3;
		this.field3923 = var4;
		this.field3926 = var5;
		this.field3928 = var6;
		this.field3919 = var7;
		this.field3917 = var8;
		this.field3921 = var9;
		this.field3927 = var10;
		this.field3931 = var11;
		this.field3929 = var12;
		this.field3935 = var13;
		this.field3937 = var14;
		this.field3936 = var15;
		this.field3938 = var16;
		this.field3930 = var17;
		this.field3920 = var18;
		this.field3922 = var19;
		this.field3933 = var20;
		this.field3939 = var21;
		this.field3942 = var22;
		this.field3934 = var23;
		this.field3932 = var24;
		this.field3940 = var25;
		this.field3941 = var26;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)V",
		garbageValue = "-1478570586"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(9);
		var1.writeByte(this.field3924);
		var1.writeByte(this.field3918 ? 1 : 0);
		var1.writeShort(this.field3925);
		var1.writeByte(this.field3923);
		var1.writeByte(this.field3926);
		var1.writeByte(this.field3928);
		var1.writeByte(this.field3919);
		var1.writeByte(this.field3917 ? 1 : 0);
		var1.writeShort(this.field3921);
		var1.writeByte(this.field3927);
		var1.writeMedium(this.field3931);
		var1.writeShort(this.field3929);
		var1.writeStringCp1252NullCircumfixed(this.field3935);
		var1.writeStringCp1252NullCircumfixed(this.field3937);
		var1.writeStringCp1252NullCircumfixed(this.field3936);
		var1.writeStringCp1252NullCircumfixed(this.field3938);
		var1.writeByte(this.field3920);
		var1.writeShort(this.field3930);
		var1.writeStringCp1252NullCircumfixed(this.field3939);
		var1.writeStringCp1252NullCircumfixed(this.field3942);
		var1.writeByte(this.field3922);
		var1.writeByte(this.field3933);

		for (int var2 = 0; var2 < this.field3934.length; ++var2) {
			var1.writeInt(this.field3934[var2]);
		}

		var1.writeInt(this.field3932);
		var1.writeStringCp1252NullCircumfixed(this.field3940);
		var1.writeStringCp1252NullCircumfixed(this.field3941);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-209852192"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var2 = var1 + class387.method1985(this.field3935);
		var2 += class387.method1985(this.field3937);
		var2 += class387.method1985(this.field3936);
		var2 += class387.method1985(this.field3938);
		var2 += class387.method1985(this.field3939);
		var2 += class387.method1985(this.field3942);
		var2 += class387.method1985(this.field3940);
		var2 += class387.method1985(this.field3941);
		return var2;
	}
}
