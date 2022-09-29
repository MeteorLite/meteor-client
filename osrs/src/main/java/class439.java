import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pl")
public class class439 extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llv;"
	)
	static AbstractArchive field4718;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lif;"
	)
	@Export("DBRowType_cache")
	public static EvictingDualNodeHashTable DBRowType_cache;
	@ObfuscatedName("f")
	Object[][] field4715;
	@ObfuscatedName("n")
	int[][] field4716;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1580984827
	)
	public int field4713;

	static {
		DBRowType_cache = new EvictingDualNodeHashTable(64);
	}

	class439() {
		this.field4713 = -1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "-435731106"
	)
	void method7830(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method7826(var1, var2);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(II)[Ljava/lang/Object;",
		garbageValue = "906427284"
	)
	public Object[] method7827(int var1) {
		return this.field4715 == null ? null : this.field4715[var1];
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Lqq;II)V",
		garbageValue = "2127843822"
	)
	void method7826(Buffer var1, int var2) {
		if (var2 == 3) {
			int var3 = var1.readUnsignedByte();
			if (this.field4715 == null) {
				this.field4715 = new Object[var3][];
				this.field4716 = new int[var3][];
			}

			for (int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) {
				int var5 = var1.readUnsignedByte();
				int[] var6 = new int[var5];

				for (int var7 = 0; var7 < var5; ++var7) {
					var6[var7] = var1.readUShortSmart();
				}

				this.field4715[var4] = class358.method6730(var1, var6);
				this.field4716[var4] = var6;
			}
		} else if (var2 == 4) {
			this.field4713 = var1.method7944();
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1247469224"
	)
	void method7829() {
	}
}
