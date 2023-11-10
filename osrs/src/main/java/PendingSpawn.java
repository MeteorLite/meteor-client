import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.Iterator;

@ObfuscatedName("dp")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("dy")
	static boolean field949;
	@ObfuscatedName("qa")
	static int field950;
	@ObfuscatedName("at")
	@Export("plane")
	int plane;
	@ObfuscatedName("ah")
	@Export("type")
	int type;
	@ObfuscatedName("ar")
	@Export("x")
	int x;
	@ObfuscatedName("ao")
	@Export("y")
	int y;
	@ObfuscatedName("ab")
	@Export("objectId")
	int objectId;
	@ObfuscatedName("au")
	int field961;
	@ObfuscatedName("aa")
	int field951;
	@ObfuscatedName("ac")
	@Export("id")
	int id;
	@ObfuscatedName("al")
	@Export("rotation")
	int rotation;
	@ObfuscatedName("az")
	@Export("objectType")
	int objectType;
	@ObfuscatedName("ap")
	int field957;
	@ObfuscatedName("ax")
	int field962;
	@ObfuscatedName("as")
	@Export("startCycle")
	int startCycle;
	@ObfuscatedName("ay")
	@Export("endCycle")
	int endCycle;

	PendingSpawn() {
		this.field962 = 31;
		this.startCycle = 0;
		this.endCycle = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1592817450"
	)
	void method503(int var1) {
		this.field962 = var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IS)Z",
		garbageValue = "7928"
	)
	boolean method504(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field962 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/ArrayList;IIIIZI)V",
		garbageValue = "1949440150"
	)
	public static void method505(ArrayList var0, int var1, int var2, int var3, int var4, boolean var5) {
		if (!var0.isEmpty()) {
			class316.field2790.clear();
			class316.field2798.clear();
			PacketBufferNode.method1637(var5);
			class30.method131(var0, var5);
			if (!class316.field2790.isEmpty()) {
				EnumComposition.method925(var1, var2, var3, var4);
				class316.field2798.add(new AddRequestTask((SongTask)null));
				class316.field2798.add(new class420((SongTask)null, class316.field2792, class316.field2791, class168.field1428));
				ArrayList var6 = new ArrayList();
				var6.add(new class415(new FadeInTask((SongTask)null, 0, true, class316.field2796)));
				if (!class316.musicSongs.isEmpty()) {
					ArrayList var7 = new ArrayList();
					var7.add(new DelayFadeTask(new ConcurrentMidiTask((SongTask)null, var6), class316.field2795));
					ArrayList var9 = new ArrayList();
					Iterator var10 = class316.musicSongs.iterator();

					while (var10.hasNext()) {
						MusicSong var11 = (MusicSong)var10.next();
						var9.add(var11);
					}

					var7.add(new DelayFadeTask(new FadeOutTask(new class413((SongTask)null, var9), 0, false, class316.field2794), class316.musicPlayerStatus));
					class316.field2798.add(new ConcurrentMidiTask((SongTask)null, var7));
				} else {
					class316.field2798.add(new DelayFadeTask((SongTask)null, class316.field2795));
					class316.field2798.add(new ConcurrentMidiTask((SongTask)null, var6));
				}

			}
		}
	}
}