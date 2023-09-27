import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("hr")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lhr;"
	)
	field1643(1, 0),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lhr;"
	)
	@Export("VerticalAlignment_centered")
	VerticalAlignment_centered(0, 1),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lhr;"
	)
	field1644(2, 2);

	@ObfuscatedName("tb")
	@ObfuscatedSignature(
		descriptor = "Lgi;"
	)
	@Export("guestClanSettings")
	static ClanSettings guestClanSettings;
	@ObfuscatedName("ax")
	@Export("value")
	public final int value;
	@ObfuscatedName("ao")
	@Export("id")
	final int id;

	VerticalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "900742897"
	)
	@Export("runWidgetOnLoadListener")
	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (class33.widgetDefinition.loadInterface(var0)) {
				Widget[] var1 = class33.widgetDefinition.Widget_interfaceComponents[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoad != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.args = var3.onLoad;
						ArchiveDisk.runScript(var4, 5000000, 0);
					}
				}

			}
		}
	}

	@ObfuscatedName("na")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1054734987"
	)
	static final void method1027() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsFriend();
		}

		Iterator var2 = Messages.Messages_hashTable.iterator();

		while (var2.hasNext()) {
			Message var3 = (Message)var2.next();
			var3.clearIsFromFriend();
		}

		if (class358.friendsChat != null) {
			class358.friendsChat.clearFriends();
		}

	}
}