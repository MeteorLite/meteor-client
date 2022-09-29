import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class97 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1307;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1306;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1308;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1313;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1309;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1311;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1312;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1305;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1310;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1314;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1315;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1316;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1317;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "Lci;"
	)
	static final class97 field1318;
	@ObfuscatedName("fi")
	@ObfuscatedGetter(
		intValue = -702734009
	)
	static int field1320;
	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		descriptor = "[Lqi;"
	)
	@Export("mapMarkerSprites")
	static SpritePixels[] mapMarkerSprites;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -323102541
	)
	int field1319;

	static {
		field1307 = new class97(0);
		field1306 = new class97(1);
		field1308 = new class97(2);
		field1313 = new class97(3);
		field1309 = new class97(4);
		field1311 = new class97(5);
		field1312 = new class97(6);
		field1305 = new class97(7);
		field1310 = new class97(8);
		field1314 = new class97(9);
		field1315 = new class97(10);
		field1316 = new class97(11);
		field1317 = new class97(12);
		field1318 = new class97(13);
	}

	class97(int var1) {
		this.field1319 = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(B)[Ldc;",
		garbageValue = "44"
	)
	static class124[] method2586() {
		return new class124[]{class124.field1531, class124.field1528, class124.field1525, class124.field1523, class124.field1527, class124.field1526, class124.field1529, class124.field1530, class124.field1524};
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	public static void method2584() {
		SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
		SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-40"
	)
	public static void method2587() {
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
	}

	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "27"
	)
	static final void method2585() {
		Scene.Scene_isLowDetail = false;
		Client.isLowDetail = false;
	}

	@ObfuscatedName("ld")
	@ObfuscatedSignature(
		descriptor = "(Lkw;I)I",
		garbageValue = "1838036367"
	)
	@Export("getWidgetFlags")
	static int getWidgetFlags(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.childIndex);
		return var1 != null ? var1.integer : var0.flags;
	}
}
