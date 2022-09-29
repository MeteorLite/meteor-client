import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oj")
public class class403 {
	@ObfuscatedName("k")
	static final int[] field4482;
	@ObfuscatedName("w")
	static final int[] field4486;

	static {
		field4482 = new int[16384];
		field4486 = new int[16384];
		double var0 = 3.834951969714103E-4D;

		for (int var2 = 0; var2 < 16384; ++var2) {
			field4482[var2] = (int)(16384.0D * Math.sin(var0 * (double)var2));
			field4486[var2] = (int)(16384.0D * Math.cos((double)var2 * var0));
		}

	}

	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		descriptor = "(Lkw;I)V",
		garbageValue = "2002811679"
	)
	@Export("invalidateWidget")
	static void invalidateWidget(Widget var0) {
		if (var0 != null && var0.cycle == Client.field713) {
			Client.field714[var0.rootIndex] = true;
		}

	}
}
