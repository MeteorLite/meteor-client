import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
public class class212 extends DualNode {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	static EvictingDualNodeHashTable field1679;

	static {
		field1679 = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("nf")
	@ObfuscatedSignature(
		descriptor = "(Lnm;I)Lnm;",
		garbageValue = "-1852354008"
	)
	static Widget method1045(Widget var0) {
		int var2 = MouseRecorder.getWidgetFlags(var0);
		int var1 = var2 >> 17 & 7;
		int var3 = var1;
		if (var1 == 0) {
			return null;
		} else {
			for (int var4 = 0; var4 < var3; ++var4) {
				var0 = class33.field89.method1740(var0.parentId);
				if (var0 == null) {
					return null;
				}
			}

			return var0;
		}
	}
}