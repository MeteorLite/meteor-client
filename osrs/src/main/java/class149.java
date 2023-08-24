import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class149 extends class159 {
	@ObfuscatedName("au")
	int field1358;
	@ObfuscatedName("ae")
	byte field1356;
	@ObfuscatedName("ao")
	int field1357;
	@ObfuscatedName("at")
	String field1359;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgg;"
	)
	final class160 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgg;)V"
	)
	class149(class160 var1) {
		this.this$0 = var1;
		this.field1358 = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		this.field1358 = var1.readUnsignedShort();
		this.field1356 = var1.readByte();
		this.field1357 = var1.readUnsignedShort();
		var1.readLong();
		this.field1359 = var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lgo;I)V",
		garbageValue = "831405774"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1358);
		var2.rank = this.field1356;
		var2.world = this.field1357;
		var2.username = new Username(this.field1359);
	}
}