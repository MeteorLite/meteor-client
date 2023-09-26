import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rr")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("ac")
	public int field3826;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lvf;"
	)
	@Export("friendUsername")
	public Username friendUsername;
	@ObfuscatedName("ak")
	@Export("worldId")
	public short worldId;

	@ObfuscatedSignature(
		descriptor = "(Lvf;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3826 = (int)(GrandExchangeOfferTotalQuantityComparator.method1971() / 1000L);
		this.friendUsername = var1;
		this.worldId = (short)var2;
	}
}