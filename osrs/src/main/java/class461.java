import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rs")
public class class461 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lrs;"
	)
	public static final class461 field3889;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lrs;"
	)
	static final class461 field3890;
	@ObfuscatedName("ar")
	String field3891;

	static {
		field3889 = new class461("application/json");
		field3890 = new class461("text/plain");
	}

	class461(String var1) {
		this.field3891 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "15"
	)
	public String method2309() {
		return this.field3891;
	}
}
