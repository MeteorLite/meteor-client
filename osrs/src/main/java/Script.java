import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("an")
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("gi")
	static String field807;
	@ObfuscatedName("ay")
	String field815;
	@ObfuscatedName("ar")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("am")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("as")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("aj")
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("ag")
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("az")
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("av")
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "[Lsa;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(II)[Lsa;",
		garbageValue = "1100527320"
	)
	@Export("newIterableNodeHashTable")
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "-1835095730"
	)
	public static boolean method449(char var0) {
		if (var0 >= ' ' && var0 < 127 || var0 > 127 && var0 < 160 || var0 > 160 && var0 <= 255) {
			return true;
		} else {
			if (var0 != 0) {
				char[] var1 = class385.cp1252AsciiExtension;

				for (int var2 = 0; var2 < var1.length; ++var2) {
					char var3 = var1[var2];
					if (var0 == var3) {
						return true;
					}
				}
			}

			return false;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Luu;",
		garbageValue = "-2099566519"
	)
	static IndexedSprite method451() {
		IndexedSprite var0 = new IndexedSprite();
		var0.width = class528.SpriteBuffer_spriteWidth;
		var0.height = class528.SpriteBuffer_spriteHeight;
		var0.xOffset = class492.SpriteBuffer_xOffsets[0];
		var0.yOffset = class134.SpriteBuffer_yOffsets[0];
		var0.subWidth = class172.SpriteBuffer_spriteWidths[0];
		var0.subHeight = class528.SpriteBuffer_spriteHeights[0];
		var0.palette = class528.SpriteBuffer_spritePalette;
		var0.pixels = ArchiveDiskAction.SpriteBuffer_pixels[0];
		DbTableType.method2483();
		return var0;
	}
}
