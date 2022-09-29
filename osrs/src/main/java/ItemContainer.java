import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("ItemContainer")
public class ItemContainer extends Node {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("itemContainers")
	static NodeHashTable itemContainers;
	@ObfuscatedName("g")
	@Export("formattedOperatingSystemName")
	public static String formattedOperatingSystemName;
	@ObfuscatedName("p")
	@Export("ids")
	int[] ids;
	@ObfuscatedName("f")
	@Export("quantities")
	int[] quantities;

	static {
		itemContainers = new NodeHashTable(32);
	}

	ItemContainer() {
		this.ids = new int[]{-1};
		this.quantities = new int[]{0};
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1170860570"
	)
	static int method2230(int var0, int var1) {
		for (int var2 = 0; var2 < 8; ++var2) {
			if (var1 <= var0 + 30) {
				return var2;
			}

			var0 += 30;
			var0 += var2 != 1 && var2 != 3 ? 5 : 20;
		}

		return 0;
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1134132490"
	)
	static final int method2233() {
		if (Player.clientPreferences.method2452()) {
			return Tiles.Client_plane;
		} else {
			int var0 = 3;
			if (class163.cameraPitch < 310) {
				int var1;
				int var2;
				if (Client.oculusOrbState == 1) {
					var1 = class147.oculusOrbFocalPointX >> 7;
					var2 = Language.oculusOrbFocalPointY >> 7;
				} else {
					var1 = class67.localPlayer.x >> 7;
					var2 = class67.localPlayer.y >> 7;
				}

				int var3 = TaskHandler.cameraX >> 7;
				int var4 = ApproximateRouteStrategy.cameraZ >> 7;
				if (var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
					return Tiles.Client_plane;
				}

				if (var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
					return Tiles.Client_plane;
				}

				if ((Tiles.Tiles_renderFlags[Tiles.Client_plane][var3][var4] & 4) != 0) {
					var0 = Tiles.Client_plane;
				}

				int var5;
				if (var1 > var3) {
					var5 = var1 - var3;
				} else {
					var5 = var3 - var1;
				}

				int var6;
				if (var2 > var4) {
					var6 = var2 - var4;
				} else {
					var6 = var4 - var2;
				}

				int var7;
				int var8;
				if (var5 > var6) {
					var7 = var6 * 65536 / var5;
					var8 = 32768;

					while (var1 != var3) {
						if (var3 < var1) {
							++var3;
						} else if (var3 > var1) {
							--var3;
						}

						if ((Tiles.Tiles_renderFlags[Tiles.Client_plane][var3][var4] & 4) != 0) {
							var0 = Tiles.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var4 < var2) {
								++var4;
							} else if (var4 > var2) {
								--var4;
							}

							if ((Tiles.Tiles_renderFlags[Tiles.Client_plane][var3][var4] & 4) != 0) {
								var0 = Tiles.Client_plane;
							}
						}
					}
				} else if (var6 > 0) {
					var7 = var5 * 65536 / var6;
					var8 = 32768;

					while (var4 != var2) {
						if (var4 < var2) {
							++var4;
						} else if (var4 > var2) {
							--var4;
						}

						if ((Tiles.Tiles_renderFlags[Tiles.Client_plane][var3][var4] & 4) != 0) {
							var0 = Tiles.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var3 < var1) {
								++var3;
							} else if (var3 > var1) {
								--var3;
							}

							if ((Tiles.Tiles_renderFlags[Tiles.Client_plane][var3][var4] & 4) != 0) {
								var0 = Tiles.Client_plane;
							}
						}
					}
				}
			}

			if (class67.localPlayer.x >= 0 && class67.localPlayer.y >= 0 && class67.localPlayer.x < 13312 && class67.localPlayer.y < 13312) {
				if ((Tiles.Tiles_renderFlags[Tiles.Client_plane][class67.localPlayer.x >> 7][class67.localPlayer.y >> 7] & 4) != 0) {
					var0 = Tiles.Client_plane;
				}

				return var0;
			} else {
				return Tiles.Client_plane;
			}
		}
	}
}
