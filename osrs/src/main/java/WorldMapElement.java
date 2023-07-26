import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("WorldMapElement_cachedSprites")
	public static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("as")
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("aj")
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("ag")
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("az")
	@Export("name")
	public String name;
	@ObfuscatedName("av")
	public int field1513;
	@ObfuscatedName("ap")
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("at")
	public boolean field1507;
	@ObfuscatedName("ah")
	public boolean field1506;
	@ObfuscatedName("ax")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("aa")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("au")
	int[] field1505;
	@ObfuscatedName("ae")
	int field1501;
	@ObfuscatedName("ab")
	int field1499;
	@ObfuscatedName("ad")
	int field1500;
	@ObfuscatedName("ao")
	int field1503;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lhz;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lhl;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("an")
	int[] field1504;
	@ObfuscatedName("af")
	byte[] field1498;
	@ObfuscatedName("ai")
	@Export("category")
	public int category;

	static {
		WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
	}

	public WorldMapElement(int var1) {
		this.sprite1 = -1;
		this.sprite2 = -1;
		this.textSize = 0;
		this.field1507 = true;
		this.field1506 = false;
		this.menuActions = new String[5];
		this.field1501 = Integer.MAX_VALUE;
		this.field1499 = Integer.MAX_VALUE;
		this.field1500 = Integer.MIN_VALUE;
		this.field1503 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "-65"
	)
	@Export("decode")
	public void decode(Buffer var1) {
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
		descriptor = "(Lty;IB)V",
		garbageValue = "-112"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method2543();
		} else if (var2 == 2) {
			this.sprite2 = var1.method2543();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field1513 = var1.readMedium();
		} else if (var2 == 5) {
			var1.readMedium();
		} else if (var2 == 6) {
			this.textSize = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) {
				var3 = var1.readUnsignedByte();
				if ((var3 & 1) == 0) {
					this.field1507 = false;
				}

				if ((var3 & 2) == 2) {
					this.field1506 = true;
				}
			} else if (var2 == 8) {
				var1.readUnsignedByte();
			} else if (var2 >= 10 && var2 <= 14) {
				this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field1505 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field1505[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field1504 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field1504.length; ++var5) {
					this.field1504[var5] = var1.readInt();
				}

				this.field1498 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field1498[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method2543();
				} else if (var2 == 19) {
					this.category = var1.readUnsignedShort();
				} else if (var2 == 21) {
					var1.readInt();
				} else if (var2 == 22) {
					var1.readInt();
				} else if (var2 == 23) {
					var1.readUnsignedByte();
					var1.readUnsignedByte();
					var1.readUnsignedByte();
				} else if (var2 == 24) {
					var1.readShort();
					var1.readShort();
				} else if (var2 == 25) {
					var1.method2543();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					HorizontalAlignment[] var6 = new HorizontalAlignment[]{HorizontalAlignment.HorizontalAlignment_centered, HorizontalAlignment.field1558, HorizontalAlignment.field1557};
					this.horizontalAlignment = (HorizontalAlignment)ClientPreferences.findEnumerated(var6, var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment)ClientPreferences.findEnumerated(class425.method2151(), var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1012170013"
	)
	public void method935() {
		if (this.field1505 != null) {
			for (int var1 = 0; var1 < this.field1505.length; var1 += 2) {
				if (this.field1505[var1] < this.field1501) {
					this.field1501 = this.field1505[var1];
				} else if (this.field1505[var1] > this.field1500) {
					this.field1500 = this.field1505[var1];
				}

				if (this.field1505[var1 + 1] < this.field1499) {
					this.field1499 = this.field1505[var1 + 1];
				} else if (this.field1505[var1 + 1] > this.field1503) {
					this.field1503 = this.field1505[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(ZI)Lud;",
		garbageValue = "1803263735"
	)
	@Export("getSpriteBool")
	public SpritePixels getSpriteBool(boolean var1) {
		int var2 = this.sprite1 * -148742303 * 179602593;
		return this.getSprite(var2);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(II)Lud;",
		garbageValue = "-858203054"
	)
	@Export("getSprite")
	SpritePixels getSprite(int var1) {
		if (var1 < 0) {
			return null;
		} else {
			SpritePixels var2 = (SpritePixels)WorldMapElement_cachedSprites.get((long)var1);
			if (var2 != null) {
				return var2;
			} else {
				var2 = WorldMap.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "119"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/Date;",
		garbageValue = "-1651888504"
	)
	static Date method939() {
		java.util.Calendar var0 = java.util.Calendar.getInstance();
		var0.set(2, 0);
		var0.set(5, 1);
		var0.set(1, 1900);
		return var0.getTime();
	}
}
