import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lds;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("al")
	@Export("pc")
	int pc;
	@ObfuscatedName("ak")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("ax")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1603981165"
	)
	public static boolean method334() {
		return !class319.field2789.isEmpty();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lnm;IIII)V",
		garbageValue = "1957450993"
	)
	@Export("Widget_setKeyRate")
	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field3074 == null) {
			throw new RuntimeException();
		} else {
			var0.field3074[var1] = var2;
			var0.field3075[var1] = var3;
		}
	}
}