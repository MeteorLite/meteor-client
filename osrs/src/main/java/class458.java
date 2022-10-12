import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qj")
public class class458 extends DualNode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Llg;"
	)
	static AbstractArchive field4848;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Ljx;"
	)
	@Export("DBRowType_cache")
	public static EvictingDualNodeHashTable DBRowType_cache;
	@ObfuscatedName("c")
	Object[][] field4849;
	@ObfuscatedName("x")
	int[][] field4846;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -116507795
	)
	public int field4850;

	static {
		DBRowType_cache = new EvictingDualNodeHashTable(64);
	}

	class458() {
		this.field4850 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqr;B)V",
		garbageValue = "-116"
	)
	void method8306(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method8314(var1, var2);
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(IB)[Ljava/lang/Object;",
		garbageValue = "56"
	)
	public Object[] method8307(int var1) {
		return this.field4849 == null ? null : this.field4849[var1];
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(Lqr;II)V",
		garbageValue = "1603267448"
	)
	void method8314(Buffer var1, int var2) {
		if (var2 == 3) {
			int var3 = var1.readUnsignedByte();
			if (this.field4849 == null) {
				this.field4849 = new Object[var3][];
				this.field4846 = new int[var3][];
			}

			for (int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) {
				int var5 = var1.readUnsignedByte();
				int[] var6 = new int[var5];

				for (int var7 = 0; var7 < var5; ++var7) {
					var6[var7] = var1.readUShortSmart();
				}

				Object[][] var16 = this.field4849;
				int var10 = var1.readUShortSmart();
				Object[] var11 = new Object[var6.length * var10];

				for (int var12 = 0; var12 < var10; ++var12) {
					for (int var13 = 0; var13 < var6.length; ++var13) {
						int var14 = var13 + var6.length * var12;
						class453 var15 = class230.method4679(var6[var13]);
						var11[var14] = var15.method8257(var1);
					}
				}

				var16[var4] = var11;
				this.field4846[var4] = var6;
			}
		} else if (var2 == 4) {
			this.field4850 = var1.method8424();
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-62"
	)
	void method8309() {
	}
}
