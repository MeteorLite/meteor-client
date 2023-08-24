import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ss")
public class class485 {
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("au")
	public final Object field4049;
	@ObfuscatedName("ae")
	public final Object field4048;

	public class485(Object var1, Object var2) {
		this.field4049 = var1;
		this.field4048 = var2;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field4049 + ", " + this.field4048;
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (var1 != null && var1 instanceof class485) {
			class485 var2 = (class485)var1;
			if (this.field4049 == null) {
				if (var2.field4049 != null) {
					return false;
				}
			} else if (!this.field4049.equals(var2.field4049)) {
				return false;
			}

			if (this.field4048 == null) {
				if (var2.field4048 != null) {
					return false;
				}
			} else if (!this.field4048.equals(var2.field4048)) {
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
		if (this.field4049 != null) {
			var1 += this.field4049.hashCode();
		}

		if (this.field4048 != null) {
			var1 += 31 * this.field4048.hashCode();
		}

		return var1;
	}
}