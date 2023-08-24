import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
final class class106 implements class323 {
	@ObfuscatedName("ae")
	@Export("javaVersion")
	public static String javaVersion;
	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	static Archive field1107;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("val$cc")
	@ObfuscatedName("val$cc")
	final Widget val$cc;

	@ObfuscatedSignature(
		descriptor = "(Lmi;)V"
	)
	class106(Widget var1) {
		this.val$cc = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "17"
	)
	@Export("vmethod5708")
	public void vmethod5708() {
		if (this.val$cc != null && this.val$cc.method1847().field2900 != null) {
			ScriptEvent var1 = new ScriptEvent();
			var1.method479(this.val$cc);
			var1.setArgs(this.val$cc.method1847().field2900);
			class30.getScriptEvents().addFirst(var1);
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIIB)I",
		garbageValue = "-47"
	)
	static final int method617(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}
}