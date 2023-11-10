import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class182 extends DualNode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	static EvictingDualNodeHashTable field1502;

	static {
		field1502 = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-419579110"
	)
	@Export("ItemContainer_getCount")
	static int ItemContainer_getCount(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}

	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-66"
	)
	static void method921() {
		ItemLayer.compass = null;
		class11.redHintArrowSprite = null;
		VarpDefinition.mapSceneSprites = null;
		UrlRequest.headIconPkSprites = null;
		AbstractByteArrayCopier.headIconPrayerSprites = null;
		class60.headIconHintSprites = null;
		class12.mapMarkerSprites = null;
		VarpDefinition.crossSprites = null;
		HorizontalAlignment.mapDotSprites = null;
		class31.scrollBarSprites = null;
		class134.field1307 = null;
	}
}