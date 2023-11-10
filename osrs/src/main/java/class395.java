import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@ObfuscatedName("pr")
public final class class395 {
	@ObfuscatedName("am")
	static int field3683;

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/Date;",
		garbageValue = "-1974311975"
	)
	static Date method2040() throws ParseException {
		SimpleDateFormat var0 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
		var0.setLenient(false);
		StringBuilder var1 = new StringBuilder();
		String[] var2 = Login.field769;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			String var4 = var2[var3];
			if (var4 == null) {
				UserComparator7.method674(7);
				class139.setLoginResponseString("Date not valid.", "Please ensure all characters are populated.", "");
				return null;
			}

			var1.append(var4);
		}

		var1.append("12");
		return var0.parse(var1.toString());
	}

	@ObfuscatedName("je")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1509651634"
	)
	static int method2041(int var0, int var1) {
		int var2 = var1 - 334;
		if (var2 < 0) {
			var2 = 0;
		} else if (var2 > 100) {
			var2 = 100;
		}

		int var3 = (Client.zoomWidth - Client.zoomHeight) * var2 / 100 + Client.zoomHeight;
		return var0 * var3 / 256;
	}
}