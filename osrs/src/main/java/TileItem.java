import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("TileItem")
public final class TileItem extends Renderable {
	@ObfuscatedName("at")
	@Export("id")
	int id;
	@ObfuscatedName("ah")
	@Export("quantity")
	int quantity;
	@ObfuscatedName("ao")
	int field1110;

	TileItem() {
		this.field1110 = 31;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-2048402866"
	)
	void method609(int var1) {
		this.field1110 = var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Lka;",
		garbageValue = "1"
	)
	@Export("getModel")
	protected final Model getModel() {
		return class214.ItemDefinition_get(this.id).getModel(this.quantity);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "117367628"
	)
	boolean method610(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field1110 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(CLof;I)C",
		garbageValue = "938832228"
	)
	@Export("standardizeChar")
	static char standardizeChar(char var0, Language var1) {
		if (var0 >= 192 && var0 <= 255) {
			if (var0 >= 192 && var0 <= 198) {
				return 'A';
			}

			if (var0 == 199) {
				return 'C';
			}

			if (var0 >= 200 && var0 <= 203) {
				return 'E';
			}

			if (var0 >= 204 && var0 <= 207) {
				return 'I';
			}

			if (var0 == 209 && var1 != Language.Language_ES) {
				return 'N';
			}

			if (var0 >= 210 && var0 <= 214) {
				return 'O';
			}

			if (var0 >= 217 && var0 <= 220) {
				return 'U';
			}

			if (var0 == 221) {
				return 'Y';
			}

			if (var0 == 223) {
				return 's';
			}

			if (var0 >= 224 && var0 <= 230) {
				return 'a';
			}

			if (var0 == 231) {
				return 'c';
			}

			if (var0 >= 232 && var0 <= 235) {
				return 'e';
			}

			if (var0 >= 236 && var0 <= 239) {
				return 'i';
			}

			if (var0 == 241 && var1 != Language.Language_ES) {
				return 'n';
			}

			if (var0 >= 242 && var0 <= 246) {
				return 'o';
			}

			if (var0 >= 249 && var0 <= 252) {
				return 'u';
			}

			if (var0 == 253 || var0 == 255) {
				return 'y';
			}
		}

		if (var0 == 338) {
			return 'O';
		} else if (var0 == 339) {
			return 'o';
		} else {
			return var0 == 376 ? 'Y' : var0;
		}
	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIIII)V",
		garbageValue = "2136163663"
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
			var10.field957 = -1;
			ScriptFrame.method344(var10);
			Client.pendingSpawns.addFirst(var10);
		}

		var10.id = var4;
		var10.objectType = var5;
		var10.rotation = var6;
		var10.startCycle = var8;
		var10.endCycle = var9;
		var10.method503(var7);
	}
}