import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class141 extends class144 {
	@ObfuscatedName("at")
	int field1333;
	@ObfuscatedName("ah")
	int field1330;
	@ObfuscatedName("ar")
	int field1332;
	@ObfuscatedName("ao")
	int field1331;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class141(class147 var1) {
		this.this$0 = var1;
		this.field1333 = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1333 = var1.readUnsignedShort();
		this.field1330 = var1.readInt();
		this.field1332 = var1.readUnsignedByte();
		this.field1331 = var1.readUnsignedByte();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method813(this.field1333, this.field1330, this.field1332, this.field1331);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lgr;",
		garbageValue = "931002418"
	)
	@Export("WorldMapElement_get")
	public static WorldMapElement WorldMapElement_get(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length && WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "-6"
	)
	static final boolean method755(int var0, int var1) {
		ObjectComposition var2 = WorldMapSection2.getObjectDefinition(var0);
		if (var1 == 11) {
			var1 = 10;
		}

		if (var1 >= 5 && var1 <= 8) {
			var1 = 4;
		}

		return var2.method1003(var1);
	}
}