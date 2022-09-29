import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class141 extends class145 {
	@ObfuscatedName("c")
	String field1654;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1572942225
	)
	int field1657;
	@ObfuscatedName("f")
	byte field1656;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lem;"
	)
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lem;)V"
	)
	class141(class146 var1) {
		this.this$0 = var1;
		this.field1654 = null;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "-64301329"
	)
	void vmethod3300(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			var1.readLong();
		}

		this.field1654 = var1.readStringCp1252NullTerminatedOrNull();
		this.field1657 = var1.readUnsignedShort();
		this.field1656 = var1.readByte();
		var1.readLong();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Ler;B)V",
		garbageValue = "97"
	)
	void vmethod3302(ClanChannel var1) {
		ClanChannelMember var2 = new ClanChannelMember();
		var2.username = new Username(this.field1654);
		var2.world = this.field1657;
		var2.rank = this.field1656;
		var1.addMember(var2);
	}
}
