import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class8 {
	@ObfuscatedName("at")
	final int field19;
	@ObfuscatedName("ah")
	final int field18;
	@ObfuscatedName("ar")
	final String field20;

	@ObfuscatedSignature(
		descriptor = "(Luj;)V"
	)
	class8(Buffer var1) {
		this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
	}

	class8(int var1, int var2, String var3) {
		this.field19 = var1;
		this.field18 = var2;
		this.field20 = var3;
	}

	@ObfuscatedName("at")
	String method21() {
		return Integer.toHexString(this.field19) + Integer.toHexString(this.field18) + this.field20;
	}

	@ObfuscatedName("ah")
	int method22() {
		return this.field18;
	}
}