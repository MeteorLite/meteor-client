import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rf")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lrf;"
	)
	static final DefaultsGroup field3830;
	@ObfuscatedName("ay")
	@Export("group")
	final int group;

	static {
		field3830 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}
}
