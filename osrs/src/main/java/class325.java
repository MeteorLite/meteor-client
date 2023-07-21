import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("my")
public class class325 {
	@ObfuscatedName("aw")
	public int field2874;
	@ObfuscatedName("ay")
	public int field2875;
	@ObfuscatedName("ar")
	public int field2873;

	class325() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "113"
	)
	static void method1674() {
		Tiles.Tiles_minPlane = 99;
		Tiles.Tiles_underlays = new short[4][104][104];
		Tiles.Tiles_overlays = new short[4][104][104];
		class19.Tiles_shapes = new byte[4][104][104];
		UserComparator10.field1180 = new byte[4][104][104];
		BufferedNetSocket.field3806 = new int[4][105][105];
		InvDefinition.field1488 = new byte[4][105][105];
		class135.field1283 = new int[105][105];
		class172.Tiles_hue = new int[104];
		GameBuild.Tiles_saturation = new int[104];
		Tiles.Tiles_lightness = new int[104];
		Language.Tiles_hueMultiplier = new int[104];
		class159.field1403 = new int[104];
	}
}
