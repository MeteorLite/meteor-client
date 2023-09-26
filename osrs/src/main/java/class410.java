import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pb")
public class class410 {
	@ObfuscatedName("ac")
	int field3711;

	@ObfuscatedSignature(
		descriptor = "(IZ)V",
		garbageValue = "1"
	)
	class410(int var1, boolean var2) {
		this.field3711 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-15695"
	)
	public int method2107() {
		return this.field3711;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "-1656605881"
	)
	static final boolean method2108(char var0) {
		if (Character.isISOControl(var0)) {
			return false;
		} else if (Decimator.isAlphaNumeric(var0)) {
			return true;
		} else {
			char[] var1 = class508.field4108;

			int var2;
			char var3;
			for (var2 = 0; var2 < var1.length; ++var2) {
				var3 = var1[var2];
				if (var0 == var3) {
					return true;
				}
			}

			var1 = class508.field4109;

			for (var2 = 0; var2 < var1.length; ++var2) {
				var3 = var1[var2];
				if (var0 == var3) {
					return true;
				}
			}

			return false;
		}
	}

	@ObfuscatedName("lz")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIII)V",
		garbageValue = "-1849908879"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (class33.field89.method1742(var0)) {
			class9.field16 = null;
			Tile.drawInterface(class33.field89.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (class9.field16 != null) {
				Tile.drawInterface(class9.field16, -1412584499, var1, var2, var3, var4, GrandExchangeEvent.field3617, class10.field24, var7);
				class9.field16 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field408[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field408[var8] = true;
				}
			}

		}
	}
}