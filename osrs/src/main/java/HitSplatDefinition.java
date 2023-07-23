import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	@Export("HitSplatDefinition_archive")
	public static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	@Export("HitSplatDefinition_fontsArchive")
	public static AbstractArchive HitSplatDefinition_fontsArchive;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("HitSplatDefinition_cached")
	public static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	public static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("at")
	@Export("fontId")
	int fontId;
	@ObfuscatedName("ah")
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("ax")
	public int field1687;
	@ObfuscatedName("aa")
	int field1673;
	@ObfuscatedName("au")
	int field1678;
	@ObfuscatedName("ae")
	int field1675;
	@ObfuscatedName("ab")
	int field1674;
	@ObfuscatedName("ad")
	public int field1682;
	@ObfuscatedName("ao")
	public int field1686;
	@ObfuscatedName("ac")
	public int field1681;
	@ObfuscatedName("ak")
	String field1680;
	@ObfuscatedName("an")
	public int field1685;
	@ObfuscatedName("af")
	public int field1683;
	@ObfuscatedName("ai")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("al")
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("bd")
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
		this.field1687 = 70;
		this.field1673 = -1;
		this.field1678 = -1;
		this.field1675 = -1;
		this.field1674 = -1;
		this.field1682 = 0;
		this.field1686 = 0;
		this.field1681 = -1;
		this.field1680 = "";
		this.field1685 = -1;
		this.field1683 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)V",
		garbageValue = "17891601"
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lty;II)V",
		garbageValue = "1627766366"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.method2543();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field1673 = var1.method2543();
		} else if (var2 == 4) {
			this.field1675 = var1.method2543();
		} else if (var2 == 5) {
			this.field1678 = var1.method2543();
		} else if (var2 == 6) {
			this.field1674 = var1.method2543();
		} else if (var2 == 7) {
			this.field1682 = var1.readShort();
		} else if (var2 == 8) {
			this.field1680 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field1687 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field1686 = var1.readShort();
		} else if (var2 == 11) {
			this.field1681 = 0;
		} else if (var2 == 12) {
			this.field1685 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field1683 = var1.readShort();
		} else if (var2 == 14) {
			this.field1681 = var1.readUnsignedShort();
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

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)Lhk;",
		garbageValue = "-517578279"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = WallDecoration.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? class177.method907(var2) : null;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "1987893545"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field1680;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + class509.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(B)Lud;",
		garbageValue = "6"
	)
	public SpritePixels method1012() {
		if (this.field1673 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1673);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMap.SpriteBuffer_getSprite(class387.field3643, this.field1673, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field1673);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)Lud;",
		garbageValue = "-36"
	)
	public SpritePixels method1013() {
		if (this.field1678 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1678);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMap.SpriteBuffer_getSprite(class387.field3643, this.field1678, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field1678);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)Lud;",
		garbageValue = "122"
	)
	public SpritePixels method1014() {
		if (this.field1675 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1675);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMap.SpriteBuffer_getSprite(class387.field3643, this.field1675, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field1675);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Lud;",
		garbageValue = "1252714259"
	)
	public SpritePixels method1015() {
		if (this.field1674 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1674);
			if (var1 != null) {
				return var1;
			} else {
				var1 = WorldMap.SpriteBuffer_getSprite(class387.field3643, this.field1674, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field1674);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)Lpc;",
		garbageValue = "-1649845453"
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
				var1 = ConcurrentMidiTask.method2106(class387.field3643, HitSplatDefinition_fontsArchive, this.fontId, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
				}

				return var1;
			}
		}
	}
}
