import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qr")
public class class429 {
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1179877011"
	)
	@Export("Login_promptCredentials")
	static void Login_promptCredentials(boolean var0) {
		if (!class159.client.method357() && !class159.client.method359() && !class159.client.method358()) {
			Login.Login_response1 = "";
			Login.Login_response2 = "Enter your username/email & password.";
			Login.Login_response3 = "";
			GameEngine.method166(2);
			if (var0) {
				Login.Login_password = "";
			}

			class188.method955();
			if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
				Login.currentLoginField = 1;
			} else {
				Login.currentLoginField = 0;
			}

		} else {
			GameEngine.method166(10);
		}
	}
}