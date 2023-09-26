import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		descriptor = "[Lun;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;
	@ObfuscatedName("ac")
	@Export("plane")
	int plane;
	@ObfuscatedName("al")
	@Export("type")
	int type;
	@ObfuscatedName("ak")
	@Export("x")
	int x;
	@ObfuscatedName("ax")
	@Export("y")
	int y;
	@ObfuscatedName("ao")
	@Export("objectId")
	int objectId;
	@ObfuscatedName("ah")
	int field947;
	@ObfuscatedName("ar")
	int field953;
	@ObfuscatedName("ab")
	@Export("id")
	int id;
	@ObfuscatedName("am")
	@Export("rotation")
	int rotation;
	@ObfuscatedName("av")
	@Export("objectType")
	int objectType;
	@ObfuscatedName("ag")
	int field946;
	@ObfuscatedName("ap")
	int field952;
	@ObfuscatedName("ay")
	@Export("startCycle")
	int startCycle;
	@ObfuscatedName("as")
	@Export("endCycle")
	int endCycle;

	PendingSpawn() {
		this.field952 = 31;
		this.startCycle = 0;
		this.endCycle = -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1554580645"
	)
	void method506(int var1) {
		this.field952 = var1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "585710320"
	)
	boolean method507(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field952 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "-121"
	)
	static final void method508(String var0) {
		class436.method2211(var0 + " is already on your friend list");
	}

	@ObfuscatedName("lq")
	@ObfuscatedSignature(
		descriptor = "([Lnm;Lnm;ZB)V",
		garbageValue = "-37"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth * -935068743 * -231105911 : var1.width * -2052421073 * -1523778353;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight * -356890711 * -111326055 : var1.height * -2112445931 * -503112387;
		class360.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			class360.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			int var6 = var5.group;
			if (class33.field89.method1742(var6)) {
				class360.resizeInterface(class33.field89.Widget_interfaceComponents[var6], -1, var3, var4, var2);
			}
		}

		if (var1.contentType == 1337) {
		}

	}
}