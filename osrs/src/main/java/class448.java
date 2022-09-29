import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qs")
public class class448 implements MouseWheel {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	public static final class448 field4784;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	public static final class448 field4785;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	static final class448 field4786;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	static final class448 field4787;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	static final class448 field4788;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	static final class448 field4789;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1359940479
	)
	final int field4790;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 316956481
	)
	final int field4791;

	static {
		field4784 = new class448(0, 0);
		field4785 = new class448(5, 2);
		field4786 = new class448(2, 5);
		field4787 = new class448(1, 6);
		field4788 = new class448(3, 7);
		field4789 = new class448(4, 8);
	}

	class448(int var1, int var2) {
		this.field4790 = var1;
		this.field4791 = var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2034877574"
	)
	public boolean method8184() {
		return this == field4785;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4791;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Llv;Llv;III)Lmv;",
		garbageValue = "-1727217771"
	)
	public static Font method8182(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
		if (!Occluder.method4475(var0, var2, var3)) {
			return null;
		} else {
			byte[] var5 = var1.takeFile(var2, var3);
			Font var4;
			if (var5 == null) {
				var4 = null;
			} else {
				Font var6 = new Font(var5, class458.SpriteBuffer_xOffsets, class458.SpriteBuffer_yOffsets, ApproximateRouteStrategy.SpriteBuffer_spriteWidths, UserComparator9.SpriteBuffer_spriteHeights, class458.SpriteBuffer_spritePalette, FileSystem.SpriteBuffer_pixels);
				class458.SpriteBuffer_xOffsets = null;
				class458.SpriteBuffer_yOffsets = null;
				ApproximateRouteStrategy.SpriteBuffer_spriteWidths = null;
				UserComparator9.SpriteBuffer_spriteHeights = null;
				class458.SpriteBuffer_spritePalette = null;
				FileSystem.SpriteBuffer_pixels = null;
				var4 = var6;
			}

			return var4;
		}
	}
}
