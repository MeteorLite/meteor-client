import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("FloorOverlayDefinition")
public class FloorOverlayDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llv;"
	)
	@Export("FloorOverlayDefinition_archive")
	public static AbstractArchive FloorOverlayDefinition_archive;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("FloorOverlayDefinition_cached")
	public static EvictingDualNodeHashTable FloorOverlayDefinition_cached;
	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		descriptor = "Lpe;"
	)
	@Export("WorldMapElement_fonts")
	static Fonts WorldMapElement_fonts;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -513383363
	)
	@Export("primaryRgb")
	public int primaryRgb;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1475480229
	)
	@Export("texture")
	public int texture;
	@ObfuscatedName("k")
	@Export("hideUnderlay")
	public boolean hideUnderlay;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 2030186885
	)
	@Export("secondaryRgb")
	public int secondaryRgb;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1770337771
	)
	@Export("hue")
	public int hue;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1122902615
	)
	@Export("saturation")
	public int saturation;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2142098127
	)
	@Export("lightness")
	public int lightness;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1651171061
	)
	@Export("secondaryHue")
	public int secondaryHue;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1008787805
	)
	@Export("secondarySaturation")
	public int secondarySaturation;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1117781413
	)
	@Export("secondaryLightness")
	public int secondaryLightness;

	static {
		FloorOverlayDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	public FloorOverlayDefinition() {
		this.primaryRgb = 0;
		this.texture = -1;
		this.hideUnderlay = true;
		this.secondaryRgb = -1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2130558716"
	)
	@Export("postDecode")
	public void postDecode() {
		if (this.secondaryRgb != -1) {
			this.setHsl(this.secondaryRgb);
			this.secondaryHue = this.hue;
			this.secondarySaturation = this.saturation;
			this.secondaryLightness = this.lightness;
		}

		this.setHsl(this.primaryRgb);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lqq;II)V",
		garbageValue = "-1223843884"
	)
	@Export("decode")
	public void decode(Buffer var1, int var2) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.decodeNext(var1, var3, var2);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Lqq;IIB)V",
		garbageValue = "81"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2, int var3) {
		if (var2 == 1) {
			this.primaryRgb = var1.readMedium();
		} else if (var2 == 2) {
			this.texture = var1.readUnsignedByte();
		} else if (var2 == 5) {
			this.hideUnderlay = false;
		} else if (var2 == 7) {
			this.secondaryRgb = var1.readMedium();
		} else if (var2 == 8) {
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-601790577"
	)
	@Export("setHsl")
	void setHsl(int var1) {
		double var2 = (double)(var1 >> 16 & 255) / 256.0D;
		double var4 = (double)(var1 >> 8 & 255) / 256.0D;
		double var6 = (double)(var1 & 255) / 256.0D;
		double var8 = var2;
		if (var4 < var2) {
			var8 = var4;
		}

		if (var6 < var8) {
			var8 = var6;
		}

		double var10 = var2;
		if (var4 > var2) {
			var10 = var4;
		}

		if (var6 > var10) {
			var10 = var6;
		}

		double var12 = 0.0D;
		double var14 = 0.0D;
		double var16 = (var10 + var8) / 2.0D;
		if (var8 != var10) {
			if (var16 < 0.5D) {
				var14 = (var10 - var8) / (var8 + var10);
			}

			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var10 == var2) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var4 == var10) {
				var12 = (var6 - var2) / (var10 - var8) + 2.0D;
			} else if (var10 == var6) {
				var12 = 4.0D + (var2 - var4) / (var10 - var8);
			}
		}

		var12 /= 6.0D;
		this.hue = (int)(var12 * 256.0D);
		this.saturation = (int)(var14 * 256.0D);
		this.lightness = (int)(256.0D * var16);
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}

		if (this.lightness < 0) {
			this.lightness = 0;
		} else if (this.lightness > 255) {
			this.lightness = 255;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "878298994"
	)
	static void method3912(int var0) {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1358201950"
	)
	@Export("loadInterface")
	public static boolean loadInterface(int var0) {
		if (class83.Widget_loadedInterfaces[var0]) {
			return true;
		} else if (!MouseHandler.Widget_archive.tryLoadGroup(var0)) {
			return false;
		} else {
			int var1 = MouseHandler.Widget_archive.getGroupFileCount(var0);
			if (var1 == 0) {
				class83.Widget_loadedInterfaces[var0] = true;
				return true;
			} else {
				if (Calendar.Widget_interfaceComponents[var0] == null) {
					Calendar.Widget_interfaceComponents[var0] = new Widget[var1];
				}

				for (int var2 = 0; var2 < var1; ++var2) {
					if (Calendar.Widget_interfaceComponents[var0][var2] == null) {
						byte[] var3 = MouseHandler.Widget_archive.takeFile(var0, var2);
						if (var3 != null) {
							Calendar.Widget_interfaceComponents[var0][var2] = new Widget();
							Calendar.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
							if (var3[0] == -1) {
								Calendar.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								Calendar.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
							}
						}
					}
				}

				class83.Widget_loadedInterfaces[var0] = true;
				return true;
			}
		}
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "999765437"
	)
	@Export("addCancelMenuEntry")
	static void addCancelMenuEntry() {
		AbstractWorldMapIcon.method5183();
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
