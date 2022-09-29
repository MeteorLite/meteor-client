import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ni")
public class class370 extends Link {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 278788719
	)
	public int field4346;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lqo;"
	)
	public Username field4345;
	@ObfuscatedName("f")
	public short field4347;

	@ObfuscatedSignature(
		descriptor = "(Lqo;I)V"
	)
	class370(Username var1, int var2) {
		this.field4346 = (int)(Language.method6232() / 1000L);
		this.field4345 = var1;
		this.field4347 = (short)var2;
	}

	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		descriptor = "(Lkw;Lgk;IIZB)V",
		garbageValue = "33"
	)
	@Export("addWidgetItemMenuItem")
	static final void addWidgetItemMenuItem(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			class399.insertMenuItem(var7, SoundCache.colorStartTag(16748608) + var1.name, var6, 0, var2, var0.id, var1.id, var4);
		}

	}
}
