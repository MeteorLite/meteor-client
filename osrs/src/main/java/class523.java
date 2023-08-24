import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ud")
public class class523 {
	@ObfuscatedName("au")
	public final int field4216;
	@ObfuscatedName("ae")
	public Object field4215;

	public class523(int var1) {
		this.field4216 = var1;
	}

	public class523(int var1, Object var2) {
		this.field4216 = var1;
		this.field4215 = var2;
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		return super.hashCode();
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class523)) {
			return false;
		} else {
			class523 var2 = (class523)var1;
			if (var2.field4215 == null && this.field4215 != null) {
				return false;
			} else if (this.field4215 == null && var2.field4215 != null) {
				return false;
			} else {
				return var2.field4216 == this.field4216 && var2.field4215.equals(this.field4215);
			}
		}
	}
}