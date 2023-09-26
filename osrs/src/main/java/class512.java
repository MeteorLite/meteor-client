import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("tx")
public class class512 extends class470 implements class297 {
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	final AbstractArchive field4127;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	final DemotingHashTable field4126;
	@ObfuscatedName("ax")
	final int field4125;

	@ObfuscatedSignature(
		descriptor = "(Lnp;ILoa;Lom;)V"
	)
	public class512(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
		super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
		this.field4126 = new DemotingHashTable(64);
		this.field4127 = var4;
		this.field4125 = var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Lsl;",
		garbageValue = "-799452482"
	)
	@Export("vmethod8207")
	protected class472 vmethod8207(int var1) {
		synchronized(this.field4126) {
			class471 var2 = (class471)this.field4126.get((long)var1);
			if (var2 == null) {
				var2 = this.method2515(var1);
				this.field4126.method1620(var2, (long)var1);
			}

			return var2;
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(IB)Lsw;",
		garbageValue = "37"
	)
	class471 method2515(int var1) {
		byte[] var2 = this.field4127.takeFile(this.field4125, var1);
		class471 var3 = new class471(var1);
		if (var2 != null) {
			var3.method2368(new Buffer(var2));
		}

		return var3;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-585456351"
	)
	public void method2516() {
		synchronized(this.field4126) {
			this.field4126.clear();
		}
	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return new class511(this);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)[Lun;",
		garbageValue = "2"
	)
	public static IndexedSprite[] method2517() {
		IndexedSprite[] var0 = new IndexedSprite[class544.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class544.SpriteBuffer_spriteCount; ++var1) {
			IndexedSprite var2 = var0[var1] = new IndexedSprite();
			var2.width = class159.SpriteBuffer_spriteWidth;
			var2.height = class500.SpriteBuffer_spriteHeight;
			var2.xOffset = class326.SpriteBuffer_xOffsets[var1];
			var2.yOffset = ModelData0.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class59.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = class544.SpriteBuffer_spriteHeights[var1];
			var2.palette = class372.SpriteBuffer_spritePalette;
			var2.pixels = AddRequestTask.SpriteBuffer_pixels[var1];
		}

		class407.method2062();
		return var0;
	}
}