import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("ay")
	static String field345;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ldh;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("ae")
	@Export("pc")
	int pc;
	@ObfuscatedName("ao")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("at")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}
}