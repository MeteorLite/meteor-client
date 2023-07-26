import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("TileItem")
public final class TileItem extends Renderable {
	@ObfuscatedName("by")
	@Export("client")
	@ObfuscatedSignature(
		descriptor = "Lclient;"
	)
	static Client client;
	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	@Export("archive7")
	static Archive archive7;
	@ObfuscatedName("aw")
	@Export("id")
	int id;
	@ObfuscatedName("ay")
	@Export("quantity")
	int quantity;
	@ObfuscatedName("am")
	int field1096;

	TileItem() {
		this.field1096 = 31;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2123957786"
	)
	void method613(int var1) {
		this.field1096 = var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Ljo;",
		garbageValue = "-983173466"
	)
	@Export("getModel")
	protected final Model getModel() {
		return class125.ItemDefinition_get(this.id).getModel(this.quantity);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "-83"
	)
	boolean method614(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field1096 & 1 << var1) != 0;
		} else {
			return true;
		}
	}
}
