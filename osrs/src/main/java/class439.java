import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qd")
public final class class439 implements Comparable {
	@ObfuscatedName("ac")
	Object field3807;
	@ObfuscatedName("al")
	Object field3808;
	@ObfuscatedName("ak")
	long field3809;
	@ObfuscatedName("ax")
	long field3810;

	class439(Object var1, Object var2) {
		this.field3807 = var1;
		this.field3808 = var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lqd;I)I",
		garbageValue = "-1884046273"
	)
	int method2221(class439 var1) {
		if (this.field3810 < var1.field3810) {
			return -1;
		} else {
			return this.field3810 > var1.field3810 ? 1 : 0;
		}
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (var1 instanceof class439) {
			return this.field3808.equals(((class439)var1).field3808);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		return this.field3808.hashCode();
	}

	@Export("compareTo")
	@ObfuscatedName("compareTo")
	public int compareTo(Object var1) {
		return this.method2221((class439)var1);
	}
}