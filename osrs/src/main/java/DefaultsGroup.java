import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rk")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lrk;"
	)
	static final DefaultsGroup field3879;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lrk;"
	)
	static final DefaultsGroup field3878;
	@ObfuscatedName("jh")
	@Export("timeOfPreviousKeyPress")
	static int timeOfPreviousKeyPress;
	@ObfuscatedName("ar")
	@Export("group")
	final int group;

	static {
		field3879 = new DefaultsGroup(1);
		field3878 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}
}