import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llv;"
	)
	@Export("HitSplatDefinition_archive")
	public static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Llv;"
	)
	public static AbstractArchive field2049;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("HitSplatDefinition_cached")
	static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("hl")
	@Export("regionLandArchiveIds")
	static int[] regionLandArchiveIds;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2001871895
	)
	@Export("fontId")
	int fontId;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 218720599
	)
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1685268435
	)
	public int field2051;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 322428637
	)
	int field2052;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1435364683
	)
	int field2048;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1740610341
	)
	int field2054;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1485190159
	)
	int field2055;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 43363931
	)
	public int field2056;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1958672999
	)
	public int field2057;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1450944369
	)
	public int field2064;
	@ObfuscatedName("y")
	String field2059;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -427333119
	)
	public int field2060;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 374547575
	)
	public int field2053;
	@ObfuscatedName("z")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1122498811
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 1552964073
	)
	@Export("transformVarp")
	int transformVarp;

	static {
		HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
		HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
	}

	HitSplatDefinition() {
		this.fontId = -1;
		this.textColor = 16777215;
		this.field2051 = 70;
		this.field2052 = -1;
		this.field2048 = -1;
		this.field2054 = -1;
		this.field2055 = -1;
		this.field2056 = 0;
		this.field2057 = 0;
		this.field2064 = -1;
		this.field2059 = "";
		this.field2060 = -1;
		this.field2053 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "-1847906835"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lqq;II)V",
		garbageValue = "-821157503"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method8028();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field2052 = var1.method8028();
		} else if (var2 == 4) {
			this.field2054 = var1.method8028();
		} else if (var2 == 5) {
			this.field2048 = var1.method8028();
		} else if (var2 == 6) {
			this.field2055 = var1.method8028();
		} else if (var2 == 7) {
			this.field2056 = var1.readShort();
		} else if (var2 == 8) {
			this.field2059 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field2051 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field2057 = var1.readShort();
		} else if (var2 == 11) {
			this.field2064 = 0;
		} else if (var2 == 12) {
			this.field2060 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field2053 = var1.readShort();
		} else if (var2 == 14) {
			this.field2064 = var1.readUnsignedShort();
		} else if (var2 == 17 || var2 == 18) {
			this.transformVarbit = var1.readUnsignedShort();
			if (this.transformVarbit == 65535) {
				this.transformVarbit = -1;
			}

			this.transformVarp = var1.readUnsignedShort();
			if (this.transformVarp == 65535) {
				this.transformVarp = -1;
			}

			int var3 = -1;
			if (var2 == 18) {
				var3 = var1.readUnsignedShort();
				if (var3 == 65535) {
					var3 = -1;
				}
			}

			int var4 = var1.readUnsignedByte();
			this.transforms = new int[var4 + 2];

			for (int var5 = 0; var5 <= var4; ++var5) {
				this.transforms[var5] = var1.readUnsignedShort();
				if (this.transforms[var5] == 65535) {
					this.transforms[var5] = -1;
				}
			}

			this.transforms[var4 + 1] = var3;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(I)Lgx;",
		garbageValue = "940413338"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = UserComparator8.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? class126.method2973(var2) : null;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "1760340181"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field2059;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + class347.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)Lqi;",
		garbageValue = "1041234730"
	)
	public SpritePixels method3754() {
		if (this.field2052 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field2052);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class114.SpriteBuffer_getSprite(field2049, this.field2052, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field2052);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(I)Lqi;",
		garbageValue = "857338442"
	)
	public SpritePixels method3755() {
		if (this.field2048 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field2048);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class114.SpriteBuffer_getSprite(field2049, this.field2048, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field2048);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(I)Lqi;",
		garbageValue = "-1623316573"
	)
	public SpritePixels method3756() {
		if (this.field2054 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field2054);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class114.SpriteBuffer_getSprite(field2049, this.field2054, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field2054);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(B)Lqi;",
		garbageValue = "-19"
	)
	public SpritePixels method3757() {
		if (this.field2055 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field2055);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class114.SpriteBuffer_getSprite(field2049, this.field2055, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field2055);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(B)Lmv;",
		garbageValue = "-102"
	)
	@Export("getFont")
	public Font getFont() {
		if (this.fontId == -1) {
			return null;
		} else {
			Font var1 = (Font)HitSplatDefinition_cachedFonts.get((long)this.fontId);
			if (var1 != null) {
				return var1;
			} else {
				var1 = class448.method8182(field2049, Username.HitSplatDefinition_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("ly")
	@ObfuscatedSignature(
		descriptor = "(Lkw;B)Lkw;",
		garbageValue = "3"
	)
	static Widget method3782(Widget var0) {
		int var1 = WorldMapSectionType.method5075(class97.getWidgetFlags(var0));
		if (var1 == 0) {
			return null;
		} else {
			for (int var2 = 0; var2 < var1; ++var2) {
				var0 = SpotAnimationDefinition.getWidget(var0.parentId);
				if (var0 == null) {
					return null;
				}
			}

			return var0;
		}
	}
}
