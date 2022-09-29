import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class134 extends class129 {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1271767891
	)
	int field1592;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -695677663
	)
	int field1591;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -768466047
	)
	int field1594;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -353550851
	)
	int field1593;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Leo;"
	)
	final class132 this$0;

	@ObfuscatedSignature(
		descriptor = "(Leo;)V"
	)
	class134(class132 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)V",
		garbageValue = "-41"
	)
	void vmethod3320(Buffer var1) {
		this.field1592 = var1.readInt();
		this.field1593 = var1.readInt();
		this.field1591 = var1.readUnsignedByte();
		this.field1594 = var1.readUnsignedByte();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Led;I)V",
		garbageValue = "-538131930"
	)
	void vmethod3313(ClanSettings var1) {
		var1.method3160(this.field1592, this.field1593, this.field1591, this.field1594);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;ZB)[B",
		garbageValue = "-126"
	)
	public static byte[] method3043(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var3 = (byte[])((byte[])var0);
			return var1 ? BuddyRankComparator.method2790(var3) : var3;
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("ll")
	@ObfuscatedSignature(
		descriptor = "(IIIB)Lcv;",
		garbageValue = "1"
	)
	static final InterfaceParent method3053(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		MouseHandler.Widget_resetModelFrames(var1);
		Widget var4 = SpotAnimationDefinition.getWidget(var0);
		class403.invalidateWidget(var4);
		if (Client.meslayerContinueWidget != null) {
			class403.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		StructComposition.revalidateWidgetScroll(Calendar.Widget_interfaceComponents[var0 >> 16], var4, false);
		class11.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			class18.runIntfCloseListeners(Client.rootInterface, 1);
		}

		return var3;
	}
}
