import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class150 extends class143 {
	@ObfuscatedName("au")
	boolean field1360;
	@ObfuscatedName("ae")
	byte field1362;
	@ObfuscatedName("ao")
	byte field1363;
	@ObfuscatedName("at")
	byte field1364;
	@ObfuscatedName("ac")
	byte field1361;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfn;"
	)
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfn;)V"
	)
	class150(class146 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "209179459"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1360 = var1.readUnsignedByte() == 1;
		this.field1362 = var1.readByte();
		this.field1363 = var1.readByte();
		this.field1364 = var1.readByte();
		this.field1361 = var1.readByte();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lfi;B)V",
		garbageValue = "73"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.allowGuests = this.field1360;
		var1.field1383 = this.field1362;
		var1.field1385 = this.field1363;
		var1.field1384 = this.field1364;
		var1.field1386 = this.field1361;
	}
}