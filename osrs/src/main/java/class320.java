import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mm")
public class class320 {
	@ObfuscatedName("at")
	int field2841;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lcg;"
	)
	class53 field2840;

	@ObfuscatedSignature(
		descriptor = "(ILcg;)V"
	)
	class320(int var1, class53 var2) {
		this.field2841 = var1;
		this.field2840 = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)[Loc;",
		garbageValue = "48"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.field3523, PlayerType.PlayerType_playerModerator, PlayerType.field3518, PlayerType.PlayerType_normal, PlayerType.field3519, PlayerType.field3515, PlayerType.field3526, PlayerType.PlayerType_hardcoreIronman, PlayerType.field3529, PlayerType.PlayerType_ironman, PlayerType.PlayerType_ultimateIronman, PlayerType.field3521, PlayerType.PlayerType_jagexModerator, PlayerType.field3517, PlayerType.field3527, PlayerType.field3528, PlayerType.field3513};
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "194"
	)
	static void method1707() {
		class74.Tiles_underlays = null;
		Interpreter.Tiles_overlays = null;
		ViewportMouse.Tiles_shapes = null;
		class369.field3559 = null;
		class344.field3130 = null;
		class93.field948 = null;
		Tiles.field843 = null;
		class337.Tiles_hue = null;
		Tiles.Tiles_saturation = null;
		class185.Tiles_lightness = null;
		MenuAction.Tiles_hueMultiplier = null;
		WorldMapLabelSize.field1943 = null;
	}

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1466473405"
	)
	static void method1708() {
		if (Client.field387) {
			AccessFile.addPlayerToScene(class229.localPlayer, false);
		}

	}
}