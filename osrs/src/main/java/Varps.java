import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mz")
@Implements("Varps")
public class Varps {
	@ObfuscatedName("au")
	@Export("Varps_masks")
	static int[] Varps_masks;
	@ObfuscatedName("ae")
	@Export("Varps_temp")
	public static int[] Varps_temp;
	@ObfuscatedName("ao")
	@Export("Varps_main")
	public static int[] Varps_main;
	@ObfuscatedName("at")
	@Export("Interpreter_intLocals")
	static int[] Interpreter_intLocals;

	static {
		Varps_masks = new int[32];
		int var0 = 2;

		for (int var1 = 0; var1 < 32; ++var1) {
			Varps_masks[var1] = var0 - 1;
			var0 += var0;
		}

		Varps_temp = new int[4000];
		Varps_main = new int[4000];
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Ldl;",
		garbageValue = "-195730682"
	)
	static class89[] method1708() {
		return new class89[]{class89.field881, class89.field883, class89.field882, class89.field880, class89.field884};
	}
}