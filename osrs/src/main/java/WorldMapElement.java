import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llv;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "[Lfh;"
	)
	@Export("WorldMapElement_cached")
	public static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 517354743
	)
	@Export("WorldMapElement_count")
	public static int WorldMapElement_count;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("WorldMapElement_cachedSprites")
	static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 666751609
	)
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -46725577
	)
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1619334869
	)
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("q")
	@Export("name")
	public String name;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 2069218199
	)
	public int field1845;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 527391355
	)
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("v")
	public boolean field1855;
	@ObfuscatedName("h")
	public boolean field1856;
	@ObfuscatedName("t")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("u")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("d")
	int[] field1859;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1422588785
	)
	int field1861;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -864218917
	)
	int field1851;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 2028882753
	)
	int field1857;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1627228615
	)
	int field1863;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("i")
	int[] field1866;
	@ObfuscatedName("r")
	byte[] field1867;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 270915399
	)
	@Export("category")
	public int category;

	static {
		WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
	}

	public WorldMapElement(int var1) {
		this.sprite1 = -1;
		this.sprite2 = -1;
		this.textSize = 0;
		this.field1855 = true;
		this.field1856 = false;
		this.menuActions = new String[5];
		this.field1861 = Integer.MAX_VALUE;
		this.field1851 = Integer.MAX_VALUE;
		this.field1857 = Integer.MIN_VALUE;
		this.field1863 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)V",
		garbageValue = "38"
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lqq;IB)V",
		garbageValue = "33"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method8028();
		} else if (var2 == 2) {
			this.sprite2 = var1.method8028();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field1845 = var1.readMedium();
		} else if (var2 == 5) {
			var1.readMedium();
		} else if (var2 == 6) {
			this.textSize = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) {
				var3 = var1.readUnsignedByte();
				if ((var3 & 1) == 0) {
					this.field1855 = false;
				}

				if ((var3 & 2) == 2) {
					this.field1856 = true;
				}
			} else if (var2 == 8) {
				var1.readUnsignedByte();
			} else if (var2 >= 10 && var2 <= 14) {
				this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field1859 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field1859[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field1866 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field1866.length; ++var5) {
					this.field1866[var5] = var1.readInt();
				}

				this.field1867 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field1867[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method8028();
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
					var1.method8028();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					this.horizontalAlignment = (HorizontalAlignment)Varps.findEnumerated(SoundCache.method834(), var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment)Varps.findEnumerated(Message.method1144(), var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "2"
	)
	public void method3538() {
		if (this.field1859 != null) {
			for (int var1 = 0; var1 < this.field1859.length; var1 += 2) {
				if (this.field1859[var1] < this.field1861) {
					this.field1861 = this.field1859[var1];
				} else if (this.field1859[var1] > this.field1857) {
					this.field1857 = this.field1859[var1];
				}

				if (this.field1859[var1 + 1] < this.field1851) {
					this.field1851 = this.field1859[var1 + 1];
				} else if (this.field1859[var1 + 1] > this.field1863) {
					this.field1863 = this.field1859[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(ZB)Lqi;",
		garbageValue = "62"
	)
	@Export("getSpriteBool")
	public SpritePixels getSpriteBool(boolean var1) {
		int var2 = this.sprite1;
		return this.getSprite(var2);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(II)Lqi;",
		garbageValue = "936206529"
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
				var2 = class114.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "21708"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(IIIB)I",
		garbageValue = "74"
	)
	static final int method3556(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = Script.method2129(var3, var5);
		int var8 = Script.method2129(var3 + 1, var5);
		int var9 = Script.method2129(var3, var5 + 1);
		int var10 = Script.method2129(var3 + 1, var5 + 1);
		int var11 = Bounds.method7094(var7, var8, var4, var2);
		int var12 = Bounds.method7094(var9, var10, var4, var2);
		return Bounds.method7094(var11, var12, var6, var2);
	}
}
