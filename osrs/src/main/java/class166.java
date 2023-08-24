import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class166 extends class159 {
	@ObfuscatedName("au")
	String field1434;
	@ObfuscatedName("ae")
	byte field1432;
	@ObfuscatedName("ao")
	byte field1433;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgg;"
	)
	final class160 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgg;)V"
	)
	class166(class160 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		this.field1434 = var1.readStringCp1252NullTerminatedOrNull();
		if (this.field1434 != null) {
			var1.readUnsignedByte();
			this.field1432 = var1.readByte();
			this.field1433 = var1.readByte();
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lgo;I)V",
		garbageValue = "831405774"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		var1.name = this.field1434;
		if (this.field1434 != null) {
			var1.field1426 = this.field1432;
			var1.field1425 = this.field1433;
		}

	}
}