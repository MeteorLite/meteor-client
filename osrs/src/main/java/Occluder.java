import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Occluder")
public final class Occluder {
	@ObfuscatedName("nc")
	@Export("menuHeight")
	static int menuHeight;
	@ObfuscatedName("au")
	@Export("minTileX")
	int minTileX;
	@ObfuscatedName("ae")
	@Export("maxTileX")
	int maxTileX;
	@ObfuscatedName("ao")
	@Export("minTileY")
	int minTileY;
	@ObfuscatedName("at")
	@Export("maxTileY")
	int maxTileY;
	@ObfuscatedName("ac")
	@Export("type")
	int type;
	@ObfuscatedName("ai")
	@Export("minX")
	int minX;
	@ObfuscatedName("az")
	@Export("maxX")
	int maxX;
	@ObfuscatedName("ap")
	@Export("minZ")
	int minZ;
	@ObfuscatedName("aa")
	@Export("maxZ")
	int maxZ;
	@ObfuscatedName("af")
	@Export("minY")
	int minY;
	@ObfuscatedName("ad")
	@Export("maxY")
	int maxY;
	@ObfuscatedName("aq")
	int field2137;
	@ObfuscatedName("al")
	int field2132;
	@ObfuscatedName("an")
	int field2134;
	@ObfuscatedName("ar")
	int field2138;
	@ObfuscatedName("ab")
	int field2125;
	@ObfuscatedName("ag")
	int field2130;
	@ObfuscatedName("am")
	int field2133;

	Occluder() {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IIIZIZI)V",
		garbageValue = "124948705"
	)
	@Export("doWorldSorting")
	static void doWorldSorting(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
		if (var0 < var1) {
			int var6 = (var0 + var1) / 2;
			int var7 = var0;
			World var8 = class176.World_worlds[var6];
			class176.World_worlds[var6] = class176.World_worlds[var1];
			class176.World_worlds[var1] = var8;

			for (int var9 = var0; var9 < var1; ++var9) {
				if (HealthBarUpdate.method525(class176.World_worlds[var9], var8, var2, var3, var4, var5) <= 0) {
					World var10 = class176.World_worlds[var9];
					class176.World_worlds[var9] = class176.World_worlds[var7];
					class176.World_worlds[var7++] = var10;
				}
			}

			class176.World_worlds[var1] = class176.World_worlds[var7];
			class176.World_worlds[var7] = var8;
			doWorldSorting(var0, var7 - 1, var2, var3, var4, var5);
			doWorldSorting(var7 + 1, var1, var2, var3, var4, var5);
		}

	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		descriptor = "(Ldf;I)Z",
		garbageValue = "-1141977008"
	)
	static boolean method1299(Player var0) {
		if (Client.drawPlayerNames == 0) {
			return false;
		} else {
			boolean var1;
			if (VarbitComposition.localPlayer == var0) {
				var1 = (Client.drawPlayerNames & 8) != 0;
				return var1;
			} else {
				var1 = UserComparator6.method695();
				if (!var1) {
					boolean var2 = (Client.drawPlayerNames & 1) != 0;
					var1 = var2 && var0.isFriend();
				}

				return var1 || UrlRequester.method655() && var0.isFriendsChatMember();
			}
		}
	}
}