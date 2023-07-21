import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
public class class271 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lkx;"
	)
	static final class271 field2429;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lkx;"
	)
	static final class271 field2430;
	@ObfuscatedName("ar")
	final int field2431;

	static {
		field2429 = new class271(0);
		field2430 = new class271(1);
	}

	class271(int var1) {
		this.field2431 = var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "25"
	)
	static final int method1502(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}
}
