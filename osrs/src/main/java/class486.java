import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("sf")
public class class486 {
	@ObfuscatedName("aw")
	public final Object field4036;
	@ObfuscatedName("ay")
	public final Object field4037;

	public class486(Object var1, Object var2) {
		this.field4036 = var1;
		this.field4037 = var2;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field4036 + ", " + this.field4037;
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (var1 != null && var1 instanceof class486) {
			class486 var2 = (class486)var1;
			if (this.field4036 == null) {
				if (var2.field4036 != null) {
					return false;
				}
			} else if (!this.field4036.equals(var2.field4036)) {
				return false;
			}

			if (this.field4037 == null) {
				if (var2.field4037 != null) {
					return false;
				}
			} else if (!this.field4037.equals(var2.field4037)) {
				return false;
			}

			return true;
		} else {
			return false;
		}
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		int var1 = 0;
		if (this.field4036 != null) {
			var1 += this.field4036.hashCode();
		}

		if (this.field4037 != null) {
			var1 += 31 * this.field4037.hashCode();
		}

		return var1;
	}
}
