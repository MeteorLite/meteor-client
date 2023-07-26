import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oo")
public class class386 {
	@ObfuscatedName("aw")
	static char[] field3638;
	@ObfuscatedName("ay")
	static char[] field3639;
	@ObfuscatedName("ar")
	static char[] field3637;
	@ObfuscatedName("am")
	static int[] field3641;
	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	@Export("archive8")
	static Archive archive8;
	@ObfuscatedName("gk")
	static int field3640;

	static {
		field3638 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3638[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3638[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3638[var0] = (char)(var0 + 48 - 52);
		}

		field3638[62] = '+';
		field3638[63] = '/';
		field3639 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3639[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3639[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3639[var0] = (char)(var0 + 48 - 52);
		}

		field3639[62] = '*';
		field3639[63] = '-';
		field3637 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3637[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3637[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3637[var0] = (char)(var0 + 48 - 52);
		}

		field3637[62] = '-';
		field3637[63] = '_';
		field3641 = new int[128];

		for (var0 = 0; var0 < field3641.length; ++var0) {
			field3641[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3641[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3641[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3641[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3641;
		field3641[43] = 62;
		var2[42] = 62;
		int[] var1 = field3641;
		field3641[47] = 63;
		var1[45] = 63;
	}
}
