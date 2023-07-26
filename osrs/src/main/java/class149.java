import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class149 extends class159 {
	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	static Archive field1340;
	@ObfuscatedName("aw")
	int field1343;
	@ObfuscatedName("ay")
	byte field1341;
	@ObfuscatedName("ar")
	int field1342;
	@ObfuscatedName("am")
	String field1344;
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
	class149(class160 var1) {
		this.this$0 = var1;
		this.field1343 = -1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "-43"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		this.field1343 = var1.readUnsignedShort();
		this.field1341 = var1.readByte();
		this.field1342 = var1.readUnsignedShort();
		var1.readLong();
		this.field1344 = var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lgh;I)V",
		garbageValue = "-2132107044"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1343);
		var2.rank = this.field1341;
		var2.world = this.field1342;
		var2.username = new Username(this.field1344);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;I)V",
		garbageValue = "-1871953753"
	)
	public static void method782(AbstractArchive var0) {
		FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
	}
}
