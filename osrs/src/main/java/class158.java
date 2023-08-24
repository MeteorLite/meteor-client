import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class158 extends class143 {
	@ObfuscatedName("au")
	long field1411;
	@ObfuscatedName("ae")
	String field1410;
	@ObfuscatedName("ao")
	int field1409;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfn;"
	)
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfn;)V"
	)
	class158(class146 var1) {
		this.this$0 = var1;
		this.field1411 = -1L;
		this.field1410 = null;
		this.field1409 = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "209179459"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1411 = var1.readLong();
		}

		this.field1410 = var1.readStringCp1252NullTerminatedOrNull();
		this.field1409 = var1.readUnsignedShort();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lfi;B)V",
		garbageValue = "73"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method812(this.field1411, this.field1410, this.field1409);
	}
}