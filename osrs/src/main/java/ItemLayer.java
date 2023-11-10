import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
@Implements("ItemLayer")
public final class ItemLayer {
	@ObfuscatedName("ht")
	static String field2109;
	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	@Export("fontPlain12")
	static Font fontPlain12;
	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		descriptor = "Luz;"
	)
	@Export("compass")
	static SpritePixels compass;
	@ObfuscatedName("mr")
	@Export("Client_plane")
	static int Client_plane;
	@ObfuscatedName("at")
	@Export("z")
	int z;
	@ObfuscatedName("ah")
	@Export("x")
	int x;
	@ObfuscatedName("ar")
	@Export("y")
	int y;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lkt;"
	)
	@Export("first")
	Renderable first;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lkt;"
	)
	@Export("second")
	Renderable second;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lkt;"
	)
	@Export("third")
	Renderable third;
	@ObfuscatedName("aa")
	@Export("tag")
	long tag;
	@ObfuscatedName("ac")
	@Export("height")
	int height;

	ItemLayer() {
	}
}