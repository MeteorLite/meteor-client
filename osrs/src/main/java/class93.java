import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class93 {
	@ObfuscatedName("ac")
	static byte[][][] field948;

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "60"
	)
	public static int method501() {
		return ViewportMouse.ViewportMouse_entityCount;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "1385698501"
	)
	public static int method500(int var0, int var1, int var2) {
		int var3 = class214.method1092(var2 - var1 + 1);
		var3 <<= var1;
		return var0 & ~var3;
	}

	@ObfuscatedName("md")
	@ObfuscatedSignature(
		descriptor = "(Lnn;I)V",
		garbageValue = "-296278834"
	)
	static final void method502(Widget var0) {
		String var1;
		int var2;
		int var3;
		if (var0.buttonType == 1) {
			var1 = var0.buttonText;
			var2 = var0.id;
			var3 = var0.itemId;
			GrandExchangeOfferTotalQuantityComparator.insertMenuItem(var1, "", 24, 0, 0, var2, var3, false);
		}

		if (var0.buttonType == 2 && !Client.isSpellSelected) {
			var1 = class89.Widget_getSpellActionName(var0);
			if (var1 != null) {
				KeyHandler.method106(var1, class167.colorStartTag(65280) + var0.field3122, 25, 0, -1, var0.id, var0.itemId);
			}
		}

		if (var0.buttonType == 3) {
			WorldMapSectionType.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
		}

		if (var0.buttonType == 4) {
			WorldMapSectionType.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
		}

		if (var0.buttonType == 5) {
			WorldMapSectionType.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
		}

		if (var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
			WorldMapSectionType.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
		}

		if (var0.isIf3) {
			int var5;
			String var9;
			if (Client.isSpellSelected) {
				var2 = class361.getWidgetFlags(var0);
				boolean var8 = (var2 >> 21 & 1) != 0;
				if (var8 && (UrlRequest.field1182 & 32) == 32) {
					var9 = Client.field599;
					String var4 = Client.field598 + " " + "->" + " " + var0.dataText;
					var5 = var0.childIndex;
					int var6 = var0.id;
					int var7 = var0.itemId;
					GrandExchangeOfferTotalQuantityComparator.insertMenuItem(var9, var4, 58, 0, var5, var6, var7, false);
				}
			} else {
				String var10;
				for (int var13 = 9; var13 >= 5; --var13) {
					if (!GraphicsObject.method428(class361.getWidgetFlags(var0), var13) && var0.onOp == null) {
						var10 = null;
					} else if (var0.actions != null && var0.actions.length > var13 && var0.actions[var13] != null && var0.actions[var13].trim().length() != 0) {
						var10 = var0.actions[var13];
					} else {
						var10 = null;
					}

					if (var10 != null) {
						KeyHandler.method106(var10, var0.dataText, 1007, var13 + 1, var0.childIndex, var0.id, var0.itemId);
					}
				}

				var1 = class89.Widget_getSpellActionName(var0);
				if (var1 != null) {
					var10 = var0.dataText;
					var3 = var0.childIndex;
					int var11 = var0.id;
					var5 = var0.itemId;
					GrandExchangeOfferTotalQuantityComparator.insertMenuItem(var1, var10, 25, 0, var3, var11, var5, false);
				}

				for (var2 = 4; var2 >= 0; --var2) {
					if (!GraphicsObject.method428(class361.getWidgetFlags(var0), var2) && var0.onOp == null) {
						var9 = null;
					} else if (var0.actions != null && var0.actions.length > var2 && var0.actions[var2] != null && var0.actions[var2].trim().length() != 0) {
						var9 = var0.actions[var2];
					} else {
						var9 = null;
					}

					if (var9 != null) {
						GrandExchangeOfferTotalQuantityComparator.insertMenuItem(var9, var0.dataText, 57, var2 + 1, var0.childIndex, var0.id, var0.itemId, var0.prioritizeMenuEntry);
					}
				}

				var3 = class361.getWidgetFlags(var0);
				boolean var12 = (var3 & 1) != 0;
				if (var12) {
					WorldMapSectionType.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
				}
			}
		}

	}
}