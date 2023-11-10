import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ObfuscatedName("te")
public class class518 extends DualNode {
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "[Ltu;"
	)
	class514[] field4139;
	@ObfuscatedName("ab")
	List field4138;

	@ObfuscatedSignature(
		descriptor = "(Lol;I)V"
	)
	public class518(AbstractArchive var1, int var2) {
		byte[] var3 = var1.takeFile(var2, 0);
		this.method2517(new Buffer(var3));
	}

	@ObfuscatedSignature(
		descriptor = "(Lol;II)V"
	)
	public class518(AbstractArchive var1, int var2, int var3) {
		byte[] var4 = var1.takeFile(var2, var3 + 1);
		this.method2517(new Buffer(var4));
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-1944052091"
	)
	void method2517(Buffer var1) {
		int var2 = var1.packBytesToInt();
		this.field4139 = new class514[var2];
		this.field4138 = new ArrayList(var2);

		for (int var3 = 0; var3 < var2; ++var3) {
			this.field4139[var3] = (class514)class12.findEnumerated(class514.method2503(), var1.readUnsignedByte());
			int var4 = var1.packBytesToInt();
			HashMap var5 = new HashMap(var4);

			while (var4-- > 0) {
				Object var6 = this.field4139[var3].method2506(var1);
				int var7 = var1.packBytesToInt();
				ArrayList var8 = new ArrayList();

				while (var7-- > 0) {
					int var9 = var1.packBytesToInt();
					var8.add(var9);
				}

				var5.put(var6, var8);
			}

			this.field4138.add(var3, var5);
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;IB)Ljava/util/List;",
		garbageValue = "40"
	)
	public List method2518(Object var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		Map var3 = (Map)this.field4138.get(var2);
		return (List)var3.get(var1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)[Lup;",
		garbageValue = "-1344314706"
	)
	public static IndexedSprite[] method2519() {
		IndexedSprite[] var0 = new IndexedSprite[class541.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class541.SpriteBuffer_spriteCount; ++var1) {
			IndexedSprite var2 = var0[var1] = new IndexedSprite();
			var2.width = class541.SpriteBuffer_spriteWidth;
			var2.height = GrandExchangeOfferWorldComparator.SpriteBuffer_spriteHeight;
			var2.xOffset = class541.SpriteBuffer_xOffsets[var1];
			var2.yOffset = class541.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class541.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = class520.SpriteBuffer_spriteHeights[var1];
			var2.palette = class541.SpriteBuffer_spritePalette;
			var2.pixels = class396.SpriteBuffer_pixels[var1];
		}

		class458.method2306();
		return var0;
	}
}