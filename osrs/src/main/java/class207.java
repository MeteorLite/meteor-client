import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class207 extends class219 {
	@ObfuscatedName("at")
	String field1826;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	final class208 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lic;Ljava/lang/String;Ljava/lang/String;)V"
	)
	class207(class208 var1, String var2, String var3) {
		super(var1, var2);
		this.this$0 = var1;
		this.field1826 = var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "561834394"
	)
	@Export("vmethod3379")
	public int vmethod3379() {
		return 1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "18"
	)
	@Export("vmethod3380")
	public String vmethod3380() {
		return this.field1826;
	}

	@ObfuscatedName("ah")
	public static boolean method1059(long var0) {
		boolean var2 = var0 != 0L;
		if (var2) {
			boolean var3 = (int)(var0 >>> 16 & 1L) == 1;
			var2 = !var3;
		}

		return var2;
	}
}