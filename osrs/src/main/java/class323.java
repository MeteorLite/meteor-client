import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

@ObfuscatedName("mo")
class class323 implements Callable {
	@ObfuscatedName("vh")
	static int field2851;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lmn;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final MidiPcmStream this$0;
	// $FF: synthetic field
	@Export("val$cancelled")
	@ObfuscatedName("val$cancelled")
	final AtomicBoolean val$cancelled;

	@ObfuscatedSignature(
		descriptor = "(Lmn;Ljava/util/concurrent/atomic/AtomicBoolean;)V"
	)
	class323(MidiPcmStream var1, AtomicBoolean var2) {
		this.this$0 = var1;
		this.val$cancelled = var2;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		PriorityQueue var1 = this.this$0.field2822;

		while (true) {
			class320 var2 = null;
			synchronized(var1) {
				if (var1.isEmpty() || this.val$cancelled.get()) {
					return null;
				}

				var2 = (class320)var1.remove();
			}

			var2.field2840.method304();
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ldo;III)V",
		garbageValue = "1668364198"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1, int var2) {
		Object[] var3 = var0.args;
		Script var4;
		if (class7.isWorldMapEvent(var0.type)) {
			class133.worldMapEvent = (WorldMapEvent)var3[0];
			WorldMapElement var5 = class141.WorldMapElement_get(class133.worldMapEvent.mapElement);
			var4 = ModeWhere.getWorldMapScript(var0.type, var5.objectId, var5.category);
		} else {
			int var6 = (Integer)var3[0];
			var4 = HealthBarUpdate.getScript(var6);
		}

		if (var4 != null) {
			ApproximateRouteStrategy.runScriptLogic(var0, var4, var1, var2);
		}

	}
}