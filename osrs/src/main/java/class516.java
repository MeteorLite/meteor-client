import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tj")
public final class class516 {
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "6525"
	)
	public static boolean method2513() {
		boolean var0 = false;
		boolean var1 = false;
		if (!class316.field2798.isEmpty()) {
			SongTask var2 = (SongTask)class316.field2798.get(0);
			if (var2 == null) {
				class316.field2798.remove(0);
			} else if (var2.vmethod2142()) {
				if (var2.method2156()) {
					System.out.println("Error in midimanager.service: " + var2.method2158());
					var0 = true;
				} else {
					if (var2.method2159() != null) {
						class316.field2798.add(1, var2.method2159());
					}

					var1 = var2.method2157();
				}

				class316.field2798.remove(0);
			} else {
				var1 = var2.method2157();
			}
		}

		if (var0) {
			class316.field2798.clear();
			SecureRandomCallable.method457();
		}

		return var1;
	}
}