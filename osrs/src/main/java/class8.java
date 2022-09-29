import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class8 {
	@ObfuscatedName("c")
	final int field28;
	@ObfuscatedName("p")
	final int field29;
	@ObfuscatedName("f")
	final String field30;

	@ObfuscatedSignature(
		descriptor = "(Lqq;)V"
	)
	class8(Buffer var1) {
		this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
	}

	class8(int var1, int var2, String var3) {
		this.field28 = var1;
		this.field29 = var2;
		this.field30 = var3;
	}

	@ObfuscatedName("c")
	String method71() {
		return Integer.toHexString(this.field28) + Integer.toHexString(this.field29) + this.field30;
	}

	@ObfuscatedName("p")
	int method72() {
		return this.field29;
	}
}
