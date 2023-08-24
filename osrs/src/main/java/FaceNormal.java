import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("iq")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("au")
	@Export("x")
	int x;
	@ObfuscatedName("ae")
	@Export("y")
	int y;
	@ObfuscatedName("ao")
	@Export("z")
	int z;

	FaceNormal() {
	}
}