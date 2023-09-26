import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("ac")
	@Export("x")
	int x;
	@ObfuscatedName("al")
	@Export("y")
	int y;
	@ObfuscatedName("ak")
	@Export("z")
	int z;

	FaceNormal() {
	}

	@ObfuscatedName("mo")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-2079902231"
	)
	static final int method1334() {
		float var0 = 200.0F * ((float)class91.clientPreferences.getBrightness() - 0.5F);
		return 100 - Math.round(var0);
	}
}