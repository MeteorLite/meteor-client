import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
@Implements("ZoneOperation")
public class ZoneOperation {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	@Export("LOC_ANIM")
	public static final ZoneOperation LOC_ANIM;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	public static final ZoneOperation field2616;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	public static final ZoneOperation field2620;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	public static final ZoneOperation field2618;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	@Export("OBJ_DEL")
	public static final ZoneOperation OBJ_DEL;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	public static final ZoneOperation field2622;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	@Export("LOC_DEL")
	public static final ZoneOperation LOC_DEL;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	@Export("LOC_ADD_CHANGE")
	public static final ZoneOperation LOC_ADD_CHANGE;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	@Export("AREA_SOUND")
	public static final ZoneOperation AREA_SOUND;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	public static final ZoneOperation field2625;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	@Export("OBJ_COUNT")
	public static final ZoneOperation OBJ_COUNT;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	@Export("MAPPROJ_ANIM")
	public static final ZoneOperation MAPPROJ_ANIM;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	@Export("PREFETCH_GAMEOBJECTS")
	public static final ZoneOperation PREFETCH_GAMEOBJECTS;

	static {
		LOC_ANIM = new ZoneOperation(4);
		field2616 = new ZoneOperation(5);
		field2620 = new ZoneOperation(20);
		field2618 = new ZoneOperation(4);
		OBJ_DEL = new ZoneOperation(16);
		field2622 = new ZoneOperation(6);
		LOC_DEL = new ZoneOperation(14);
		LOC_ADD_CHANGE = new ZoneOperation(14);
		AREA_SOUND = new ZoneOperation(5);
		field2625 = new ZoneOperation(7);
		OBJ_COUNT = new ZoneOperation(19);
		MAPPROJ_ANIM = new ZoneOperation(11);
		PREFETCH_GAMEOBJECTS = new ZoneOperation(2);
	}

	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "4"
	)
	ZoneOperation(int var1) {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(ILuj;I)Lgx;",
		garbageValue = "-485620123"
	)
	public static ObjTypeCustomisation method1631(int var0, Buffer var1) {
		int var2 = var1.readUnsignedByte();
		boolean var3 = (var2 & 1) != 0;
		boolean var4 = (var2 & 2) != 0;
		ObjTypeCustomisation var5 = new ObjTypeCustomisation(var0);
		int var6;
		int[] var7;
		boolean var8;
		int var9;
		short var10;
		if (var3) {
			var6 = var1.readUnsignedByte();
			var7 = new int[]{var6 & 15, var6 >> 4 & 15};
			var8 = var5.recol != null && var7.length == var5.recol.length;

			for (var9 = 0; var9 < 2; ++var9) {
				if (var7[var9] != 15) {
					var10 = (short)var1.readUnsignedShort();
					if (var8) {
						var5.recol[var7[var9]] = var10;
					}
				}
			}
		}

		if (var4) {
			var6 = var1.readUnsignedByte();
			var7 = new int[]{var6 & 15, var6 >> 4 & 15};
			var8 = var5.retex != null && var7.length == var5.retex.length;

			for (var9 = 0; var9 < 2; ++var9) {
				if (var7[var9] != 15) {
					var10 = (short)var1.readUnsignedShort();
					if (var8) {
						var5.retex[var7[var9]] = var10;
					}
				}
			}
		}

		return var5;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "744218081"
	)
	public static void method1632(int var0, int var1) {
		VarbitComposition var2 = ClientPreferences.getWidget(var0);
		int var3 = var2.baseVar;
		int var4 = var2.startBit;
		int var5 = var2.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		if (var1 < 0 || var1 > var6) {
			var1 = 0;
		}

		var6 <<= var4;
		Varps.Varps_main[var3] = Varps.Varps_main[var3] & ~var6 | var1 << var4 & var6;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-373898981"
	)
	public static int method1630(int var0) {
		return var0 >>> 4 & class520.field4147;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(Lnn;IIS)V",
		garbageValue = "-21324"
	)
	public static void method1633(Widget var0, int var1, int var2) {
		var0.field3125.bodyColors[var1] = var2;
		var0.field3125.method1756();
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "56799465"
	)
	static final int method1634() {
		if (WorldMapIcon_1.clientPreferences.getRoofsHidden()) {
			return ItemLayer.Client_plane;
		} else {
			int var0 = 3;
			if (Varcs.cameraPitch < 310) {
				int var1;
				int var2;
				if (Client.oculusOrbState == 1) {
					var1 = LoginScreenAnimation.oculusOrbFocalPointX >> 7;
					var2 = ScriptFrame.oculusOrbFocalPointY >> 7;
				} else {
					var1 = class229.localPlayer.x >> 7;
					var2 = class229.localPlayer.y >> 7;
				}

				int var3 = ViewportMouse.cameraX >> 7;
				int var4 = class36.cameraZ >> 7;
				if (var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
					return ItemLayer.Client_plane;
				}

				if (var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
					return ItemLayer.Client_plane;
				}

				if ((Tiles.Tiles_renderFlags[ItemLayer.Client_plane][var3][var4] & 4) != 0) {
					var0 = ItemLayer.Client_plane;
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

						if ((Tiles.Tiles_renderFlags[ItemLayer.Client_plane][var3][var4] & 4) != 0) {
							var0 = ItemLayer.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var4 < var2) {
								++var4;
							} else if (var4 > var2) {
								--var4;
							}

							if ((Tiles.Tiles_renderFlags[ItemLayer.Client_plane][var3][var4] & 4) != 0) {
								var0 = ItemLayer.Client_plane;
							}
						}
					}
				} else if (var6 > 0) {
					var7 = var5 * 65536 / var6;
					var8 = 32768;

					while (var2 != var4) {
						if (var4 < var2) {
							++var4;
						} else if (var4 > var2) {
							--var4;
						}

						if ((Tiles.Tiles_renderFlags[ItemLayer.Client_plane][var3][var4] & 4) != 0) {
							var0 = ItemLayer.Client_plane;
						}

						var8 += var7;
						if (var8 >= 65536) {
							var8 -= 65536;
							if (var3 < var1) {
								++var3;
							} else if (var3 > var1) {
								--var3;
							}

							if ((Tiles.Tiles_renderFlags[ItemLayer.Client_plane][var3][var4] & 4) != 0) {
								var0 = ItemLayer.Client_plane;
							}
						}
					}
				}
			}

			if (class229.localPlayer.x >= 0 && class229.localPlayer.y >= 0 && class229.localPlayer.x < 13312 && class229.localPlayer.y < 13312) {
				if ((Tiles.Tiles_renderFlags[ItemLayer.Client_plane][class229.localPlayer.x >> 7][class229.localPlayer.y >> 7] & 4) != 0) {
					var0 = ItemLayer.Client_plane;
				}

				return var0;
			} else {
				return ItemLayer.Client_plane;
			}
		}
	}
}