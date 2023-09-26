import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("po")
public class class400 {
	@ObfuscatedName("ac")
	static char[] field3683;
	@ObfuscatedName("al")
	static char[] field3685;
	@ObfuscatedName("ak")
	static char[] field3684;
	@ObfuscatedName("ax")
	static int[] field3686;

	static {
		field3683 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3683[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3683[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3683[var0] = (char)(var0 + 48 - 52);
		}

		field3683[62] = '+';
		field3683[63] = '/';
		field3685 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3685[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3685[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3685[var0] = (char)(var0 + 48 - 52);
		}

		field3685[62] = '*';
		field3685[63] = '-';
		field3684 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3684[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3684[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3684[var0] = (char)(var0 + 48 - 52);
		}

		field3684[62] = '-';
		field3684[63] = '_';
		field3686 = new int[128];

		for (var0 = 0; var0 < field3686.length; ++var0) {
			field3686[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3686[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3686[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3686[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3686;
		field3686[43] = 62;
		var2[42] = 62;
		int[] var1 = field3686;
		field3686[47] = 63;
		var1[45] = 63;
	}
}