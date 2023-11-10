import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class205 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	static final class205 field1821;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	static final class205 field1817;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	static final class205 field1819;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	static final class205 field1818;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	public static final class205 field1811;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	static final class205 field1822;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	public static final class205 field1810;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	public static final class205 field1812;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	public static final class205 field1813;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	public static final class205 field1816;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	public static final class205 field1814;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	public static final class205 field1815;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	static final class205 field1823;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	static final class205 field1820;
	@ObfuscatedName("ay")
	public final int field1824;

	static {
		field1821 = new class205(0);
		field1817 = new class205(1);
		field1819 = new class205(2);
		field1818 = new class205(3);
		field1811 = new class205(4, class192.field1592);
		field1822 = new class205(5);
		field1810 = new class205(6, class192.field1591);
		field1812 = new class205(7, class192.field1594);
		field1813 = new class205(8, class192.field1593);
		field1816 = new class205(9, class192.field1589);
		field1814 = new class205(10, class192.field1588);
		field1815 = new class205(11, class192.field1590);
		field1823 = new class205(12);
		field1820 = new class205(13);
	}

	class205(int var1) {
		this(var1, (class192)null);
	}

	@ObfuscatedSignature(
		descriptor = "(ILhc;)V"
	)
	class205(int var1, class192 var2) {
		this.field1824 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lol;IIB)Lup;",
		garbageValue = "0"
	)
	static IndexedSprite method1056(AbstractArchive var0, int var1, int var2) {
		byte[] var4 = var0.takeFile(var1, var2);
		boolean var3;
		if (var4 == null) {
			var3 = false;
		} else {
			class162.SpriteBuffer_decode(var4);
			var3 = true;
		}

		if (!var3) {
			return null;
		} else {
			IndexedSprite var5 = new IndexedSprite();
			var5.width = class541.SpriteBuffer_spriteWidth;
			var5.height = GrandExchangeOfferWorldComparator.SpriteBuffer_spriteHeight;
			var5.xOffset = class541.SpriteBuffer_xOffsets[0];
			var5.yOffset = class541.SpriteBuffer_yOffsets[0];
			var5.subWidth = class541.SpriteBuffer_spriteWidths[0];
			var5.subHeight = class520.SpriteBuffer_spriteHeights[0];
			var5.palette = class541.SpriteBuffer_spritePalette;
			var5.pixels = class396.SpriteBuffer_pixels[0];
			class541.SpriteBuffer_xOffsets = null;
			class541.SpriteBuffer_yOffsets = null;
			class541.SpriteBuffer_spriteWidths = null;
			class520.SpriteBuffer_spriteHeights = null;
			class541.SpriteBuffer_spritePalette = null;
			class396.SpriteBuffer_pixels = null;
			return var5;
		}
	}
}