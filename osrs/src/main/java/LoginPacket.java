import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
@Implements("LoginPacket")
public class LoginPacket implements class294 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Llx;"
	)
	public static final LoginPacket field2725;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Llx;"
	)
	static final LoginPacket field2727;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Llx;"
	)
	@Export("NEW_LOGIN_CONNECTION")
	public static final LoginPacket NEW_LOGIN_CONNECTION;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Llx;"
	)
	@Export("RECONNECT_LOGIN_CONNECTION")
	public static final LoginPacket RECONNECT_LOGIN_CONNECTION;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Llx;"
	)
	public static final LoginPacket field2724;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Llx;"
	)
	static final LoginPacket field2726;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "[Llx;"
	)
	static final LoginPacket[] field2728;
	@ObfuscatedName("ag")
	@Export("id")
	public final int id;

	static {
		field2725 = new LoginPacket(14, 0);
		field2727 = new LoginPacket(15, 4);
		NEW_LOGIN_CONNECTION = new LoginPacket(16, -2);
		RECONNECT_LOGIN_CONNECTION = new LoginPacket(18, -2);
		field2724 = new LoginPacket(19, -2);
		field2726 = new LoginPacket(27, 0);
		field2728 = new LoginPacket[32];
		LoginPacket[] var0 = class138.method743();

		for (int var1 = 0; var1 < var0.length; ++var1) {
			field2728[var0[var1].id] = var0[var1];
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
