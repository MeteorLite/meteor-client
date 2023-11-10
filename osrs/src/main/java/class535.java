import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ux")
public class class535 {
	@ObfuscatedName("at")
	public final int field4244;
	@ObfuscatedName("ah")
	public Object field4243;

	public class535(int var1) {
		this.field4244 = var1;
	}

	public class535(int var1, Object var2) {
		this.field4244 = var1;
		this.field4243 = var2;
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		return super.hashCode();
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class535)) {
			return false;
		} else {
			class535 var2 = (class535)var1;
			if (var2.field4243 == null && this.field4243 != null) {
				return false;
			} else if (this.field4243 == null && var2.field4243 != null) {
				return false;
			} else {
				return this.field4244 == var2.field4244 && var2.field4243.equals(this.field4243);
			}
		}
	}
}