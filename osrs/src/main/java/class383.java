import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oi")
public final class class383 {
	@ObfuscatedName("oc")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1663230842"
	)
	static void method2021() {
		if (class390.field3656 != null) {
			Client.field369 = Client.cycle;
			class390.field3656.method1964();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					class390.field3656.method1963((Client.players[var0].x >> 7) + UrlRequester.baseX, (Client.players[var0].y >> 7) + class47.baseY);
				}
			}
		}

	}
}