import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class149 extends class145 {
	@ObfuscatedName("ac")
	int field1337;
	@ObfuscatedName("al")
	byte field1336;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lff;"
	)
	final class148 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lff;)V"
	)
	class149(class148 var1) {
		this.this$0 = var1;
		this.field1337 = -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "-11659242"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1337 = var1.readUnsignedShort();
		this.field1336 = var1.readByte();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lgi;I)V",
		garbageValue = "21847466"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method822(this.field1337, this.field1336);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(BI)C",
		garbageValue = "-1818830164"
	)
	public static char method782(byte var0) {
		int var1 = var0 & 255;
		if (var1 == 0) {
			throw new IllegalArgumentException("" + Integer.toString(var1, 16));
		} else {
			if (var1 >= 128 && var1 < 160) {
				char var2 = class399.cp1252AsciiExtension[var1 - 128];
				if (var2 == 0) {
					var2 = '?';
				}

				var1 = var2;
			}

			return (char)var1;
		}
	}
}