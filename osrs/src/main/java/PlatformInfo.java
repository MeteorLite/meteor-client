import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("os")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1491327705
	)
	int field4517;
	@ObfuscatedName("aa")
	boolean field4518;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1770862873
	)
	int field4519;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 168679747
	)
	int field4529;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 788596425
	)
	int field4521;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1793496309
	)
	int field4522;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1553431275
	)
	int field4523;
	@ObfuscatedName("ad")
	boolean field4524;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -1639768545
	)
	int field4525;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -1260912817
	)
	int field4526;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1168171821
	)
	int field4527;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 121638841
	)
	int field4513;
	@ObfuscatedName("ay")
	String field4536;
	@ObfuscatedName("ag")
	String field4514;
	@ObfuscatedName("aw")
	String field4528;
	@ObfuscatedName("ah")
	String field4532;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = 104379723
	)
	int field4512;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 1336079991
	)
	int field4534;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 1881657771
	)
	int field4535;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 733268679
	)
	int field4530;
	@ObfuscatedName("bw")
	String field4537;
	@ObfuscatedName("bc")
	String field4538;
	@ObfuscatedName("bv")
	int[] field4539;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 28181965
	)
	int field4540;
	@ObfuscatedName("bj")
	String field4541;
	@ObfuscatedName("by")
	String field4542;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
		this.field4539 = new int[3];
		this.field4517 = var1;
		this.field4518 = var2;
		this.field4519 = var3;
		this.field4529 = var4;
		this.field4521 = var5;
		this.field4522 = var6;
		this.field4523 = var7;
		this.field4524 = var8;
		this.field4525 = var9;
		this.field4526 = var10;
		this.field4527 = var11;
		this.field4513 = var12;
		this.field4536 = var13;
		this.field4514 = var14;
		this.field4528 = var15;
		this.field4532 = var16;
		this.field4512 = var17;
		this.field4534 = var18;
		this.field4535 = var19;
		this.field4530 = var20;
		this.field4537 = var21;
		this.field4538 = var22;
		this.field4539 = var23;
		this.field4540 = var24;
		this.field4541 = var25;
		this.field4542 = var26;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;S)V",
		garbageValue = "2713"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(9);
		var1.writeByte(this.field4517);
		var1.writeByte(this.field4518 ? 1 : 0);
		var1.writeShort(this.field4519);
		var1.writeByte(this.field4529);
		var1.writeByte(this.field4521);
		var1.writeByte(this.field4522);
		var1.writeByte(this.field4523);
		var1.writeByte(this.field4524 ? 1 : 0);
		var1.writeShort(this.field4525);
		var1.writeByte(this.field4526);
		var1.writeMedium(this.field4527);
		var1.writeShort(this.field4513);
		var1.writeStringCp1252NullCircumfixed(this.field4536);
		var1.writeStringCp1252NullCircumfixed(this.field4514);
		var1.writeStringCp1252NullCircumfixed(this.field4528);
		var1.writeStringCp1252NullCircumfixed(this.field4532);
		var1.writeByte(this.field4534);
		var1.writeShort(this.field4512);
		var1.writeStringCp1252NullCircumfixed(this.field4537);
		var1.writeStringCp1252NullCircumfixed(this.field4538);
		var1.writeByte(this.field4535);
		var1.writeByte(this.field4530);

		for (int var2 = 0; var2 < this.field4539.length; ++var2) {
			var1.writeInt(this.field4539[var2]);
		}

		var1.writeInt(this.field4540);
		var1.writeStringCp1252NullCircumfixed(this.field4541);
		var1.writeStringCp1252NullCircumfixed(this.field4542);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "853872720"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		int var2 = var1 + class142.method3185(this.field4536);
		var2 += class142.method3185(this.field4514);
		var2 += class142.method3185(this.field4528);
		var2 += class142.method3185(this.field4532);
		var2 += class142.method3185(this.field4537);
		var2 += class142.method3185(this.field4538);
		var2 += class142.method3185(this.field4541);
		var2 += class142.method3185(this.field4542);
		return var2;
	}
}
