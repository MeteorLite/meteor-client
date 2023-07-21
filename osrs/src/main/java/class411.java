import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("pw")
public class class411 {
	@ObfuscatedName("aw")
	int field3721;
	@ObfuscatedName("ay")
	int field3722;
	@ObfuscatedName("ar")
	int field3720;
	@ObfuscatedName("am")
	int field3719;

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		boolean var1 = true;
		int var2 = 10 - Integer.toString(this.field3721).length();
		int var3 = 10 - Integer.toString(this.field3720).length();
		int var4 = 10 - Integer.toString(this.field3722).length();
		String var5 = "          ".substring(10 - var2);
		String var6 = "          ".substring(10 - var3);
		String var7 = "          ".substring(10 - var4);
		return "    Size: " + this.field3721 + var5 + "Created: " + this.field3722 + var7 + "Total used: " + this.field3720 + var6 + "Max-In-Use: " + this.field3719;
	}
}
