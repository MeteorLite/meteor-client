import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class152 extends class145 {
	@ObfuscatedName("jq")
	@Export("regions")
	static int[] regions;
	@ObfuscatedName("ac")
	boolean field1347;
	@ObfuscatedName("al")
	byte field1349;
	@ObfuscatedName("ak")
	byte field1348;
	@ObfuscatedName("ax")
	byte field1351;
	@ObfuscatedName("ao")
	byte field1350;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lff;"
	)
	final class148 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lff;)V"
	)
	class152(class148 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "-11659242"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1347 = var1.readUnsignedByte() == 1;
		this.field1349 = var1.readByte();
		this.field1348 = var1.readByte();
		this.field1351 = var1.readByte();
		this.field1350 = var1.readByte();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lgi;I)V",
		garbageValue = "21847466"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.allowGuests = this.field1347;
		var1.field1371 = this.field1349;
		var1.field1372 = this.field1348;
		var1.field1370 = this.field1351;
		var1.field1369 = this.field1350;
	}
}