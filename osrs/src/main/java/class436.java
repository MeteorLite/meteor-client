import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qe")
public final class class436 implements Comparable {
	@ObfuscatedName("at")
	Object field3812;
	@ObfuscatedName("ah")
	Object field3811;
	@ObfuscatedName("ar")
	long field3814;
	@ObfuscatedName("ao")
	long field3813;

	class436(Object var1, Object var2) {
		this.field3812 = var1;
		this.field3811 = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lqe;I)I",
		garbageValue = "1786312392"
	)
	int method2202(class436 var1) {
		if (this.field3813 < var1.field3813) {
			return -1;
		} else {
			return this.field3813 > var1.field3813 ? 1 : 0;
		}
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (var1 instanceof class436) {
			return this.field3811.equals(((class436)var1).field3811);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		return this.field3811.hashCode();
	}

	@Export("compareTo")
	@ObfuscatedName("compareTo")
	public int compareTo(Object var1) {
		return this.method2202((class436)var1);
	}
}