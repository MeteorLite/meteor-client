import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ln")
public class class300 {
	@ObfuscatedName("ax")
	static int field2730;
	@ObfuscatedName("qu")
	static int field2731;

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1871273953"
	)
	@Export("changeWorldSelectSorting")
	static void changeWorldSelectSorting(int var0, int var1) {
		int[] var2 = new int[4];
		int[] var3 = new int[4];
		var2[0] = var0;
		var3[0] = var1;
		int var4 = 1;

		for (int var5 = 0; var5 < 4; ++var5) {
			if (World.World_sortOption1[var5] != var0) {
				var2[var4] = World.World_sortOption1[var5];
				var3[var4] = World.World_sortOption2[var5];
				++var4;
			}
		}

		World.World_sortOption1 = var2;
		World.World_sortOption2 = var3;
		VarbitComposition.sortWorlds(class387.World_worlds, 0, class387.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
	}
}
