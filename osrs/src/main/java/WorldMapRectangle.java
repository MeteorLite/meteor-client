import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("ac")
	@Export("width")
	int width;
	@ObfuscatedName("al")
	@Export("height")
	int height;
	@ObfuscatedName("ak")
	@Export("x")
	int x;
	@ObfuscatedName("ax")
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lkk;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		descriptor = "(Lkk;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}
}