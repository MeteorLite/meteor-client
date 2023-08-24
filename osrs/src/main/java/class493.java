import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.*;

@ObfuscatedName("sg")
public class class493 {
	@ObfuscatedName("ao")
	static final char[] field4077;
	@ObfuscatedName("at")
	static final char[] field4078;

	static {
		field4077 = new char[]{' ', '\u00a0', '_', '-', '\u00e0', '\u00e1', '\u00e2', '\u00e4', '\u00e3', '\u00c0', '\u00c1', '\u00c2', '\u00c4', '\u00c3', '\u00e8', '\u00e9', '\u00ea', '\u00eb', '\u00c8', '\u00c9', '\u00ca', '\u00cb', '\u00ed', '\u00ee', '\u00ef', '\u00cd', '\u00ce', '\u00cf', '\u00f2', '\u00f3', '\u00f4', '\u00f6', '\u00f5', '\u00d2', '\u00d3', '\u00d4', '\u00d6', '\u00d5', '\u00f9', '\u00fa', '\u00fb', '\u00fc', '\u00d9', '\u00da', '\u00db', '\u00dc', '\u00e7', '\u00c7', '\u00ff', '\u0178', '\u00f1', '\u00d1', '\u00df'};
		field4078 = new char[]{'[', ']', '#'};
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
		garbageValue = "1089015752"
	)
	static String method2465(Throwable var0) throws IOException {
		String var1;
		if (var0 instanceof RunException) {
			RunException var2 = (RunException)var0;
			var1 = var2.field4291 + " | ";
			var0 = var2.parent;
		} else {
			var1 = "";
		}

		StringWriter var12 = new StringWriter();
		PrintWriter var3 = new PrintWriter(var12);
		var0.printStackTrace(var3);
		var3.close();
		String var4 = var12.toString();
		BufferedReader var5 = new BufferedReader(new StringReader(var4));
		String var6 = var5.readLine();

		while (true) {
			while (true) {
				String var7 = var5.readLine();
				if (var7 == null) {
					var1 = var1 + "| " + var6;
					return var1;
				}

				int var8 = var7.indexOf(40);
				int var9 = var7.indexOf(41, var8 + 1);
				if (var8 >= 0 && var9 >= 0) {
					String var10 = var7.substring(var8 + 1, var9);
					int var11 = var10.indexOf(".java:");
					if (var11 >= 0) {
						var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
						var1 = var1 + var10 + ' ';
						continue;
					}

					var7 = var7.substring(0, var8);
				}

				var7 = var7.trim();
				var7 = var7.substring(var7.lastIndexOf(32) + 1);
				var7 = var7.substring(var7.lastIndexOf(9) + 1);
				var1 = var1 + var7 + ' ';
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)Luk;",
		garbageValue = "-94"
	)
	public static IndexedSprite method2466() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = class529.SpriteBuffer_spriteWidth;
		var0.height = class420.SpriteBuffer_spriteHeight;
		var0.xOffset = class529.SpriteBuffer_xOffsets[0];
		var0.yOffset = class152.SpriteBuffer_yOffsets[0];
		var0.subWidth = HealthBarUpdate.SpriteBuffer_spriteWidths[0];
		var0.subHeight = SpriteMask.SpriteBuffer_spriteHeights[0];
		var0.palette = DbTableType.SpriteBuffer_spritePalette;
		var0.pixels = Coord.SpriteBuffer_pixels[0];
		class529.SpriteBuffer_xOffsets = null;
		class152.SpriteBuffer_yOffsets = null;
		HealthBarUpdate.SpriteBuffer_spriteWidths = null;
		SpriteMask.SpriteBuffer_spriteHeights = null;
		DbTableType.SpriteBuffer_spritePalette = null;
		Coord.SpriteBuffer_pixels = null;
		return var0;
	}
}