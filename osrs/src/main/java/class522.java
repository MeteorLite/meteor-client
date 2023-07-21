import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("uh")
public class class522 {
	@ObfuscatedName("aw")
	public final int field4170;
	@ObfuscatedName("ay")
	public Object field4169;

	public class522(int var1) {
		this.field4170 = var1;
	}

	public class522(int var1, Object var2) {
		this.field4170 = var1;
		this.field4169 = var2;
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		return super.hashCode();
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class522)) {
			return false;
		} else {
			class522 var2 = (class522)var1;
			if (var2.field4169 == null && this.field4169 != null) {
				return false;
			} else if (this.field4169 == null && var2.field4169 != null) {
				return false;
			} else {
				return var2.field4170 == this.field4170 && var2.field4169.equals(this.field4169);
			}
		}
	}
}
