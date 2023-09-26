import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("kp")
public class class275 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;I)V",
		garbageValue = "-770626975"
	)
	public static void method1537(AbstractArchive var0) {
		EnumComposition.EnumDefinition_archive = var0;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/ArrayList;IIIII)V",
		garbageValue = "459181923"
	)
	public static void method1538(ArrayList var0, int var1, int var2, int var3, int var4) {
		class319.field2789.clear();
		class319.field2789.addAll(var0);
		MouseHandler.method177(var1, var2, var3, var4);
	}

	@ObfuscatedName("mv")
	@ObfuscatedSignature(
		descriptor = "(Lnm;I)Lnm;",
		garbageValue = "1424851041"
	)
	static Widget method1539(Widget var0) {
		Widget var1 = class212.method1045(var0);
		if (var1 == null) {
			var1 = var0.parent;
		}

		return var1;
	}
}