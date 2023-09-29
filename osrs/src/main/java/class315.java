import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mm")
public final class class315 {
	@ObfuscatedName("al")
	static long field2773;

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(FFFFLfz;B)V",
		garbageValue = "0"
	)
	static void method1654(float var0, float var1, float var2, float var3, class132 var4) {
		float var5 = var1 - var0;
		float var6 = var2 - var1;
		float var7 = var3 - var2;
		float var8 = var6 - var5;
		var4.field1240 = var7 - var6 - var8;
		var4.field1242 = var8 + var8 + var8;
		var4.field1249 = var5 + var5 + var5;
		var4.field1244 = var0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1734109525"
	)
	public static void method1655() {
		ItemComposition.ItemDefinition_cached.clear();
		ItemComposition.HealthBarDefinition_cachedSprites.clear();
		ItemComposition.ItemDefinition_cachedSprites.clear();
	}
}