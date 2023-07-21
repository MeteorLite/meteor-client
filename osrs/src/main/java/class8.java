import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class8 {
	@ObfuscatedName("aw")
	final int field14;
	@ObfuscatedName("ay")
	final int field15;
	@ObfuscatedName("ar")
	final String field16;

	@ObfuscatedSignature(
		descriptor = "(Lty;)V"
	)
	class8(Buffer var1) {
		this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
	}

	class8(int var1, int var2, String var3) {
		this.field14 = var1;
		this.field15 = var2;
		this.field16 = var3;
	}

	@ObfuscatedName("aw")
	String method22() {
		return Integer.toHexString(this.field14) + Integer.toHexString(this.field15) + this.field16;
	}

	@ObfuscatedName("ay")
	int method23() {
		return this.field15;
	}
}
