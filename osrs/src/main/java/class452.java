import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ql")
public class class452 {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 527354441
	)
	public final int field4796;
	@ObfuscatedName("p")
	public Object field4797;

	public class452(int var1) {
		this.field4796 = var1;
	}

	public class452(int var1, Object var2) {
		this.field4796 = var1;
		this.field4797 = var2;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof class452)) {
			return false;
		} else {
			class452 var2 = (class452)var1;
			if (var2.field4797 == null && this.field4797 != null) {
				return false;
			} else if (this.field4797 == null && var2.field4797 != null) {
				return false;
			} else {
				return this.field4796 == var2.field4796 && var2.field4797.equals(this.field4797);
			}
		}
	}

	public int hashCode() {
		return super.hashCode();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
		garbageValue = "0"
	)
	public static String method8211(CharSequence var0) {
		int var1 = var0.length();
		StringBuilder var2 = new StringBuilder(var1);

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
				if (var4 == ' ') {
					var2.append('+');
				} else {
					byte var5 = PlayerComposition.charToByteCp1252(var4);
					var2.append('%');
					int var6 = var5 >> 4 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}

					var6 = var5 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}
				}
			} else {
				var2.append(var4);
			}
		}

		return var2.toString();
	}
}
