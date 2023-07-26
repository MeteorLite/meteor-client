import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class140 extends class143 {
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	@Export("ItemDefinition_modelArchive")
	static AbstractArchive ItemDefinition_modelArchive;
	@ObfuscatedName("jh")
	static int field1314;
	@ObfuscatedName("aw")
	int field1318;
	@ObfuscatedName("ay")
	int field1319;
	@ObfuscatedName("ar")
	int field1317;
	@ObfuscatedName("am")
	int field1316;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfr;)V"
	)
	class140(class146 var1) {
		this.this$0 = var1;
		this.field1318 = -1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1318 = var1.readUnsignedShort();
		this.field1319 = var1.readInt();
		this.field1317 = var1.readUnsignedByte();
		this.field1316 = var1.readUnsignedByte();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lfx;B)V",
		garbageValue = "-72"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method817(this.field1318, this.field1319, this.field1317, this.field1316);
	}
}
