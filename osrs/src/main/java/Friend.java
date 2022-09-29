import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ne")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("c")
	boolean field4339;
	@ObfuscatedName("p")
	boolean field4340;

	Friend() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lne;I)I",
		garbageValue = "596588464"
	)
	@Export("compareToFriend")
	int compareToFriend(Friend var1) {
		if (super.world == Client.worldId && Client.worldId != var1.world) {
			return -1;
		} else if (Client.worldId == var1.world && super.world != Client.worldId) {
			return 1;
		} else if (super.world != 0 && var1.world == 0) {
			return -1;
		} else if (var1.world != 0 && super.world == 0) {
			return 1;
		} else if (this.field4339 && !var1.field4339) {
			return -1;
		} else if (!this.field4339 && var1.field4339) {
			return 1;
		} else if (this.field4340 && !var1.field4340) {
			return -1;
		} else if (!this.field4340 && var1.field4340) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lnc;I)I",
		garbageValue = "-1401768476"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareToFriend((Friend)var1);
	}

	public int compareTo(Object var1) {
		return this.compareToFriend((Friend)var1);
	}

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-2137951637"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[Tiles.Client_plane][var0][var1];
		if (var2 == null) {
			MusicPatchNode.scene.removeGroundItemPile(Tiles.Client_plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemComposition var7 = UserComparator3.ItemDefinition_get(var6.id);
				long var11 = (long)var7.price;
				if (var7.isStackable == 1) {
					var11 *= (long)(var6.quantity + 1);
				}

				if (var11 > var3) {
					var3 = var11;
					var5 = var6;
				}
			}

			if (var5 == null) {
				MusicPatchNode.scene.removeGroundItemPile(Tiles.Client_plane, var0, var1);
			} else {
				var2.addLast(var5);
				TileItem var13 = null;
				TileItem var8 = null;

				for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
					if (var6.id != var5.id) {
						if (var13 == null) {
							var13 = var6;
						}

						if (var13.id != var6.id && var8 == null) {
							var8 = var6;
						}
					}
				}

				long var9 = class259.calculateTag(var0, var1, 3, false, 0);
				MusicPatchNode.scene.newGroundItemPile(Tiles.Client_plane, var0, var1, class120.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, Tiles.Client_plane), var5, var9, var13, var8);
			}
		}
	}
}
