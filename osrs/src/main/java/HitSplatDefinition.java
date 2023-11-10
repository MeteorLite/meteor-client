import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	@Export("HitSplatDefinition_archive")
	public static AbstractArchive HitSplatDefinition_archive;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	public static AbstractArchive field1640;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	@Export("HitSplatDefinition_fontsArchive")
	public static AbstractArchive HitSplatDefinition_fontsArchive;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("HitSplatDefinition_cached")
	static EvictingDualNodeHashTable HitSplatDefinition_cached;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("HitSplatDefinition_cachedFonts")
	static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
	@ObfuscatedName("av")
	@Export("fontId")
	int fontId;
	@ObfuscatedName("ax")
	@Export("textColor")
	public int textColor;
	@ObfuscatedName("as")
	public int field1658;
	@ObfuscatedName("ay")
	int field1651;
	@ObfuscatedName("ak")
	int field1648;
	@ObfuscatedName("aj")
	int field1647;
	@ObfuscatedName("am")
	int field1649;
	@ObfuscatedName("aq")
	public int field1657;
	@ObfuscatedName("ai")
	public int field1655;
	@ObfuscatedName("aw")
	public int field1659;
	@ObfuscatedName("ae")
	String field1653;
	@ObfuscatedName("an")
	public int field1656;
	@ObfuscatedName("ag")
	public int field1654;
	@ObfuscatedName("ad")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("af")
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("be")
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
		this.field1658 = 70;
		this.field1651 = -1;
		this.field1648 = -1;
		this.field1647 = -1;
		this.field1649 = -1;
		this.field1657 = 0;
		this.field1655 = 0;
		this.field1659 = -1;
		this.field1653 = "";
		this.field1656 = -1;
		this.field1654 = 0;
		this.transformVarbit = -1;
		this.transformVarp = -1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Luj;B)V",
		garbageValue = "76"
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
		descriptor = "(Luj;IB)V",
		garbageValue = "-1"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.fontId = var1.readNullableLargeSmart();
		} else if (var2 == 2) {
			this.textColor = var1.readMedium();
		} else if (var2 == 3) {
			this.field1651 = var1.readNullableLargeSmart();
		} else if (var2 == 4) {
			this.field1647 = var1.readNullableLargeSmart();
		} else if (var2 == 5) {
			this.field1648 = var1.readNullableLargeSmart();
		} else if (var2 == 6) {
			this.field1649 = var1.readNullableLargeSmart();
		} else if (var2 == 7) {
			this.field1657 = var1.readShort();
		} else if (var2 == 8) {
			this.field1653 = var1.readStringCp1252NullCircumfixed();
		} else if (var2 == 9) {
			this.field1658 = var1.readUnsignedShort();
		} else if (var2 == 10) {
			this.field1655 = var1.readShort();
		} else if (var2 == 11) {
			this.field1659 = 0;
		} else if (var2 == 12) {
			this.field1656 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field1654 = var1.readShort();
		} else if (var2 == 14) {
			this.field1659 = var1.readUnsignedShort();
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

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)Lhz;",
		garbageValue = "14"
	)
	@Export("transform")
	public final HitSplatDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = HealthBar.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? class149.method776(var2) : null;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(IS)Ljava/lang/String;",
		garbageValue = "184"
	)
	@Export("getString")
	public String getString(int var1) {
		String var2 = this.field1653;

		while (true) {
			int var3 = var2.indexOf("%1");
			if (var3 < 0) {
				return var2;
			}

			var2 = var2.substring(0, var3) + SceneTilePaint.intToString(var1, false) + var2.substring(var3 + 2);
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)Luz;",
		garbageValue = "87"
	)
	public SpritePixels method992() {
		if (this.field1651 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1651);
			if (var1 != null) {
				return var1;
			} else {
				var1 = IgnoreList.SpriteBuffer_getSprite(field1640, this.field1651, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field1651);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Luz;",
		garbageValue = "-1829294182"
	)
	public SpritePixels method993() {
		if (this.field1648 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1648);
			if (var1 != null) {
				return var1;
			} else {
				var1 = IgnoreList.SpriteBuffer_getSprite(field1640, this.field1648, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field1648);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Luz;",
		garbageValue = "40"
	)
	public SpritePixels method995() {
		if (this.field1647 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1647);
			if (var1 != null) {
				return var1;
			} else {
				var1 = IgnoreList.SpriteBuffer_getSprite(field1640, this.field1647, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field1647);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Luz;",
		garbageValue = "-1809532978"
	)
	public SpritePixels method996() {
		if (this.field1649 < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1649);
			if (var1 != null) {
				return var1;
			} else {
				var1 = IgnoreList.SpriteBuffer_getSprite(field1640, this.field1649, 0);
				if (var1 != null) {
					HitSplatDefinition_cachedSprites.put(var1, (long)this.field1649);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Lpf;",
		garbageValue = "1266357542"
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
				AbstractArchive var3 = field1640;
				AbstractArchive var4 = HitSplatDefinition_fontsArchive;
				int var5 = this.fontId;
				byte[] var7 = var3.takeFile(var5, 0);
				boolean var6;
				if (var7 == null) {
					var6 = false;
				} else {
					class162.SpriteBuffer_decode(var7);
					var6 = true;
				}

				Font var2;
				if (!var6) {
					var2 = null;
				} else {
					var2 = WorldMapArea.method1229(var4.takeFile(var5, 0));
				}

				if (var2 != null) {
					HitSplatDefinition_cachedFonts.put(var2, (long)this.fontId);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("at")
	@Export("base37DecodeLong")
	public static String base37DecodeLong(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (var0 % 37L == 0L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; var3 != 0L; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5;
				char var8;
				for (var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
					long var6 = var0;
					var0 /= 37L;
					var8 = class400.base37Table[(int)(var6 - var0 * 37L)];
					if (var8 == '_') {
						int var9 = var5.length() - 1;
						var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
						var8 = 160;
					}
				}

				var5.reverse();
				var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
				return var5.toString();
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2098653411"
	)
	public static void method994() {
		KitDefinition.KitDefinition_cached.clear();
	}

	@ObfuscatedName("la")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lnn;I)Ljava/lang/String;",
		garbageValue = "-1437467043"
	)
	static String method998(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					String var4 = var0.substring(0, var3);
					int var6 = UserComparator4.method666(var1, var2 - 1);
					String var5;
					if (var6 < 999999999) {
						var5 = Integer.toString(var6);
					} else {
						var5 = "*";
					}

					var0 = var4 + var5 + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}
}