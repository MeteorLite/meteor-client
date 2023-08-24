import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rc")
public class class452 {
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lpi;"
	)
	@Export("ItemDefinition_fontPlain11")
	public static Font ItemDefinition_fontPlain11;
	@ObfuscatedName("aj")
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("au")
	float[] field3891;
	@ObfuscatedName("ae")
	int field3892;

	class452(float[] var1, int var2) {
		this.field3891 = var1;
		this.field3892 = var2;
	}
}