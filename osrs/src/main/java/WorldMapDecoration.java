import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("qd")
	@ObfuscatedSignature(
		descriptor = "[Lmt;"
	)
	static Widget[] field2419;
	@ObfuscatedName("aw")
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("ay")
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("ar")
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}
}
