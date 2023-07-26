import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class155 extends class159 {
	@ObfuscatedName("jy")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;
	@ObfuscatedName("aw")
	String field1388;
	@ObfuscatedName("ay")
	int field1387;
	@ObfuscatedName("ar")
	byte field1386;
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
	class155(class160 var1) {
		this.this$0 = var1;
		this.field1388 = null;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "-43"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			var1.readLong();
		}

		this.field1388 = var1.readStringCp1252NullTerminatedOrNull();
		this.field1387 = var1.readUnsignedShort();
		this.field1386 = var1.readByte();
		var1.readLong();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lgh;I)V",
		garbageValue = "-2132107044"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = new ClanChannelMember();
		var2.username = new Username(this.field1388);
		var2.world = this.field1387;
		var2.rank = this.field1386;
		var1.addMember(var2);
	}
}
