import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ov")
public class class385 {
	@ObfuscatedName("au")
	static char[] field3649;
	@ObfuscatedName("ae")
	static char[] field3647;
	@ObfuscatedName("ao")
	static char[] field3648;
	@ObfuscatedName("at")
	static int[] field3650;
	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	@Export("archive6")
	static Archive archive6;

	static {
		field3649 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3649[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3649[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3649[var0] = (char)(var0 + 48 - 52);
		}

		field3649[62] = '+';
		field3649[63] = '/';
		field3647 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3647[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3647[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3647[var0] = (char)(var0 + 48 - 52);
		}

		field3647[62] = '*';
		field3647[63] = '-';
		field3648 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3648[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3648[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3648[var0] = (char)(var0 + 48 - 52);
		}

		field3648[62] = '-';
		field3648[63] = '_';
		field3650 = new int[128];

		for (var0 = 0; var0 < field3650.length; ++var0) {
			field3650[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3650[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3650[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3650[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3650;
		field3650[43] = 62;
		var2[42] = 62;
		int[] var1 = field3650;
		field3650[47] = 63;
		var1[45] = 63;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
		garbageValue = "1294395846"
	)
	public static String method2023(CharSequence var0) {
		String var1 = class211.base37DecodeLong(class134.method739(var0));
		if (var1 == null) {
			var1 = "";
		}

		return var1;
	}

	@ObfuscatedName("lg")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
		garbageValue = "12"
	)
	@Export("insertMenuItemNoShift")
	public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
		UserComparator8.insertMenuItem(var0, var1, var2, var3, var4, var5, -1, false);
	}

	@ObfuscatedName("mw")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "189486485"
	)
	@Export("runIntfCloseListeners")
	static final void runIntfCloseListeners(int var0, int var1) {
		if (ModeWhere.loadInterface(var0)) {
			class212.runComponentCloseListeners(PacketBufferNode.Widget_interfaceComponents[var0], var1);
		}
	}

	@ObfuscatedName("nl")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-85"
	)
	static final void method2026(int var0) {
		var0 = Math.min(Math.max(var0, 0), 127);
		class449.clientPreferences.setCurrentSoundEffectVolume(var0);
	}
}