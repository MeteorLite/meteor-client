import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class151 extends class159 {
	@ObfuscatedName("ag")
	static int field1351;
	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	static Archive field1352;
	@ObfuscatedName("aw")
	int field1353;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgs;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class160 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgs;)V"
	)
	class151(class160 var1) {
		this.this$0 = var1;
		this.field1353 = -1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "-43"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		this.field1353 = var1.readUnsignedShort();
		var1.readUnsignedByte();
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			var1.readLong();
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lgh;I)V",
		garbageValue = "-2132107044"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		var1.removeMember(this.field1353);
	}
}
