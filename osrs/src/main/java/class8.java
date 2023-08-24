import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class8 {
	@ObfuscatedName("au")
	final int field15;
	@ObfuscatedName("ae")
	final int field14;
	@ObfuscatedName("ao")
	final String field16;

	@ObfuscatedSignature(
		descriptor = "(Ltm;)V"
	)
	class8(Buffer var1) {
		this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
	}

	class8(int var1, int var2, String var3) {
		this.field15 = var1;
		this.field14 = var2;
		this.field16 = var3;
	}

	@ObfuscatedName("au")
	String method19() {
		return Integer.toHexString(this.field15) + Integer.toHexString(this.field14) + this.field16;
	}

	@ObfuscatedName("ae")
	int method20() {
		return this.field14;
	}
}