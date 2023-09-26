import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("op")
public class class379 {
	@ObfuscatedName("az")
	@Export("loginBoxCenter")
	static int loginBoxCenter;

	@ObfuscatedName("ng")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-960191990"
	)
	static void method1983(int var0) {
		for (IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
			if ((long)var0 == (var1.key >> 48 & 65535L)) {
				var1.remove();
			}
		}

	}
}