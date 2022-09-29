import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("LoginPacket")
public class LoginPacket implements class262 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	public static final LoginPacket field3182;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	static final LoginPacket field3180;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	public static final LoginPacket field3187;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	public static final LoginPacket field3179;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	public static final LoginPacket field3183;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	static final LoginPacket field3181;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "[Ljz;"
	)
	static final LoginPacket[] field3186;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1664223141
	)
	@Export("id")
	public final int id;

	static {
		field3182 = new LoginPacket(14, 0);
		field3180 = new LoginPacket(15, 4);
		field3187 = new LoginPacket(16, -2);
		field3179 = new LoginPacket(18, -2);
		field3183 = new LoginPacket(19, -2);
		field3181 = new LoginPacket(27, 0);
		field3186 = new LoginPacket[32];
		LoginPacket[] var0 = new LoginPacket[]{field3182, field3181, field3183, field3179, field3180, field3187};
		LoginPacket[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			field3186[var1[var2].id] = var1[var2];
		}

	}

	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "0"
	)
	LoginPacket(int var1, int var2) {
		this.id = var1;
	}
}
