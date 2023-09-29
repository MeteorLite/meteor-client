import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("ac")
	@Export("text")
	String text;
	@ObfuscatedName("al")
	@Export("width")
	int width;
	@ObfuscatedName("ak")
	@Export("height")
	int height;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lka;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IILka;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1591685204"
	)
	public static int method1569(int var0) {
		var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
		var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
		var0 = var0 + (var0 >>> 4) & 252645135;
		var0 += var0 >>> 8;
		var0 += var0 >>> 16;
		return var0 & 255;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(IIIB)I",
		garbageValue = "-26"
	)
	static int method1570(int var0, int var1, int var2) {
		if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 8) != 0) {
			return 0;
		} else {
			return var0 > 0 && (Tiles.Tiles_renderFlags[1][var1][var2] & 2) != 0 ? var0 - 1 : var0;
		}
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		descriptor = "(Ldc;I)V",
		garbageValue = "-1071136907"
	)
	static void method1571(NPC var0) {
		var0.field971 = var0.definition.size;
		var0.field1020 = var0.definition.rotation;
		var0.walkSequence = var0.definition.walkSequence;
		var0.walkBackSequence = var0.definition.walkBackSequence;
		var0.walkLeftSequence = var0.definition.walkLeftSequence;
		var0.walkRightSequence = var0.definition.walkRightSequence;
		var0.idleSequence = var0.definition.idleSequence;
		var0.turnLeftSequence = var0.definition.turnLeftSequence;
		var0.turnRightSequence = var0.definition.turnRightSequence;
		var0.runSequence = var0.definition.runSequence;
		var0.runBackSequence = var0.definition.runBackSequence;
		var0.runLeftSequence = var0.definition.runLeftSequence;
		var0.runRightSequence = var0.definition.runRightSequence;
		var0.crawlSequence = var0.definition.crawlSequence;
		var0.crawlBackSequence = var0.definition.crawlBackSequence;
		var0.crawlLeftSequence = var0.definition.crawlLeftSequence;
		var0.crawlRightSequence = var0.definition.crawlRightSequence;
	}
}