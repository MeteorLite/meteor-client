import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nn")
public final class class388 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "[Lnn;"
	)
	static class388[] field4429;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -842987581
	)
	static int field4430;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1861704181
	)
	static int field4434;
	@ObfuscatedName("n")
	float field4432;
	@ObfuscatedName("k")
	float field4433;
	@ObfuscatedName("s")
	float field4431;
	@ObfuscatedName("q")
	float field4435;

	static {
		field4429 = new class388[0];
		Skeleton.method4247(100);
		new class388();
	}

	class388() {
		this.method7157();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-814630220"
	)
	public void method7143() {
		synchronized(field4429) {
			if (field4434 < field4430 - 1) {
				field4429[++field4434 - 1] = this;
			}

		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(FFFFI)V",
		garbageValue = "-1516201827"
	)
	void method7141(float var1, float var2, float var3, float var4) {
		this.field4432 = var1;
		this.field4433 = var2;
		this.field4431 = var3;
		this.field4435 = var4;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(FFFFB)V",
		garbageValue = "2"
	)
	public void method7144(float var1, float var2, float var3, float var4) {
		float var5 = (float)Math.sin((double)(var4 * 0.5F));
		float var6 = (float)Math.cos((double)(0.5F * var4));
		this.field4432 = var1 * var5;
		this.field4433 = var2 * var5;
		this.field4431 = var3 * var5;
		this.field4435 = var6;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2126804452"
	)
	final void method7157() {
		this.field4431 = 0.0F;
		this.field4433 = 0.0F;
		this.field4432 = 0.0F;
		this.field4435 = 1.0F;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(Lnn;B)V",
		garbageValue = "65"
	)
	public final void method7163(class388 var1) {
		this.method7141(var1.field4433 * this.field4431 + var1.field4435 * this.field4432 + var1.field4432 * this.field4435 - this.field4433 * var1.field4431, this.field4435 * var1.field4433 + (this.field4433 * var1.field4435 - this.field4431 * var1.field4432) + var1.field4431 * this.field4432, var1.field4432 * this.field4433 + var1.field4435 * this.field4431 - this.field4432 * var1.field4433 + var1.field4431 * this.field4435, var1.field4435 * this.field4435 - this.field4432 * var1.field4432 - this.field4433 * var1.field4433 - this.field4431 * var1.field4431);
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof class388)) {
			return false;
		} else {
			class388 var2 = (class388)var1;
			return this.field4432 == var2.field4432 && var2.field4433 == this.field4433 && var2.field4431 == this.field4431 && this.field4435 == var2.field4435;
		}
	}

	public int hashCode() {
		boolean var1 = true;
		float var2 = 1.0F;
		var2 = this.field4432 + 31.0F * var2;
		var2 = this.field4433 + var2 * 31.0F;
		var2 = this.field4431 + var2 * 31.0F;
		var2 = this.field4435 + 31.0F * var2;
		return (int)var2;
	}

	public String toString() {
		return this.field4432 + "," + this.field4433 + "," + this.field4431 + "," + this.field4435;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(II)Ldt;",
		garbageValue = "-1154602557"
	)
	static class120 method7152(int var0) {
		class120[] var1 = new class120[]{class120.field1498, class120.field1486, class120.field1492, class120.field1488, class120.field1489, class120.field1487, class120.field1491, class120.field1501, class120.field1490, class120.field1494, class120.field1495, class120.field1496, class120.field1497, class120.field1503, class120.field1499, class120.field1500, class120.field1493};
		class120 var2 = (class120)Varps.findEnumerated(var1, var0);
		if (var2 == null) {
			var2 = class120.field1498;
		}

		return var2;
	}
}
