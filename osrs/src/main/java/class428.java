import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pv")
class class428 implements Iterator {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2130092703
	)
	int field4678;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	final class429 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lpf;)V"
	)
	class428(class429 var1) {
		this.this$0 = var1;
	}

	public Object next() {
		int var1 = ++this.field4678 - 1;
		class395 var2 = (class395)this.this$0.field4679.get((long)var1);
		return var2 != null ? var2 : this.this$0.method7731(var1);
	}

	public boolean hasNext() {
		return this.field4678 < this.this$0.method7267();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "([BB)V",
		garbageValue = "125"
	)
	@Export("SpriteBuffer_decode")
	public static void SpriteBuffer_decode(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class458.SpriteBuffer_spriteCount = var1.readUnsignedShort();
		class458.SpriteBuffer_xOffsets = new int[class458.SpriteBuffer_spriteCount];
		class458.SpriteBuffer_yOffsets = new int[class458.SpriteBuffer_spriteCount];
		ApproximateRouteStrategy.SpriteBuffer_spriteWidths = new int[class458.SpriteBuffer_spriteCount];
		UserComparator9.SpriteBuffer_spriteHeights = new int[class458.SpriteBuffer_spriteCount];
		FileSystem.SpriteBuffer_pixels = new byte[class458.SpriteBuffer_spriteCount][];
		var1.offset = var0.length - 7 - class458.SpriteBuffer_spriteCount * 8;
		SecureRandomCallable.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
		class402.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class458.SpriteBuffer_spriteCount; ++var3) {
			class458.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class458.SpriteBuffer_spriteCount; ++var3) {
			class458.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class458.SpriteBuffer_spriteCount; ++var3) {
			ApproximateRouteStrategy.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class458.SpriteBuffer_spriteCount; ++var3) {
			UserComparator9.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
		}

		var1.offset = var0.length - 7 - class458.SpriteBuffer_spriteCount * 8 - (var2 - 1) * 3;
		class458.SpriteBuffer_spritePalette = new int[var2];

		for (var3 = 1; var3 < var2; ++var3) {
			class458.SpriteBuffer_spritePalette[var3] = var1.readMedium();
			if (class458.SpriteBuffer_spritePalette[var3] == 0) {
				class458.SpriteBuffer_spritePalette[var3] = 1;
			}
		}

		var1.offset = 0;

		for (var3 = 0; var3 < class458.SpriteBuffer_spriteCount; ++var3) {
			int var4 = ApproximateRouteStrategy.SpriteBuffer_spriteWidths[var3];
			int var5 = UserComparator9.SpriteBuffer_spriteHeights[var3];
			int var6 = var5 * var4;
			byte[] var7 = new byte[var6];
			FileSystem.SpriteBuffer_pixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var4 * var10] = var1.readByte();
					}
				}
			}
		}

	}
}
