import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
	AbstractByteArrayCopier() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(B)[B",
		garbageValue = "56"
	)
	@Export("get")
	abstract byte[] get();

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "([BB)V",
		garbageValue = "1"
	)
	@Export("set")
	public abstract void set(byte[] var1);

	@ObfuscatedName("km")
	@ObfuscatedSignature(
		descriptor = "(Lkw;IIB)V",
		garbageValue = "20"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null) {
				Widget var4 = HitSplatDefinition.method3782(var0);
				if (var4 == null) {
					var4 = var0.parent;
				}

				if (var4 != null) {
					Client.clickedWidget = var0;
					var4 = HitSplatDefinition.method3782(var0);
					if (var4 == null) {
						var4 = var0.parent;
					}

					Client.clickedWidgetParent = var4;
					Client.widgetClickX = var1;
					Client.widgetClickY = var2;
					class259.widgetDragDuration = 0;
					Client.isDraggingWidget = false;
					int var5 = class156.method3411();
					if (var5 != -1) {
						class146.tempMenuAction = new MenuAction();
						class146.tempMenuAction.param0 = Client.menuArguments1[var5];
						class146.tempMenuAction.param1 = Client.menuArguments2[var5];
						class146.tempMenuAction.opcode = Client.menuOpcodes[var5];
						class146.tempMenuAction.identifier = Client.menuIdentifiers[var5];
						class146.tempMenuAction.itemId = Client.menuItemIds[var5];
						class146.tempMenuAction.action = Client.menuActions[var5];
						class146.tempMenuAction.target = Client.menuTargets[var5];
					}

					return;
				}
			}

		}
	}
}
