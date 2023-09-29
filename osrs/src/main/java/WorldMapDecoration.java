import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("ac")
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("al")
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("ak")
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1531578947"
	)
	static final void method1567() {
		for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0.endCycle == -1) {
				var0.startCycle = 0;
				GrandExchangeOfferOwnWorldComparator.method350(var0);
			} else {
				var0.remove();
			}
		}

	}
}