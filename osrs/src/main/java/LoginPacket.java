import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mi")
@Implements("LoginPacket")
public class LoginPacket implements class307 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	public static final LoginPacket field2762;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	static final LoginPacket field2767;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("NEW_LOGIN_CONNECTION")
	public static final LoginPacket NEW_LOGIN_CONNECTION;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("RECONNECT_LOGIN_CONNECTION")
	public static final LoginPacket RECONNECT_LOGIN_CONNECTION;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	public static final LoginPacket field2764;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	static final LoginPacket field2766;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "[Lmi;"
	)
	static final LoginPacket[] field2768;
	@ObfuscatedName("ar")
	@Export("id")
	public final int id;

	static {
		field2762 = new LoginPacket(14, 0);
		field2767 = new LoginPacket(15, 4);
		NEW_LOGIN_CONNECTION = new LoginPacket(16, -2);
		RECONNECT_LOGIN_CONNECTION = new LoginPacket(18, -2);
		field2764 = new LoginPacket(19, -2);
		field2766 = new LoginPacket(27, 0);
		field2768 = new LoginPacket[32];
		LoginPacket[] var0 = FloorOverlayDefinition.method1109();

		for (int var1 = 0; var1 < var0.length; ++var1) {
			field2768[var0[var1].id] = var0[var1];
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