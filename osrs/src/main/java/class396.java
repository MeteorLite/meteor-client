import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pp")
public class class396 {
	@ObfuscatedName("at")
	@Export("cp1252AsciiExtension")
	static final char[] cp1252AsciiExtension;
	@ObfuscatedName("al")
	@Export("SpriteBuffer_pixels")
	public static byte[][] SpriteBuffer_pixels;
	@ObfuscatedName("rs")
	@ObfuscatedSignature(
		descriptor = "Lis;"
	)
	@Export("mouseWheel")
	static class212 mouseWheel;

	static {
		cp1252AsciiExtension = new char[]{'\u20ac', '\u0000', '\u201a', '\u0192', '\u201e', '\u2026', '\u2020', '\u2021', '\u02c6', '\u2030', '\u0160', '\u2039', '\u0152', '\u0000', '\u017d', '\u0000', '\u0000', '\u2018', '\u2019', '\u201c', '\u201d', '\u2022', '\u2013', '\u2014', '\u02dc', '\u2122', '\u0161', '\u203a', '\u0153', '\u0000', '\u017e', '\u0178'};
	}

	@ObfuscatedName("mw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1031282913"
	)
	static void method2042() {
		for (InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (HealthBarDefinition.widgetDefinition.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = HealthBarDefinition.widgetDefinition.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int)var0.key;
					Widget var5 = HealthBarDefinition.widgetDefinition.method1733(var4);
					if (var5 != null) {
						class159.invalidateWidget(var5);
					}
				}
			}
		}

	}
}