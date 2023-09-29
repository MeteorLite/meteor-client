import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class157 extends class161 {
	@ObfuscatedName("kb")
	@ObfuscatedSignature(
		descriptor = "[Lud;"
	)
	@Export("headIconPrayerSprites")
	static SpritePixels[] headIconPrayerSprites;
	@ObfuscatedName("ac")
	String field1386;
	@ObfuscatedName("al")
	int field1385;
	@ObfuscatedName("ak")
	byte field1384;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgf;"
	)
	final class162 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgf;)V"
	)
	class157(class162 var1) {
		this.this$0 = var1;
		this.field1386 = null;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;B)V",
		garbageValue = "0"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			var1.readLong();
		}

		this.field1386 = var1.readStringCp1252NullTerminatedOrNull();
		this.field1385 = var1.readUnsignedShort();
		this.field1384 = var1.readByte();
		var1.readLong();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lgb;B)V",
		garbageValue = "0"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = new ClanChannelMember();
		var2.username = new Username(this.field1386);
		var2.world = this.field1385;
		var2.rank = this.field1384;
		var1.addMember(var2);
	}
}