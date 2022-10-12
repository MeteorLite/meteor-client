import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rw")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Lrw;"
	)
	static final PrivateChatMode field5002;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lrw;"
	)
	public static final PrivateChatMode field5000;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lrw;"
	)
	static final PrivateChatMode field5001;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 201638827
	)
	public final int field4999;

	static {
		field5002 = new PrivateChatMode(0);
		field5000 = new PrivateChatMode(1);
		field5001 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field4999 = var1;
	}
}
