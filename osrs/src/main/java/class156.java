import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class156 extends class159 {
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;
	@ObfuscatedName("aw")
	int field1392;
	@ObfuscatedName("ay")
	byte field1390;
	@ObfuscatedName("ar")
	int field1391;
	@ObfuscatedName("am")
	String field1393;
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
	class156(class160 var1) {
		this.this$0 = var1;
		this.field1392 = -1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "-43"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		var1.readUnsignedByte();
		this.field1392 = var1.readUnsignedShort();
		this.field1390 = var1.readByte();
		this.field1391 = var1.readUnsignedShort();
		var1.readLong();
		this.field1393 = var1.readStringCp1252NullTerminated();
		var1.readUnsignedByte();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lgh;I)V",
		garbageValue = "-2132107044"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1392);
		var2.rank = this.field1390;
		var2.world = this.field1391;
		var2.username = new Username(this.field1393);
	}
}
