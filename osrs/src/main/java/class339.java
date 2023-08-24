import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("na")
public enum class339 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lna;"
	)
	field3117(0),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lna;"
	)
	field3115(1),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lna;"
	)
	field3116(2),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lna;"
	)
	field3113(3),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lna;"
	)
	field3114(4);

	@ObfuscatedName("ai")
	final int field3118;

	class339(int var3) {
		this.field3118 = var3;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3118;
	}

	@ObfuscatedName("nb")
	@ObfuscatedSignature(
		descriptor = "(IIII)Lds;",
		garbageValue = "-800562138"
	)
	@Export("ifOpenSub")
	static final InterfaceParent ifOpenSub(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		class19.Widget_resetModelFrames(var1);
		Widget var4 = class92.getWidget(var0);
		class218.invalidateWidget(var4);
		if (Client.meslayerContinueWidget != null) {
			class218.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		Login.revalidateWidgetScroll(PacketBufferNode.Widget_interfaceComponents[var0 >> 16], var4, false);
		MoveSpeed.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			class385.runIntfCloseListeners(Client.rootInterface, 1);
		}

		return var3;
	}

	@ObfuscatedName("nh")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "18"
	)
	static void method1865(int var0) {
		for (IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
			if ((var1.key >> 48 & 65535L) == (long)var0) {
				var1.remove();
			}
		}

	}
}