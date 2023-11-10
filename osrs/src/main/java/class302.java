import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
public class class302 {
	@ObfuscatedName("wx")
	@ObfuscatedSignature(
		descriptor = "Lrg;"
	)
	static ArchiveDisk field2511;
	@ObfuscatedName("up")
	static int field2510;

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(Lnn;IIB)V",
		garbageValue = "51"
	)
	public static void method1626(Widget var0, int var1, int var2) {
		PlayerComposition var3 = var0.field3125;
		boolean var4 = var2 != var3.field2947;
		var3.field2947 = var2;
		if (var4) {
			int var5;
			int var7;
			if (var3.field2947 == var1) {
				for (var5 = 0; var5 < PlayerComposition.equipmentIndices.length; ++var5) {
					var7 = PlayerComposition.equipmentIndices[var5];
					if (var3.equipment[var7] > 0 && var3.equipment[var7] < 512) {
						var3.equipment[var7] = var3.field2944[var7];
					}
				}
			} else {
				label62: {
					if (var3.equipment[0] >= 512) {
						boolean var8;
						if (var3.equipment[0] < 512) {
							var8 = false;
						} else {
							ItemComposition var6 = class214.ItemDefinition_get(var3.equipment[0] - 512);
							var8 = var6.maleModel1 != class205.field1815.field1824 && var6.maleModel2 != class205.field1815.field1824;
						}

						if (!var8) {
							break label62;
						}
					}

					var3.equipment[class205.field1815.field1824] = 1;
				}

				for (var5 = 0; var5 < 7; ++var5) {
					var7 = PlayerComposition.equipmentIndices[var5];
					if (var3.equipment[var7] > 0 && var3.equipment[var7] < 512) {
						MoveSpeed.method1167(var2, var3.equipment, var5);
					}
				}
			}
		}

		var3.method1756();
	}

	@ObfuscatedName("nb")
	@ObfuscatedSignature(
		descriptor = "(Ldc;ZB)V",
		garbageValue = "-113"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1) {
			HealthBarDefinition.widgetDefinition.method1736(var2);
		}

		for (IntegerNode var4 = (IntegerNode)Client.widgetFlags.first(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.next()) {
			if ((var4.key >> 48 & 65535L) == (long)var2) {
				var4.remove();
			}
		}

		Widget var5 = HealthBarDefinition.widgetDefinition.method1733(var3);
		if (var5 != null) {
			class159.invalidateWidget(var5);
		}

		if (Client.rootInterface != -1) {
			class514.runIntfCloseListener(Client.rootInterface, 1);
		}

	}
}