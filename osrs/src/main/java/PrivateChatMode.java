import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ub")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lub;"
	)
	static final PrivateChatMode field4273;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lub;"
	)
	public static final PrivateChatMode field4271;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lub;"
	)
	static final PrivateChatMode field4272;
	@ObfuscatedName("at")
	@Export("id")
	public final int id;

	static {
		field4273 = new PrivateChatMode(0);
		field4271 = new PrivateChatMode(1);
		field4272 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.id = var1;
	}
}