import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ti")
public class class497 {
	@ObfuscatedName("at")
	public final Object field4074;
	@ObfuscatedName("ah")
	public final Object field4073;

	public class497(Object var1, Object var2) {
		this.field4074 = var1;
		this.field4073 = var2;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field4074 + ", " + this.field4073;
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (var1 != null && var1 instanceof class497) {
			class497 var2 = (class497)var1;
			if (this.field4074 == null) {
				if (var2.field4074 != null) {
					return false;
				}
			} else if (!this.field4074.equals(var2.field4074)) {
				return false;
			}

			if (this.field4073 == null) {
				if (var2.field4073 != null) {
					return false;
				}
			} else if (!this.field4073.equals(var2.field4073)) {
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
		if (this.field4074 != null) {
			var1 += this.field4074.hashCode();
		}

		if (this.field4073 != null) {
			var1 += 31 * this.field4073.hashCode();
		}

		return var1;
	}
}