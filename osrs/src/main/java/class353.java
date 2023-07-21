import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nr")
public enum class353 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lnr;"
	)
	field3469(-1),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lnr;"
	)
	field3470(0),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lnr;"
	)
	field3468(1),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lnr;"
	)
	field3467(2);

	@ObfuscatedName("as")
	final int field3471;

	class353(int var3) {
		this.field3471 = var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3471;
	}

	@ObfuscatedName("mu")
	@ObfuscatedSignature(
		descriptor = "(Lmt;III)V",
		garbageValue = "-587359339"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null && class503.method2475(var0) != null) {
				Client.clickedWidget = var0;
				Client.clickedWidgetParent = class503.method2475(var0);
				Client.widgetClickX = var1;
				Client.widgetClickY = var2;
				class130.widgetDragDuration = 0;
				Client.isDraggingWidget = false;
				int var3 = class59.method323();
				if (var3 != -1) {
					Language.method1943(var3);
				}

			}
		}
	}
}
