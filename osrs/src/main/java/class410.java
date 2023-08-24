import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ph")
public class class410 {
	@ObfuscatedName("ax")
	@Export("ByteArrayPool_arrays")
	static byte[][][] ByteArrayPool_arrays;
	@ObfuscatedName("au")
	int field3733;
	@ObfuscatedName("ae")
	int field3730;
	@ObfuscatedName("ao")
	int field3731;
	@ObfuscatedName("at")
	int field3732;

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		boolean var1 = true;
		int var2 = 10 - Integer.toString(this.field3733).length();
		int var3 = 10 - Integer.toString(this.field3731).length();
		int var4 = 10 - Integer.toString(this.field3730).length();
		String var5 = "          ".substring(10 - var2);
		String var6 = "          ".substring(10 - var3);
		String var7 = "          ".substring(10 - var4);
		return "    Size: " + this.field3733 + var5 + "Created: " + this.field3730 + var7 + "Total used: " + this.field3731 + var6 + "Max-In-Use: " + this.field3732;
	}
}