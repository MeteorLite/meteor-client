import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rh")
@Implements("DefaultsGroup")
public class DefaultsGroup {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lrh;"
	)
	static final DefaultsGroup field3844;
	@ObfuscatedName("ae")
	@Export("group")
	final int group;

	static {
		field3844 = new DefaultsGroup(3);
	}

	DefaultsGroup(int var1) {
		this.group = var1;
	}
}