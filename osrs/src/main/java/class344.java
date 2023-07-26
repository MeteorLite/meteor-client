import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("na")
public final class class344 {
	@ObfuscatedName("ar")
	static int field3132;
	@ObfuscatedName("ab")
	static int field3131;
	@ObfuscatedName("ru")
	@ObfuscatedSignature(
		descriptor = "Ltp;"
	)
	@Export("HitSplatDefinition_cached")
	static class498 HitSplatDefinition_cached;

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-512665068"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[class36.Client_plane][var0][var1];
		if (var2 == null) {
			UserComparator5.scene.removeGroundItemPile(class36.Client_plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemComposition var7 = class125.ItemDefinition_get(var6.id);
				long var8 = (long)var7.price;
				if (var7.isStackable == 1) {
					var8 *= var6.quantity < Integer.MAX_VALUE ? (long)(var6.quantity + 1) : (long)var6.quantity;
				}

				if (var8 > var3) {
					var3 = var8;
					var5 = var6;
				}
			}

			if (var5 == null) {
				UserComparator5.scene.removeGroundItemPile(class36.Client_plane, var0, var1);
			} else {
				var2.addLast(var5);
				TileItem var12 = null;
				TileItem var11 = null;

				for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
					if (var5.id != var6.id) {
						if (var12 == null) {
							var12 = var6;
						}

						if (var6.id != var12.id && var11 == null) {
							var11 = var6;
						}
					}
				}

				long var9 = BufferedNetSocket.calculateTag(var0, var1, 3, false, 0);
				UserComparator5.scene.newGroundItemPile(class36.Client_plane, var0, var1, class306.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class36.Client_plane), var5, var9, var12, var11);
			}
		}
	}
}
