import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class128 extends class129 {
	@ObfuscatedName("ak")
	static Image field1561;
	@ObfuscatedName("hd")
	@ObfuscatedGetter(
		intValue = -1981589143
	)
	@Export("baseX")
	static int baseX;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 153057193
	)
	int field1558;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Leo;"
	)
	final class132 this$0;

	@ObfuscatedSignature(
		descriptor = "(Leo;)V"
	)
	class128(class132 var1) {
		this.this$0 = var1;
		this.field1558 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)V",
		garbageValue = "-41"
	)
	void vmethod3320(Buffer var1) {
		this.field1558 = var1.readUnsignedShort();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Led;I)V",
		garbageValue = "-538131930"
	)
	void vmethod3313(ClanSettings var1) {
		var1.method3146(this.field1558);
	}

	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-371587618"
	)
	static int method3003() {
		if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
			int var0 = 0;

			for (int var1 = 0; var1 <= Client.archiveLoadersDone; ++var1) {
				var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
			}

			return var0 * 10000 / Client.field613;
		} else {
			return 10000;
		}
	}

	@ObfuscatedName("id")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "1935735857"
	)
	@Export("selectSpell")
	static void selectSpell(int var0, int var1, int var2, int var3) {
		Widget var4 = JagexCache.getWidgetChild(var0, var1);
		if (var4 != null && var4.onTargetEnter != null) {
			ScriptEvent var5 = new ScriptEvent();
			var5.widget = var4;
			var5.args = var4.onTargetEnter;
			class348.runScriptEvent(var5);
		}

		Client.selectedSpellItemId = var3;
		Client.isSpellSelected = true;
		ClanSettings.selectedSpellWidget = var0;
		Client.selectedSpellChildIndex = var1;
		UrlRequest.selectedSpellFlags = var2;
		class403.invalidateWidget(var4);
	}
}
