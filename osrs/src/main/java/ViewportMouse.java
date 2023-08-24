import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("au")
	@Export("ViewportMouse_isInViewport")
	static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("ae")
	@Export("ViewportMouse_x")
	static int ViewportMouse_x;
	@ObfuscatedName("ao")
	@Export("ViewportMouse_y")
	static int ViewportMouse_y;
	@ObfuscatedName("at")
	@Export("ViewportMouse_false0")
	static boolean ViewportMouse_false0;
	@ObfuscatedName("ac")
	static int field2249;
	@ObfuscatedName("ai")
	static int field2252;
	@ObfuscatedName("az")
	static int field2254;
	@ObfuscatedName("aa")
	static int field2248;
	@ObfuscatedName("ad")
	static int field2250;
	@ObfuscatedName("an")
	@Export("ViewportMouse_entityCount")
	public static int ViewportMouse_entityCount;
	@ObfuscatedName("ar")
	@Export("ViewportMouse_entityTags")
	public static long[] ViewportMouse_entityTags;

	static {
		ViewportMouse_isInViewport = false;
		ViewportMouse_x = 0;
		ViewportMouse_y = 0;
		ViewportMouse_false0 = false;
		ViewportMouse_entityCount = 0;
		ViewportMouse_entityTags = new long[1000];
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(BI)C",
		garbageValue = "-1224781915"
	)
	public static char method1348(byte var0) {
		int var1 = var0 & 255;
		if (var1 == 0) {
			throw new IllegalArgumentException("" + Integer.toString(var1, 16));
		} else {
			if (var1 >= 128 && var1 < 160) {
				char var2 = class384.cp1252AsciiExtension[var1 - 128];
				if (var2 == 0) {
					var2 = '?';
				}

				var1 = var2;
			}

			return (char)var1;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "759776126"
	)
	static int method1349(int var0, int var1, int var2) {
		if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 8) != 0) {
			return 0;
		} else {
			return var0 > 0 && (Tiles.Tiles_renderFlags[1][var1][var2] & 2) != 0 ? var0 - 1 : var0;
		}
	}
}