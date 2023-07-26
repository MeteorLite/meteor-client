import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qi")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("aw")
	boolean field3782;
	@ObfuscatedName("ay")
	boolean field3783;

	Friend() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lqi;I)I",
		garbageValue = "-1755487366"
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
		} else if (this.field3782 && !var1.field3782) {
			return -1;
		} else if (!this.field3782 && var1.field3782) {
			return 1;
		} else if (this.field3783 && !var1.field3783) {
			return -1;
		} else if (!this.field3783 && var1.field3783) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lqe;B)I",
		garbageValue = "114"
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
