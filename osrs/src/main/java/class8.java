import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class8 {
	@ObfuscatedName("ac")
	final int field11;
	@ObfuscatedName("al")
	final int field12;
	@ObfuscatedName("ak")
	final String field13;

	@ObfuscatedSignature(
		descriptor = "(Lul;)V"
	)
	class8(Buffer var1) {
		this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
	}

	class8(int var1, int var2, String var3) {
		this.field11 = var1;
		this.field12 = var2;
		this.field13 = var3;
	}

	@ObfuscatedName("ac")
	String method24() {
		return Integer.toHexString(this.field11) + Integer.toHexString(this.field12) + this.field13;
	}

	@ObfuscatedName("al")
	int method25() {
		return this.field12;
	}
}