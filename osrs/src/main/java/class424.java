import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qj")
public final class class424 implements Comparable {
	@ObfuscatedName("au")
	Object field3778;
	@ObfuscatedName("ae")
	Object field3777;
	@ObfuscatedName("ao")
	long field3779;
	@ObfuscatedName("at")
	long field3780;

	class424(Object var1, Object var2) {
		this.field3778 = var1;
		this.field3777 = var2;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lqj;B)I",
		garbageValue = "1"
	)
	int method2185(class424 var1) {
		if (this.field3780 < var1.field3780) {
			return -1;
		} else {
			return this.field3780 > var1.field3780 ? 1 : 0;
		}
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (var1 instanceof class424) {
			return this.field3777.equals(((class424)var1).field3777);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		return this.field3777.hashCode();
	}

	@Export("compareTo")
	@ObfuscatedName("compareTo")
	public int compareTo(Object var1) {
		return this.method2185((class424)var1);
	}
}