import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class152 extends class160 {
	@ObfuscatedName("at")
	int field1365;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgi;"
	)
	final class161 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgi;)V"
	)
	class152(class161 var1) {
		this.this$0 = var1;
		this.field1365 = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "1810249387"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		this.field1365 = var1.readUnsignedShort();
		var1.readUnsignedByte();
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			var1.readLong();
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lgn;B)V",
		garbageValue = "-75"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		var1.removeMember(this.field1365);
	}
}