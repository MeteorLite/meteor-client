import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class188 extends DualNode {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	public static EvictingDualNodeHashTable field1492;

	static {
		field1492 = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "726259362"
	)
	static void method955() {
		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (class91.clientPreferences.getUsernameToRemember() != null) {
				Login.Login_username = class91.clientPreferences.getUsernameToRemember();
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}

		}
	}
}