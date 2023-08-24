import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("VertexNormal")
public class VertexNormal {
	@ObfuscatedName("ul")
	static int field2255;
	@ObfuscatedName("au")
	@Export("x")
	int x;
	@ObfuscatedName("ae")
	@Export("y")
	int y;
	@ObfuscatedName("ao")
	@Export("z")
	int z;
	@ObfuscatedName("at")
	@Export("magnitude")
	int magnitude;

	VertexNormal() {
	}

	@ObfuscatedSignature(
		descriptor = "(Lja;)V"
	)
	VertexNormal(VertexNormal var1) {
		this.x = var1.x;
		this.y = var1.y;
		this.z = var1.z;
		this.magnitude = var1.magnitude;
	}
}