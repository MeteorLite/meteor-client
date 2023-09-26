import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class142 extends class145 {
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lpu;"
	)
	@Export("ItemDefinition_fontPlain11")
	static Font ItemDefinition_fontPlain11;
	@ObfuscatedName("ac")
	int field1319;
	@ObfuscatedName("al")
	int field1321;
	@ObfuscatedName("ak")
	int field1320;
	@ObfuscatedName("ax")
	int field1322;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lff;"
	)
	final class148 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lff;)V"
	)
	class142(class148 var1) {
		this.this$0 = var1;
		this.field1319 = -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "-11659242"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1319 = var1.readUnsignedShort();
		this.field1321 = var1.readInt();
		this.field1320 = var1.readUnsignedByte();
		this.field1322 = var1.readUnsignedByte();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lgi;I)V",
		garbageValue = "21847466"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method825(this.field1319, this.field1321, this.field1320, this.field1322);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;I)V",
		garbageValue = "1595932932"
	)
	public static void method753(AbstractArchive var0) {
		StructComposition.StructDefinition_archive = var0;
	}
}