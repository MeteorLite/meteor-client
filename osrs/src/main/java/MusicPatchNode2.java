import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
	@ObfuscatedName("uz")
	@Export("cameraLookAtHeight")
	static int cameraLookAtHeight;
	@ObfuscatedName("au")
	byte[] field2758;
	@ObfuscatedName("ae")
	byte[] field2757;
	@ObfuscatedName("ao")
	int field2762;
	@ObfuscatedName("at")
	int field2764;
	@ObfuscatedName("ac")
	int field2760;
	@ObfuscatedName("ai")
	int field2761;
	@ObfuscatedName("az")
	int field2765;
	@ObfuscatedName("ap")
	int field2763;
	@ObfuscatedName("aa")
	int field2759;

	MusicPatchNode2() {
	}

	@ObfuscatedName("oe")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "31198036"
	)
	static void method1625(int var0) {
		Client.oculusOrbState = var0;
	}
}