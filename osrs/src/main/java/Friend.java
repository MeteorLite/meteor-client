import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qo")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("au")
	boolean field3794;
	@ObfuscatedName("ae")
	boolean field3793;

	Friend() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lqo;I)I",
		garbageValue = "-1434956269"
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
		} else if (this.field3794 && !var1.field3794) {
			return -1;
		} else if (!this.field3794 && var1.field3794) {
			return 1;
		} else if (this.field3793 && !var1.field3793) {
			return -1;
		} else if (!this.field3793 && var1.field3793) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lqs;I)I",
		garbageValue = "1756748027"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareToFriend((Friend)var1);
	}

	@ObfuscatedName("compareTo")
	public int compareTo(Object var1) {
		return this.compareToFriend((Friend)var1);
	}
}