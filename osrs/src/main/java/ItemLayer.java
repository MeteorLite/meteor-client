import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("ItemLayer")
public final class ItemLayer {
	@ObfuscatedName("ac")
	@Export("z")
	int z;
	@ObfuscatedName("al")
	@Export("x")
	int x;
	@ObfuscatedName("ak")
	@Export("y")
	int y;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Ljy;"
	)
	@Export("first")
	Renderable first;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ljy;"
	)
	@Export("second")
	Renderable second;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ljy;"
	)
	@Export("third")
	Renderable third;
	@ObfuscatedName("ar")
	@Export("tag")
	long tag;
	@ObfuscatedName("ab")
	@Export("height")
	int height;

	ItemLayer() {
	}
}