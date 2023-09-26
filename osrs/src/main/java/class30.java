import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.imageio.ImageIO;

@ObfuscatedName("be")
public class class30 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	@Export("FloorOverlayDefinition_archive")
	static AbstractArchive FloorOverlayDefinition_archive;

	static {
		ImageIO.setUseCache(false);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)[Lnq;",
		garbageValue = "-42"
	)
	static class360[] method121() {
		return new class360[]{class360.field3179, class360.field3180};
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Ltp;ILjava/lang/String;B)Ljava/lang/String;",
		garbageValue = "42"
	)
	static String method122(IterableNodeHashTable var0, int var1, String var2) {
		if (var0 == null) {
			return var2;
		} else {
			ObjectNode var3 = (ObjectNode)var0.get((long)var1);
			return var3 == null ? var2 : (String)var3.obj;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)[Lsz;",
		garbageValue = "-651272604"
	)
	static class468[] method120() {
		return new class468[]{class468.field3927, class468.field3925, class468.field3926, class468.field3924};
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "2111489575"
	)
	static int method123(int var0, Script var1, boolean var2) {
		Widget var3 = class33.field89.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		if (var0 == 2500) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == 2501) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == 2502) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == 2503) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == 2504) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == 2505) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "106"
	)
	static void method124() {
		if (class434.worldMap != null) {
			class434.worldMap.method2432(class87.Client_plane, (TextureProvider.localPlayer.x >> 7) + class20.baseX, (TextureProvider.localPlayer.y >> 7) + class19.baseY, false);
			class434.worldMap.loadCache();
		}

	}

	@ObfuscatedName("ke")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1209602899"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[class87.Client_plane][var0][var1];
		if (var2 == null) {
			class10.scene.removeGroundItemPile(class87.Client_plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemComposition var7 = class214.ItemDefinition_get(var6.id);
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
				class10.scene.removeGroundItemPile(class87.Client_plane, var0, var1);
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

				long var9 = GrandExchangeOfferAgeComparator.calculateTag(var0, var1, 3, false, 0);
				class10.scene.newGroundItemPile(class87.Client_plane, var0, var1, class115.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class87.Client_plane), var5, var9, var12, var11);
			}
		}
	}
}