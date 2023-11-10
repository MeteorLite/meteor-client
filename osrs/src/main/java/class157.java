import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class157 extends class160 {
	@ObfuscatedName("an")
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("at")
	int field1400;
	@ObfuscatedName("ah")
	byte field1398;
	@ObfuscatedName("ar")
	int field1399;
	@ObfuscatedName("ao")
	String field1401;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgi;"
	)
	final class161 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgi;)V"
	)
	class157(class161 var1) {
		this.this$0 = var1;
		this.field1400 = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "1810249387"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		var1.readUnsignedByte();
		this.field1400 = var1.readUnsignedShort();
		this.field1398 = var1.readByte();
		this.field1399 = var1.readUnsignedShort();
		var1.readLong();
		this.field1401 = var1.readStringCp1252NullTerminated();
		var1.readUnsignedByte();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lgn;B)V",
		garbageValue = "-75"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		ClanChannelMember var2 = (ClanChannelMember)var1.members.get(this.field1400);
		var2.rank = this.field1398;
		var2.world = this.field1399;
		var2.username = new Username(this.field1401);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ldo;B)V",
		garbageValue = "-120"
	)
	@Export("runScriptEvent")
	public static void runScriptEvent(ScriptEvent var0) {
		class323.runScript(var0, 500000, 475000);
	}

	@ObfuscatedName("ow")
	@ObfuscatedSignature(
		descriptor = "(B)Loz;",
		garbageValue = "0"
	)
	static JagNetThread method827() {
		return WorldMapSectionType.field2038;
	}
}