import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nt")
public class class344 {
	@ObfuscatedName("ui")
	@Export("cameraMoveToSpeed")
	static int cameraMoveToSpeed;

	static {
		Math.sqrt(8192.0D);
	}

	@ObfuscatedName("oi")
	@ObfuscatedSignature(
		descriptor = "(II)Ltx;",
		garbageValue = "2122507406"
	)
	static class506 method1868(int var0) {
		class506 var1 = (class506)Client.Widget_cachedModels.get((long)var0);
		if (var1 == null) {
			var1 = new class506(class343.field3148, UserComparator3.method682(var0), NewShit.method979(var0));
			Client.Widget_cachedModels.put(var1, (long)var0);
		}

		return var1;
	}
}