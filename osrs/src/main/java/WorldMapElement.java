import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
@Implements("WorldMapElement")
public class WorldMapElement extends DualNode {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "[Lhd;"
	)
	@Export("WorldMapElement_cached")
	public static WorldMapElement[] WorldMapElement_cached;
	@ObfuscatedName("ao")
	@Export("WorldMapElement_count")
	public static int WorldMapElement_count;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("WorldMapElement_cachedSprites")
	public static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	static Archive field1509;
	@ObfuscatedName("uc")
	@Export("cameraLookAtAcceleration")
	static int cameraLookAtAcceleration;
	@ObfuscatedName("ac")
	@Export("objectId")
	public final int objectId;
	@ObfuscatedName("ai")
	@Export("sprite1")
	public int sprite1;
	@ObfuscatedName("az")
	@Export("sprite2")
	int sprite2;
	@ObfuscatedName("ap")
	@Export("name")
	public String name;
	@ObfuscatedName("aa")
	public int field1522;
	@ObfuscatedName("af")
	@Export("textSize")
	public int textSize;
	@ObfuscatedName("aq")
	public boolean field1519;
	@ObfuscatedName("al")
	public boolean field1518;
	@ObfuscatedName("an")
	@Export("menuActions")
	public String[] menuActions;
	@ObfuscatedName("ar")
	@Export("menuTargetName")
	public String menuTargetName;
	@ObfuscatedName("ab")
	int[] field1516;
	@ObfuscatedName("ag")
	int field1511;
	@ObfuscatedName("am")
	int field1513;
	@ObfuscatedName("ax")
	int field1514;
	@ObfuscatedName("ah")
	int field1512;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lhe;"
	)
	@Export("horizontalAlignment")
	public HorizontalAlignment horizontalAlignment;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lhy;"
	)
	@Export("verticalAlignment")
	public VerticalAlignment verticalAlignment;
	@ObfuscatedName("aj")
	int[] field1517;
	@ObfuscatedName("av")
	byte[] field1510;
	@ObfuscatedName("aw")
	@Export("category")
	public int category;

	static {
		WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256);
	}

	public WorldMapElement(int var1) {
		this.sprite1 = -1;
		this.sprite2 = -1;
		this.textSize = 0;
		this.field1519 = true;
		this.field1518 = false;
		this.menuActions = new String[5];
		this.field1511 = Integer.MAX_VALUE;
		this.field1513 = Integer.MAX_VALUE;
		this.field1514 = Integer.MIN_VALUE;
		this.field1512 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered;
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered;
		this.category = -1;
		this.objectId = var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "332990063"
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

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ltm;II)V",
		garbageValue = "675267888"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.sprite1 = var1.method2563();
		} else if (var2 == 2) {
			this.sprite2 = var1.method2563();
		} else if (var2 == 3) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.field1522 = var1.readMedium();
		} else if (var2 == 5) {
			var1.readMedium();
		} else if (var2 == 6) {
			this.textSize = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) {
				var3 = var1.readUnsignedByte();
				if ((var3 & 1) == 0) {
					this.field1519 = false;
				}

				if ((var3 & 2) == 2) {
					this.field1518 = true;
				}
			} else if (var2 == 8) {
				var1.readUnsignedByte();
			} else if (var2 >= 10 && var2 <= 14) {
				this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field1516 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field1516[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field1517 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field1517.length; ++var5) {
					this.field1517[var5] = var1.readInt();
				}

				this.field1510 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field1510[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) {
					var1.method2563();
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
					var1.method2563();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					this.horizontalAlignment = (HorizontalAlignment)KeyHandler.findEnumerated(class113.method658(), var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment)KeyHandler.findEnumerated(Tiles.method457(), var1.readUnsignedByte());
				}
			}
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-79"
	)
	public void method949() {
		if (this.field1516 != null) {
			for (int var1 = 0; var1 < this.field1516.length; var1 += 2) {
				if (this.field1516[var1] < this.field1511) {
					this.field1511 = this.field1516[var1];
				} else if (this.field1516[var1] > this.field1514) {
					this.field1514 = this.field1516[var1];
				}

				if (this.field1516[var1 + 1] < this.field1513) {
					this.field1513 = this.field1516[var1 + 1];
				} else if (this.field1516[var1 + 1] > this.field1512) {
					this.field1512 = this.field1516[var1 + 1];
				}
			}
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ZB)Lui;",
		garbageValue = "0"
	)
	@Export("getSpriteBool")
	public SpritePixels getSpriteBool(boolean var1) {
		int var2 = this.sprite1 * 1744805107 * -479011781;
		return this.getSprite(var2);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IB)Lui;",
		garbageValue = "-54"
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
				var2 = Tiles.SpriteBuffer_getSprite(WorldMapElement_archive, var1, 0);
				if (var2 != null) {
					WorldMapElement_cachedSprites.put(var2, (long)var1);
				}

				return var2;
			}
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1172107767"
	)
	@Export("getObjectId")
	public int getObjectId() {
		return this.objectId;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)Lhv;",
		garbageValue = "-69"
	)
	@Export("getObjectDefinition")
	public static ObjectComposition getObjectDefinition(int var0) {
		ObjectComposition var1 = (ObjectComposition)ObjectComposition.ObjectDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectComposition.ObjectDefinition_archive.takeFile(6, var0);
			var1 = new ObjectComposition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectComposition.ObjectDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "1376332394"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + class348.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}
}