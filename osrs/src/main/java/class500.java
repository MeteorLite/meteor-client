import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

import java.io.File;

@ObfuscatedName("tw")
public class class500 {
	@ObfuscatedName("ak")
	@Export("SpriteBuffer_spriteHeight")
	public static int SpriteBuffer_spriteHeight;
	@ObfuscatedName("ao")
	@Export("cacheDir")
	static File cacheDir;
	@ObfuscatedName("ac")
	public final Object field4079;
	@ObfuscatedName("al")
	public final Object field4080;

	public class500(Object var1, Object var2) {
		this.field4079 = var1;
		this.field4080 = var2;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field4079 + ", " + this.field4080;
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (var1 != null && var1 instanceof class500) {
			class500 var2 = (class500)var1;
			if (this.field4079 == null) {
				if (var2.field4079 != null) {
					return false;
				}
			} else if (!this.field4079.equals(var2.field4079)) {
				return false;
			}

			if (this.field4080 == null) {
				if (var2.field4080 != null) {
					return false;
				}
			} else if (!this.field4080.equals(var2.field4080)) {
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
		if (this.field4079 != null) {
			var1 += this.field4079.hashCode();
		}

		if (this.field4080 != null) {
			var1 += 31 * this.field4080.hashCode();
		}

		return var1;
	}
}