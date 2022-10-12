import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("LoginPacket")
public class LoginPacket implements class271 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Lja;"
	)
	public static final LoginPacket field3247;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lja;"
	)
	static final LoginPacket field3245;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lja;"
	)
	public static final LoginPacket field3251;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Lja;"
	)
	public static final LoginPacket field3246;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Lja;"
	)
	public static final LoginPacket field3248;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "Lja;"
	)
	static final LoginPacket field3249;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "[Lja;"
	)
	static final LoginPacket[] field3244;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -781023195
	)
	@Export("id")
	public final int id;

	static {
		field3247 = new LoginPacket(14, 0);
		field3245 = new LoginPacket(15, 4);
		field3251 = new LoginPacket(16, -2);
		field3246 = new LoginPacket(18, -2);
		field3248 = new LoginPacket(19, -2);
		field3249 = new LoginPacket(27, 0);
		field3244 = new LoginPacket[32];
		LoginPacket[] var0 = new LoginPacket[]{field3246, field3251, field3248, field3249, field3245, field3247};
		LoginPacket[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			field3244[var1[var2].id] = var1[var2];
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
