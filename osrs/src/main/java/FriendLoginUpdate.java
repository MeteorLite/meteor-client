import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qt")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("aw")
	public int field3784;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lui;"
	)
	@Export("friendUsername")
	public Username friendUsername;
	@ObfuscatedName("ar")
	@Export("worldId")
	public short worldId;

	@ObfuscatedSignature(
		descriptor = "(Lui;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3784 = (int)(class113.clockNow() / 1000L);
		this.friendUsername = var1;
		this.worldId = (short)var2;
	}

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1532325121"
	)
	static final void method2176() {
		Client.field485 = 0;
		int var0 = (class136.localPlayer.x >> 7) + AbstractArchive.baseX;
		int var1 = (class136.localPlayer.y >> 7) + class148.baseY;
		if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
			Client.field485 = 1;
		}

		if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
			Client.field485 = 1;
		}

		if (Client.field485 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
			Client.field485 = 0;
		}

	}
}
