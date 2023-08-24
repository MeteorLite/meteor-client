import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class156 extends class159 {
	@ObfuscatedName("wl")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("au")
	int field1404;
	@ObfuscatedName("ae")
	byte field1402;
	@ObfuscatedName("ao")
	int field1403;
	@ObfuscatedName("at")
	String field1405;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgg;"
	)
	final class160 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgg;)V"
	)
	class156(class160 var1) {
		this.this$0 = var1;
		this.field1404 = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		var1.readUnsignedByte();
		this.field1404 = var1.readUnsignedShort();
		this.field1402 = var1.readByte();
		this.field1403 = var1.readUnsignedShort();
		var1.readLong();
		this.field1405 = var1.readStringCp1252NullTerminated();
		var1.readUnsignedByte();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lgo;I)V",
		garbageValue = "831405774"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1404);
		var2.rank = this.field1402;
		var2.world = this.field1403;
		var2.username = new Username(this.field1405);
	}
}