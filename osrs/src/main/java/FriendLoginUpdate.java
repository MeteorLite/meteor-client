import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qg")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("la")
	@Export("oculusOrbFocalPointX")
	static int oculusOrbFocalPointX;
	@ObfuscatedName("au")
	public int field3796;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Luc;"
	)
	@Export("friendUsername")
	public Username friendUsername;
	@ObfuscatedName("ao")
	@Export("worldId")
	public short worldId;

	@ObfuscatedSignature(
		descriptor = "(Luc;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3796 = (int)(GameEngine.clockNow() / 1000L);
		this.friendUsername = var1;
		this.worldId = (short)var2;
	}
}