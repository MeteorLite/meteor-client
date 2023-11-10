import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("un")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lun;"
	)
	static final PrivateChatMode field4305;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lun;"
	)
	public static final PrivateChatMode field4303;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lun;"
	)
	static final PrivateChatMode field4304;
	@ObfuscatedName("ao")
	@Export("id")
	public final int id;

	static {
		field4305 = new PrivateChatMode(0);
		field4303 = new PrivateChatMode(1);
		field4304 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.id = var1;
	}
}