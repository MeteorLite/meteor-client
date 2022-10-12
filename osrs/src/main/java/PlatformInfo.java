import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pw")
@Implements("PlatformInfo")
public class PlatformInfo extends Node {
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 1986853609
	)
	int field4661;
	@ObfuscatedName("av")
	boolean field4652;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 503045331
	)
	int field4651;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 951411975
	)
	int field4654;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -2078295935
	)
	int field4655;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 1360270049
	)
	int field4645;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1414009049
	)
	int field4657;
	@ObfuscatedName("al")
	boolean field4658;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1913366845
	)
	int field4643;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -57306917
	)
	int field4660;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 1124886807
	)
	int field4656;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 676182769
	)
	int field4670;
	@ObfuscatedName("au")
	String field4663;
	@ObfuscatedName("aw")
	String field4664;
	@ObfuscatedName("at")
	String field4646;
	@ObfuscatedName("ar")
	String field4666;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -468699877
	)
	int field4675;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -304749407
	)
	int field4668;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 871091663
	)
	int field4659;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 621341049
	)
	int field4647;
	@ObfuscatedName("bh")
	String field4671;
	@ObfuscatedName("bm")
	String field4672;
	@ObfuscatedName("bp")
	int[] field4673;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = 1955870365
	)
	int field4674;
	@ObfuscatedName("bo")
	String field4662;
	@ObfuscatedName("bg")
	String field4665;

	PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
		this.field4673 = new int[3];
		this.field4661 = var1;
		this.field4652 = var2;
		this.field4651 = var3;
		this.field4654 = var4;
		this.field4655 = var5;
		this.field4645 = var6;
		this.field4657 = var7;
		this.field4658 = var8;
		this.field4643 = var9;
		this.field4660 = var10;
		this.field4656 = var11;
		this.field4670 = var12;
		this.field4663 = var13;
		this.field4664 = var14;
		this.field4646 = var15;
		this.field4666 = var16;
		this.field4675 = var17;
		this.field4668 = var18;
		this.field4659 = var19;
		this.field4647 = var20;
		this.field4671 = var21;
		this.field4672 = var22;
		this.field4673 = var23;
		this.field4674 = var24;
		this.field4662 = var25;
		this.field4665 = var26;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(Lqr;I)V",
		garbageValue = "1670253037"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(9);
		var1.writeByte(this.field4661);
		var1.writeByte(this.field4652 ? 1 : 0);
		var1.writeShort(this.field4651);
		var1.writeByte(this.field4654);
		var1.writeByte(this.field4655);
		var1.writeByte(this.field4645);
		var1.writeByte(this.field4657);
		var1.writeByte(this.field4658 ? 1 : 0);
		var1.writeShort(this.field4643);
		var1.writeByte(this.field4660);
		var1.writeMedium(this.field4656);
		var1.writeShort(this.field4670);
		var1.writeStringCp1252NullCircumfixed(this.field4663);
		var1.writeStringCp1252NullCircumfixed(this.field4664);
		var1.writeStringCp1252NullCircumfixed(this.field4646);
		var1.writeStringCp1252NullCircumfixed(this.field4666);
		var1.writeByte(this.field4668);
		var1.writeShort(this.field4675);
		var1.writeStringCp1252NullCircumfixed(this.field4671);
		var1.writeStringCp1252NullCircumfixed(this.field4672);
		var1.writeByte(this.field4659);
		var1.writeByte(this.field4647);

		for (int var2 = 0; var2 < this.field4673.length; ++var2) {
			var1.writeInt(this.field4673[var2]);
		}

		var1.writeInt(this.field4674);
		var1.writeStringCp1252NullCircumfixed(this.field4662);
		var1.writeStringCp1252NullCircumfixed(this.field4665);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "3"
	)
	@Export("size")
	public int size() {
		byte var1 = 39;
		String var4 = this.field4663;
		int var3 = var4.length() + 2;
		int var26 = var1 + var3;
		String var7 = this.field4664;
		int var6 = var7.length() + 2;
		var26 += var6;
		String var10 = this.field4646;
		int var9 = var10.length() + 2;
		var26 += var9;
		String var13 = this.field4666;
		int var12 = var13.length() + 2;
		var26 += var12;
		String var16 = this.field4671;
		int var15 = var16.length() + 2;
		var26 += var15;
		String var19 = this.field4672;
		int var18 = var19.length() + 2;
		var26 += var18;
		String var22 = this.field4662;
		int var21 = var22.length() + 2;
		var26 += var21;
		String var25 = this.field4665;
		int var24 = var25.length() + 2;
		var26 += var24;
		return var26;
	}
}
