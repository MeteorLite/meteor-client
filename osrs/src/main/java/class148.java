import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class148 extends class144 {
	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		descriptor = "[Lup;"
	)
	@Export("worldSelectArrows")
	static IndexedSprite[] worldSelectArrows;
	@ObfuscatedName("qj")
	@Export("widgetDragDuration")
	static int widgetDragDuration;
	@ObfuscatedName("at")
	int field1350;
	@ObfuscatedName("ah")
	byte field1349;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class148(class147 var1) {
		this.this$0 = var1;
		this.field1350 = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1350 = var1.readUnsignedShort();
		this.field1349 = var1.readByte();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method810(this.field1350, this.field1349);
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "415376551"
	)
	static int method775(int var0, Script var1, boolean var2) {
		return 2;
	}
}