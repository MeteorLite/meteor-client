import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mk")
public class class333 {
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	@Export("SequenceDefinition_animationsArchive")
	static AbstractArchive SequenceDefinition_animationsArchive;

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-92"
	)
	static void method1811(boolean var0) {
		byte var1 = 0;
		boolean var2 = class150.clientPreferences.method571() >= Client.param21;
		if (!var2) {
			var1 = 12;
		} else if (TileItem.client.method361() || TileItem.client.method363() || TileItem.client.method362()) {
			var1 = 10;
		}

		class328.method1678(var1);
		if (var0) {
			Login.Login_username = "";
			Login.Login_password = "";
			class424.field3758 = 0;
			Login.otp = "";
		}

		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (class150.clientPreferences.getUsernameToRemember() != null) {
				Login.Login_username = class150.clientPreferences.getUsernameToRemember();
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}
		}

		class395.method2020();
	}
}
