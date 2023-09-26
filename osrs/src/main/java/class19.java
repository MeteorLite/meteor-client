import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.concurrent.Callable;

@ObfuscatedName("ae")
public class class19 implements Callable {
	@ObfuscatedName("jj")
	@Export("baseY")
	static int baseY;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lag;"
	)
	final class10 field54;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Las;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class14 this$0;

	@ObfuscatedSignature(
		descriptor = "(Las;Lag;)V"
	)
	class19(class14 var1, class10 var2) {
		this.this$0 = var1;
		this.field54 = var2;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() throws Exception {
		try {
			while (this.field54.method34()) {
				Players.method623(10L);
			}
		} catch (IOException var2) {
			return new class20("Error servicing REST query: " + var2.getMessage());
		}

		return this.field54.method35();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "44"
	)
	static void method67(String var0, String var1, String var2) {
		GameEngine.method166(7);
		AbstractWorldMapIcon.setLoginResponseString(var0, var1, var2);
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "770676496"
	)
	protected static final void method66() {
		class314.clock.mark();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.graphicsTickTimes[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.clientTickTimes[var0] = 0L;
		}

		class160.gameCyclesToDo = 0;
	}

	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIIIB)V",
		garbageValue = "-11"
	)
	@Export("updatePendingSpawn")
	static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
		PendingSpawn var10 = null;

		for (PendingSpawn var11 = (PendingSpawn)Client.pendingSpawns.last(); var11 != null; var11 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var11.plane && var11.x == var1 && var2 == var11.y && var3 == var11.type) {
				var10 = var11;
				break;
			}
		}

		if (var10 == null) {
			var10 = new PendingSpawn();
			var10.plane = var0;
			var10.type = var3;
			var10.x = var1;
			var10.y = var2;
			var10.field946 = -1;
			GrandExchangeOfferOwnWorldComparator.method350(var10);
			Client.pendingSpawns.addFirst(var10);
		}

		var10.id = var4;
		var10.objectType = var5;
		var10.rotation = var6;
		var10.startCycle = var8;
		var10.endCycle = var9;
		var10.method506(var7);
	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-1266586426"
	)
	static final void method69(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
			if (Client.rootWidgetXs[var4] + Client.rootWidgetWidths[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetYs[var4] + Client.rootWidgetHeights[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
				Client.field408[var4] = true;
			}
		}

	}
}