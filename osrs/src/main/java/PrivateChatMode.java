import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("va")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lva;"
	)
	static final PrivateChatMode field4299;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lva;"
	)
	public static final PrivateChatMode field4298;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lva;"
	)
	static final PrivateChatMode field4300;
	@ObfuscatedName("ax")
	@Export("id")
	public final int id;

	static {
		field4299 = new PrivateChatMode(0);
		field4298 = new PrivateChatMode(1);
		field4300 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.id = var1;
	}
}