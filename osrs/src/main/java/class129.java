import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class129 implements Callable {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lfm;"
	)
	final class130 field1223;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	final class131 field1221;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	final class132 field1222;
	@ObfuscatedName("am")
	final int field1224;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfz;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class137 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfz;Lfm;Lfa;Lfg;I)V"
	)
	class129(class137 var1, class130 var2, class131 var3, class132 var4, int var5) {
		this.this$0 = var1;
		this.field1223 = var2;
		this.field1221 = var3;
		this.field1222 = var4;
		this.field1224 = var5;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		this.field1223.method710();
		class130[][] var1;
		if (this.field1221 == class131.field1256) {
			var1 = this.this$0.field1288;
		} else {
			var1 = this.this$0.field1293;
		}

		var1[this.field1224][this.field1222.method724()] = this.field1223;
		return null;
	}

	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-68"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 30) {
				Client.field594.method1071();
			}

			if (Client.gameState == 0) {
				TileItem.client.method160();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45 || var0 == 50) {
				BuddyRankComparator.method686(0);
				Client.field440 = 0;
				Client.field441 = 0;
				Client.timer.method2115(var0);
				if (var0 != 20) {
					GrandExchangeOfferTotalQuantityComparator.method1911(false);
				}
			}

			if (var0 != 20 && var0 != 40 && UserComparator5.field1175 != null) {
				UserComparator5.field1175.close();
				UserComparator5.field1175 = null;
			}

			if (Client.gameState == 25) {
				Client.field453 = 0;
				Client.field450 = 0;
				Client.field451 = 1;
				Client.field448 = 0;
				Client.field449 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					int var3 = Client.gameState == 11 ? 4 : 0;
					UserComparator10.method682(class131.archive10, class386.archive8, false, var3);
				} else if (var0 == 11) {
					UserComparator10.method682(class131.archive10, class386.archive8, false, 4);
				} else if (var0 == 50) {
					Actor.setLoginResponseString("", "Updating date of birth...", "");
					UserComparator10.method682(class131.archive10, class386.archive8, false, 7);
				} else {
					WorldMapData_0.method1363();
				}
			} else {
				boolean var1 = class150.clientPreferences.method571() >= Client.param21;
				int var2 = var1 ? 0 : 12;
				UserComparator10.method682(class131.archive10, class386.archive8, true, var2);
			}

			Client.gameState = var0;
		}
	}
}
