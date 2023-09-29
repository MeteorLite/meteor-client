import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ti")
public abstract class class495 {
	@ObfuscatedName("ab")
	int field4004;
	@ObfuscatedName("am")
	int field4006;
	@ObfuscatedName("av")
	double field4003;
	@ObfuscatedName("ag")
	int field4005;

	class495(int var1, int var2) {
		this.field4004 = 0;
		this.field4006 = 0;
		this.field4003 = 0.0D;
		this.field4005 = 0;
		this.field4004 = var1;
		this.field4006 = 0;
		this.field4005 = var2 >= 0 && var2 <= 27 ? var2 : 0;
		this.field4003 = MenuAction.method428(this.field4006, this.field4004, this.field4005);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2121571736"
	)
	public void method2413() {
		if (this.field4006 < this.field4004) {
			++this.field4006;
			this.field4003 = MenuAction.method428(this.field4006, this.field4004, this.field4005);
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)D",
		garbageValue = "1788156713"
	)
	double method2414() {
		return this.field4003;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lul;[II)[Ljava/lang/Object;",
		garbageValue = "1602002103"
	)
	static Object[] method2415(Buffer var0, int[] var1) {
		int var2 = var0.readUShortSmart();
		Object[] var3 = new Object[var1.length * var2];

		for (int var4 = 0; var4 < var2; ++var4) {
			for (int var5 = 0; var5 < var1.length; ++var5) {
				int var6 = var1.length * var4 + var5;
				class517 var7 = Tile.method1230(var1[var5]);
				var3[var6] = var7.method2532(var0);
			}
		}

		return var3;
	}
}