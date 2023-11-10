import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class127 {
	@ObfuscatedName("ao")
	public static final float field1219;
	@ObfuscatedName("ab")
	public static final float field1218;
	@ObfuscatedName("au")
	static float[] field1221;
	@ObfuscatedName("aa")
	static float[] field1220;
	@ObfuscatedName("ap")
	@Export("Interpreter_stringStackSize")
	static int Interpreter_stringStackSize;
	@ObfuscatedName("us")
	@Export("cameraLookAtHeight")
	static int cameraLookAtHeight;
	@ObfuscatedName("vz")
	static int field1224;

	static {
		field1219 = Math.ulp(1.0F);
		field1218 = 2.0F * field1219;
		field1221 = new float[4];
		field1220 = new float[5];
	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2049504300"
	)
	static void method692() {
		if (NewShit.worldMap != null) {
			NewShit.worldMap.method2408(ItemLayer.Client_plane, (class229.localPlayer.x >> 7) + NewShit.baseX, (class229.localPlayer.y >> 7) + class101.baseY, false);
			NewShit.worldMap.loadCache();
		}

	}
}