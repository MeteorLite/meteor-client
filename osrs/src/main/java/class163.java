import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class163 extends class144 {
	@ObfuscatedName("at")
	int field1412;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class163(class147 var1) {
		this.this$0 = var1;
		this.field1412 = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1412 = var1.readUnsignedShort();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method811(this.field1412);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-114"
	)
	static final void method849() {
		WorldMapArea.method1213("You can't add yourself to your own friend list");
	}

	@ObfuscatedName("mx")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "2130928035"
	)
	static boolean method852(int var0) {
		for (int var1 = 0; var1 < Client.field530; ++var1) {
			if (Client.field577[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}