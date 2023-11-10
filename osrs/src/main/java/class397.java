import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("pb")
public class class397 {
	@ObfuscatedName("at")
	static char[] field3689;
	@ObfuscatedName("ah")
	static char[] field3687;
	@ObfuscatedName("ar")
	static char[] field3688;
	@ObfuscatedName("ao")
	static int[] field3690;

	static {
		field3689 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3689[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3689[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3689[var0] = (char)(var0 + 48 - 52);
		}

		field3689[62] = '+';
		field3689[63] = '/';
		field3687 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3687[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3687[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3687[var0] = (char)(var0 + 48 - 52);
		}

		field3687[62] = '*';
		field3687[63] = '-';
		field3688 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3688[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3688[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3688[var0] = (char)(var0 + 48 - 52);
		}

		field3688[62] = '-';
		field3688[63] = '_';
		field3690 = new int[128];

		for (var0 = 0; var0 < field3690.length; ++var0) {
			field3690[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3690[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3690[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3690[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3690;
		field3690[43] = 62;
		var2[42] = 62;
		int[] var1 = field3690;
		field3690[47] = 63;
		var1[45] = 63;
	}
}