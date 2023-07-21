import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ut")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lut;"
	)
	static final PrivateChatMode field4229;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lut;"
	)
	public static final PrivateChatMode field4227;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lut;"
	)
	static final PrivateChatMode field4228;
	@ObfuscatedName("am")
	@Export("id")
	public final int id;

	static {
		field4229 = new PrivateChatMode(0);
		field4227 = new PrivateChatMode(1);
		field4228 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.id = var1;
	}
}
