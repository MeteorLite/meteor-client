import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.security.SecureRandom;

@ObfuscatedName("gh")
@Implements("HealthBarDefinition")
public class HealthBarDefinition extends DualNode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	@Export("HealthBarDefinition_archive")
	public static AbstractArchive HealthBarDefinition_archive;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("HealthBarDefinition_cached")
	static EvictingDualNodeHashTable HealthBarDefinition_cached;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("ItemDefinition_cachedModels")
	static EvictingDualNodeHashTable ItemDefinition_cachedModels;
	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		descriptor = "Lmr;"
	)
	@Export("widgetDefinition")
	static WidgetDefinition widgetDefinition;
	@ObfuscatedName("ab")
	public int field1494;
	@ObfuscatedName("ac")
	@Export("int1")
	public int int1;
	@ObfuscatedName("al")
	@Export("int2")
	public int int2;
	@ObfuscatedName("az")
	@Export("int3")
	public int int3;
	@ObfuscatedName("ap")
	public int field1498;
	@ObfuscatedName("av")
	@Export("int5")
	public int int5;
	@ObfuscatedName("ax")
	@Export("frontSpriteID")
	int frontSpriteID;
	@ObfuscatedName("as")
	@Export("backSpriteID")
	int backSpriteID;
	@ObfuscatedName("ay")
	@Export("width")
	public int width;
	@ObfuscatedName("ak")
	@Export("widthPadding")
	public int widthPadding;

	static {
		HealthBarDefinition_cached = new EvictingDualNodeHashTable(64);
		ItemDefinition_cachedModels = new EvictingDualNodeHashTable(64);
	}

	HealthBarDefinition() {
		this.int1 = 255;
		this.int2 = 255;
		this.int3 = -1;
		this.field1498 = 1;
		this.int5 = 70;
		this.frontSpriteID = -1;
		this.backSpriteID = -1;
		this.width = 30;
		this.widthPadding = 0;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-1942652761"
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
		descriptor = "(Luj;II)V",
		garbageValue = "88568767"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			var1.readUnsignedShort();
		} else if (var2 == 2) {
			this.int1 = var1.readUnsignedByte();
		} else if (var2 == 3) {
			this.int2 = var1.readUnsignedByte();
		} else if (var2 == 4) {
			this.int3 = 0;
		} else if (var2 == 5) {
			this.int5 = var1.readUnsignedShort();
		} else if (var2 == 6) {
			var1.readUnsignedByte();
		} else if (var2 == 7) {
			this.frontSpriteID = var1.readNullableLargeSmart();
		} else if (var2 == 8) {
			this.backSpriteID = var1.readNullableLargeSmart();
		} else if (var2 == 11) {
			this.int3 = var1.readUnsignedShort();
		} else if (var2 == 14) {
			this.width = var1.readUnsignedByte();
		} else if (var2 == 15) {
			this.widthPadding = var1.readUnsignedByte();
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Luz;",
		garbageValue = "-309117701"
	)
	@Export("getFrontSprite")
	public SpritePixels getFrontSprite() {
		if (this.frontSpriteID < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)ItemDefinition_cachedModels.get((long)this.frontSpriteID);
			if (var1 != null) {
				return var1;
			} else {
				var1 = IgnoreList.SpriteBuffer_getSprite(SecureRandomCallable.field851, this.frontSpriteID, 0);
				if (var1 != null) {
					ItemDefinition_cachedModels.put(var1, (long)this.frontSpriteID);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)Luz;",
		garbageValue = "54"
	)
	@Export("getBackSprite")
	public SpritePixels getBackSprite() {
		if (this.backSpriteID < 0) {
			return null;
		} else {
			SpritePixels var1 = (SpritePixels)ItemDefinition_cachedModels.get((long)this.backSpriteID);
			if (var1 != null) {
				return var1;
			} else {
				var1 = IgnoreList.SpriteBuffer_getSprite(SecureRandomCallable.field851, this.backSpriteID, 0);
				if (var1 != null) {
					ItemDefinition_cachedModels.put(var1, (long)this.backSpriteID);
				}

				return var1;
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/security/SecureRandom;",
		garbageValue = "1872253772"
	)
	static SecureRandom method911() {
		SecureRandom var0 = new SecureRandom();
		var0.nextInt();
		return var0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-876386223"
	)
	public static void method916() {
		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var0 = 0; var0 < UserComparator6.field1202; ++var0) {
				KeyHandler.JagexCache_idxFiles[var0].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var2) {
		}

	}
}