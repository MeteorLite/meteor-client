import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("UserComparator8")
public class UserComparator8 extends AbstractUserComparator {
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "[Ltl;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("ev")
	@Export("mouseCam")
	static boolean mouseCam;
	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		descriptor = "[Lud;"
	)
	@Export("headIconHintSprites")
	static SpritePixels[] headIconHintSprites;
	@ObfuscatedName("ac")
	@Export("reversed")
	final boolean reversed;

	public UserComparator8(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lri;Lri;B)I",
		garbageValue = "0"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world) {
			if (var2.world != Client.worldId) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world == Client.worldId) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	static final void method669() {
		for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0.endCycle > 0) {
				--var0.endCycle;
			}

			boolean var1;
			int var2;
			int var3;
			ObjectComposition var4;
			if (var0.endCycle == 0) {
				if (var0.objectId >= 0) {
					var2 = var0.objectId;
					var3 = var0.field953;
					var4 = class91.getObjectDefinition(var2);
					if (var3 == 11) {
						var3 = 10;
					}

					if (var3 >= 5 && var3 <= 8) {
						var3 = 4;
					}

					var1 = var4.method1078(var3);
					if (!var1) {
						continue;
					}
				}

				class115.addPendingSpawnToScene(var0.plane, var0.type, var0.x, var0.y, var0.objectId, var0.field947, var0.field953, var0.field946);
				var0.remove();
			} else {
				if (var0.startCycle > 0) {
					--var0.startCycle;
				}

				if (var0.startCycle == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102) {
					if (var0.id >= 0) {
						var2 = var0.id;
						var3 = var0.objectType;
						var4 = class91.getObjectDefinition(var2);
						if (var3 == 11) {
							var3 = 10;
						}

						if (var3 >= 5 && var3 <= 8) {
							var3 = 4;
						}

						var1 = var4.method1078(var3);
						if (!var1) {
							continue;
						}
					}

					class115.addPendingSpawnToScene(var0.plane, var0.type, var0.x, var0.y, var0.id, var0.rotation, var0.objectType, var0.field946);
					var0.startCycle = -1;
					if (var0.objectId == var0.id && var0.objectId == -1) {
						var0.remove();
					} else if (var0.objectId == var0.id && var0.rotation == var0.field947 && var0.objectType == var0.field953) {
						var0.remove();
					}
				}
			}
		}

	}
}